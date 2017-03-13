package application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	public Usuario findUsuarioByNomeUsuario(String nomeUsuario);

	public Usuario findUsuariosByNomeUsuarioEquals(String nomeUsuario);
	


}
