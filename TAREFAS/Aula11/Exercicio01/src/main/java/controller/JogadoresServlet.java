package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Jogador;
import model.Time;
import persistence.GenericDao;
import persistence.JogadoresDao;
import persistence.TimesDao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

@WebServlet("/jogadores")
public class JogadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JogadoresServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erro = "";
		List<Time> times = new ArrayList<>();

		GenericDao gDao = new GenericDao();
		TimesDao tDao = new TimesDao(gDao);

		try {
			times = tDao.listar();
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {

			request.setAttribute("erro", erro);
			request.setAttribute("times", times);
		}

		RequestDispatcher rd = request.getRequestDispatcher("jogadores.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retorno
		String saida = "";
		String erro = "";
		Jogador j = new Jogador();
		List<Time> times = new ArrayList();
		
		try {
			times = listarTimes();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		List<Jogador> jogadores = new ArrayList<>();
		
		// Entrada
		String cmd = request.getParameter("botao");
		int codigoJogador;
		

		try {
			if (cmd.contains("Inserir") || cmd.contains("Alterar") ) {
				codigoJogador = Integer.parseInt(request.getParameter("idJogador"));
				String nomeJogador = request.getParameter("nomeJogador");
				String nascJogador = request.getParameter("nascJogador");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.sql.Date sqlDate = null;
				try {
					Date parsedDate = dateFormat.parse(nascJogador);
					sqlDate = new java.sql.Date(parsedDate.getTime());
				} catch (ParseException e) {
					 e.getMessage();
				}
				float altura = Float.parseFloat(request.getParameter("alturaJogador"));
				float peso = Float.parseFloat(request.getParameter("pesoJogador"));
				String codigoTime = request.getParameter("timeCodigo");
				
				Time t = new Time();
				t.setCodigo(Integer.parseInt(codigoTime));
				t = buscarTime(t);
				
				j.setId(codigoJogador);
				j.setNome(nomeJogador);
				j.setData_nasc(sqlDate);
				j.setAltura(altura);
				j.setPeso(peso);
				j.setTime(t);

			}

			if (cmd.contains("Inserir")) {
				codigoJogador = Integer.parseInt(request.getParameter("idJogador"));
				cadastrarJogador(j);
				saida = "Jogador cadastrado com sucesso!";
				j = null;
			}

			if (cmd.contains("Alterar")) {
				codigoJogador = Integer.parseInt(request.getParameter("idJogador"));
				j.setId(codigoJogador);
				alterarJogador(j);
				saida = "Jogador alterado com sucesso!";
				j = null;
			}

			if (cmd.contains("Excluir")) {
				codigoJogador = Integer.parseInt(request.getParameter("idJogador"));
				j.setId(codigoJogador);
				excluirJogador(j);
				saida = "Jogador excluido com sucesso!";
				j = null;
			}

			if (cmd.contains("Buscar")) {
				codigoJogador = Integer.parseInt(request.getParameter("idJogador"));
				j.setId(codigoJogador);
				j = buscarJogador(j);
			}

			if (cmd.contains("Consultar")) {
				jogadores = consultarJogadores();
				j = null;
			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {

			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("jogador", j);
			request.setAttribute("jogadores", jogadores);
			request.setAttribute("times", times);

			RequestDispatcher rd = request.getRequestDispatcher("jogadores.jsp");
			rd.forward(request, response);
		}
	}



	private void cadastrarJogador(Jogador j) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		JogadoresDao jDao = new JogadoresDao(gDao);
		jDao.inserir(j);
		consultarJogadores();

	}

	private void alterarJogador(Jogador j) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		JogadoresDao jDao = new JogadoresDao(gDao);
		jDao.atualizar(j);
		consultarJogadores();

	}

	private void excluirJogador(Jogador j) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		JogadoresDao jDao = new JogadoresDao(gDao);
		jDao.excluir(j);
		consultarJogadores();

	}

	private Jogador buscarJogador(Jogador j) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		JogadoresDao jDao = new JogadoresDao(gDao);
		j = jDao.consultar(j);
		return j;
	}

	private List<Jogador> consultarJogadores() throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		JogadoresDao jDao = new JogadoresDao(gDao);
		List<Jogador> jogadores = jDao.listar();
		return jogadores;
	}
	
	
	
	
	
	private Time buscarTime(Time t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		TimesDao tDao = new TimesDao(gDao);
		t = tDao.consultar(t);
		return t;
	}
	
	private List<Time> listarTimes() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		TimesDao tDao = new TimesDao(gDao);
		List<Time> time = tDao.listar();
		return time;
	}

}
