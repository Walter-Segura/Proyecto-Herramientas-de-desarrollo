package com.example.demo.service;

import com.example.demo.model.Devolucion;
import com.example.demo.model.PilaDevoluciones;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionService {

    private PilaDevoluciones pilaDevoluciones = new PilaDevoluciones();

    public void registrarDevolucion(Devolucion devolucion) {
        pilaDevoluciones.apilar(devolucion);
    }

    public Devolucion procesarDevolucion() {
        return pilaDevoluciones.desapilar();
    }

    public boolean pilaVacia() {
        return pilaDevoluciones.estaVacia();
    }

    public String mostrarPila() {
        return pilaDevoluciones.mostrarPila(); // este es tu "listar"
    }
}
