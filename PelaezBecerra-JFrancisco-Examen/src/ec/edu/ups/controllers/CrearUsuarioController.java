package ec.edu.ups.controllers;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.OperadorasDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.TelefonosDAO;
import ec.edu.ups.dao.TipoDAO;
import ec.edu.ups.entidades.Operadoras;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Telefonos;
import ec.edu.ups.entidades.Tipo;

/**
 * Servlet implementation class CrearUsuarioController
 */
@WebServlet("/CrearUsuarioController")
public class CrearUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonaDAO personaDAO;
    private TipoDAO tipoDAO;
    private OperadorasDAO operadoraDAO;
    private TelefonosDAO telefonoDAO;
    private Persona persona;
    private Tipo tipo;
    private Operadoras operadora;
    private Telefonos telefono;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuarioController() {
        personaDAO = DAOFactory.getFactory().getPersonaDAO();
        tipoDAO = DAOFactory.getFactory().getTipoDAO();
        operadoraDAO = DAOFactory.getFactory().getOperadorasDAO();
        telefonoDAO = DAOFactory.getFactory().getTelefonosDAO();
        persona = new Persona();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = null;
		String apellido = null;
		String cedula = null;
		String direccion = null;
		String email = null;
		String pass = null;
		String pass2 = null;
		String num = null;
		int ope = 0;
		int tip = 0;
		String url = null;
		
		try {
			nombre = request.getParameter("nombre");
			apellido = request.getParameter("apellido");
			cedula = request.getParameter("cedula");
			direccion = request.getParameter("direccion");
			email = request.getParameter("email");
			pass = getMd5(request.getParameter("contra"));
			pass2 = getMd5(request.getParameter("contra2"));
			
			//Instanciamos la persona
			persona.setPer_id(0);
			persona.setPer_nombre(nombre);
			persona.setPer_apellido(apellido);
			persona.setPer_cedula(cedula);
			persona.setPer_direccion(direccion);
			persona.setPer_email(email);
			persona.setPer_contrasena(pass);
			
			
			if (pass.equals(pass2)) {
				try {
					try {
						//Nos creamos la persona
						personaDAO.create(persona);
					} catch (Exception e) {
						e.printStackTrace();
						url="/public/Registarse.html";
					}
					for (int i = 0; i < 5; i++) {
						tipo = new Tipo();
				        operadora = new Operadoras();
				        telefono = new Telefonos();
						System.out.println("Veces que agarra telf="+i);
						num = request.getParameter("num"+i);
						ope = Integer.parseInt(request.getParameter("ope"+i));
						tip = Integer.parseInt(request.getParameter("tip"+i));
						
						System.out.println("Ope="+ope);
						System.out.println("tip="+tip);
						
						//Traemos la operadora
						operadora = operadoraDAO.read(ope);
						
						//Treamos el tipo
						tipo = tipoDAO.read(tip);
						
						//Agregamos al array de Telefonos
						telefono.setTel_numero(num);
						telefono.setOperador(operadora);
						telefono.setTipos(tipo);
						telefono.setPersona(persona);
						
						//Nos creamos el telefono
						telefonoDAO.create(telefono);
						
						url = "/index.html";
					}
				} catch (NumberFormatException e) {
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}else {
				url="/public/Registarse.html";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			url="/public/Registarse.html";
		}
		request.setAttribute("telefono", null);
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
