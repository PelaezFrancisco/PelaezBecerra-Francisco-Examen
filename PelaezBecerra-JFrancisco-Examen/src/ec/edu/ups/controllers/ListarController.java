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
import ec.edu.ups.dao.TelefonosDAO;
import ec.edu.ups.entidades.Telefonos;

/**
 * Servlet implementation class ListarController
 */
@WebServlet("/ListarController")
public class ListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonosDAO telefonoDAO;
	private List<Telefonos> telefonos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarController() {
        telefonoDAO = DAOFactory.getFactory().getTelefonosDAO();
        telefonos = new ArrayList<Telefonos>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		telefonos = telefonoDAO.findAll();
		System.out.println("Tamano de telefnos="+telefonos.size());
		String url="/public/ListarTelefonos.jsp";
		request.setAttribute("telefonos", telefonos);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
