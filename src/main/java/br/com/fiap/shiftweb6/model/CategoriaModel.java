package br.com.fiap.shiftweb6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SHIFT6_CATEGORIA")
public class CategoriaModel {

	@Id
	@Column(name="ID_CATEGORIA")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQ")
	@SequenceGenerator( name = "CATEGORIA_SEQ", initialValue = 10, allocationSize = 1)
	private Long idCategoria;

	@Column(name="NOME_CATEGORIA")
	private String nomeCategoria;
	
	@Column(name="ATIVO")	
	private Boolean ativo;
	
	
	
	public CategoriaModel() {
		super();
	}

	public CategoriaModel(Long idCategoria, String nomeCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
	}



	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}


	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "CategoriaModel [idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria + "]";
	}
	
	
}