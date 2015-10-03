/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.persistencia.DAO.CidadeDAOJPA;
import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Crreated by Édipo on 03/10/2015
 */
@Service
public class CidadeService {

    @Autowired
    @Qualifier("cidadeDAOJPA")
    private CidadeDAOJPA dao;

    public void salvar(Cidade cidade) throws ServiceException {
        try {
            dao.salvar(cidade);
        } catch (DAOException e) {
            throw new ServiceException("Erro ao salvar!", e);
        }
    }

    public void remover(Long id) throws ServiceException {
        try {
            dao.remover(id);
        } catch (DAOException e) {
            throw new ServiceException("Erro ao salvar!", e);
        }
    }

}
