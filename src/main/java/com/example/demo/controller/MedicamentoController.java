package com.example.demo.controller;

import com.example.demo.model.Medicamento;
import com.example.demo.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @PostMapping("/agregar")
    public String agregarMedicamento(@RequestBody Medicamento medicamento) {
        medicamentoService.agregarMedicamento(medicamento);
        return "Medicamento agregado.";
    }

    @PostMapping("/atender")
    public Medicamento atenderMedicamento() {
        return medicamentoService.atenderMedicamento();
    }

    @GetMapping("/vacia")
    public boolean pilaVacia() {
        return medicamentoService.pilaVacia();
    }

    @GetMapping("/listar")
    public String mostrarPila() {
        return medicamentoService.mostrarPila();
    }
}
