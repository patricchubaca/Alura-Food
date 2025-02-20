package com.pagamentos.demo.services;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagamentos.demo.dto.PagamentoDto;
import com.pagamentos.demo.model.Pagamento;
import com.pagamentos.demo.repository.PagamentosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PagamentoService {

    @Autowired
    private PagamentosRepository repository;

    private ModelMapper modelMapper;

    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, PagamentoDto.class));
    }

    public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto criarPagamento(PagamentoDto dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public void excluirPagamento(Long id) {
        repository.deleteById(id);
    }
}
