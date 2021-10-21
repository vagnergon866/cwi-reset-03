package br.com.cwi.reset.vagnergoncalves.controller;

import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
import br.com.cwi.reset.vagnergoncalves.domain.Filme;
import br.com.cwi.reset.vagnergoncalves.request.FilmeRequest;
import br.com.cwi.reset.vagnergoncalves.service.FilmeSevice;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filme")
public class FilmeController {
    private FilmeSevice filmeSevice;

    public FilmeController(){
        this.filmeSevice = new FilmeSevice(FakeDatabase.getInstance());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws Exception{
         this.filmeSevice.criarFilme(filmeRequest);
    }
    @GetMapping
    public List<Filme> consultarFilmes(@RequestParam String nomeFilme,
                                       @RequestParam String nomeDiretor,@RequestParam String nomePersonagem,
                                       @RequestParam String nomeAtor) throws Exception{

        return this.filmeSevice.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }
}
