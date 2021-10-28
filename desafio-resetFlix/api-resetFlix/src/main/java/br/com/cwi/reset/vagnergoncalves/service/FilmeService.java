package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.domain.*;
import br.com.cwi.reset.vagnergoncalves.exception.*;
import br.com.cwi.reset.vagnergoncalves.repositoty.FilmeRepository;
import br.com.cwi.reset.vagnergoncalves.request.FilmeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import static java.util.Objects.isNull;


@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private DiretorService diretorService;
    @Autowired
    private EstudioService estudioService;
    @Autowired
    private PersonagemService personagemService;


    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        Long generoDuplicado = filmeRequest.getGeneros().stream()
                .filter(genero -> Collections.frequency(filmeRequest.getGeneros(), genero) > 1)
                .count();

        if(generoDuplicado > 0){
            throw new GeneroDuplicadoException();
        }

        Diretor diretor = diretorService.consultarDiretor(filmeRequest.getIdDiretor());
        Estudio estudio = estudioService.consultarEstudio(filmeRequest.getIdEstudio());
        List<PersonagemAtor> personagens = personagemService.criarPersonagemAtor(filmeRequest.getPersonagens());

        Filme filme = new Filme(filmeRequest.getNome(), filmeRequest.getAnoLancamento(),
                filmeRequest.getCapaFilme(), filmeRequest.getGeneros(), estudio, diretor,
                personagens, filmeRequest.getResumo());


        this.filmeRepository.save(filme);
    }

    public List<Filme> consultarFilmes(
            String nomeFilme,
            String nomeDiretor,
            String nomePersonagem,
            String nomeAtor) throws Exception {
        List<Filme> filmesCadastrados = this.filmeRepository.findAll();

        if (filmeRepository.count() == 0) {
            throw new ListaVaziaException(TipoDominioException.FILME.getSingular(), TipoDominioException.FILME.getPlural());
        }

        List<Filme> filtrarNomePersonagem = filtrarNomePersonagem(filmesCadastrados, nomePersonagem);
        List<Filme> filtrarNomeAtor = filtrarNomeAtor(filtrarNomePersonagem, nomeAtor);
        List<Filme> filtrarNomeDiretor = filtrarNomeDiretor(filtrarNomeAtor, nomeDiretor);
        List<Filme> filtroFinal = filtrarNomeFilme(filtrarNomeDiretor, nomeFilme);

        if (filtroFinal.isEmpty()) {
            throw new FiltrosNaoEncontradosEmFilmesException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
        }

        return filtroFinal;
    }

    private List<Filme> filtrarNomeFilme(final List<Filme> listaOriginal, String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            if (filme.getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                filmeFiltrado.add(filme);
            }
        }

        return filmeFiltrado;
    }

    private List<Filme> filtrarNomeDiretor(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            if (filme.getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                filmeFiltrado.add(filme);
            }
        }

        return filmeFiltrado;
    }

    private List<Filme> filtrarNomeAtor(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            for (PersonagemAtor personagens : filme.getPersonagens()) {
                if (personagens.getAtor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                    filmeFiltrado.add(filme);
                    break;
                }
            }
        }

        return filmeFiltrado;
    }

    private List<Filme> filtrarNomePersonagem(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            for (PersonagemAtor personagens : filme.getPersonagens()) {
                if (personagens.getNomePersonagem()
                        .toLowerCase(Locale.ROOT)
                        .equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))
                ) {
                    filmeFiltrado.add(filme);
                    break;
                }
            }
        }

        return filmeFiltrado;
    }

}
