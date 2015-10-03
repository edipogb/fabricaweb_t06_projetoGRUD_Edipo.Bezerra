
package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import br.com.fabricadeprogramador.service.CidadeService;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import br.com.fabricadeprogramador.web.util.MensagemUtil;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *Created by Édipo on 03/10/2015
 */

@Controller
@ManagedBean
public class CidadeController {
    
    @Autowired
    private CidadeService cidadeService;
    
    //Objeto do Bind
    private Cidade cidade;
    
    //Contrutor
    private CidadeController(){
        
    }

    public void init(){
        
        setCidade(new Cidade());
        
    }
    
    public void salar(Cidade cidade){
        try {
            cidadeService.salvar(cidade);
            //Pega Mensagem de informação no MensagemUtil
            MensagemUtil.mensagemInfo("Cidade salva com sucesso!");
        } catch (ServiceException ex) {
            ex.printStackTrace();
            // pega mensagem de erro no MensagemUtil
            MensagemUtil.mensagemErro("Erro ao salvar a cidade!");
        }
        
    }
    
    public void remover(Long id){
        try {
            cidadeService.remover(id);
        //Pega mensagem de informação do MensagemUtil
            MensagemUtil.mensagemInfo("Cidade removida com sucesso!");
        } catch (ServiceException ex) {
            ex.printStackTrace();
            // pega mensagem de erro no MensagemUtil
            MensagemUtil.mensagemErro("Erro ao remover a cidade!");
        }
    }
    
    public CidadeService getCidadeService() {
        return cidadeService;
    }

    public void setCidadeService(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
    
    
}
