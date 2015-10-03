package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.persistencia.DAO.EstadoDAOJPA;
import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Édipo on 03/10/2015
 */
@Service
public class EstadoService {

    @Autowired
    @Qualifier("estadoDAOJPA")
    private EstadoDAOJPA dao;

    public void salvar(Estado estado) throws ServiceException {
        try {
            dao.salvar(estado);
        } catch (DAOException e) {
            throw new ServiceException("Erro ao salvar!", e);
        }
    }

    public void remover(Long id) throws ServiceException {
        try {
            dao.remover(id);
        } catch (DAOException e) {
            throw new ServiceException("Erro ao excluir!", e);
        }
    }

}
