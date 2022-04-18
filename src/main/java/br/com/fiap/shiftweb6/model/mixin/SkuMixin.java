package br.com.fiap.shiftweb6.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SkuMixin {

	@JsonIgnore
	String getSku();
	
}
