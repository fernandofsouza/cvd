package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.CategoriaProduto;



@Stateless
public class CategoriaProdutoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public CategoriaProduto salvar(CategoriaProduto categoriaProduto) {
		return manager.merge(categoriaProduto);
	}
	
	public void excluir(CategoriaProduto categoriaProduto) {
		try {
			categoriaProduto = buscarPorId(categoriaProduto.getId());
			manager.remove(categoriaProduto);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Categoria não pode ser excluída");
		}
	}

	public CategoriaProduto buscarPorId(Long id) {		
		return manager.find(CategoriaProduto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<CategoriaProduto> listarTodos() {
		List<CategoriaProduto> t = new ArrayList<CategoriaProduto>();
		try {
			t = (List<CategoriaProduto>) manager.createNativeQuery("Select * FROM categoria_produto t", CategoriaProduto.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return t;	
	}
		
}
