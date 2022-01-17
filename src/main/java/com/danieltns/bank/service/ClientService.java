package com.danieltns.bank.service;

import com.danieltns.bank.entity.Client;

public interface ClientService extends CrudService<Client, Long> {

	boolean existsById(long id);

}
