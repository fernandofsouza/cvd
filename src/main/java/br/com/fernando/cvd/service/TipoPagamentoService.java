package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.TipoPagamentoDao;
import br.com.fernando.cvd.model.TipoPagamento;



public class TipoPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private TipoPagamentoDao tipoPagamentoDao;

	
	public void salvar(TipoPagamento tipoPagamento) {
		
		tipoPagamentoDao.salvar(tipoPagamento);
	}

	
	public void excluir(TipoPagamento tipoPagamento) {
		tipoPagamentoDao.excluir(tipoPagamento);
	}

	public List<TipoPagamento> listarTodos() {
		return tipoPagamentoDao.listarTodos();
	}
	

	public TipoPagamento buscarPorId(Long id) {
		return tipoPagamentoDao.buscarPorId(id);
	}

}
