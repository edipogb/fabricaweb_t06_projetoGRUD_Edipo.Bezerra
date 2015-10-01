package br.com.fabricadeprogramador.persistencia.entidade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
class Contato implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "seq_contato")
	@SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato", initialValue = 1)
	private Long id;

	@JoinColumn
	@ManyToOne
	private Cliente cliente;

	@JoinColumn
	@ManyToOne
	private TipoContato tipo;
	private String contato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoContato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Contato contato1 = (Contato) o;

		if (id != null ? !id.equals(contato1.id) : contato1.id != null) return false;
		if (cliente != null ? !cliente.equals(contato1.cliente) : contato1.cliente != null) return false;
		if (tipo != null ? !tipo.equals(contato1.tipo) : contato1.tipo != null) return false;
		return !(contato != null ? !contato.equals(contato1.contato) : contato1.contato != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
		result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
		result = 31 * result + (contato != null ? contato.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Contato{" +
				"id=" + id +
				", cliente=" + cliente +
				", tipo=" + tipo +
				", contato='" + contato + '\'' +
				'}';
	}
}
