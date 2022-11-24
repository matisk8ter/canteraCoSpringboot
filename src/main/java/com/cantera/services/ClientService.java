package com.cantera.services;

import com.cantera.interfaces.IClient;
import com.cantera.domain.Client;
import com.cantera.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements IClient {

    @Autowired
    private ClientRepository repository;

    @Override
    public Iterable<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
