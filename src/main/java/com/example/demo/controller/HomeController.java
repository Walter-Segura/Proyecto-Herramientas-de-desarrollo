package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public String home() {
        return "index";
    }

    @GetMapping("/clientes")
    public String clientes() {
        return "clientes";
    }

    @GetMapping("/medicamentos")
    public String medicamentos() {
        return "medicamentos";
    }

    @GetMapping("/devoluciones")
    public String devoluciones() {
        return "devoluciones";
    }
}
