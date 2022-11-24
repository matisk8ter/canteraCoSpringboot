package com.cantera.controller;

import com.cantera.domain.Client;
import com.cantera.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/client")//http://localhost:8080/api/client/
public class ClientController {

    @Autowired
    private ClientService service;

//    @PostMapping("/crear")
//    public Client save(@RequestBody Client client){
//        return service.save(client);
//    }

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(client));
    }

    @GetMapping()
    public Iterable<Client> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        Optional<Client> client = service.findById(id);

        if (!client.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable(value = "id") String id) {
        Optional<Client> newClient = service.findById(id);

        if (!newClient.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        newClient.get().setNombre(client.getNombre());
        newClient.get().setEmail(client.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newClient.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id){
        return  null;
    }


}
