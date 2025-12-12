package com.example.demo.controller;

import com.example.demo.service.MedicamentoService;
import com.example.demo.service.DevolucionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private DevolucionService devolucionService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/medicamentos")
    public String medicamentos(Model model) {
        model.addAttribute("medicamentos", medicamentoService.listar());
        return "medicamentos";
    }

    @GetMapping("/devoluciones")
    public String devoluciones(Model model) {
        model.addAttribute("devoluciones", devolucionService.listar());
        model.addAttribute("medicamentos", medicamentoService.listar());
        return "devoluciones";
    }
}
