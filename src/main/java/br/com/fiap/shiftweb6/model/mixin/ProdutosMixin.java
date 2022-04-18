package br.com.fiap.shiftweb6.model.mixin;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.fiap.shiftweb6.model.ProdutoModel;

public interface ProdutosMixin {

	@JsonIgnore
	List<ProdutoModel> getProdutos();
	
}
