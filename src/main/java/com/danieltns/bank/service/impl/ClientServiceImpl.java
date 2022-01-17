package com.danieltns.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieltns.bank.entity.Client;
import com.danieltns.bank.repository.ClientRepository;
import com.danieltns.bank.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Long id) {
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	public Client saveOrUpdate(Client object) {
		return clientRepository.save(object);
	}

	@Override
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public boolean existsById(long uid) {
		return clientRepository.existsById(uid);
	}
	
	
}
