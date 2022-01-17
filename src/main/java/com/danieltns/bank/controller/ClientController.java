package com.danieltns.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danieltns.bank.dto.ClientDto;
import com.danieltns.bank.entity.Account;
import com.danieltns.bank.entity.Client;
import com.danieltns.bank.service.AccountService;
import com.danieltns.bank.service.ClientService;
import com.danieltns.bank.utils.AppConstants;

@RestController
@RequestMapping(AppConstants.CLIENT_CONTROLLER)
public class ClientController {
	
	private final ClientService clientService;
	private final AccountService accountService;
	
	public ClientController(ClientService clientService, AccountService accountService) {
		this.clientService = clientService;
		this.accountService = accountService;
	}

	@PostMapping(AppConstants.REGISTER_CLIENT)
	public ResponseEntity<Account> registerClient(@Valid @RequestBody ClientDto clientDto) {
		Client client = new Client();
		BeanUtils.copyProperties(clientDto, client);
		
		clientService.saveOrUpdate(client);
		Account returnedAccount = accountService.createAccount(client);
		
		return new ResponseEntity<>(returnedAccount, HttpStatus.OK);
	}
	
}
