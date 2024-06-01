package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Revista;
import persistence.GenericDao;
import persistence.RevistasDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/revistas")
public class RevistasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RevistasServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("revistas.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("botao");
		int codigo;

		// Retorno
		String saida = "";
		String erro = "";

		Revista t = new Revista();
		List<Revista> revistas = new ArrayList<Revista>();
		
		
		
		if (cmd.contains("Inserir") || cmd.contains("Alterar")) {
			codigo = Integer.parseInt(request.getParameter("codigoRevista"));
			String nomeRevista = request.getParameter("nomeRevista");
			String qtdPaginasRevista = request.getParameter("qtdPaginasRevista");
			String ISBN = request.getParameter("ISSNRevista");
			t.setCodigo(codigo);
			t.setNome(nomeRevista);
			t.setQtdPaginas(Integer.parseInt(qtdPaginasRevista));
			t.setISSN(ISBN);
		}
		
		try {
			
			if (cmd.contains("Inserir")) {
				inserirRevista(t);
				saida = "Revista inserido com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Buscar")) {
				codigo = Integer.parseInt(request.getParameter("codigoRevista"));
				t.setCodigo(codigo);
				t = buscarRevista(t);
			}
			
			if (cmd.contains("Alterar")) {
				alterarRevista(t);
				saida = "Revista alterada com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Excluir")) {
				codigo = Integer.parseInt(request.getParameter("codigoRevista"));
				t.setCodigo(codigo);
				t = buscarRevista(t);
				excluirRevista(t);
				saida = "Revista excluida com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Listar")) {
				revistas = listarRevistas();
				t = null;

			}
			
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("revista", t);
			request.setAttribute("revistas", revistas);

			RequestDispatcher rd = request.getRequestDispatcher("revistas.jsp");
			rd.forward(request, response);
		}
	}


	private void inserirRevista(Revista t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		RevistasDao rDao = new RevistasDao(gDao);
		rDao.insert(t);
		
	}


	private void alterarRevista(Revista t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		RevistasDao rDao = new RevistasDao(gDao);
		rDao.update(t);
		
	}


	private Revista buscarRevista(Revista t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		RevistasDao rDao = new RevistasDao(gDao);
		t = rDao.findOne(t);
		return t;
	}


	private void excluirRevista(Revista t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		RevistasDao rDao = new RevistasDao(gDao);
		rDao.delete(t);
		
	}


	private List<Revista> listarRevistas() throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		RevistasDao rDao = new RevistasDao(gDao);
		
		List<Revista> revistas = new ArrayList<Revista>();
		revistas = rDao.findAll();
		return revistas;
	}

}
