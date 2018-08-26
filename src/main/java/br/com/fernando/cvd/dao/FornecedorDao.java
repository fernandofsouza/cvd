package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.Fornecedor;



@Stateless
public class FornecedorDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public Fornecedor salvar(Fornecedor fornecedor) {
		return manager.merge(fornecedor);
	}
	
	public void excluir(Fornecedor fornecedor) {
		try {
			fornecedor = buscarPorId(fornecedor.getId());
			manager.remove(fornecedor);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Fornecedor não pode ser excluído");
		}
	}

	public Fornecedor buscarPorId(Long id) {		
		return manager.find(Fornecedor.class, id);
	}
	
	public List<Fornecedor> listarTodos() {
		List<Fornecedor> f = new ArrayList<Fornecedor>();
		try {
			f = (List<Fornecedor>) manager.createQuery("Select f FROM fornecedor f", Fornecedor.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return f;	
	}
		
}
