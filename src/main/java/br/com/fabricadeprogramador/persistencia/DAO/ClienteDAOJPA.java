package br.com.fabricadeprogramador.persistencia.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import br.com.fabricadeprogramador.persistencia.entidade.Cliente;
import br.com.fabricadeprogramador.persistencia.entidade.Estado;

public class ClienteDAOJPA implements ClienteDAO{

	private EntityManager entityManager;
	
	@Override
	public void salvar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> buscarPorCidade(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarPorEstado(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarPotNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buscarPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

}
