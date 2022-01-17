package com.danieltns.bank.service;

import java.util.List;

import com.danieltns.bank.dto.TransferRequestDto;
import com.danieltns.bank.entity.Transaction;

public interface TransactionService extends CrudService<Transaction, Long> {

	Transaction transferFund(TransferRequestDto transferDto);

	List<Transaction> findByMonth(String accountNumber, int month, int year);

}
