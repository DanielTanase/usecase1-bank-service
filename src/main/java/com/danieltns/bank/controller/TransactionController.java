package com.danieltns.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danieltns.bank.dto.TransferRequestDto;
import com.danieltns.bank.entity.Transaction;
import com.danieltns.bank.service.TransactionService;
import com.danieltns.bank.utils.AppConstants;
import com.danieltns.bank.utils.Utils;

@RestController
@RequestMapping(AppConstants.TRANSFER_CONTROLLER)
public class TransactionController {
	
	private final TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping(AppConstants.TRANSFER_FUND)
	public ResponseEntity<Transaction> transferFund(@Valid @RequestBody TransferRequestDto transferDto) {
		Transaction result = transactionService.transferFund(transferDto);
		
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(AppConstants.GET_MONTHLY_TRANSACTIONS)
	public ResponseEntity<List<Transaction>> getMontlyTransactions(@RequestParam String accountNumber, @RequestParam int month, @RequestParam int year) {
		Utils.checkDateValid(month, year);
		
		List<Transaction> transactionList = transactionService.findByMonth(accountNumber, month, year);
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}
	
}
