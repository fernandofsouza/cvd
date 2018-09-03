package br.com.fernando.cvd.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fernando.cvd.model.Produto;
import br.com.fernando.cvd.service.ProdutoService;

@Named
@ApplicationScoped
public class ImagemProdutoView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoService produtoService;

	public StreamedContent getImagem() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so
			// that it will generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			String produtoId = context.getExternalContext().getRequestParameterMap().get("produtoId");
			Produto produto = produtoService.buscarPorId(Long.valueOf(produtoId));
			System.out.println("produtoId: "+produtoId);
			return new DefaultStreamedContent(new ByteArrayInputStream(produto.getImagens().get(0).getImagem()));
		}
	}
}
