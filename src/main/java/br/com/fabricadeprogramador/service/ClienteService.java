package br.com.fabricadeprogramador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;

import br.com.fabricadeprogramador.persistencia.DAO.ClienteDAO;

import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import br.com.fabricadeprogramador.persistencia.entidade.Cliente;
import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.service.exception.ServiceException;

@Service
public class ClienteService {

	@Qualifier("clienteDAOJPA")
	@Autowired
	private ClienteDAO dao;

	public void salvar(Cliente cliente) throws ServiceException {

		try {
//			// verificar se o Cliente ja existe pelo id
//			Cliente clienteExistente = dao.buscarPorId(cliente.getId());
//
//			if (clienteExistente != null) {
//				// se o id já estiver sendo usado, lança-se uma exceção
//				throw new ServiceException("Cliente Já Existe já existe!");
//			}
			// salvar usuario
			dao.salvar(cliente);

		} catch (DAOException e) {
			throw new ServiceException("Erro ao Salvar!", e);
		}

	}

	public List<Cliente> buscarPorCidade(Cidade cidade) throws ServiceException {
		
		try {
			return dao.buscarPorCidade(cidade);
		} catch (DAOException e) {
			throw new ServiceException("Erro ao buscar pela Cidade!", e);
		}
	}

	public List<Cliente> buscarPorEstado(Estado estado) throws ServiceException {
		try{
		return dao.buscarPorEstado(estado);
		}catch(DAOException e){
			throw new ServiceException("Erro ao buscar pelo Estado!", e);
		}
	}

	public List<Cliente> buscarPorNome(String nome) throws ServiceException {
		try{
		return dao.buscarPorNome(nome);
		}catch(DAOException e){
			throw new ServiceException("Erro ao buscar pelo Nome!", e);
		}
	}

	public Cliente buscarPorId(Long id) throws ServiceException {
		try{
			return dao.buscarPorId(id);
			
		}catch(DAOException e){
			throw new ServiceException("Erro ao buscar pelo ID");
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
