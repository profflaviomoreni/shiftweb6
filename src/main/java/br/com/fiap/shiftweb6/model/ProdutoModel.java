package br.com.fiap.shiftweb6.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="SHIFT6_PRODUTO")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ProdutoModel {

	
	@Id
	@Column(name = "ID_PRODUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
	@SequenceGenerator(name = "PRODUTO_SEQ", initialValue = 1, allocationSize = 1)
	private Long idProduto;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "SKU")
	private String sku;
	
	@Column(name = "FOTO")
	private String foto;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "PRECO")
	private float preco;
	
	@Column(name = "CARACTERISTICAS")
	private String caracteristicas;
	
	@Column(name = "DATA_LANCAMENTO")
	private Date dataLancamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_MARCA", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private MarcaModel marcaModel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CATEGORIA", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CategoriaModel categoriaModel;
	
	
	@ManyToMany
	@JoinTable(  
			name = "SHIFT6_PRODUTO_LOJA",
			joinColumns = @JoinColumn( name="ID_PRODUTO", referencedColumnName = "ID_PRODUTO"),
			inverseJoinColumns = @JoinColumn( name="ID_LOJA", referencedColumnName = "ID_LOJA")
			)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<LojaModel> lojas;
	
	
	
	
	
	public List<LojaModel> getLojas() {
		return lojas;
	}

	public void setLojas(List<LojaModel> lojas) {
		this.lojas = lojas;
	}

	public MarcaModel getMarcaModel() {
		return marcaModel;
	}

	public void setMarcaModel(MarcaModel marcaModel) {
		this.marcaModel = marcaModel;
	}

	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}

	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	
	
	
	
	
}
