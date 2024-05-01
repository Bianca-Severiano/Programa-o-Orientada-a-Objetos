package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ControllerSP;

import java.io.IOException;

@WebServlet("/saopaulo")
public class SaoPauloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SaoPauloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("SaoPaulo.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float area = Float.parseFloat(request.getParameter("Valor_Area_SP"));
		int qtdQuartos = Integer.parseInt(request.getParameter("Num_Quartos_SP"));
		ControllerSP c = new ControllerSP(area, qtdQuartos);
		String retorno = "Valor a ser pago: R$" + c.calculoImposto();
		request.setAttribute("saida", retorno);
		
		RequestDispatcher rd = request.getRequestDispatcher("SaoPaulo.jsp");
		rd.forward(request, response);
	}

}
