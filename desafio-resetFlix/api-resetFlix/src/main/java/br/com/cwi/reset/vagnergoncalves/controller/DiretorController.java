package br.com.cwi.reset.vagnergoncalves.controller;

import br.com.cwi.reset.vagnergoncalves.domain.Diretor;
import br.com.cwi.reset.vagnergoncalves.request.DiretorRequest;
import br.com.cwi.reset.vagnergoncalves.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception{
        this.diretorService.cadastrarDiretor(diretorRequest);
     }
    @GetMapping
    public List<Diretor> listarDiretores(@RequestParam String filtroNome) throws Exception{
        return diretorService.listarDiretores(filtroNome);
    }
    @GetMapping(value = "/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id)throws Exception{
        return diretorService.consultarDiretor(id);
    }

    @PutMapping("/{id}")
    public void atualizarDiretor(@PathVariable @Valid Integer id, @RequestBody @Valid DiretorRequest diretorRequest) throws Exception{
        this.diretorService.atualizarDiretor(id, diretorRequest);
    }

    @DeleteMapping("/{id}")
    public void removerDiretores(@PathVariable @Valid Integer id)throws Exception{
        diretorService.removeDiretor(id);
    }

}
