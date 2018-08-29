package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.CategoriaProdutoDao;
import br.com.fernando.cvd.model.CategoriaProduto;



public class CategoriaProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CategoriaProdutoDao categoriaProdutoDao;

	
	public void salvar(CategoriaProduto categoriaProduto) {
		
		categoriaProdutoDao.salvar(categoriaProduto);
	}

	
	public void excluir(CategoriaProduto categoriaProduto) {
		categoriaProdutoDao.excluir(categoriaProduto);
	}

	public List<CategoriaProduto> listarTodos() {
		return categoriaProdutoDao.listarTodos();
	}

	public CategoriaProduto buscarPorId(Long id) {
		return categoriaProdutoDao.buscarPorId(id);
	}

}
