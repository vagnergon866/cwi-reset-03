package br.com.cwi.reset.vagnergoncalves.repositoty;

import br.com.cwi.reset.vagnergoncalves.domain.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonagemRepository extends CrudRepository<PersonagemAtor, Integer> {

    List<PersonagemAtor> findAll();

    List<PersonagemAtor> findByAtorIdEquals(Integer idAtor);
}
