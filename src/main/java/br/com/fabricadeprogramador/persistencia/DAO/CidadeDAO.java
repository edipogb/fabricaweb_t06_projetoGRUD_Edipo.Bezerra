package br.com.fabricadeprogramador.persistencia.DAO;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import org.springframework.stereotype.Repository;

/**
 * Created by edipo on 30/09/15.
 */

@Repository
public interface CidadeDAO {

    public void salvar(Cidade cidade)throws DAOException;
    public void remover(Long id)throws DAOException;

}
