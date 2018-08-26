package br.com.fernando.cvd.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.TipoUsuario;
import br.com.fernando.cvd.service.TipoUsuarioService;

@Named
@ViewScoped
public class CadastroTipoUsuarioView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private TipoUsuario tipoUsuario = new TipoUsuario();
	
	private Long idTipoUsuario;
	
	@Inject
	private TipoUsuarioService tipoUsuarioService;
	
	
	public void inicializar() {
		if (idTipoUsuario != null) {
			tipoUsuario = tipoUsuarioService.buscarPorId(idTipoUsuario);
		}
	}
	
	
	public String salvar() {
		tipoUsuarioService.salvar(tipoUsuario);
		return "lista-tipoUsuario.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		tipoUsuarioService.excluir(tipoUsuario);
		return "lista-tipoUsuario.xhtml?faces-redirect=true";
	}


	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public Long getIdTipoUsuario() {
		return idTipoUsuario;
	}


	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

}
