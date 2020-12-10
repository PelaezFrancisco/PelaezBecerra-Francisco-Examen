package ec.edu.ups.controllers;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.TelefonosDAO;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Telefonos;

/**
 * Servlet implementation class IniciarSesionController
 */
@WebServlet("/IniciarSesionController")
public class IniciarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDAO;
	private TelefonosDAO telefonosDAO;
	private List<Telefonos> telefono;
    private Persona persona;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionController() {
    	telefonosDAO = DAOFactory.getFactory().getTelefonosDAO();
        personaDAO = DAOFactory.getFactory().getPersonaDAO();
        telefono = new ArrayList<Telefonos>();
        persona = new Persona();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		String email = null;
		String contra = null;
		ArrayList<Telefonos> tel_list = new ArrayList<Telefonos>();
		
		try {
			email = request.getParameter("email");
			//MD5 para contrasena
			contra = getMd5(request.getParameter("contra"));
			
			persona = personaDAO.find_email(email);
			
			System.out.println("Email recibido = "+email);
			System.out.println("Email de Base = "+persona.getPer_email());
			
			//If para control de contrasena
			System.out.println("Contrasena puesta= "+contra);
			System.out.println("Contrasena de base= "+persona.getPer_contrasena());
			if (contra.equals(persona.getPer_contrasena())) {
				
				//Carga los datos del usuario dentro del HttpSession
				HttpSession  session=request.getSession(true);
		        session.setAttribute("mail", email);
		        session.setAttribute("password", persona.getPer_contrasena());
				
		        telefono = telefonosDAO.findAll();
		        for (int i = 0; i < telefono.size(); i++) {
		        	if (telefono.get(i).getPersona().getPer_id()==persona.getPer_id()) {
		        		tel_list.add(telefono.get(i));

		        	}

		        }

		        
				//If para redireccion de rol
		        request.setAttribute("telefonos", tel_list);
		        url = "/private/user/inicio_user.jsp";
			}else {
				request.setAttribute("telefonos", null);
				url = "/public/IniciarSesion.html";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//MD5 hashing
			public static String getMd5(String input) 
		    { 
		        try { 
		  
		            // Static getInstance method is called with hashing MD5 
		            MessageDigest md = MessageDigest.getInstance("MD5"); 
		  
		            // digest() method is called to calculate message digest 
		            //  of an input digest() return array of byte 
		            byte[] messageDigest = md.digest(input.getBytes()); 
		  
		            // Convert byte array into signum representation 
		            BigInteger no = new BigInteger(1, messageDigest); 
		  
		            // Convert message digest into hex value 
		            String hashtext = no.toString(16); 
		            while (hashtext.length() < 32) { 
		                hashtext = "0" + hashtext; 
		            } 
		            return hashtext; 
		        }  
		  
		        // For specifying wrong message digest algorithms 
		        catch (NoSuchAlgorithmException e) { 
		            throw new RuntimeException(e); 
		        } 
		    } 



}
