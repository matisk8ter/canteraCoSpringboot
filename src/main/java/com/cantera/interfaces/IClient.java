package com.cantera.interfaces;

import com.cantera.domain.Client;

import java.util.Optional;

public interface IClient {
    Iterable<Client> findAll();
    Optional<Client> findById(String id);
    Client save(Client client);
    void deleteById(String id);
}
