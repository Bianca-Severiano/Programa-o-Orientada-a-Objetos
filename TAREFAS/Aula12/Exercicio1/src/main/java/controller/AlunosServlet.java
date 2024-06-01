package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import persistence.AlunosDao;
import persistence.GenericDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/alunos")
public class AlunosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlunosServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("alunos.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("botao");
		int ra;

		// Retorno
		String saida = "";
		String erro = "";

		Aluno t = new Aluno();
		List<Aluno> alunos = new ArrayList<Aluno>();

		if (cmd.contains("Inserir") || cmd.contains("Alterar")) {
			ra = Integer.parseInt(request.getParameter("raAluno"));
			String nomeAluno = request.getParameter("nomeAluno");
			String emailAluno = request.getParameter("emailAluno");
			t.setRA(ra);
			t.setNome(nomeAluno);
			t.setEmail(emailAluno);
		}

		try {

			if (cmd.contains("Inserir")) {
				inserirAluno(t);
				saida = "Aluno inserido com sucesso!";
				t = null;
			}

			if (cmd.contains("Alterar")) {
				alterarAluno(t);
				saida = "Aluno alterado com sucesso!";
				t = null;
			}

			if (cmd.contains("Excluir")) {
				ra = Integer.parseInt(request.getParameter("raAluno"));
				t.setRA(ra);
				t = buscarAluno(t);
				excluirAluno(t);
				saida = "Aluno excluido com sucesso!";
				t = null;
			}

			if (cmd.contains("Buscar")) {
				ra = Integer.parseInt(request.getParameter("raAluno"));
				t.setRA(ra);
				t = buscarAluno(t);
			}

			if (cmd.contains("Listar")) {
				alunos = listarAlunos();
				t = null;

			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("aluno", t);
			request.setAttribute("alunos", alunos);

			RequestDispatcher rd = request.getRequestDispatcher("alunos.jsp");
			rd.forward(request, response);
		}
	}

	private List<Aluno> listarAlunos() throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunosDao aDao = new AlunosDao(gDao);
		
		List<Aluno> aluno = new ArrayList();
		aluno = aDao.findAll();
		return aluno;
	}

	private void excluirAluno(Aluno t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunosDao aDao = new AlunosDao(gDao);
		aDao.delete(t);

	}

	private Aluno buscarAluno(Aluno t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunosDao aDao = new AlunosDao(gDao);
		t = aDao.findOne(t);

		return t;
	}

	private void alterarAluno(Aluno t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunosDao aDao = new AlunosDao(gDao);
		aDao.update(t);

	}

	private void inserirAluno(Aluno t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunosDao aDao = new AlunosDao(gDao);
		
		aDao.insert(t);
	}

}
