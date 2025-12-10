package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Medicamento;
import com.example.demo.repository.MedicamentoRepository;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository repo;

    public MedicamentoService(MedicamentoRepository repo) {
        this.repo = repo;
    }

    public List<Medicamento> listar() {
        return repo.findAll();
    }

    public Medicamento guardar(Medicamento m) {
        return repo.save(m);
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
