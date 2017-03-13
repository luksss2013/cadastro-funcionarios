package application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import application.model.Funcionario;
import application.model.Usuario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

	@Transactional
	Long removeByNomeFuncionario(String nomeFuncionario);

}
