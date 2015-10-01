package br.com.fabricadeprogramador.persistencia.entidade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Estado implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_estado")
	@SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado", initialValue = 1)
	private Long id;
	private String nome;
	private String uf;

	@JoinColumn
	@OneToMany
	private Cidade cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Estado estado = (Estado) o;

		if (id != null ? !id.equals(estado.id) : estado.id != null) return false;
		if (nome != null ? !nome.equals(estado.nome) : estado.nome != null) return false;
		if (uf != null ? !uf.equals(estado.uf) : estado.uf != null) return false;
		return !(cidade != null ? !cidade.equals(estado.cidade) : estado.cidade != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (nome != null ? nome.hashCode() : 0);
		result = 31 * result + (uf != null ? uf.hashCode() : 0);
		result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Estado{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", uf='" + uf + '\'' +
				", cidade=" + cidade +
				'}';
	}
}
