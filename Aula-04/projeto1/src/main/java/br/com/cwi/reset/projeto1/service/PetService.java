package br.com.cwi.reset.projeto1.service;


import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;

import java.util.List;

public class PetService {

    private static PetRepository repository = new PetRepository();

    public static Pet salvar(Pet pet) throws PetJaExistenteException{
        Pet petJaExistente = repository.findByNome(pet.getNome());

        if (petJaExistente != null){
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " já existe! ");
        }
        repository.save(pet);
        return pet;
    }

    public static List<Pet> listarTodos(){
        return repository.findAll();
    }

    public static Pet buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public static void deletar(String nomePet) throws PetJaExistenteException {
        Pet pet = buscarPorNome(nomePet);
        if (pet == null) {
            throw new PetJaExistenteException("Pet com o nome " + nomePet + " não existe");
        }
        repository.delete(pet);
    }
    public Pet atualizar(Pet pet) throws PetJaExistenteException {
        Pet PetJaCadastrado = buscarPorNome(pet.getNome());
        if (pet == null) {
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " não existe");
        }
        return repository.update(pet);
    }
}
