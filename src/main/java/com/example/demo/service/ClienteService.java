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

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
