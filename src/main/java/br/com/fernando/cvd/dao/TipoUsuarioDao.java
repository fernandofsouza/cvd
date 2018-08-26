package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.TipoUsuario;



@Stateless
public class TipoUsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public TipoUsuario salvar(TipoUsuario tipoUsuario) {
		return manager.merge(tipoUsuario);
	}
	
	public void excluir(TipoUsuario tipoUsuario) {
		try {
			tipoUsuario = buscarPorId(tipoUsuario.getId());
			manager.remove(tipoUsuario);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Tipo de Usuário não pode ser excluído");
		}
	}

	public TipoUsuario buscarPorId(Long id) {		
		return manager.find(TipoUsuario.class, id);
	}
	
	public List<TipoUsuario> listarTodos() {
		List<TipoUsuario> t = new ArrayList<TipoUsuario>();
		try {
			t = (List<TipoUsuario>) manager.createQuery("Select t FROM TipoUsuario t", TipoUsuario.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return t;	
	}
		
}
