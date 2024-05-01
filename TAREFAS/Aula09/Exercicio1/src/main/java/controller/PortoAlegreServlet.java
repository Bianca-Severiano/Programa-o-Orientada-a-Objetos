package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ControllerPA;

import java.io.IOException;

@WebServlet("/portoalegre")
public class PortoAlegreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PortoAlegreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("PortoAlegre.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float area = Float.parseFloat(request.getParameter("Valor_Area_PA"));
		float haGaragem = Float.parseFloat(request.getParameter("Ha_Garagem_PA"));
		ControllerPA c = new ControllerPA(area, haGaragem);
		String retorno = "Valor a ser pago: R$" + c.calculoImposto();
		request.setAttribute("saida", retorno);
		
		RequestDispatcher rd = request.getRequestDispatcher("PortoAlegre.jsp");
		rd.forward(request, response);
	}

}
