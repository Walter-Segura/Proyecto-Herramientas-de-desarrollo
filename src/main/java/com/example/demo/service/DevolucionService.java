package com.example.demo.service;

import com.example.demo.model.Devolucion;
import org.springframework.stereotype.Service;

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
