package br.com.atos.atividadearquiteturadesoftware.adapters.inbound.web;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.atos.atividadearquiteturadesoftware.adapters.inbound.dto.CardapioDTO;
import br.com.atos.atividadearquiteturadesoftware.adapters.inbound.mapper.CardapioMapper;
import br.com.atos.atividadearquiteturadesoftware.application.core.domain.Cardapio;
import br.com.atos.atividadearquiteturadesoftware.application.ports.in.CardapioServicePort;

@RestController
@RequestMapping("/cardapios")
public class CardapioController {
	
	@Autowired
	private CardapioServicePort cardapioServicePort;
	
	@Autowired
	private CardapioMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> inserir(
			@RequestBody
			CardapioDTO dto){
		if(dto.getId() != null) {
			Cardapio cardapioParaAtualizar = mapper.toDomain(dto);
			Cardapio cardapioAtualizado = cardapioServicePort.salvar(cardapioParaAtualizar);			
			return ResponseEntity.ok(cardapioAtualizado);
		}
		Cardapio novoCardapio = mapper.toDomain(dto);
		Cardapio cardapioSalvo = cardapioServicePort.salvar(novoCardapio);
		return ResponseEntity.created(URI.create("/tipos-cardapios/id" + cardapioSalvo.getId())).build();
	}
	
	@PutMapping
	public ResponseEntity<?> alterar(
			@RequestBody
			CardapioDTO dto){
		if(dto.getId() == null || dto.getId() == 0) {
			throw new IllegalArgumentException("O id do cardapio é obrigatório");
		}
		Cardapio cardapio = mapper.toDomain(dto);
		Cardapio cardapioAlterado = cardapioServicePort.salvar(cardapio);
		return ResponseEntity.ok(cardapioAlterado);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscarPor(
			@PathVariable("id")
			Integer id){
		if(id <= 0) {
			throw new IllegalArgumentException("O id do cardapio deve ser válido");
		}
		Cardapio cardapioEncontrado = cardapioServicePort.buscarPor(id);
		return ResponseEntity.ok(cardapioEncontrado);	
	}
	
	@GetMapping
	public ResponseEntity<?> listarPor(
			@RequestParam("nome")
			String nome){
		List<Cardapio> cardapios = cardapioServicePort.listarPor(nome);
		if(!cardapios.isEmpty()) {
			return ResponseEntity.ok(cardapios);
		}
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<?> removerPor(
			@PathVariable("id")
			Integer id){
		Cardapio cardapioExcluido = cardapioServicePort.removerPor(id);
		return ResponseEntity.ok(cardapioExcluido);
	}

}
