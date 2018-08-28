package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.TipoPagamento;



@Stateless
public class TipoPagamentoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public TipoPagamento salvar(TipoPagamento tipoPagamento) {
		return manager.merge(tipoPagamento);
	}
	
	public void excluir(TipoPagamento tipoPagamento) {
		try {
			tipoPagamento = buscarPorId(tipoPagamento.getId());
			manager.remove(tipoPagamento);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Tipo de Pagamento não pode ser excluído");
		}
	}

	public TipoPagamento buscarPorId(Long id) {		
		return manager.find(TipoPagamento.class, id);
	}
	
	public List<TipoPagamento> listarTodos() {
		List<TipoPagamento> t = new ArrayList<TipoPagamento>();
		try {
			t = (List<TipoPagamento>) manager.createQuery("select t from TipoPagamento t", TipoPagamento.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return t;	
	}
		
}
