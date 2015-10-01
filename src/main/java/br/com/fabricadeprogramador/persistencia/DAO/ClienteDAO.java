package br.com.fabricadeprogramador.persistencia.DAO;

import java.util.List;

import br.com.fabricadeprogramador.persistencia.DAO.exception.DAOException;
import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import br.com.fabricadeprogramador.persistencia.entidade.Cliente;
import br.com.fabricadeprogramador.persistencia.entidade.Estado;

@Repository
public interface ClienteDAO {

	public void salvar(Cliente cliente) throws DAOException;

	public List<Cliente> buscarPorCidade(Cidade cidade) throws DAOException;

	public List<Cliente> buscarPorEstado(Estado estado);

	public List<Cliente> buscarPorNome(String nome);

	public void buscarPorId(Long id) throws DAOException;

	public void remover(Long id) throws DAOException;

}
