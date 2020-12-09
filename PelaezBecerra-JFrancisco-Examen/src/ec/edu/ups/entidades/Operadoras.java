package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Operadoras
 *
 */
@Entity
@Table(name = "PAG_Operadoras")
public class Operadoras implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int ope_id;
	private String ope_nombre;
	private String ope_descripcion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operador")
	private Set<Telefonos> telefono = new HashSet<Telefonos>();

	public Set<Telefonos> getTelefono() {
		return telefono;
	}

	public void setTelefono(Set<Telefonos> telefono) {
		this.telefono = telefono;
	}

	public Operadoras() {
		super();
	}
	
	public Operadoras(int ope_id, String ope_nombre, String ope_descripcion) {
		this.ope_id=ope_id;
		this.ope_nombre=ope_nombre;
		this.ope_descripcion=ope_descripcion;
	}

	public int getOpe_id() {
		return ope_id;
	}

	public void setOpe_id(int ope_id) {
		this.ope_id = ope_id;
	}

	public String getOpe_nombre() {
		return ope_nombre;
	}

	public void setOpe_nombre(String ope_nombre) {
		this.ope_nombre = ope_nombre;
	}

	public String getOpe_descripcion() {
		return ope_descripcion;
	}

	public void setOpe_descripcion(String ope_descripcion) {
		this.ope_descripcion = ope_descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ope_descripcion == null) ? 0 : ope_descripcion.hashCode());
		result = prime * result + ope_id;
		result = prime * result + ((ope_nombre == null) ? 0 : ope_nombre.hashCode());
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
		Operadoras other = (Operadoras) obj;
		if (ope_descripcion == null) {
			if (other.ope_descripcion != null)
				return false;
		} else if (!ope_descripcion.equals(other.ope_descripcion))
			return false;
		if (ope_id != other.ope_id)
			return false;
		if (ope_nombre == null) {
			if (other.ope_nombre != null)
				return false;
		} else if (!ope_nombre.equals(other.ope_nombre))
			return false;
		return true;
	}
   
}
