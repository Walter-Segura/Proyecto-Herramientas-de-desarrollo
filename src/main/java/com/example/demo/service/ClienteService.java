package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.ColaClientes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ColaClientes colaClientes = new ColaClientes();

    public void agregarCliente(Cliente cliente) {
        colaClientes.encolar(cliente);
    }

    public Cliente atenderCliente() {
        return colaClientes.desencolar();
    }

    public boolean colaVacia() {
        return colaClientes.estaVacia();
    }

    public String mostrarCola() {
        return colaClientes.mostrarCola(); // <-- Este es tu "listar"
    }
}
