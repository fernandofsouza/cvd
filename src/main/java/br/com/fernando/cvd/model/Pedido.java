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
@JoinColumn(name="id_cliente")
private Usuario usuario;

@Column(name="codigo_rastreamento")
private String rastreamento;

private Double frete;

@OneToMany(mappedBy="pedido")
private List<ItemPedido> itemPedido = new ArrayList<>();

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

@Override
public String toString() {
	return "Pedido [id=" + id + ", numeroPedido=" + numeroPedido + ", dataPedido=" + dataPedido + ", dataPagamento="
			+ dataPagamento + ", usuario=" + usuario + ", rastreamento=" + rastreamento + ", frete=" + frete
			+ ", itemPedido=" + itemPedido + "]";
}


}