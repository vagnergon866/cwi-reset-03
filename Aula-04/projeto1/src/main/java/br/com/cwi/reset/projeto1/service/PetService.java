package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public Pet buscarPeloNome(String nome) throws PetNaoExistenteException {
        Pet pet = repository.findByNome(nome);

        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não existe");
        }

        return pet;
    }

    public Pet salvar(Pet pet) throws PetJaExistenteException {
        Pet petJaCadastrado = repository.findByNome(pet.getNome());

        if (petJaCadastrado != null) {
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " já existe");
        }

        return repository.findBysalvar(pet);
    }

    public void delete(String nome) throws PetNaoExistenteException {
        Pet pet = repository.findByNome(nome);

        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não existe");
        }

        repository.findBydeletar(pet);
    }

    public Pet atualizar(Pet pet) throws PetNaoExistenteException {
        Pet petJaCadastrado = repository.findByNome(pet.getNome());

        if (petJaCadastrado == null) {
            throw new PetNaoExistenteException("Pet com o nome " + pet.getNome() + " não existe");
        }

        return repository.findByatualizar(pet);
    }

    public List<Pet> listarTodos() {
        return repository.findBylistarTodos();
    }
}
