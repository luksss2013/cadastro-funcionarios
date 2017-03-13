package application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import application.model.Portfolio;
import application.model.Usuario;

@Repository
public interface PortfolioRepository extends CrudRepository<Portfolio, Long>{

	@Transactional
	Long removeByNomeProjeto(String nomeProjeto);

}
