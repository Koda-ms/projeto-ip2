package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.util.Objects;

public class Administrador extends Usuario{
	private String iD;

	public Administrador(String nome, String email, String senha, LocalDate dtNascimento, String iD) {
		super(nome, email, senha, dtNascimento);
		this.iD = iD;
	}

	public Administrador(){}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(iD);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Administrador))
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(iD, other.iD);
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}
}
