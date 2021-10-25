package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.domain.Ator;
import br.com.cwi.reset.vagnergoncalves.repositoty.AtorRepository;
import br.com.cwi.reset.vagnergoncalves.response.AtorEmAtividade;
import br.com.cwi.reset.vagnergoncalves.domain.StatusCarreira;
import br.com.cwi.reset.vagnergoncalves.exception.*;
import br.com.cwi.reset.vagnergoncalves.request.AtorRequest;
import br.com.cwi.reset.vagnergoncalves.validador.BasicInfoRequiredValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;


    public void criarAtor(AtorRequest atorRequest) throws Exception {

        final List<Ator> atoresCadastrados = repository.findAll();

        for (Ator atorCadastrado : atoresCadastrados) {
            if (atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.ATOR.getSingular(), atorRequest.getNome());
            }
        }

        final Integer idGerado = atoresCadastrados.size() + 1;

        final Ator ator = new Ator(idGerado, atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade());

        repository.save(ator);
    }

//    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
//        final List<Ator> atoresCadastrados = repository.findByrecuperaAtores();
//
//        if (atoresCadastrados.isEmpty()) {
//            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
//        }
//
//        final List<AtorEmAtividade> retorno = new ArrayList<>();
//
//        if (filtroNome != null) {
//            for (Ator ator : atoresCadastrados) {
//                final boolean containsFilter = ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
//                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
//                if (containsFilter && emAtividade) {
//                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
//                }
//            }
//        } else {
//            for (Ator ator : atoresCadastrados) {
//                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
//                if (emAtividade) {
//                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
//                }
//            }
//        }
//
//        if (retorno.isEmpty()) {
//            throw new FiltroNomeNaoEncontrado("Ator", filtroNome);
//        }
//
//        return retorno;
//    }
//
//    public Ator consultarAtor(Integer id) throws Exception {
//        if (id == null) {
//            throw new IdNaoInformado();
//        }
//
//        final List<Ator> atores = repository.findByrecuperaAtores();
//
//        for (Ator ator : atores) {
//            if (ator.getId().equals(id)) {
//                return ator;
//            }
//        }
//
//        throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
//    }
//
//    public List<Ator> consultarAtores() throws Exception {
//        final List<Ator> atores = repository.findByrecuperaAtores();
//
//        if (atores.isEmpty()) {
//            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
//        }
//
//        return atores;
//    }
}