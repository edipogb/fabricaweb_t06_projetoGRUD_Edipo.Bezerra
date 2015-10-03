package br.com.fabricadeprogramador.persistencia.DAO;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import org.springframework.stereotype.Repository;

/**
 * Created by edipo on 30/09/15.
 */

@Repository
public interface EstadoDAO {

    public void salvar(Estado estado)throws DAOException;
    public void remover(Long id)throws DAOException;

}
