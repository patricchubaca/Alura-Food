package com.pagamentos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagamentos.demo.model.Pagamento;

public interface PagamentosRepository extends JpaRepository<Pagamento, Long> {

}
