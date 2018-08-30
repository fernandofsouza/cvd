package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.Produto;



@Stateless
public class ProdutoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public Produto salvar(Produto produto) {
		return manager.merge(produto);
	}
	
	public void excluir(Produto produto) {
		try {
			produto = buscarPorId(produto.getId());
			manager.remove(produto);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Produto não pode ser excluído");
		}
	}

	public Produto buscarPorId(Long id) {		
		return manager.find(Produto.class, id);
	}
	
	public List<Produto> listarTodos() {
		List<Produto>p = new ArrayList<Produto>();
		try {
			p = (List<Produto>) manager.createQuery("Select p FROM Produto p", Produto.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return p;	
	}
		
}
