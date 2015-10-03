package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.persistencia.DAO.ContatoDAOJPA;
import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Contato;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Édipo on 01/10/15.
 */
@Service
public class ContatoService {

    @Qualifier("contatoDAOJPA")
    @Autowired
    private ContatoDAOJPA dao;

    public void salvar(Contato contato) throws ServiceException {

        try {
            dao.salvar(contato);
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
