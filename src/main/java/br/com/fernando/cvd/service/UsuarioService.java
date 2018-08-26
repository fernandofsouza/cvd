package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.UsuarioDao;
import br.com.fernando.cvd.model.Usuario;



public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioDao usuarioDao;

	
	public void salvar(Usuario usuario) {
		
		usuarioDao.salvar(usuario);
	}

	
	public void excluir(Usuario usuario) {
		usuarioDao.excluir(usuario);
	}

	public List<Usuario> listarTodos() {
		return usuarioDao.listarTodos();
	}

	public Usuario buscarPorId(Long id) {
		return usuarioDao.buscarPorId(id);
	}

}
