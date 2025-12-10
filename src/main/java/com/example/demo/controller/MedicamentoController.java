package com.example.demo.controller;

import com.example.demo.model.Medicamento;
import com.example.demo.service.MedicamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
@CrossOrigin(origins = "*")
public class MedicamentoController {

    private final MedicamentoService service;

    public MedicamentoController(MedicamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medicamento> listar() {
        return service.listar();
    }

    @PostMapping
    public Medicamento guardar(@RequestBody Medicamento m) {
        return service.guardar(m);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
