package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
import br.com.cwi.reset.vagnergoncalves.domain.Diretor;
import br.com.cwi.reset.vagnergoncalves.domain.Estudio;
import br.com.cwi.reset.vagnergoncalves.domain.Filme;
import br.com.cwi.reset.vagnergoncalves.domain.PersonagemAtor;
import br.com.cwi.reset.vagnergoncalves.exception.FiltrosNaoEncontradosFilmeException;
import br.com.cwi.reset.vagnergoncalves.exception.GeneroDuplicadoException;
import br.com.cwi.reset.vagnergoncalves.exception.ListaVaziaException;
import br.com.cwi.reset.vagnergoncalves.exception.TipoDominioException;
import br.com.cwi.reset.vagnergoncalves.request.FilmeRequest;
import br.com.cwi.reset.vagnergoncalves.validador.BasicInfoRequiredValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilmeSevice {

    private FakeDatabase fakeDatabase;
    private DiretorService diretorService;
    private PersonagemService personagemService;
    private EstudioService estudioService;

    public FilmeSevice(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
        this.personagemService = new PersonagemService(FakeDatabase.getInstance());
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {
        new BasicInfoRequiredValidator().accept(filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(), filmeRequest.getIdDiretor(), filmeRequest.getIdEstudio(),
                filmeRequest.getResumo(), filmeRequest.getPersonagens());


        Integer generoDublicado = Math.toIntExact(filmeRequest.getGeneros()
                .stream().filter(genero -> Collections.frequency(filmeRequest.getGeneros(),
                        genero) > 1).count());
        if (generoDublicado > 0) {
            throw new GeneroDuplicadoException();
        }

        Diretor diretor = diretorService.consultarDiretor(filmeRequest.getIdDiretor());
        Estudio estudio = estudioService.consultarEstudio(filmeRequest.getIdEstudio());
        List<PersonagemAtor> personagens = personagemService.criarPersonagem(filmeRequest.getPersonagens());

        Integer idGerado = fakeDatabase.recuperaFilmes().size() + 1;

        Filme filme = new Filme(idGerado, filmeRequest.getNome(), filmeRequest.getAnoLancamento(),
                filmeRequest.getCapaFilme(), filmeRequest.getGeneros(), estudio, diretor, personagens, filmeRequest.getResumo());
        fakeDatabase.persisteFilme(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws Exception {
        List<Filme> filmesCadastrados = fakeDatabase.recuperaFilmes();

        if (filmesCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.Filme.getSingular(), TipoDominioException.Filme.getPlural());
        }

        List<Filme> retorno = new ArrayList<>();
        boolean filtroNomeFilme = !nomeFilme.equals("");
        boolean filtroNomePersonagem = !nomePersonagem.equals("");
        boolean filtroNomeDiretor = !nomeDiretor.equals("");
        boolean filtroNomeAtor = !nomeAtor.equals("");

        boolean contemNome = false;
        boolean contemPersonagem = false;
        boolean contemAtor = false;
        boolean contemDiretor = false;

        for (Filme filme : filmesCadastrados) {
            if (filtroNomeFilme) {
                contemNome = filme.getNome().toLowerCase().contains(nomeFilme.toLowerCase());
            }
            if (filtroNomePersonagem) {
                for (PersonagemAtor personagem : filme.getPersonagens()) {
                    contemPersonagem = personagem.getNomePersonagem().toLowerCase().contains(nomePersonagem.toLowerCase());
                }
            }
            if (filtroNomeDiretor) {
                contemDiretor = filme.getDiretor().getNome().toLowerCase().contains(nomeDiretor.toLowerCase());
            }
            if (filtroNomeAtor) {
                for (PersonagemAtor ator : filme.getPersonagens()) {
                    contemAtor = ator.getAtor().getNome().toLowerCase().contains(nomeAtor.toLowerCase());
                }
            }
            boolean algunsFiltros = contemNome || contemDiretor || contemPersonagem || contemAtor;
            if (algunsFiltros) {
                retorno.add(filme);
                System.out.println(filme);
            }
        }
        if (retorno.isEmpty()) {
            throw new FiltrosNaoEncontradosFilmeException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);

        }
        return retorno;

    }
}
