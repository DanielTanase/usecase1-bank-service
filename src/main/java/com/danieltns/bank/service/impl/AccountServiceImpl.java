package com.danieltns.bank.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieltns.bank.entity.Account;
import com.danieltns.bank.entity.Client;
import com.danieltns.bank.repository.AccountRepository;
import com.danieltns.bank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	private Random random;
	
	public AccountServiceImpl() throws NoSuchAlgorithmException {
		random = SecureRandom.getInstanceStrong();
		
	}
	
	@Override
	public Iterable<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findById(Long id) {
		return accountRepository.findById(id).orElse(null);
	}

	@Override
	public Account saveOrUpdate(Account object) {
		return accountRepository.save(object);
	}

	@Override
	public void deleteById(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Account createAccount(Client client) {
		Account newAccount = new Account();
		newAccount.setDate(LocalDate.now());
		newAccount.setBalance(5000);
		
		int randomNumber = random.nextInt(999999);
		newAccount.setAccountNumber(String.format("%06d", randomNumber));
		client.addAccount(newAccount);
		
		return saveOrUpdate(newAccount);
	}

	@Override
	public Account findByAccountNumber(String fromAccountNumber) {
		return accountRepository.findByAccountNumber(fromAccountNumber);
	}
	
}
