package br.com.fiap.shiftweb6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SHIFT6_MARCA")
public class MarcaModel {

	
	@Id
	@Column(name = "ID_MARCA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARCA_SEQ")
	@SequenceGenerator(name = "MARCA_SEQ", initialValue = 1, allocationSize = 1)
	private Long idMarca;
	
	@Column(name = "NOME_MARCA", length = 50, nullable = false)
	private String nomeMarca;

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	
	
	
	
}
