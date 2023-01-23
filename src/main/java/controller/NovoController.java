package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

import java.io.IOException;

public class NovoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
       
    public NovoController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//setar as variaveis JavaBeans
		contato.setNome(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		//invocar o método inserir contato
		dao.inserirContato(contato);
		
		response.sendRedirect("Controller");
	}

}
