package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.service.EstadoService;
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
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    //Objeto do Bind
    private Estado estado;

    //Contrutor
    private EstadoController() {

    }

    @PostConstruct
    public void init() {

        setEstado(new Estado());

    }

    public void salvar(Estado estado) {
        try {
            estadoService.salvar(estado);
            //Pega Mensagem de informação no MensagemUtil
            MensagemUtil.mensagemInfo("Estado salvo com sucesso!");
        } catch (ServiceException ex) {
            ex.printStackTrace();
            // pega mensagem de erro no MensagemUtil
            MensagemUtil.mensagemErro("Erro ao salvar o Estado!");
        }
    }

    public void remover(Long id){
        try {
            estadoService.remover(id);
        //Pega Mensagem de informação no MensagemUtil
            MensagemUtil.mensagemInfo("Contato salvo com sucesso!");
        } catch (ServiceException ex) {
            ex.printStackTrace();
            // pega mensagem de erro no MensagemUtil
            MensagemUtil.mensagemErro("Erro ao salvar o contato!");
        }
    }
    
    public EstadoService getEstadoService() {
        return estadoService;
    }

    public void setEstadoService(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
