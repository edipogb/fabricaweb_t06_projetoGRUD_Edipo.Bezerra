package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.persistencia.entidade.Cliente;
import br.com.fabricadeprogramador.persistencia.entidade.Contato;
import br.com.fabricadeprogramador.service.ClienteService;
import br.com.fabricadeprogramador.service.ContatoService;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import br.com.fabricadeprogramador.web.util.MensagemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;

/**
 * Created by Édipo on 01/10/15.
 */
@Controller
@ManagedBean
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    //Obijeto do Bind
    private Contato contato;

    //Construtor
    public void ContatoService() {

    }

    public void init() {

        setContato(new Contato());

    }

    public void salvar() {

        try {
            contatoService.salvar(contato);
            //Pega Mensagem de informação no MensagemUtil
            MensagemUtil.mensagemInfo("Contato salvo com sucesso!");
        } catch (ServiceException ex) {
            ex.printStackTrace();
            // pega mensagem de erro no MensagemUtil
            MensagemUtil.mensagemErro("Erro ao salvar o contato!");
        }
    }

    public void remover(Long id) {

        try {
            contatoService.remover(id);
            //Pega mensagem de informação do MensagemUtil
            MensagemUtil.mensagemInfo("Contato removido com sucesso!");
        } catch (ServiceException ex) {
            ex.printStackTrace();
            // pega mensagem de erro no MensagemUtil
            MensagemUtil.mensagemErro("Erro ao remover o contato!");
        }
    }

    public ContatoService getContatoService() {
        return contatoService;
    }

    public void setContatoService(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

}
