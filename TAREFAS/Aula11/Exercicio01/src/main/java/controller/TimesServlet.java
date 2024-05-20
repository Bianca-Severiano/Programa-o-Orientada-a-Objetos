package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Time;
import persistence.GenericDao;
import persistence.TimesDao;



@WebServlet("/times")
public class TimesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TimesServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("times.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Entrada
		String cmd = request.getParameter("botao");
		int codigo; 

		
		//Retorno
		String saida = "";
		String erro = "";
		Time t = new Time();
		
		List<Time> times = new ArrayList<Time>();
		

		
		if (cmd.contains("Inserir") || cmd.contains("Alterar")) {
			codigo = Integer.parseInt(request.getParameter("idTime"));
			String nomeTime = request.getParameter("nomeTime");
			String	cidadeTime = request.getParameter("cidadeTime");
			t.setCodigo(codigo);
			t.setNome(nomeTime);
			t.setCidade(cidadeTime);
		}
		
		try {
			if (cmd.contains("Inserir")) {
				cadastrarTime(t);
				saida = "Time cadastrado com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Alterar")) {
				alterarTime(t);
				saida = "Time alteradocom sucesso!";
				t = null;
			}
			
			if (cmd.contains("Excluir")) {
				codigo = Integer.parseInt(request.getParameter("idTime"));
				t.setCodigo(codigo);
				t = buscarTime(t);
				excluirTime(t);
				saida = "Time excluido com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Buscar")) {
				codigo = Integer.parseInt(request.getParameter("idTime"));
				t.setCodigo(codigo);
				t = buscarTime(t);
			}
			
			if (cmd.contains("Consultar")) {
				times = consultarTimes();
				t = null;
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			
			request.setAttribute("saida", saida );
			request.setAttribute("erro", erro );
			request.setAttribute("time", t);
			request.setAttribute("times", times);
			
			RequestDispatcher rd = request.getRequestDispatcher("times.jsp");
			rd.forward(request, response);
		}
	}

	private void cadastrarTime(Time t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		TimesDao tDao = new TimesDao(gDao);
		tDao.inserir(t);
		consultarTimes();
		
	}

	private void alterarTime(Time t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		TimesDao tDao = new TimesDao(gDao);
		tDao.atualizar(t);
		consultarTimes();
		
	}

	private void excluirTime(Time t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		TimesDao tDao = new TimesDao(gDao);
		tDao.excluir(t);
		consultarTimes();
		
	}

	private Time buscarTime(Time t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		TimesDao tDao = new TimesDao(gDao);
		t = tDao.consultar(t);

		return t;
	}

	private List<Time> consultarTimes() throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		TimesDao tDao = new TimesDao(gDao);
		List<Time> time = tDao.listar();

		return time;
	}

}
