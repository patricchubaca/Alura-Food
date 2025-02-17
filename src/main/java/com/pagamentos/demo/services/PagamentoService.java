package com.pagamentos.demo.services;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagamentos.demo.repository.PagamentosRepository;

@Service
public class PagamentoService {

    @Autowired
    private PagamentosRepository repository;

    private ModelMapper modelMapper;
}
