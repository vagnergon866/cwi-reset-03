package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.domain.Filme;
import br.com.cwi.reset.vagnergoncalves.domain.Genero;
import br.com.cwi.reset.vagnergoncalves.domain.PersonagemAtor;
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
    private PersonagemAtorService personagemAtorService;

    public FilmeService(FilmeRepository filmeRepository) {

    }

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {
        Filme filme = filmeRequest.convertObjeto();

        Set<Genero> generoSet = new HashSet<>();
        for (Genero genero : filme.getGeneros()) {
            if (generoSet.contains(genero)) {
                throw new GeneroDuplicadoException();
            } else {
                generoSet.add(genero);
            }
        }

        this.filmeRepository.save(filme);
    }

    public List<Filme> consultarFilmes(
            String nomeFilme,
            String nomeDiretor,
            String nomePersonagem,
            String nomeAtor) throws Exception {
        List<Filme> filmesCadastrados = this.filmeRepository.findAll();

        if (filmesCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.FILME.getSingular(), TipoDominioException.FILME.getPlural());
        }

        final List<Filme> filtrarNomePersonagem = filtrarNomePersonagem(filmesCadastrados, nomePersonagem);
        final List<Filme> filtrarNomeAtor = filtrarNomeAtor(filtrarNomePersonagem, nomeAtor);
        final List<Filme> filtrarNomeDiretor = filtrarNomeDiretor(filtrarNomeAtor, nomeDiretor);
        final List<Filme> filtroFinal = filtrarNomeFilme(filtrarNomeDiretor, nomeFilme);

        if (filtroFinal.isEmpty()) {
            throw new FiltrosNaoEncontradosEmFilmesException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
        }

        return filtroFinal;
    }

    private List<Filme> filtrarNomeFilme(final List<Filme> listaOriginal, final String nome) {
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
            if (filme.getDiretor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
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
