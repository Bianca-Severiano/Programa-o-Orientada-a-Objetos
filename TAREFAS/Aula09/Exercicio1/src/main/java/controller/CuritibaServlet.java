package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ControllerCB;

import java.io.IOException;

@WebServlet("/curitiba")
public class CuritibaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CuritibaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Curitiba.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float area = Float.parseFloat(request.getParameter("Valor_Area_CB"));
		float idadeImovel = Float.parseFloat(request.getParameter("Idade_Imovel_CB"));
		ControllerCB c = new ControllerCB(area, idadeImovel);
		String retorno = "Valor a ser pago: R$" + c.calculoImposto();
		
		request.setAttribute("saida", retorno);
		RequestDispatcher rd = request.getRequestDispatcher("Curitiba.jsp");
		rd.forward(request, response);
	}

}
