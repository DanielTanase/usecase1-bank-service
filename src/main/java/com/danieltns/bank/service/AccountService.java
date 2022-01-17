package com.danieltns.bank.service;

import com.danieltns.bank.entity.Account;
import com.danieltns.bank.entity.Client;

public interface AccountService extends CrudService<Account, Long> {

	Account createAccount(Client client);

	Account findByAccountNumber(String fromAccountNumber);
	
}
