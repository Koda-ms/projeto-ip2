package br.ufrpe.habitact.excecoes;

public class ObjetoNaoExisteException extends Exception{
	public ObjetoNaoExisteException(String aviso) {
		super(aviso);
	}
}
