package com.example.demo.controller;

import com.example.demo.model.Devolucion;
import com.example.demo.model.Medicamento;
import com.example.demo.service.DevolucionService;
import com.example.demo.service.MedicamentoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/devoluciones")
@CrossOrigin(origins = "*")
public class DevolucionController {

    private final DevolucionService service;
    private final MedicamentoService medicamentoService;

    public DevolucionController(DevolucionService service, MedicamentoService medicamentoService) {
        this.service = service;
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public List<Devolucion> listar() {
        return service.listar();
    }

    @PostMapping
    public Devolucion guardar(@RequestBody Devolucion d) {

        // Validar medicamento
        Medicamento med = medicamentoService
                .listar()
                .stream()
                .filter(m -> m.getId_medicamento().equals(d.getMedicamento().getId_medicamento()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado"));

        d.setMedicamento(med);

        // Registrar fecha si viene null
        if (d.getFecha() == null) {
            d.setFecha(LocalDateTime.now());
        }

        return service.guardar(d);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

}
