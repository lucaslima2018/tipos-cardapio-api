package br.com.atos.atividadearquiteturadesoftware.adapters.outbound.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.atos.atividadearquiteturadesoftware.adapters.inbound.entity.CardapioEntity;

public interface CardapioRepository extends JpaRepository<CardapioEntity, Integer>{
	
	@Query(value = 
			"SELECT c FROM Cardapio c WHERE Upper(c.nome) LIKE Upper(:nome)",
			countQuery = "SELECT Count(c) from Cardapio c WHERE Upper(c.nome) LIKE Upper(:nome)")
	public List<CardapioEntity> listarPor(String nome, Pageable paginacao);
	
	@Query(value = "SELECT c FROM Cardapio c WHERE c.id = :id ")
	public CardapioEntity buscarPor(Integer id);

}
