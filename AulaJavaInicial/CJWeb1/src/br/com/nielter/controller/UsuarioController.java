package br.com.nielter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nielter.entidades.Usuario;
import br.com.nielter.jdbc.UsuarioDAO;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando M�todo GET");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.BuscarTodos();
		
		//engavetar no request a lista
		request.setAttribute("lista", lista);
		
		//Encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("listausuarios.jsp");
		saida.forward(request, response);
    
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando M�todo POST");
		//Recebe dados da Tela
		String id = request.getParameter("txtid");
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		
		//Cria objeto Usuario e sera os valores
		
		Usuario usuario = new Usuario();
		if (id != "" && id != "0"){ 
			usuario.setId(Integer.parseInt(id));
		}		
		usuario.setNome(nome);
		usuario.setUsuario(login);
		usuario.setSenha(senha);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.Salvar(usuario);
		
		PrintWriter saida = response.getWriter();
		saida.print("Salvo!");
		
	}

}