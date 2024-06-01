package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Revista;


public class RevistasDao implements ICRUDDaoGenerico<Revista> {
	
	
	private GenericDao gDao;

	public RevistasDao(GenericDao gDao) {
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
	public void insert(Revista t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "INSERT INTO Exemplar VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getCodigo());
		ps.setString(2, t.getNome());
		ps.setInt(3, t.getQtdPaginas());
		ps.execute();

		SQL = "INSERT INTO revista VALUES (?, ?)";
		ps = c.prepareStatement(SQL);
		ps.setInt(2, t.getCodigo());
		ps.setString(1, t.getISSN());
		ps.execute();

		ps.close();
		c.close();
		
	}

	@Override
	public void update(Revista t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "UPDATE exemplar SET nome=?, qtdPaginas=? WHERE codigo=?";
		PreparedStatement ps = c.prepareStatement(SQL);

		ps.setString(1, t.getNome());
		ps.setInt(2, t.getQtdPaginas());
		ps.setInt(3, t.getCodigo());
		ps.execute();

		SQL = "UPDATE revista SET issn=? WHERE ExemplarCodigo=?";
		ps = c.prepareStatement(SQL);
		ps.setString(1, t.getISSN());
		ps.setInt(2, t.getCodigo());

		ps.execute();
		ps.close();
		c.close();
		
	}

	@Override
	public void delete(Revista t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "DELETE FROM revista WHERE ExemplarCodigo=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getCodigo());
		ps.execute();

		SQL = "DELETE FROM exemplar WHERE codigo=?";
		ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getCodigo());
		ps.execute();

		ps.close();
		c.close();
		
	}

	@Override
	public Revista findOne(Revista t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT t.issn AS issn, ");
		sql.append("e.codigo AS codigoExemplar, e.nome AS nome, e.qtdPaginas AS paginas ");
		sql.append("FROM revista t, exemplar e ");
		sql.append("WHERE t.ExemplarCodigo = e.codigo ");
		sql.append("AND t.ExemplarCodigo = ? ");

		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, t.getCodigo());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			t.setCodigo(rs.getInt("codigoExemplar"));
			t.setNome(rs.getString("nome"));
			t.setISSN(rs.getString("issn"));
			t.setQtdPaginas(rs.getInt("paginas"));
		}

		rs.close();
		ps.close();
		c.close();

		return t;
	}

	@Override
	public List<Revista> findAll() throws SQLException, ClassNotFoundException {
		List<Revista> revistas = new ArrayList();
		Connection c = gDao.getConnection();

		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT t.issn AS issn, ");
		sql.append("e.codigo AS codigoExemplar, e.nome AS nome, e.qtdPaginas AS paginas ");
		sql.append("FROM revista t, exemplar e ");
		sql.append("WHERE t.ExemplarCodigo = e.codigo ");


		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Revista t = new Revista();
			t.setCodigo(rs.getInt("codigoExemplar"));
			t.setNome(rs.getString("nome"));
			t.setISSN(rs.getString("issn"));
			t.setQtdPaginas(rs.getInt("paginas"));
			revistas.add(t);
		}

		rs.close();
		ps.close();
		c.close();

		return revistas;
	}

}
