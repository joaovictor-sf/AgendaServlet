package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

import java.io.IOException;

public class EditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JavaBeans contato = new JavaBeans();
	DAO dao = new DAO();
       
    public EditarController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		
		// Recebe o id do contato que será editado
		String idicon = request.getParameter("idicon");
		// Seta a variável JavaBeans
		contato.setIdicon(idicon);
		// metodo selecionar contato(DAO)
		dao.selecionarContato(contato);
		//Setar os atributos do formulário com o JavaBeans
		request.setAttribute("idicon", contato.getIdicon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("telefone", contato.getTelefone());
		request.setAttribute("email", contato.getEmail());
		//Encaminhar ao editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("Editar.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
