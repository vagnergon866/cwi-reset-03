package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.List;

public interface PetRepository {

    Pet buscarPeloNome(String nome);

    Pet salvar(Pet pet);

    Pet atualizar(Pet pet);

    List<Pet> listarTodos();

    void deletar(Pet pet);
}
