//package br.com.cwi.reset.vagnergoncalves.controller;
//
//import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
//import br.com.cwi.reset.vagnergoncalves.domain.Estudio;
//import br.com.cwi.reset.vagnergoncalves.request.EstudioRequest;
//import br.com.cwi.reset.vagnergoncalves.service.EstudioService;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/estudios")
//public class EstudioController {
//    private EstudioService estudioService;
//
//    private EstudioController(){
//        this.estudioService = new EstudioService(FakeDatabase.getInstance());
//    }
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception{
//        this.estudioService.criarEstudio(estudioRequest);
//    }
//    @GetMapping
//    public List<Estudio> consultarEstudios(@RequestParam String filtroNome)throws Exception{
//        return this.estudioService.consultarEstudios(filtroNome);
//    }
//    @GetMapping("/{id}")
//    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception{
//        return this.estudioService.consultarEstudio(id);
//    }
//
//}
