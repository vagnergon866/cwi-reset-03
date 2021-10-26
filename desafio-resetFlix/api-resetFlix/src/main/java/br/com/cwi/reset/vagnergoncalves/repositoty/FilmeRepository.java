package br.com.cwi.reset.vagnergoncalves.repositoty;

import br.com.cwi.reset.vagnergoncalves.domain.Filme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmeRepository extends CrudRepository<Filme, Integer> {

    Filme findBynome(String nome);
    List<Filme> findAll();

}
