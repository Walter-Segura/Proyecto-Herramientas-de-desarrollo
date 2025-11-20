package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/agregar")
    public String agregarCliente(@RequestBody Cliente cliente) {
        clienteService.agregarCliente(cliente);
        return "Cliente agregado correctamente";
    }

    @PostMapping("/atender")
    public Cliente atenderCliente() {
        return clienteService.atenderCliente();
    }

    @GetMapping("/vacia")
    public boolean colaVacia() {
        return clienteService.colaVacia();
    }

    @GetMapping("/listar")
    public String listarClientes() {
        return clienteService.mostrarCola();
    }
}
