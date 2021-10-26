package br.com.cwi.reset.vagnergoncalves.repositoty;

import br.com.cwi.reset.vagnergoncalves.domain.Diretor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiretorRepository extends CrudRepository<Diretor, Integer> {

    Diretor findByNome(String nome);
    List<Diretor> findAll();

    List<Diretor> findByNomeContainsIgnoreCase(String filtroNome);

}
