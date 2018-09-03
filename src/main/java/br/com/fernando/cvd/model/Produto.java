package br.com.fernando.cvd.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Produto implements Serializable{


private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String nome;

@Column(name="descricao_produto")
private String descricao;

@Column(name="preco_unit")
private Double precoUnitario;

@Column(name="estoque")
private Boolean estoque;

@Column(name="qtd_estoque")
private Double quantidadeEstoque;

@Column(name="qtd_reservado")
private Double quantidadeReservado;

@Column(name="cod_produto")
private String codigo;

@Column(name="avaliacao")
private Integer avaliacao;





@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="produto")
@Fetch(FetchMode.SELECT)
private List<Imagem> imagens;

@OneToOne
@JoinColumn(name="id_categoria")
private CategoriaProduto categoriaProduto;


@OneToOne
@JoinColumn(name="id_caract")
private CaracteristicaProduto caracteristicaProduto;


public Produto() {
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public List<Imagem> getImagens() {
	return imagens;
}

public void setImagens(List<Imagem> imagem) {
	this.imagens = imagem;
}

public CategoriaProduto getCategoriaProduto() {
	return categoriaProduto;
}

public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
	this.categoriaProduto = categoriaProduto;
}

public CaracteristicaProduto getCaracteristicaProduto() {
	return caracteristicaProduto;
}

public void setCaracteristicaProduto(CaracteristicaProduto caracteristicaProduto) {
	this.caracteristicaProduto = caracteristicaProduto;
}
public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public Double getPrecoUnitario() {
	return precoUnitario;
}

public void setPrecoUnitario(Double precoUnitario) {
	this.precoUnitario = precoUnitario;
}

public Boolean getEstoque() {
	return estoque;
}

public void setEstoque(Boolean estoque) {
	this.estoque = estoque;
}

public Double getQuantidadeEstoque() {
	return quantidadeEstoque;
}

public void setQuantidadeEstoque(Double quantidadeEstoque) {
	this.quantidadeEstoque = quantidadeEstoque;
}

public Double getQuantidadeReservado() {
	return quantidadeReservado;
}

public void setQuantidadeReservado(Double quantidadeReservado) {
	this.quantidadeReservado = quantidadeReservado;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public Integer getAvaliacao() {
	return avaliacao;
}

public void setAvaliacao(Integer avaliacao) {
	this.avaliacao = avaliacao;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((caracteristicaProduto == null) ? 0 : caracteristicaProduto.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
	Produto other = (Produto) obj;
	if (caracteristicaProduto == null) {
		if (other.caracteristicaProduto != null)
			return false;
	} else if (!caracteristicaProduto.equals(other.caracteristicaProduto))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	return true;
}

@Override
public String toString() {
	return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario
			+ ", estoque=" + estoque + ", quantidadeEstoque=" + quantidadeEstoque + ", quantidadeReservado="
			+ quantidadeReservado + ", codigo=" + codigo + ", avaliacao=" + avaliacao + ", categoriaProduto="
			+ categoriaProduto.getDescricao() + ", caracteristicaProduto=" + caracteristicaProduto.getDescricao() + "]";
}







}