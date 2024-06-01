package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluguel;
import model.Aluno;
import model.Livro;
import model.Revista;
import persistence.AluguelDao;
import persistence.AlunosDao;
import persistence.GenericDao;
import persistence.LivrosDao;
import persistence.RevistasDao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/alugueis")
public class AlugueisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	public AlugueisServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("alugueis.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("botao");
		int ra;
		int codigo = 0;

		// Retorno
		String saida = "";
		String erro = "";

		Aluguel t = new Aluguel();

		List<Aluguel> alugueis = new ArrayList<>();

		if (cmd.contains("Inserir") || cmd.contains("Alterar")) {
			ra = Integer.parseInt(request.getParameter("raAluno"));
			codigo = Integer.parseInt(request.getParameter("codigoExemplar"));
			String dtRetirada = request.getParameter("dataRetirada");
			String dtDevolucao = request.getParameter("dataDevolucao");
			t = montaAluguel(ra, codigo, dtRetirada, dtDevolucao);
			}
			
		
		try {
			if (cmd.contains("Inserir")) {
				inserirAluguel(t);
				saida = "Aluguel inserido com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Buscar")) {
				codigo = Integer.parseInt(request.getParameter("codigoExemplar"));
				t = montaAluguel(0, codigo, "", "");
				t = buscarAluguel(t);
			}
			
			if (cmd.contains("Listar")) {
				alugueis = listarAlugueis();
				t = null;
			}
			
			if (cmd.contains("Alterar")) {
				alterarAluguel(t);
				saida = "Aluguel alterado com sucesso!";
				t = null;
			}
			
			if (cmd.contains("Excluir")) {
				ra = Integer.parseInt(request.getParameter("raAluno"));
				codigo = Integer.parseInt(request.getParameter("codigoExemplar"));
				t = montaAluguel(ra, codigo, "", "");
				excluirAluno(t);
				saida = "Aluguel excluido com sucesso!";
				t = null;
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("aluguel", t);
			request.setAttribute("alugueis", alugueis);
			RequestDispatcher rd = request.getRequestDispatcher("alugueis.jsp");
			rd.forward(request, response);
		}

	}

	private void alterarAluguel(Aluguel t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AluguelDao lDao = new AluguelDao(gDao);
		
		lDao.update(t);
		
	}

	private void excluirAluno(Aluguel t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AluguelDao lDao = new AluguelDao(gDao);
		
		lDao.delete(t);
		
	}

	private List<Aluguel> listarAlugueis()throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AluguelDao lDao = new AluguelDao(gDao);
		
		List<Aluguel> alugueis = new ArrayList();
		alugueis = lDao.findAll();
		return alugueis;
	}

	private Aluguel buscarAluguel(Aluguel t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		AluguelDao lDao = new AluguelDao(gDao);
		
		t = lDao.findOne(t);
		return t;
	}

	private void inserirAluguel(Aluguel t)throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AluguelDao lDao = new AluguelDao(gDao);
		
		lDao.insert(t);
		
	}
	
	private Aluguel montaAluguel(int ra, int codigo, String dtRetirada, String dtDevolucao) {
		
		Aluguel t = new Aluguel();
		Aluno a = new Aluno();
		Revista r = new Revista();
		Livro l = new Livro();
		String saida = "";
		String erro = "";
		
		try {
			GenericDao gDao = new GenericDao();
			AlunosDao aDao = new AlunosDao(gDao);
			a.setRA(ra);
			a = aDao.findOne(a);
			t.setAluno(a);
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		}

		try {
			GenericDao gDao = new GenericDao();
			RevistasDao rDao = new RevistasDao(gDao);
			r.setCodigo(codigo);
			try {
				r = rDao.findOne(r);
			} catch (ClassNotFoundException | SQLException e) {
				erro = e.getMessage();
			}
		} finally {
			if (r != null) { // é revista
				t.setExemplar(r);
			} else { // é livro
				GenericDao gDao = new GenericDao();
				LivrosDao lDao = new LivrosDao(gDao);
				l.setCodigo(codigo);
				try {
					l = lDao.findOne(l);
					t.setExemplar(l);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = null;

		try {
			Date parsedDate = dateFormat.parse(dtRetirada);
			sqlDate = new java.sql.Date(parsedDate.getTime());
			t.setDataRetirada(sqlDate);
			parsedDate = dateFormat.parse(dtDevolucao);
			sqlDate = new java.sql.Date(parsedDate.getTime());
			t.setDataDevolucao(sqlDate);
		} catch (ParseException e) {
			e.getStackTrace();
		}
		
		return t;
	}

}
