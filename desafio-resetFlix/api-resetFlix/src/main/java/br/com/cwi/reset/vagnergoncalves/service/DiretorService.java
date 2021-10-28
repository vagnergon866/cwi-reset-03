package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.domain.Diretor;
import br.com.cwi.reset.vagnergoncalves.exception.*;
import br.com.cwi.reset.vagnergoncalves.repositoty.DiretorRepository;
import br.com.cwi.reset.vagnergoncalves.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;


    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {
        Diretor diretor = diretorRequest.convertObjeto();

        if (diretor.getNome().split("").length < 2){
            throw new NomeSobrenomeObrigatorioException(TipoDominioException.DIRETOR.getSingular());
        }

        List<Diretor> diretoresCadastrados = this.diretorRepository.findAll();
        for (Diretor diretorCadastrado : diretoresCadastrados) {
            if (diretorCadastrado.getNome().equalsIgnoreCase(diretorRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.DIRETOR.getSingular(),diretorRequest.getNome());
            }
        }
        this.diretorRepository.save(diretor);
    }

    public List<Diretor> listarDiretores(final String filtroNome) throws Exception {
        List<Diretor> retorno;


        if (filtroNome != null) {
            retorno = diretorRepository.findByNomeContainsIgnoreCase(filtroNome);
            if (retorno.isEmpty()) {
                throw new FiltroNomeNaoEncontrado("Diretor", filtroNome);
            }
        } else {
            retorno = diretorRepository.findAll();
            if(retorno.isEmpty()){
                throw new ListaVaziaException(TipoDominioException.DIRETOR.getSingular(),TipoDominioException.DIRETOR.getPlural());
            }
        }
        return retorno;
    }

    public Diretor consultarDiretor(final Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }
         List<Diretor> diretores = diretorRepository.findAll();

        for (Diretor diretor : diretores) {
            if (diretor.getId().equals(id)) {
                return diretor;
            }
        }
        throw new ConsultaIdInvalidoException(TipoDominioException.DIRETOR.getSingular(), id);
    }
}