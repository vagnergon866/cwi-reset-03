package br.com.reset.primeiroprojetospring.Controler;

import br.com.reset.primeiroprojetospring.domain.Filme;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeControler {

    private static List<Filme> filmes = new ArrayList<>();

    @PostMapping("/{nome}")
    public Filme cadastrarFilme(@RequestBody Filme filme){
        filmes.add(filme);
        return filme;

    }

    private String consultaFilmeNome(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equals(nome)) {
                return nome;
            }
        }
        return null;
    }
    @DeleteMapping("/{nome}")
    public void deleteFilme(@PathVariable String nome){
        String filme = consultaFilmeNome(nome);
        if(filme != null){
            filmes.remove(filme);
        }

    }
    @PutMapping("/{nome}")
    public void atualizarFilme(@PathVariable String nome, @RequestBody Filme filme){
        String filmeCadastrado = consultaFilmeNome(filme.getNome());
        if (filmeCadastrado != null){
            filmes.remove(filmeCadastrado);
            filmes.add(filme);
        }
    }
}
