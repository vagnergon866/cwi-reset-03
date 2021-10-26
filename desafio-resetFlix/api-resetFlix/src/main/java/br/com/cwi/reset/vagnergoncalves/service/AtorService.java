package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.domain.Ator;
import br.com.cwi.reset.vagnergoncalves.domain.StatusCarreira;
import br.com.cwi.reset.vagnergoncalves.repositoty.AtorRepository;
import br.com.cwi.reset.vagnergoncalves.exception.*;
import br.com.cwi.reset.vagnergoncalves.request.AtorRequest;
import br.com.cwi.reset.vagnergoncalves.response.AtorEmAtividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public void criarAtor(AtorRequest atorRequest) throws Exception {
        Ator ator = atorRequest.converteObjeto();

        if (ator.getNome().split(" ").length < 2) {
            throw new NomeSobrenomeObrigatorioException(TipoDominioException.ATOR.getSingular());
        }

         List<Ator> atoresCadastrados = this.atorRepository.findAll();
        for(Ator atorCadastrado : atoresCadastrados){
            if(atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())){
                throw new CadastroDuplicadoException(TipoDominioException.ATOR,
                        "Já existe um ator cadastrado para o nome " +atorRequest.getNome());
            }

        }
        Integer idGerado = atoresCadastrados.size() + 1;

        this.atorRepository.save(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
         List<Ator> atoresCadastrados = atorRepository.findByStatusCarreira(StatusCarreira.EM_ATIVIDADE);

        if (atoresCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        List<AtorEmAtividade> retorno = new ArrayList<>();
        if (filtroNome != null) {
            for (Ator ator : atoresCadastrados) {
                final boolean containsFilter = ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter) {
                    retorno.add(new AtorEmAtividade(ator.getId(),ator.getNome(),ator.getDataNascimento()));
                }
            }
        }

        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Ator", filtroNome);
        }

        return retorno;
    }

    public Ator consultarAtor(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }

        final List<Ator> atores = atorRepository.findAll();

        for (Ator ator : atores) {
            if (ator.getId().equals(id)) {
                return ator;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
    }

    public List<Ator> consultarAtores() throws Exception {
        final List<Ator> atores = atorRepository.findAll();

        if (atores.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        return atores;
    }
}