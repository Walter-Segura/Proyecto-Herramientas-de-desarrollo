package com.example.demo.service;

import com.example.demo.model.Medicamento;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    private PilaMedicamentos pilaMedicamentos = new PilaMedicamentos();

    public void agregarMedicamento(Medicamento medicamento) {
        pilaMedicamentos.apilar(medicamento);
    }

    public Medicamento atenderMedicamento() {
        return pilaMedicamentos.desapilar();
    }

    public boolean pilaVacia() {
        return pilaMedicamentos.estaVacia();
    }

    public String mostrarPila() {
        return pilaMedicamentos.mostrarPila(); // <-- Este es tu "listar"
    }
}
