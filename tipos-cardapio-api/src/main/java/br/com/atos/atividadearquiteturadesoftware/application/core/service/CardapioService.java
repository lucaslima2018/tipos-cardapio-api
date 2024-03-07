package br.com.atos.atividadearquiteturadesoftware.application.core.service;

import java.util.List;

import br.com.atos.atividadearquiteturadesoftware.application.core.domain.Cardapio;
import br.com.atos.atividadearquiteturadesoftware.application.core.exception.DominioObrigatorioException;
import br.com.atos.atividadearquiteturadesoftware.application.core.exception.RegistroNaoEncontradoException;
import br.com.atos.atividadearquiteturadesoftware.application.ports.in.CardapioServicePort;
import br.com.atos.atividadearquiteturadesoftware.application.ports.out.CardapioCrudPort;

public class CardapioService implements CardapioServicePort{
	
	private CardapioCrudPort cardapioCrudPort;
	
	public CardapioCrudPort getCardapioCrudPort() {
		return cardapioCrudPort;
	}
	
	public CardapioService(CardapioCrudPort cardapioCrudPort) {
		this.cardapioCrudPort = cardapioCrudPort;
	}

	@Override
	public Cardapio salvar(Cardapio cardapio) {
		if(cardapio != null) {
			Cardapio cardapioSalvo = cardapioCrudPort.salvar(cardapio);
			return cardapioSalvo;
		}
		throw new DominioObrigatorioException("O cardápio é obrigatório");
	}

	@Override
	public List<Cardapio> listarPor(String nome) {
		if(nome != null && !nome.isBlank()) {
			List<Cardapio> cardapios = cardapioCrudPort.listarPor(nome);
			return cardapios;
		}
		throw new IllegalArgumentException("O nome para listagem é obrigatório");
	}

	@Override
	public Cardapio buscarPor(Integer id) {
		if(id == null || id < 0) {
			throw new IllegalArgumentException("O id deve ser positivo");
		}
		Cardapio cardapioEncontrado = cardapioCrudPort.buscarPor(id);
		if(cardapioEncontrado == null) {
			throw new RegistroNaoEncontradoException("Não foi encontrado cardápio vinculado ao id informado");
		}
		return cardapioEncontrado;
	}

	@Override
	public Cardapio removerPor(Integer id) {
		Cardapio cardapioParaRemocao = buscarPor(id);
		this.cardapioCrudPort.removerPor(id);
		return cardapioParaRemocao;
	}

}
