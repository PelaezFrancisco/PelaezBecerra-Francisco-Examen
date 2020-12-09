package ec.edu.ups.jpa;


import ec.edu.ups.dao.TipoDAO;
import ec.edu.ups.entidades.Tipo;

public class JPADAOTipo extends JPAGenericDAO<Tipo, Integer, String> implements TipoDAO{

	public JPADAOTipo() {
		super(Tipo.class);
		// TODO Auto-generated constructor stub
	}

}
