package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.persistencia.entidade.TipoContato;
import br.com.fabricadeprogramador.service.TipoContatoService;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import br.com.fabricadeprogramador.web.util.MensagemUtil;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Édipo on 03/10/2015
 */
@Controller
@ManagedBean
public class TipoContatoController {
    
    @Autowired
    private TipoContatoService tipoContatoService;
    
    //obijeto do Bind
    private TipoContato tipoContato;
    
    //construtor
    public void TipoContatoController(){
        
    }

    @PostConstruct
    public void init(){
        setTipoContato(new TipoContato());
    }
    
    public void salvar(){
        try {
            tipoContatoService.salvar(tipoContato);
            //Pega Mensagem de informação no MensagemUtil
            MensagemUtil.mensagemInfo("Tipo de Contato salvo com sucesso!");
        } catch (ServiceException ex) {
            ex.printStackTrace();
            // pega mensagem de erro no MensagemUtil
            MensagemUtil.mensagemErro("Erro ao salvar o tipo de contato!");
        }
    }
    
    public void remover(Long id){
        try {
            tipoContatoService.remover(id);
            //Pega Mensagem de informação no MensagemUtil
            MensagemUtil.mensagemInfo("Tipo de Contato removido com sucesso!");
        } catch (ServiceException ex) {
            ex.printStackTrace();
            // pega mensagem de erro no MensagemUtil
            MensagemUtil.mensagemErro("Erro ao remover o tipo de contato!");
        }
    }
    
    public TipoContatoService getTipoContatoService() {
        return tipoContatoService;
    }

    public void setTipoContatoService(TipoContatoService tipoContatoService) {
        this.tipoContatoService = tipoContatoService;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }
    
    
    
}
