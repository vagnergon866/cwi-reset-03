package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Integer> {

    Pet findByNome(String nome);

    Pet findBysalvar(Pet pet);

    Pet findByatualizar(Pet pet);

    List<Pet> findBylistarTodos();

    void findBydeletar(Pet pet);


}
