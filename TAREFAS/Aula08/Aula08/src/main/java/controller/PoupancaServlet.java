package controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaPoupanca;

import java.io.IOException;


@WebServlet("/poupanca")
public class PoupancaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PoupancaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Poupanca.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CMD = request.getParameter("btn");
		ContaPoupanca c = new ContaPoupanca();
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
		} else if (CMD.equals("Rendimento")) {
			float valorRendimento = Float.parseFloat(request.getParameter("valorRendimento"));
			String retorno = c.calcularNovoSaldo(valorRendimento);
			request.setAttribute("saida", retorno);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Poupanca.jsp");
		rd.forward(request, response);
	}

}
