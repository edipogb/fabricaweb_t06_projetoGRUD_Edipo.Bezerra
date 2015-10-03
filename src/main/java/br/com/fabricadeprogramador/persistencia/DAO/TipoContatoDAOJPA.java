package br.com.fabricadeprogramador.persistencia.DAO;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.TipoContato;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Édipo on 30/09/15.
 */
@Repository("tipoContatoDAOJPA")
public class TipoContatoDAOJPA implements TipoContatoDAO {
    
    @PersistenceContext
	private EntityManager entityManager;

    @Transactional
    public void salvar(TipoContato tipoContato) throws DAOException {
        
        try {
            //Merge do TipoContato
            entityManager.merge(tipoContato);
            
        } catch (Exception e) {
            throw new DAOException("Ocorreu um erro ao salvar o Tipo de Contato!", e);
        }
        
    }

    @Transactional
    public void remover(Long id) throws DAOException {
        try {
            //find
            TipoContato tcRemomove = entityManager.find(TipoContato.class, id);
            
            //remove
            entityManager.remove(tcRemomove);
        } catch (Exception e) {
            throw new DAOException("Ocorreu um erro ao remover o Tipo de Contato!", e);
        }
        
    }
}
