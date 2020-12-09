package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tipo
 *
 */
@Entity
@Table(name = "PAG_tipos")
public class Tipo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int tip_id;
	private String tip_nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipos")
	private Set<Telefonos> telefono = new HashSet<Telefonos>();

	public Tipo() {
		super();
	}
	
	public Tipo(int tip_id, String tip_nombre) {
		this.tip_id=tip_id;
		this.tip_nombre=tip_nombre;
	}

	
	public Set<Telefonos> getTelefono() {
		return telefono;
	}

	public void setTelefono(Set<Telefonos> telefono) {
		this.telefono = telefono;
	}

	public int getTip_id() {
		return tip_id;
	}

	public void setTip_id(int tip_id) {
		this.tip_id = tip_id;
	}

	public String getTip_nombre() {
		return tip_nombre;
	}

	public void setTip_nombre(String tip_nombre) {
		this.tip_nombre = tip_nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tip_id;
		result = prime * result + ((tip_nombre == null) ? 0 : tip_nombre.hashCode());
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
		Tipo other = (Tipo) obj;
		if (tip_id != other.tip_id)
			return false;
		if (tip_nombre == null) {
			if (other.tip_nombre != null)
				return false;
		} else if (!tip_nombre.equals(other.tip_nombre))
			return false;
		return true;
	}
	
	
   
}
