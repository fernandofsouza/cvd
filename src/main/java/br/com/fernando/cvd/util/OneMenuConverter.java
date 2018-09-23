package br.com.fernando.cvd.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.fernando.cvd.model.StatusPedido;
import br.com.fernando.cvd.service.StatusPedidoService;


@FacesConverter(value="oneMenuConverter")
@SessionScoped
public class OneMenuConverter implements Converter, Serializable {
    
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private StatusPedidoService service;

    /* ... */
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        long id = Long.parseLong(value);
        return service.buscarPorId(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        return ((StatusPedido)value).getId().toString();
    }
}