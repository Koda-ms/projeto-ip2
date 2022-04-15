package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;

public abstract class Usuario {
	private String nome;
	private String email;
	private String senha;
	private LocalDate dtNascimento;
	
	public Usuario(String nome, String email, String senha, LocalDate dtNascimento) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dtNascimento = dtNascimento;
	}

	
}
