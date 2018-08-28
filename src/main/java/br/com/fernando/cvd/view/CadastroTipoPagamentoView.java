package br.com.fernando.cvd.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.TipoPagamento;
import br.com.fernando.cvd.service.TipoPagamentoService;

@Named
@ViewScoped
public class CadastroTipoPagamentoView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private TipoPagamento tipoPagamento = new TipoPagamento();
	
	private Long idTipoPagamento;
	
	@Inject
	private TipoPagamentoService tipoPagamentoService;
	
	
	public void inicializar() {
		if (idTipoPagamento != null) {
			tipoPagamento = tipoPagamentoService.buscarPorId(idTipoPagamento);
		}
	}
	
	
	public String salvar() {
		tipoPagamentoService.salvar(tipoPagamento);
		return "lista-tipo-pagamento.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		tipoPagamentoService.excluir(tipoPagamento);
		return "lista-tipo-pagamento.xhtml?faces-redirect=true";
	}


	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}


	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


	public Long getIdTipoPagamento() {
		return idTipoPagamento;
	}


	public void setIdTipoPagamento(Long idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

}
