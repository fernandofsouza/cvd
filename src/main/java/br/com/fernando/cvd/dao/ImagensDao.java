package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.Imagem;



@Stateless
public class ImagensDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public Imagem salvar(Imagem imagem) {
		return manager.merge(imagem);
	}
	
	public void excluir(Imagem imagem) {
		try {
			imagem = buscarPorId(imagem.getId());
			manager.remove(imagem);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Imagem não pode ser excluída");
		}
	}

	public Imagem buscarPorId(Long id) {		
		return manager.find(Imagem.class, id);
	}
	

	public List<Imagem> listarTodos() {
		List<Imagem> i = new ArrayList<Imagem>();
		try {
			i = (List<Imagem>) manager.createQuery("Select i FROM Imagem i", Imagem.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return i;	
	}
		
}
