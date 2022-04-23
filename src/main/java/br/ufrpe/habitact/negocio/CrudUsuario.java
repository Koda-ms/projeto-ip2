package br.ufrpe.habitact.negocio;

import java.util.List;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.excecoes.SenhaIncorretaException;
import br.ufrpe.habitact.negocio.beans.Administrador;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Usuario;

public class CrudUsuario {
	private IRepositorio<Cliente> repositorioCliente;
	private IRepositorio<Administrador> repositorioAdm;
	private static long qtdUsuariosCadastrados;

	public CrudUsuario() {
		this.repositorioCliente = new Repositorio<>();
		this.repositorioAdm = new Repositorio<>();
	}

	public void cadastrarUsuario(Usuario u) throws ObjetoDuplicadoException {
		if (u instanceof Cliente) {
			Cliente c = (Cliente) u;
			try {
				this.repositorioCliente.inserir(c);
				qtdUsuariosCadastrados++;
			} catch (ObjetoDuplicadoException e) {
				throw new ObjetoDuplicadoException("Usuário já cadastrado no sistema");
			}
		} else if (u instanceof Administrador) {
			Administrador a = (Administrador) u;
			try {
				this.repositorioAdm.inserir(a);
				qtdUsuariosCadastrados++;
			} catch (ObjetoDuplicadoException e) {
				throw new ObjetoDuplicadoException("Usuário já cadastrado no sistema");
			}
		}
	}

	public Usuario autenticarUsuario(String email, String senha) {
		Usuario u = null;
		if (this.repositorioCliente.listar().size() > 0) {
			for (Cliente c : this.repositorioCliente.listar()) {
				if (c.getEmail().equals(email) && c.getSenha().equals(senha)) {
					u = c;
					return u;
				}
			}
		} else if (this.repositorioAdm.listar().size() > 0) {
			for (Administrador a : this.repositorioAdm.listar()) {
				if (a.getEmail().equals(email) && a.getSenha().equals(senha)) {
					u = a;
					return u;
				}
			}
		}
		return u;
	}

	public void alterarDados(Usuario usuarioAntigo, Usuario usuarioNovo, String senha)
			throws SenhaIncorretaException, ObjetoNaoExisteException {
		if (usuarioAntigo instanceof Cliente) {
			if (usuarioAntigo.getSenha().equals(senha)) {
				this.repositorioCliente.atualizar((Cliente) usuarioAntigo, (Cliente) usuarioNovo);
			} else {
				throw new SenhaIncorretaException("Senha Incorreta");
			}
		} else if (usuarioAntigo instanceof Administrador) {
			if (usuarioAntigo.getSenha().equals(senha)) {
				this.repositorioAdm.atualizar((Administrador) usuarioAntigo, (Administrador) usuarioNovo);
			} else {
				throw new SenhaIncorretaException("Senha Incorreta");
			}
		}
	}

	public List<Cliente> listarClientes() {
		return repositorioCliente.listar();
	}

	public List<Administrador> listarAdms() {
		return repositorioAdm.listar();
	}

}