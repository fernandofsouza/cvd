package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.ProdutoDao;
import br.com.fernando.cvd.model.Produto;



public class ProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ProdutoDao produtoDao;

	
	public void salvar(Produto produto) {
		
		produtoDao.salvar(produto);
	}

	
	public void excluir(Produto produto) {
		produtoDao.excluir(produto);
	}

	public List<Produto> listarTodos() {
		return produtoDao.listarTodos();
	}

	public Produto buscarPorId(Long id) {
		return produtoDao.buscarPorId(id);
	}

}
