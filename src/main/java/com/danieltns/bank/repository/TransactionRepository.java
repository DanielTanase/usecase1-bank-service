package com.danieltns.bank.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieltns.bank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	List<Transaction> findByFromAccount_AccountNumberAndDateTimeBetweenOrToAccount_AccountNumberAndDateTimeBetween(
			String fromAccountNumber, LocalDateTime startDate1, LocalDateTime endDate1, 
			String toAccountNumber, LocalDateTime startDate2, LocalDateTime endDate2);
	
}
