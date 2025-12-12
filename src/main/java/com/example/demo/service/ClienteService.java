package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente guardar(Cliente c) {
        return repo.save(c);
    }

    public Cliente atender() {
        List<Cliente> lista = repo.findAll();

        if (lista.isEmpty()) {
            return null;
        }

        Cliente primero = lista.get(0);

        repo.deleteById(primero.getId_cliente());

        return primero;
    }

}
