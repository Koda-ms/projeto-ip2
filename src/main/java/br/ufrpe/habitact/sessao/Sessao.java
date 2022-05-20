package br.ufrpe.habitact.sessao;

import br.ufrpe.habitact.negocio.beans.Administrador;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Usuario;

public class Sessao {
    private static Sessao instance;
    private Usuario usuario;

    public static Sessao getInstance() {
        if (instance == null) {
            instance = new Sessao();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
