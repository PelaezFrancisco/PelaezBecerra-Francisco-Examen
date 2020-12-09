package ec.edu.ups.jpa;

import ec.edu.ups.dao.TelefonosDAO;
import ec.edu.ups.entidades.Telefonos;

public class JPADAOTelefonos extends JPAGenericDAO<Telefonos, Integer, String> implements TelefonosDAO{

	public JPADAOTelefonos() {
		super(Telefonos.class);
		// TODO Auto-generated constructor stub
	}

}
