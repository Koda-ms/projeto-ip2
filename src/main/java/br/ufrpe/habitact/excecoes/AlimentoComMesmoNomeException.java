package br.ufrpe.habitact.excecoes;

public class AlimentoComMesmoNomeException extends Exception{
	public AlimentoComMesmoNomeException(String aviso) {
		super(aviso);
	}
}
