package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.TipoUsuarioDao;
import br.com.fernando.cvd.model.TipoUsuario;



public class TipoUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private TipoUsuarioDao tipoUsuarioDao;

	
	public void salvar(TipoUsuario tipoUsuario) {
		
		tipoUsuarioDao.salvar(tipoUsuario);
	}

	
	public void excluir(TipoUsuario tipoUsuario) {
		tipoUsuarioDao.excluir(tipoUsuario);
	}

	public List<TipoUsuario> listarTodos() {
		return tipoUsuarioDao.listarTodos();
	}

	public TipoUsuario buscarPorId(Long id) {
		return tipoUsuarioDao.buscarPorId(id);
	}

}
