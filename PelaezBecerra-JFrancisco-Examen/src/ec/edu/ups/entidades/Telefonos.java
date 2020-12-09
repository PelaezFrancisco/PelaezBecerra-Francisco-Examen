package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Telefonos
 *
 */
@Entity
@Table(name = "PAG_Telefonos")
public class Telefonos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int tel_id;
	private String tel_numero;
	@ManyToOne
	@JoinColumn(name = "ope_id", unique = true, nullable = false)
	private Operadoras operador;
	@ManyToOne
	@JoinColumn(name = "per_id", unique = true, nullable = false)
	private Persona persona;
	@ManyToOne
	@JoinColumn(name = "tip_id", unique = true, nullable = false)
	private Tipo tipos;

	public Telefonos() {
		super();
	}

	public int getTel_id() {
		return tel_id;
	}

	public void setTel_id(int tel_id) {
		this.tel_id = tel_id;
	}

	public String getTel_numero() {
		return tel_numero;
	}

	public void setTel_numero(String tel_numero) {
		this.tel_numero = tel_numero;
	}

	public Operadoras getOperador() {
		return operador;
	}

	public void setOperador(Operadoras operador) {
		this.operador = operador;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Tipo getTipos() {
		return tipos;
	}

	public void setTipos(Tipo tipos) {
		this.tipos = tipos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operador == null) ? 0 : operador.hashCode());
		result = prime * result + tel_id;
		result = prime * result + ((tel_numero == null) ? 0 : tel_numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefonos other = (Telefonos) obj;
		if (operador == null) {
			if (other.operador != null)
				return false;
		} else if (!operador.equals(other.operador))
			return false;
		if (tel_id != other.tel_id)
			return false;
		if (tel_numero == null) {
			if (other.tel_numero != null)
				return false;
		} else if (!tel_numero.equals(other.tel_numero))
			return false;
		return true;
	}
	
	
   
}
