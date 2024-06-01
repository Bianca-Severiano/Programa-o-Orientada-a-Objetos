package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluguel;
import model.Aluno;
import model.Exemplar;
import model.Livro;
import model.Revista;

public class AluguelDao implements ICRUDDaoGenerico<Aluguel> {
	
	private GenericDao gDao;

	public AluguelDao(GenericDao gDao) {
		super();
		this.gDao = gDao;
	}
	

	public GenericDao getgDao() {
		return gDao;
	}

	public void setgDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	

	@Override
	public void insert(Aluguel t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "INSERT INTO Aluguel VALUES (?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setDate(1, t.getDataRetirada());
		ps.setDate(2, t.getDataDevolucao());
		ps.setInt(3, t.getExemplar().getCodigo());
		ps.setInt(4, t.getAluno().getRA());
		ps.execute();
		ps.close();
		c.close();
		
	}

	@Override
	public void update(Aluguel t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "UPDATE Aluguel SET data_retirada=?, data_devolucao=?, ExemplarCodigo=?, AlunoRa=? WHERE ExemplarCodigo=? AND AlunoRa=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setDate(1, t.getDataRetirada());
		ps.setDate(2, t.getDataDevolucao());
		ps.setInt(3, t.getExemplar().getCodigo());
		ps.setInt(4, t.getAluno().getRA());
		ps.setInt(5, t.getExemplar().getCodigo());
		ps.setInt(6, t.getAluno().getRA());
		ps.execute();
		ps.close();
		c.close();
		
	}

	@Override
	public void delete(Aluguel t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "DELETE FROM Aluguel WHERE AlunoRa=? AND ExemplarCodigo=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getAluno().getRA());
		ps.setInt(2, t.getExemplar().getCodigo());
		ps.execute();
		ps.close();
		c.close();
		
	}

	@Override
	public Aluguel findOne(Aluguel t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT t.data_retirada AS dtRetirada, t.data_devolucao AS dtDevolucao, ");
		sql.append("a.ra AS alunoRa, a.nome AS nomeAluno, a.email AS email, ");
		sql.append("e.codigo AS codigoExemplar, e.nome AS nomeExemplar, e.qtdPaginas AS paginas ");
		sql.append("FROM aluguel t, exemplar e, aluno a ");
		sql.append("WHERE t.ExemplarCodigo = e.codigo AND  t.AlunoRa = a.ra ");
		sql.append("AND t.ExemplarCodigo = ? ");

		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, t.getExemplar().getCodigo());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Exemplar e = null;
			Aluno a = new Aluno();
			a.setRA(rs.getInt("alunoRa"));
			a.setNome(rs.getString("nomeAluno"));
			a.setEmail(rs.getString("email"));
			
			t.setAluno(a);
			String SQL = "Select count(*) from livro WHERE ExemplarCodigo = ? ";
			PreparedStatement ps2 = c.prepareStatement(SQL);
			ps2.setInt(1,  rs.getInt("codigoExemplar"));
			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next()) {
				if (rs2.getInt(1) > 0) { // é livro
					e = new Livro();
				} else { // é revista
					e = new Revista();
				}
			}
			
			e.setCodigo(rs.getInt("codigoExemplar"));
			e.setNome(rs.getString("nomeExemplar"));
			e.setQtdPaginas(rs.getInt("paginas"));
			
			t.setExemplar(e);
			t.setDataRetirada(rs.getDate("dtRetirada"));
			t.setDataDevolucao(rs.getDate("dtDevolucao"));
		}

		rs.close();
		ps.close();
		c.close();

		return t;
	}

	@Override
	public List<Aluguel> findAll() throws SQLException, ClassNotFoundException {
		List<Aluguel> alugueis = new ArrayList<Aluguel>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT t.data_retirada AS dtRetirada, t.data_devolucao AS dtDevolucao, ");
		sql.append("a.ra AS alunoRa, a.nome AS nomeAluno, a.email AS email, ");
		sql.append("e.codigo AS codigoExemplar, e.nome AS nomeExemplar, e.qtdPaginas AS paginas ");
		sql.append("FROM aluguel t, exemplar e, aluno a ");
		sql.append("WHERE t.ExemplarCodigo = e.codigo AND  t.AlunoRa = a.ra");


		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Aluguel t = new Aluguel();
			Exemplar e = null;
			Aluno a = new Aluno();
			a.setRA(rs.getInt("alunoRa"));
			a.setNome(rs.getString("nomeAluno"));
			a.setEmail(rs.getString("email"));
			
			t.setAluno(a);
			String SQL = "Select count(*) from livro WHERE ExemplarCodigo = ? ";
			PreparedStatement ps2 = c.prepareStatement(SQL);
			ps2.setInt(1, rs.getInt("codigoExemplar"));
			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next()) {
				if (rs2.getInt(1) > 0) { // é livro
					e = new Livro();
				} else { // é revista
					e = new Revista();
				}
			}
			
			e.setCodigo(rs.getInt("codigoExemplar"));
			e.setNome(rs.getString("nomeExemplar"));
			e.setQtdPaginas(rs.getInt("paginas"));
			
			t.setExemplar(e);
			t.setDataRetirada(rs.getDate("dtRetirada"));
			t.setDataDevolucao(rs.getDate("dtDevolucao"));
			alugueis.add(t);
		}

		rs.close();
		ps.close();
		c.close();
		
		return alugueis;
	}

}
