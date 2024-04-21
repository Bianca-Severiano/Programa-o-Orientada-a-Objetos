package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaEspecial;

import java.io.IOException;

@WebServlet("/especial")
public class EspecialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EspecialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Especial.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CMD = request.getParameter("btn");
		ContaEspecial c = new ContaEspecial();
		if (CMD.equals("Deposito")) {
			String valorDeposito = request.getParameter("valorDeposito");
			String retorno = c.depositar(Float.parseFloat(valorDeposito));
			request.setAttribute("saida", retorno);
		} else if (CMD.equals("Saque")) {
			float valorSaque = Float.parseFloat(request.getParameter("valorSaque"));
			String retorno = c.sacar(valorSaque);
			request.setAttribute("saida", retorno);
		} else if (CMD.equals("Dados")) {
			String retorno = c.toString();
			request.setAttribute("saida", retorno);
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Especial.jsp");
		rd.forward(request, response);
	}

}
