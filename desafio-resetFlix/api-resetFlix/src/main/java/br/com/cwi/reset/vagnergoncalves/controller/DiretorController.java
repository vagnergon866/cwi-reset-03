package br.com.cwi.reset.vagnergoncalves.controller;

import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
import br.com.cwi.reset.vagnergoncalves.domain.Diretor;
import br.com.cwi.reset.vagnergoncalves.request.DiretorRequest;
import br.com.cwi.reset.vagnergoncalves.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController(){
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception{
        this.diretorService.cadastrarDiretor(diretorRequest);
     }
    @GetMapping
    public List<Diretor> listarDiretores(String filtroNome) throws Exception{
        return diretorService.listarDiretores(filtroNome);
    }
    @GetMapping("/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id)throws Exception{
        return diretorService.consultarDiretor(id);
    }

}
