package br.com.fiap.shiftweb6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.shiftweb6.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	
	public UsuarioModel findByEmailAndSenha(String email, String senha);

	public UsuarioModel findByEmail(String email);
	
	
	/*
	public void delete(int id) {
	
		String sql = "DELETE FROM tb_cliente WHERE id = " + id;
		
		abrir conexao com o banco
		abrir statement
		executar statement (sql)
		pegar a reposta
		finalizo
	
	}
	
	
	public List<Usuario> selectAll() {
	
		String sql = "SELECT * FROM tb_cliente ";
		
		abrir conexao com o banco
		abrir statement
		resultset executar statement (sql)
		
		while ( resultset.next() ) {
			UsuarioModel u = new UsuarioModel();
			u.setId( resultset.getInt("idUsuario");
			u.setNome( resultset.getInt("idUsuario");
			u.setId( resultset.getInt("idUsuario");
			u.setId( resultset.getInt("idUsuario");
			u.setId( resultset.getInt("idUsuario");
			
			lista.add(u);
		}
	
	}
	
	
	*/
	
}
