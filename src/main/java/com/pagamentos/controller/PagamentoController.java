package com.pagamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagamentos.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
	
	@Autowired
	private PagamentoService pagamentoService;

	@PutMapping("/{emprestimoId}")
	public ResponseEntity realizarPagamento(@PathVariable Long emprestimoId) throws Exception {
		pagamentoService.realizarPagamento(emprestimoId);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
