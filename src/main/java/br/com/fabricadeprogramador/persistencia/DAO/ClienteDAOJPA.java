package br.com.fabricadeprogramador.persistencia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import br.com.fabricadeprogramador.persistencia.entidade.Cliente;
import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import org.springframework.stereotype.Repository;

@Repository("clienteDAOJPA")
public class ClienteDAOJPA implements ClienteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void salvar(Cliente cliente) throws DAOException {

		try {
			// Merge do Cliente
			entityManager.merge(cliente);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro ao salvar o Cliente!", e);
		}

	}

	@Override
	public List<Cliente> buscarPorCidade(Cidade cidade) throws DAOException {

		List<Cliente> clientes = null;

		try {
			// sql (jpql)
			String jpql = "select u from Cliente u where u.cidade := pcidade";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("pcidade", cidade);
			clientes = query.getResultList();

		} catch (NoResultException ex) {
			throw new DAOException("Nenhum resultado encontrado!", ex);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro genérico", e);
		} finally {
			return clientes;
		}
	}

	@Override
	public List<Cliente> buscarPorEstado(Estado estado) throws DAOException {

		List<Cliente> clientes = null;

		try {
			// sql (jpql)
			String jpql = "select u from Cliente u where u.estado := pestado";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("pestado", estado);
			clientes = query.getResultList();

		} catch (NoResultException ex) {
			throw new DAOException("Nenhum resultado encontrado!", ex);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro genérico", e);
		} finally {
			return null;
		}
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) throws DAOException{

		List<Cliente> clientes = null;

		try {
			// sql (jpql)
			String jpql = "select u from Cliente u where u.nome := pnome";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("pnome", nome);
			clientes = query.getResultList();

		} catch (NoResultException ex) {
			throw new DAOException("Nenhum resultado encontrado!", ex);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro genérico", e);
		} finally {
			return null;
		}
	}

	@Override
	public Cliente buscarPorId(Long id) throws DAOException {

		Cliente cliRetorno = null;

		try {
			cliRetorno = entityManager.find(Cliente.class, id);

		} catch (NoResultException ex) {
			throw new DAOException("Nenhum resultado encontrado!", ex);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro genérico", e);
		} finally {
			return cliRetorno;
		}

	}

	@Transactional
	public void remover(Long id) throws DAOException {

		try {
			// find
			Cliente cliRemove = entityManager.find(Cliente.class, id);

			// remove
			entityManager.remove(cliRemove);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro ao Remover o Cliente!", e);
		}

	}

}
