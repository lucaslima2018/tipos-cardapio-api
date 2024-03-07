package br.com.atos.atividadearquiteturadesoftware.adapters.inbound.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CardapioDTO {
	
	@EqualsAndHasCode.Include
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private String status;

}
