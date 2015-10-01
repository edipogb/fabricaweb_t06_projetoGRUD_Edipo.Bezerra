package br.com.fabricadeprogramador.persistencia.entidade;

import java.io.Serializable;
import javax.persistence.*;

public class TipoContato implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_tipocontato")
    @SequenceGenerator(name = "seq_tipocontato", sequenceName = "seq_tipocontato")
	private Long id;
	private String tipo;


    @JoinColumn
    @OneToMany
    private Contato contato;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoContato that = (TipoContato) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        return !(contato != null ? !contato.equals(that.contato) : that.contato != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (contato != null ? contato.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TipoContato{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", contato=" + contato +
                '}';
    }
}
