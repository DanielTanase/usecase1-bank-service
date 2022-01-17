package com.danieltns.bank.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieltns.bank.dto.TransferRequestDto;
import com.danieltns.bank.entity.Account;
import com.danieltns.bank.entity.Transaction;
import com.danieltns.bank.repository.TransactionRepository;
import com.danieltns.bank.service.AccountService;
import com.danieltns.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountService accountService;

	@Override
	public Iterable<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction findById(Long id) {
		return transactionRepository.findById(id).orElse(null);
	}

	@Override
	public Transaction saveOrUpdate(Transaction object) {
		return transactionRepository.save(object);
	}

	@Override
	public void deleteById(Long id) {
		transactionRepository.deleteById(id);
	}
	
	@Transactional
	@Override
	public Transaction transferFund(TransferRequestDto transferDto) {
		if (transferDto.getFromAccountNumber().equals(transferDto.getToAccountNumber())) {
			throw new IllegalArgumentException("Cannot transfer funds to the same account!");
		}
		
		Account senderAccount = accountService.findByAccountNumber(transferDto.getFromAccountNumber());
		if (senderAccount == null) {
			throw new IllegalArgumentException("Invalid fromAccount number!");
		}
		
		Account receiverAccount = accountService.findByAccountNumber(transferDto.getToAccountNumber());
		if (receiverAccount == null) {
			throw new IllegalArgumentException("Invalid toAccount number!");
		}
		
		if (senderAccount.getBalance() >= transferDto.getValue()) {
			senderAccount.setBalance(senderAccount.getBalance() - transferDto.getValue());
			receiverAccount.setBalance(receiverAccount.getBalance() + transferDto.getValue());
			
			Transaction transaction = new Transaction();
			transaction.setFromAccount(senderAccount);
			transaction.setToAccount(receiverAccount);
			transaction.setValue(transferDto.getValue());
			transaction.setDateTime(LocalDateTime.now());
			transaction.setDescription(transferDto.getDescription());
			
			accountService.saveOrUpdate(senderAccount);
			accountService.saveOrUpdate(receiverAccount);
			saveOrUpdate(transaction);
			
			return transaction;
		} else {
			throw new IllegalArgumentException("Invalid value! Insufficient funds!");
		}
		
	}

	@Override
	public List<Transaction> findByMonth(String accountNumber, int month, int year) {
		LocalDate startDate = LocalDate.of(year, month, 1);
		LocalDate endDate = LocalDate.of(year, month, startDate.lengthOfMonth());
		
		return transactionRepository.findByFromAccount_AccountNumberAndDateTimeBetweenOrToAccount_AccountNumberAndDateTimeBetween(
				accountNumber, startDate.atTime(LocalTime.MIDNIGHT), endDate.atTime(LocalTime.MAX), 
				accountNumber, startDate.atTime(LocalTime.MIDNIGHT), endDate.atTime(LocalTime.MAX));
	}
	
}
