package br.com.fernando.cvd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity(name="historico_status")
public class HistoricoPedido {


@SuppressWarnings("unused")
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="data")
private Date dataStatus;

@OneToOne
@JoinColumn(name="id_status")
private StatusPedido statusPedido;

@OneToOne
@JoinColumn(name="id_pedido")
private Pedido pedido;



public HistoricoPedido() {
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Date getDataStatus() {
	return dataStatus;
}

public void setDataStatus(Date dataStatus) {
	this.dataStatus = dataStatus;
}

public StatusPedido getStatusPedido() {
	return statusPedido;
}

public void setStatusPedido(StatusPedido statusPedido) {
	this.statusPedido = statusPedido;
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
	result = prime * result + ((dataStatus == null) ? 0 : dataStatus.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
	result = prime * result + ((statusPedido == null) ? 0 : statusPedido.hashCode());
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
	HistoricoPedido other = (HistoricoPedido) obj;
	if (dataStatus == null) {
		if (other.dataStatus != null)
			return false;
	} else if (!dataStatus.equals(other.dataStatus))
		return false;
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
	if (statusPedido == null) {
		if (other.statusPedido != null)
			return false;
	} else if (!statusPedido.equals(other.statusPedido))
		return false;
	return true;
}

@Override
public String toString() {
	return "HistoricoPedido [id=" + id + ", dataStatus=" + dataStatus + ", statusPedido=" + statusPedido + ", pedido="
			+ pedido + "]";
}



}