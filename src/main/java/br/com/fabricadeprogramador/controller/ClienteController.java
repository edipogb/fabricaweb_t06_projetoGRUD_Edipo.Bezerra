package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.service.exception.ServiceException;

import br.com.fabricadeprogramador.web.util.MensagemUtil;

import br.com.fabricadeprogramador.persistencia.entidade.Cidade;
import br.com.fabricadeprogramador.persistencia.entidade.Cliente;
import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.service.ClienteService;

@Controller
@ManagedBean
public class ClienteController {

	//Instancia de ClienteService
	@Autowired
	private ClienteService clienteService;
	
	//Obijeto do Bind
	private Cliente cliente;
	
	//Instancia de Cidade para Busca
	private Cidade cidadeBuscar;
	
	//Instancia de Estado para Busca
	private Estado estadoBuscar;
	
	//Instancia para Buscar por nome
	private String nomeBuscar;
	
	//Instancia para Buscar pelo ID
	private Long idBuscar;
	
	// Instancia da Lista de Clientes
	private List<Cliente> listaBuscada;
	
	//Construttor
	public void ClienteController(){
		
	}
	

	public void init(){
		setCliente(new Cliente());
		
		
	}
	
	
	public void salvar(){
		try {
			clienteService.salvar(cliente);
			// pega mensagem de sucesso no MensagemUtil
			MensagemUtil.mensagemInfo("Salvo com sucesso!");
			//Limpar o Cliente
			init();
		} catch (ServiceException e) {
			e.printStackTrace();
			// pega mensagem de erro no MensagemUtil
			MensagemUtil.mensagemErro("Erro ao salvar cliente!");
		}
	}
	
	public void buscarPorCidade(){
		try {
			clienteService.buscarPorCidade(cidadeBuscar);
			MensagemUtil.mensagemInfo("Localizado com sucesso!");
		} catch (ServiceException e) {
			e.printStackTrace();
			// pega mensagem de erro no MensagemUtil
			MensagemUtil.mensagemErro("Erro ao localixar o cliente!");
		}
	}
	
	public void buscarPorEstado(){
		try {
			clienteService.buscarPorEstado(estadoBuscar);
			MensagemUtil.mensagemInfo("Localizado com sucesso!");
		} catch (ServiceException e) {
			e.printStackTrace();
			// pega mensagem de erro no MensagemUtil
			MensagemUtil.mensagemErro("Erro ao localixar o cliente!");
		}
	}
	
	public void buscarPorNome(){
		try {
			clienteService.buscarPorNome(nomeBuscar);
			MensagemUtil.mensagemInfo("Localizado com sucesso!");
		} catch (ServiceException e) {
			e.printStackTrace();
			// pega mensagem de erro no MensagemUtil
			MensagemUtil.mensagemErro("Erro ao localixar o cliente!");
		}
	}
	
	public void Remover(Long id){
		try {
			clienteService.remover(id);
			MensagemUtil.mensagemInfo("Cliente removido com sucesso!");
		} catch (ServiceException e) {
			e.printStackTrace();
			// pega mensagem de erro no MensagemUtil
			MensagemUtil.mensagemErro("Erro ao remover o cliente!");
		}
	}
	
	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cidade getCidadeBuscar() {
		return cidadeBuscar;
	}

	public void setCidadeBuscar(Cidade cidadeBuscar) {
		this.cidadeBuscar = cidadeBuscar;
	}

	public Estado getEstadoBuscar() {
		return estadoBuscar;
	}

	public void setEstadoBuscar(Estado estadoBuscar) {
		this.estadoBuscar = estadoBuscar;
	}

	public String getNomeBuscar() {
		return nomeBuscar;
	}

	public void setNomeBuscar(String nomeBuscar) {
		this.nomeBuscar = nomeBuscar;
	}

	public Long getIdBuscar() {
		return idBuscar;
	}

	public void setIdBuscar(Long idBuscar) {
		this.idBuscar = idBuscar;
	}

	public List<Cliente> getListaBuscada() {
		return listaBuscada;
	}

	public void setListaBuscada(List<Cliente> listaBuscada) {
		this.listaBuscada = listaBuscada;
	}
}
