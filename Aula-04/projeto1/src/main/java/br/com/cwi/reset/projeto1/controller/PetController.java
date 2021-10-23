package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.FilmeJaExistenteException;
import br.com.cwi.reset.projeto1.exception.FilmeNaoExistenteException;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private PetService petService = new PetService();

    @PostMapping
    public ResponseEntity<Pet> cadastrarPet(@RequestBody Pet pet) {
        try {
            Pet petSalvo = PetService.salvar(pet);
            return ResponseEntity.ok(petSalvo);
        } catch (PetJaExistenteException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public List<Pet> consultarTodos() {
        return PetService.listarTodos();
    }

    @GetMapping("/{nome}")
    public Pet buscarPetPeloNome(@PathVariable String nome) {
        return PetService.buscarPorNome(nome);
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity deletarPet(@PathVariable String nome) {
        try {
            PetService.deletar(nome);
            return ResponseEntity.ok().build();
        } catch (PetJaExistenteException exception) {
            return ResponseEntity.badRequest().build();
        }
    }


}
