package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;

public class Administrador extends Usuario{
	private String iD;

	public Administrador(String nome, String email, String senha, LocalDate dtNascimento, String iD) {
		super(nome, email, senha, dtNascimento);
		this.iD = iD;
	}
	
	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}
}
