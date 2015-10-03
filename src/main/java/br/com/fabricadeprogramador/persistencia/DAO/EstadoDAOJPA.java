package br.com.fabricadeprogramador.persistencia.DAO;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Édipo on 30/09/15.
 */
@Repository("estadoDAOJPA")
public class EstadoDAOJPA implements EstadoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Estado estado) throws DAOException {

         try {
            // Merge do Ccontato
	entityManager.merge(estado);
	} catch (Exception e) {
            throw new DAOException("Ocorreu um erro ao salvar o Estado!", e);
	}
        
    }

    @Transactional
    public void remover(Long id) throws DAOException {

        try {
            // find
            Estado estadoRemove = entityManager.find(Estado.class, id);

            // remove
            entityManager.remove(estadoRemove);
	} catch (Exception e) {
            throw new DAOException("Ocorreu um erro ao Remover o Estado!", e);
	}

        
    }

}
