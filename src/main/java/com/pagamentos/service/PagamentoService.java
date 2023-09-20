package com.pagamentos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PagamentoService {
	private final Logger LOGGER = LoggerFactory.getLogger(PagamentoService.class);

	@Value("${emprestimos.api.url}")
	private String emprestimosApiUrl;

	public void realizarPagamento(Long emprestimoId) throws Exception {
		try {
			RestTemplate restTemplate =  new RestTemplate();
			restTemplate.put(emprestimosApiUrl + "/emprestimos/" + emprestimoId + "/pagamento", null);
		} catch (Exception e) {
			LOGGER.error("[realizarPagamento] Nao foi possivel pagar emprestimo, causa: {}", e.getMessage(), e);
			throw new Exception("Nao foi possivel pagar emprestimo.");
		}
	}
}
