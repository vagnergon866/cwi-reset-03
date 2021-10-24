package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Ator;
import org.springframework.data.repository.CrudRepository;



public class AtorRepository implements CrudRepository<Ator, Integer> {

     Ator findByNome(String nome);

    Ator findByQuantidadeOscar(Integer numeroOscars);
}

