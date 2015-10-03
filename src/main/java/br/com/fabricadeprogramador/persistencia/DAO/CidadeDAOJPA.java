package br.com.fabricadeprogramador.persistencia.DAO;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import br.com.fabricadeprogramador.persistencia.entidade.Contato;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by edipo on 30/09/15.
 */
@Repository("cidadeDAOJPA")
public class CidadeDAOJPA implements CidadeDAO {

    @PersistenceContext
	private EntityManager entityManager;
    
    
    @Transactional
    public void salvar(Cidade cidade) throws DAOException{
        try {
            // Merge do Ccontato
	entityManager.merge(cidade);
	} catch (Exception e) {
            throw new DAOException("Ocorreu um erro ao salvar a Cidade!", e);
	}
    }

    @Transactional
    public void remover(Long id) throws DAOException{
        try {
            // find
            Cidade cidadeRemove = entityManager.find(Cidade.class, id);

            // remove
            entityManager.remove(cidadeRemove);
	} catch (Exception e) {
            throw new DAOException("Ocorreu um erro ao Remover o Contato!", e);
	}
    }

    
}
