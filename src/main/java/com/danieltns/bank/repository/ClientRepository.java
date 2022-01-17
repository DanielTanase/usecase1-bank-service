package com.danieltns.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieltns.bank.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
