package ec.edu.ups.jpa;

import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.entidades.Persona;

public class JPADAOPersona extends JPAGenericDAO<Persona, Integer, String> implements PersonaDAO{

	public JPADAOPersona() {
		super(Persona.class);
		// TODO Auto-generated constructor stub
	}

}
