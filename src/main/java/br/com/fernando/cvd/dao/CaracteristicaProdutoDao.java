package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.CaracteristicaProduto;



@Stateless
public class CaracteristicaProdutoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public CaracteristicaProduto salvar(CaracteristicaProduto caracteristicaProduto) {
		return manager.merge(caracteristicaProduto);
	}
	
	public void excluir(CaracteristicaProduto caracteristicaProduto) {
		try {
			caracteristicaProduto = buscarPorId(caracteristicaProduto.getId());
			manager.remove(caracteristicaProduto);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Caracteristca não pode ser excluída");
		}
	}

	public CaracteristicaProduto buscarPorId(Long id) {		
		return manager.find(CaracteristicaProduto.class, id);
	}
	
	
	public List<CaracteristicaProduto> listarTodos() {
		List<CaracteristicaProduto> c = new ArrayList<CaracteristicaProduto>();
		try {
			c = (List<CaracteristicaProduto>) manager.createQuery("Select c FROM CaracteristicaProduto c", CaracteristicaProduto.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return c;	
	}
		
}
