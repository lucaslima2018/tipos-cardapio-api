package br.com.atos.atividadearquiteturadesoftware.adapters.inbound.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.atos.atividadearquiteturadesoftware.adapters.inbound.dto.CardapioDTO;
import br.com.atos.atividadearquiteturadesoftware.adapters.inbound.entity.CardapioEntity;
import br.com.atos.atividadearquiteturadesoftware.application.core.domain.Cardapio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Component
@Valid
public class CardapioMapper {
	
	public Cardapio toDomain(
			@NotNull(message = "O dto é obrigatório")
			CardapioDTO dto) {
		Cardapio domain = new Cardapio();
		BeanUtils.copyProperties(dto, domain);
		return domain;
	}
	
	public Cardapio toDomain(
			@NotNull(message = "A entidade é obrigatória")
			CardapioEntity entity) {
		Cardapio domain = new Cardapio();
		BeanUtils.copyProperties(entity, domain);
		return domain;
	}
	
	public CardapioEntity toEntity(
			@NotNull(message = "O domain é obrigatório")
			Cardapio domain) {
		CardapioEntity entity = new CardapioEntity();
		BeanUtils.copyProperties(domain, entity);
		return entity;
	}

}
