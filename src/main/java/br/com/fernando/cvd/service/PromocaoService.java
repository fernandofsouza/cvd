package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.PromocaoDao;
import br.com.fernando.cvd.model.Promocao;



public class PromocaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PromocaoDao promocaoDao;

	
	public void salvar(Promocao promocao) {
		
		promocaoDao.salvar(promocao);
	}

	
	public void excluir(Promocao promocao) {
		promocaoDao.excluir(promocao);
	}

	public List<Promocao> listarTodos() {
		return promocaoDao.listarTodos();
	}
	

	public Promocao buscarPorId(Long id) {
		return promocaoDao.buscarPorId(id);
	}

}
