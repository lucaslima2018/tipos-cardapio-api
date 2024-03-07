package br.com.atos.atividadearquiteturadesoftware.application.ports.out;

import java.util.List;

import br.com.atos.atividadearquiteturadesoftware.application.core.domain.Cardapio;

public interface CardapioCrudPort {
	
	public Cardapio salvar(Cardapio cardapio);
	
	public List<Cardapio> listarPor(String nome);
	
	public Cardapio buscarPor(Integer id);
	
	public Cardapio removerPor(Integer id);
	
	public Cardapio atualizarStatus(String status);

}
