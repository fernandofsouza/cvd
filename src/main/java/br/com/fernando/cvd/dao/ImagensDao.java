package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.Imagens;



@Stateless
public class ImagensDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public Imagens salvar(Imagens imagem) {
		return manager.merge(imagem);
	}
	
	public void excluir(Imagens imagem) {
		try {
			imagem = buscarPorId(imagem.getId());
			manager.remove(imagem);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Imagem não pode ser excluída");
		}
	}

	public Imagens buscarPorId(Long id) {		
		return manager.find(Imagens.class, id);
	}
	

	public List<Imagens> listarTodos() {
		List<Imagens> i = new ArrayList<Imagens>();
		try {
			i = (List<Imagens>) manager.createQuery("Select i FROM Imagens_i", Imagens.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return i;	
	}
		
}
