package ec.edu.ups.jpa;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.OperadorasDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.TelefonosDAO;
import ec.edu.ups.dao.TipoDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public OperadorasDAO getOperadorasDAO() {
		// TODO Auto-generated method stub
		return new JPADAOOperadoras();
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TelefonosDAO getTelefonosDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDAO getTipoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
