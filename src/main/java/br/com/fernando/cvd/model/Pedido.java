package br.com.fernando.cvd.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Pedido implements Serializable{


private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="num_pedido")
private Long numeroPedido;

@Column(name="data_pedido")
private Date dataPedido;

@Column(name="data_pagamento")
private Date dataPagamento;

@OneToOne
@JoinColumn(name="id_tipo_pagamento")
private TipoPagamento tipoPagamento;

@OneToOne
@JoinColumn(name="id_cliente")
private Usuario usuario;

@OneToOne
@JoinColumn(name="vendedor")
private Usuario vendedor;

@Column(name="codigo_rastreamento")
private String rastreamento;

private Double frete;

private Double total; 

@OneToMany(mappedBy="pedido")
private List<ItemPedido> itemPedido = new ArrayList<>();

@OneToOne
@JoinColumn(name="id_promocao")
private Promocao promocao;

@OneToOne
@JoinColumn(name="id_status")
private StatusPedido statusPedido;



public Pedido() {
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getNumeroPedido() {
	return numeroPedido;
}

public void setNumeroPedido(Long numeroPedido) {
	this.numeroPedido = numeroPedido;
}

public Date getDataPedido() {
	return dataPedido;
}

public void setDataPedido(Date dataPedido) {
	this.dataPedido = dataPedido;
}

public Date getDataPagamento() {
	return dataPagamento;
}

public void setDataPagamento(Date dataPagamento) {
	this.dataPagamento = dataPagamento;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

public String getRastreamento() {
	return rastreamento;
}

public void setRastreamento(String rastreamento) {
	this.rastreamento = rastreamento;
}

public Double getFrete() {
	return frete;
}

public void setFrete(Double frete) {
	this.frete = frete;
}

public List<ItemPedido> getItemPedido() {
	return itemPedido;
}

public void setItemPedido(List<ItemPedido> itemPedido) {
	this.itemPedido = itemPedido;
}


public Double getTotal() {
	return total;
}

public void setTotal(Double total) {
	this.total = total;
}


public TipoPagamento getTipoPagamento() {
	return tipoPagamento;
}

public void setTipoPagamento(TipoPagamento tipoPagamento) {
	this.tipoPagamento = tipoPagamento;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((dataPedido == null) ? 0 : dataPedido.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((tipoPagamento == null) ? 0 : tipoPagamento.hashCode());
	result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
	Pedido other = (Pedido) obj;
	if (dataPedido == null) {
		if (other.dataPedido != null)
			return false;
	} else if (!dataPedido.equals(other.dataPedido))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (tipoPagamento == null) {
		if (other.tipoPagamento != null)
			return false;
	} else if (!tipoPagamento.equals(other.tipoPagamento))
		return false;
	if (usuario == null) {
		if (other.usuario != null)
			return false;
	} else if (!usuario.equals(other.usuario))
		return false;
	return true;
}

@Override
public String toString() {
	return "Pedido [id=" + id + ", numeroPedido=" + numeroPedido + ", dataPedido=" + dataPedido + ", dataPagamento="
			+ dataPagamento + ", tipoPagamento=" + tipoPagamento + ", usuario=" + usuario + ", rastreamento="
			+ rastreamento + ", frete=" + frete + ", total=" + total + ", itemPedido=" + itemPedido + "]";
}

public Promocao getPromocao() {
	return promocao;
}

public void setPromocao(Promocao promocao) {
	this.promocao = promocao;
}

public StatusPedido getStatusPedido() {
	return statusPedido;
}

public void setStatusPedido(StatusPedido statusPedido) {
	this.statusPedido = statusPedido;
}

public Usuario getVendedor() {
	return vendedor;
}

public void setVendedor(Usuario vendedor) {
	this.vendedor = vendedor;
}


}