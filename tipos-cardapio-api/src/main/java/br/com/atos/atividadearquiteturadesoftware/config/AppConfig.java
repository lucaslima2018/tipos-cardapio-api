package br.com.atos.atividadearquiteturadesoftware.config;

import org.springframework.context.annotation.Configuration;

import br.com.atos.atividadearquiteturadesoftware.adapters.outbound.CardapioCrudAdapter;
import br.com.atos.atividadearquiteturadesoftware.application.core.service.CardapioService;

@Configuration
public class AppConfig {
	
	public CardapioService cardapioService(CardapioCrudAdapter cardapioCrudAdapter) {
		return new CardapioService(cardapioCrudAdapter);
	}

}
