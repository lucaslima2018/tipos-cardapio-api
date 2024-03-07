package br.com.atos.atividadearquiteturadesoftware.application.core.exception;

public class DominioObrigatorioException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	public DominioObrigatorioException(String mensagem) {
		super(mensagem);
	}

}
