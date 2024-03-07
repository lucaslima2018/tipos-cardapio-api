package br.com.atos.atividadearquiteturadesoftware.adapters.outbound;

import java.util.ArrayList;
import java.util.List;

import br.com.atos.atividadearquiteturadesoftware.adapters.inbound.entity.CardapioEntity;
import br.com.atos.atividadearquiteturadesoftware.adapters.inbound.mapper.CardapioMapper;
import br.com.atos.atividadearquiteturadesoftware.adapters.outbound.data.repository.CardapioRepository;
import br.com.atos.atividadearquiteturadesoftware.application.core.domain.Cardapio;
import br.com.atos.atividadearquiteturadesoftware.application.ports.out.CardapioCrudPort;

public class CardapioCrudAdapter implements CardapioCrudPort{
	
	@Autowired
	private CardapioRepository repository;
	
	private CardapioMapper mapper;

	@Override
	public Cardapio salvar(Cardapio cardapio) {
		CardapioEntity entitySalva = repository.save(mapper.toEntity(cardapio));
		return mapper.toDomain(entitySalva);
	}

	@Override
	public List<Cardapio> listarPor(String nome) {
		List<CardapioEntity> entities = repository.listarPor("%" + nome + "%");
		List<Cardapio> cardapios = new ArrayList<>();
		for(CardapioEntity entity: entities) {
			cardapios.add(mapper.toDomain(entity));
		}
		return cardapios;
	}

	@Override
	public Cardapio buscarPor(Integer id) {
		CardapioEntity entity = repository.buscarPor(id);
		if(entity != null) {
			return mapper.toDomain(entity);
		}
		return null;
	}

	@Override
	public Cardapio removerPor(Integer id) {
		Cardapio cardapio = buscarPor(id);
		if(cardapio != null) {
			this.repository.deleteBy(id);
			return cardapio;
		}
		return null;
	}

	@Override
	public Cardapio atualizarStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
