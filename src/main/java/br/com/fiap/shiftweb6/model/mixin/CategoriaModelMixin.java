package br.com.fiap.shiftweb6.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fiap.shiftweb6.model.CategoriaModel;

public interface CategoriaModelMixin {

	@JsonIgnore
	CategoriaModel getCategoriaModel();
	
	
}
