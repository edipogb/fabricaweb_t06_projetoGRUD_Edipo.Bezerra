package br.com.fabricadeprogramador.persistencia.DAO;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Cliente;
import br.com.fabricadeprogramador.persistencia.entidade.Contato;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by edipo on 30/09/15.
 */

@Repository("contatoDAOJPA")
public class ContatoDAOJPA implements ContatoDAO{

    @PersistenceContext
	private EntityManager entityManager;
    
    @Transactional
    public void salvar(Contato contato) throws DAOException {
       try {
            // Merge do Ccontato
	entityManager.merge(contato);
	} catch (Exception e) {
            throw new DAOException("Ocorreu um erro ao salvar o Comtato!", e);
	}
    }
    
    @Transactional
    public void remover(Long id) throws DAOException{
        try {
            // find
            Contato contRemove = entityManager.find(Contato.class, id);

            // remove
            entityManager.remove(contRemove);
	} catch (Exception e) {
            throw new DAOException("Ocorreu um erro ao Remover o Contato!", e);
	}

    }
    

 
   
}