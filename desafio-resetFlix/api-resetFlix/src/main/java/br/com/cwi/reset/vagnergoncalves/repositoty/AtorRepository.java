package br.com.cwi.reset.vagnergoncalves.repositoty;

import br.com.cwi.reset.vagnergoncalves.domain.Ator;
import br.com.cwi.reset.vagnergoncalves.domain.StatusCarreira;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    Ator findByNome(String nome);
    List<Ator> findAll();

    List<Ator> findByStatusCarreira(StatusCarreira statusCarreira);
}