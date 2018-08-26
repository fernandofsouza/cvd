package br.com.fernando.cvd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.TipoPagamento;
import br.com.fernando.cvd.service.TipoPagamentoService;
import br.com.fernando.cvd.util.FacesUtil;


@Named
@ViewScoped
public class ListaTipoPagamentoView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoPagamentoService tipoPagamentoService;
	
	private List<TipoPagamento> tiposPagamento = new ArrayList<>();
	
	private List<TipoPagamento> tiposPagamentoSelecionados = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		tiposPagamento = tipoPagamentoService.listarTodos();		
	}
	
	public void excluirSelecionados() {
		for (TipoPagamento tipoPagamento : tiposPagamentoSelecionados) {
			tipoPagamentoService.excluir(tipoPagamento);
			tiposPagamento.remove(tipoPagamento);
		}
		
		FacesUtil.addInfoMessage("TipoPagamento(s) excluído(s) com sucesso!");
	}

	public List<TipoPagamento> getTipoPagamentos() {
		return tiposPagamento;
	}

	public void setTipoPagamentos(List<TipoPagamento> tiposPagamento) {
		this.tiposPagamento = tiposPagamento;
	}

	public List<TipoPagamento> getTipoPagamentoSelecionados() {
		return tiposPagamentoSelecionados;
	}

	public void setTipoPagamentoSelecionados(List<TipoPagamento> tiposPagamentoSelecionados) {
		this.tiposPagamentoSelecionados = tiposPagamentoSelecionados;
	}


}
