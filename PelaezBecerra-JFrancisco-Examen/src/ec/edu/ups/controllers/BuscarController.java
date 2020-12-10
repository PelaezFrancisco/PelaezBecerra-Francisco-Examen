package ec.edu.ups.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.TelefonosDAO;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Telefonos;

/**
 * Servlet implementation class BuscarController
 */
@WebServlet("/BuscarController")
public class BuscarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TelefonosDAO telefonosDAO;
    private PersonaDAO personaDAO;
    private List<Telefonos> telefono;
    private List<Persona> persona;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarController() {
        telefonosDAO = DAOFactory.getFactory().getTelefonosDAO();
        personaDAO = DAOFactory.getFactory().getPersonaDAO();
        telefono = new ArrayList<Telefonos>();
        persona = new ArrayList<Persona>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = null;
		String busq = null;
		String url = null;
		ArrayList<Telefonos> tel_list = new ArrayList<Telefonos>();
		
		opcion=request.getParameter("opcion");
		busq=request.getParameter("search");
		
		//System.out.println("Opcion que entra= "+opcion);
		//System.out.println("Cedula que entra= "+busq);
		try {
			if (opcion.equals("cedula")) {
				//System.out.println("Entra a opcion de Cedula");
				persona = personaDAO.find_cedula(busq);
				telefono = telefonosDAO.findAll();
				for (int i = 0; i < telefono.size(); i++) {
					for (int k = 0; k < persona.size(); k++) {
						if (telefono.get(i).getPersona().getPer_id()==persona.get(k).getPer_id()) {
							tel_list.add(telefono.get(i));
						}
					}
					
				}
				
				request.setAttribute("telefonos", tel_list);
				
			}else {
				System.out.println("Entra a opcion de Telefono");
				telefono = telefonosDAO.find_telefono(busq);
				request.setAttribute("telefonos", telefono);
			}
			url="/public/ListarTelefonos.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			url="index.html";
		}
		System.out.println("Manda a la pagina de listar");
		getServletContext().getRequestDispatcher(url).forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
