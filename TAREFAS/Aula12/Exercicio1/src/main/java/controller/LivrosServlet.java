package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Livro;
import persistence.GenericDao;
import persistence.LivrosDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/livros")
public class LivrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LivrosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("livros.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("botao");
		int codigo;

		// Retorno
		String saida = "";
		String erro = "";

		Livro t = new Livro();
		List<Livro> livros = new ArrayList<Livro>();
		
		if (cmd.contains("Inserir") || cmd.contains("Alterar")) {
			codigo = Integer.parseInt(request.getParameter("codigoLivro"));
			String nomeLivro = request.getParameter("nomeLivro");
			String qtdPaginasLivro = request.getParameter("qtdPaginasLivro");
			String ISBN = request.getParameter("ISBNLivro");
			String edicao = request.getParameter("edicaoLivro");
			t.setCodigo(codigo);
			t.setNome(nomeLivro);
			t.setQtdPaginas(Integer.parseInt(qtdPaginasLivro));
			t.setISBN(ISBN);
			t.setEdicao(Integer.parseInt(edicao));
		}
		
		try {
			if (cmd.contains("Inserir")) {
				inserirLivro(t);
				saida = "Livro inserido com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Buscar")) {
				codigo = Integer.parseInt(request.getParameter("codigoLivro"));
				t.setCodigo(codigo);
				t = buscarLivro(t);
			}
			
			if (cmd.contains("Alterar")) {
				alterarLivro(t);
				saida = "Livro alterado com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Excluir")) {
				codigo = Integer.parseInt(request.getParameter("codigoLivro"));
				t.setCodigo(codigo);
				t = buscarLivro(t);
				excluirLivro(t);
				saida = "Livro excluido com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Listar")) {
				livros = listarLivros();
				t = null;

			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("livro", t);
			request.setAttribute("livros", livros);

			RequestDispatcher rd = request.getRequestDispatcher("livros.jsp");
			rd.forward(request, response);
		}
	}

	private List<Livro> listarLivros()throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		LivrosDao lDao = new LivrosDao(gDao);
		
		List<Livro> livros = new ArrayList();
		livros = lDao.findAll();
		return livros;
	}

	private void excluirLivro(Livro t)throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		LivrosDao lDao = new LivrosDao(gDao);
		lDao.delete(t);
		
	}

	private void alterarLivro(Livro t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		LivrosDao lDao = new LivrosDao(gDao);
		lDao.update(t);
		
	}

	private Livro buscarLivro(Livro t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		LivrosDao lDao = new LivrosDao(gDao);
		t = lDao.findOne(t);

		return t;
	}

	private void inserirLivro(Livro t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		LivrosDao lDao = new LivrosDao(gDao);
		
		lDao.insert(t);
	}

}
