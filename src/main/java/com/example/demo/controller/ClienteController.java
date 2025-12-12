package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<Cliente> listar() {
        return service.listar();
    }

    @PostMapping("/agregar")
    public Cliente guardar(@RequestBody Cliente c) {
        if (c.getFecha_registro() == null) {
            c.setFecha_registro(LocalDateTime.now());
        }
        return service.guardar(c);
    }

    @PostMapping("/atender")
    public Cliente atender() {
        return service.atender();
    }
}
