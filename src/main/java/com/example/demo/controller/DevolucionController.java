package com.example.demo.controller;

import com.example.demo.model.Devolucion;
import com.example.demo.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    @PostMapping("/registrar")
    public String registrarDevolucion(@RequestBody Devolucion devolucion) {
        devolucionService.registrarDevolucion(devolucion);
        return "Devolución registrada.";
    }

    @PostMapping("/procesar")
    public Devolucion procesarDevolucion() {
        return devolucionService.procesarDevolucion();
    }

    @GetMapping("/vacia")
    public boolean pilaVacia() {
        return devolucionService.pilaVacia();
    }

    @GetMapping("/listar")
    public String mostrarPila() {
        return devolucionService.mostrarPila();
    }
}
