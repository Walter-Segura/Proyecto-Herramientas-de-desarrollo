package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Devolucion;
import com.example.demo.repository.DevolucionRepository;

import java.util.List;

@Service
public class DevolucionService {

    private final DevolucionRepository repo;

    public DevolucionService(DevolucionRepository repo) {
        this.repo = repo;
    }

    public List<Devolucion> listar() {
        return repo.findAll();
    }

    public Devolucion guardar(Devolucion d) {
        return repo.save(d);
    }
}
