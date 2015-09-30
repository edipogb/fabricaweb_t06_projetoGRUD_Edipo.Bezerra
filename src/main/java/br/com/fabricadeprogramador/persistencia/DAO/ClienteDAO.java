package br.com.fabricadeprogramador.persistencia.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import br.com.fabricadeprogramador.persistencia.entidade.Cliente;
import br.com.fabricadeprogramador.persistencia.entidade.Estado;

@Repository
public interface ClienteDAO {

	public void salvar(Cliente cliente);

	public List<Cliente> buscarPorCidade(Cidade cidade);

	public List<Cliente> buscarPorEstado(Estado estado);

	public List<Cliente> buscarPotNome(String nome);

	public void buscarPorId(Long id);

}
