package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetRepository {

    private static List<Pet> pets = new ArrayList<>();

    public Pet buscarPeloNome(String nome) {
        for (Pet pet : pets) {
            if (pet.getNome().equals(nome)) {
                return pet;
            }
        }
        return null;
    }

    public Pet salvar(Pet pet) {
        pets.add(pet);
        return pet;
    }

    public void deletar(Pet pet) {
        pets.remove(pet);
    }

    public Pet atualizar(Pet pet) {
        Pet petCadastrado = buscarPeloNome(pet.getNome());

        if (petCadastrado != null) {
            pets.remove(petCadastrado);
            pets.add(pet);
            return pet;
        } else {
            return null;
        }
    }

    public List<Pet> listarTodos() {
        return pets;
    }
}
