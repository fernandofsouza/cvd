package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.FornecedorDao;
import br.com.fernando.cvd.model.Fornecedor;



public class FornecedorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private FornecedorDao fornecedorDao;

	
	public void salvar(Fornecedor fornecedor) {
		
		fornecedorDao.salvar(fornecedor);
	}

	
	public void excluir(Fornecedor fornecedor) {
		fornecedorDao.excluir(fornecedor);
	}

	public List<Fornecedor> listarTodos() {
		return fornecedorDao.listarTodos();
	}

	public Fornecedor buscarPorId(Long id) {
		return fornecedorDao.buscarPorId(id);
	}

}
