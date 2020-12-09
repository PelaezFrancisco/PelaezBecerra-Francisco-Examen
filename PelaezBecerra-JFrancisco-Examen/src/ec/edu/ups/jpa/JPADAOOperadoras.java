package ec.edu.ups.jpa;

import ec.edu.ups.dao.OperadorasDAO;
import ec.edu.ups.entidades.Operadoras;

public class JPADAOOperadoras extends JPAGenericDAO<Operadoras, Integer, String> implements OperadorasDAO{

	public JPADAOOperadoras() {
		super(Operadoras.class);
	}
}
