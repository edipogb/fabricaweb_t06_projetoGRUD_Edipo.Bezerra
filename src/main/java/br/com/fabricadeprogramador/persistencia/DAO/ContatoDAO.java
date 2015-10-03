package br.com.fabricadeprogramador.persistencia.DAO;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Contato;
import org.springframework.stereotype.Repository;

/**
 * Created by edipo on 30/09/15.
 */

@Repository
public interface ContatoDAO {

    public void salvar(Contato contato) throws DAOException;
    public void remover(Long id)throws DAOException;

}
