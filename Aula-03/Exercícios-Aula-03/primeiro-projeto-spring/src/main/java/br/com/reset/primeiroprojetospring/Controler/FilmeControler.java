package br.com.reset.primeiroprojetospring.Controler;

import br.com.reset.primeiroprojetospring.domain.Filme;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.FilteredImageSource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeControler {

    private static List<Filme> filmes = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme){
        Filme filmeExistente = buscarPorNome(filme.getNome());
        if (filmeExistente != null){
            return ResponseEntity.badRequest().build();
        }
        filmes.add(filme);
        return ResponseEntity.ok(filme);
    }
    @GetMapping
    public List<Filme> consultarTodos(){
        return filmes;
    }
    @GetMapping("/{nome}")
    public Filme buscarFilmePeloNome(@PathVariable String nome){
        return buscarPorNome(nome);
    }


    @DeleteMapping("/{nome}")
    public void deleteFilme(@PathVariable String nome){
        Filme filme = buscarFilmePeloNome(nome);
        if(filme != null){
            filmes.remove(filme);
        }

    }
    @PutMapping
    public Filme atualizarFilme( @RequestBody Filme filme){
        Filme filmeCadastrado = buscarFilmePeloNome(filme.getNome());
        if (filmeCadastrado != null){
            filmes.remove(filmeCadastrado);
            filmes.add(filme);
        }
        return null;
    }
    private Filme buscarPorNome(String nome){
        for(Filme filme : filmes){
            if(filme.getNome().equals(nome)){
                return filme;

            }
        }
        return null;
    }
}
