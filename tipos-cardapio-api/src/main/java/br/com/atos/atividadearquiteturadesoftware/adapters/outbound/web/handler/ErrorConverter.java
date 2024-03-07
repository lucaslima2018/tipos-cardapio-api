package br.com.atos.atividadearquiteturadesoftware.adapters.outbound.web.handler;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.atos.atividadearquiteturadesoftware.adapters.outbound.web.handler.ErroDaApi;

@Component
public class ErrorConverter {
	
public JSONObject criarJsonDeErro(ErroDaApi erroDaApi, String msgDeErro) {
		
		JSONObject body = new JSONObject();					
		
		JSONObject detalhe = new JSONObject();
		detalhe.put("mensagem", msgDeErro);
		detalhe.put("codigo", erroDaApi.getCodigo());
		
		JSONArray detalhes = new JSONArray();
		detalhes.put(detalhe);
		
		body.put("erros", detalhes);
		
		return body;
		
	}

	public Map<String, Object> criarMapDeErro(ErroDaApi erroDaApi, String msgDeErro){			
		
		JSONObject body = new JSONObject();					
		
		JSONObject detalhe = new JSONObject();
		detalhe.put("mensagem", msgDeErro);
		detalhe.put("codigo", erroDaApi.getCodigo());
		
		JSONArray detalhes = new JSONArray();
		detalhes.put(detalhe);
		
		body.put("erros", detalhes);
		
		return criarJsonDeErro(erroDaApi, msgDeErro).toMap();
		
	}

}
