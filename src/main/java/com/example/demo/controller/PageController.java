package com.example.demo.controller;

import com.example.demo.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final ClienteService clienteService;

    public PageController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public String clientesPage(Model model) {
        model.addAttribute("clientes", clienteService.listar());
        return "clientes"; // templates/clientes.html
    }
}
