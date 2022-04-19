package br.com.fiap.shiftweb6.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SHIFT6_LOJA")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class LojaModel {

	
	@Id
	@Column(name = "ID_LOJA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOJA_SEQ")
	@SequenceGenerator(name = "LOJA_SEQ", initialValue = 1, allocationSize = 1)
	private Long idLoja;
	
	@Column(name = "NOME_LOJA")
	private String nomeLoja;
	
	@ManyToMany( mappedBy = "lojas" ,  fetch = FetchType.EAGER )
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<ProdutoModel> produtos;

	
	public Long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Long idLoja) {
		this.idLoja = idLoja;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	
	
	
	
	
	
}
