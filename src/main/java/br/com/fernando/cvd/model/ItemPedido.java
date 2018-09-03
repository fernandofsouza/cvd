package br.com.fernando.cvd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity(name="item_pedido")
public class ItemPedido implements Serializable{


private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@OneToOne
@JoinColumn(name="id_produto")
private Produto produto;

@Column(name="qtd")
private Double quantidade;

@Column(name="valor_unit")
private Double precoUnitario;

@ManyToOne
@JoinColumn(name="id_pedido")
private Pedido pedido;

public ItemPedido() {
	

}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Produto getProduto() {
	return produto;
}

public void setProduto(Produto produto) {
	this.produto = produto;
}

public Double getQuantidade() {
	return quantidade;
}

public void setQuantidade(Double quantidade) {
	this.quantidade = quantidade;
}

public Double getPrecoUnitario() {
	return precoUnitario;
}

public void setPrecoUnitario(Double precoUnitario) {
	this.precoUnitario = precoUnitario;
}

public Pedido getPedido() {
	return pedido;
}

public void setPedido(Pedido pedido) {
	this.pedido = pedido;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
	result = prime * result + ((produto == null) ? 0 : produto.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ItemPedido other = (ItemPedido) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (pedido == null) {
		if (other.pedido != null)
			return false;
	} else if (!pedido.equals(other.pedido))
		return false;
	if (produto == null) {
		if (other.produto != null)
			return false;
	} else if (!produto.equals(other.produto))
		return false;
	return true;
}

@Override
public String toString() {
	return "ItemPedido [id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + ", precoUnitario="
			+ precoUnitario + ", pedido=" + pedido + "]";
}



}