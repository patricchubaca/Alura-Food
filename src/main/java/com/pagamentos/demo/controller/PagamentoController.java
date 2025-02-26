package com.pagamentos.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagamentos.demo.model.Pagamento;
import com.pagamentos.demo.services.PagamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping("/")
    public String getHellow() {
        return "Hellow";
    }

    @GetMapping("/d")
    public String getMethodName(@RequestParam String param) {
        return new String("Hellow");
    }

}
