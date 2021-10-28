package br.com.cwi.reset.vagnergoncalves.repositoty;

import br.com.cwi.reset.vagnergoncalves.domain.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

    Estudio findByNomeEqualsIgnoreCase(String nome);

    List<Estudio> findByNomeContainingIgnoreCase( String filtroNome);
}
