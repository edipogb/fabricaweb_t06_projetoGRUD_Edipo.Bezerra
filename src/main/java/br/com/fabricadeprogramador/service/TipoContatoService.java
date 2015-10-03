package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.persistencia.DAO.TipoContatoDAOJPA;
import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.TipoContato;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Édipo on 03/10/2015
 */

@Service
public class TipoContatoService {
    
    @Qualifier("tipoContatoDAOJPA")
    @Autowired
    private TipoContatoDAOJPA dao;
    
    public void salvar(TipoContato tipoContato) throws ServiceException{
        try {
            dao.salvar(tipoContato);
        } catch (DAOException e) {
            throw new ServiceException("Erro ao Salvar!", e);
        }
    }
    
    public void remover(Long id) throws ServiceException{
        try {
            dao.remover(id);
        } catch (DAOException e) {
            throw new ServiceException("Erro ao excluir!", e);
        }
    }
    
    
}
