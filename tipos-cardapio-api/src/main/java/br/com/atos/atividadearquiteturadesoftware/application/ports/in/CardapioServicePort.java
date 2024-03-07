package br.com.atos.atividadearquiteturadesoftware.application.ports.in;

import java.util.List;

import br.com.atos.atividadearquiteturadesoftware.application.core.domain.Cardapio;

public interface CardapioServicePort {
	
	public Cardapio salvar(Cardapio cardapio);
	
	public List<Cardapio> listarPor(String nome);
	
	public Cardapio buscarPor(Integer id);
	
	public Cardapio removerPor(Integer id); 
	
	public Cardapio atualizarStatus(String status);

}
