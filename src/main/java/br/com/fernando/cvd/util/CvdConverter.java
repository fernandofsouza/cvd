package br.com.fernando.cvd.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.fernando.cvd.model.TipoPagamento;
import br.com.fernando.cvd.service.TipoPagamentoService;

//@ManagedBean(value="cvdConverter")
@FacesConverter(value="cvdConverter")
@SessionScoped
public class CvdConverter implements Converter, Serializable {
    
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private TipoPagamentoService tipoPagamentoService;

    /* ... */
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        long id = Long.parseLong(value);
        return tipoPagamentoService.buscarPorId(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        return ((TipoPagamento)value).getId().toString();
    }
}