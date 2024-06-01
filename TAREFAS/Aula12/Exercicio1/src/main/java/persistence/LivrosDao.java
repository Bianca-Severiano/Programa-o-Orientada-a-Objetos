package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Livro;

public class LivrosDao implements ICRUDDaoGenerico<Livro> {

	private GenericDao gDao;

	public LivrosDao(GenericDao gDao) {
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
	public void insert(Livro t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "INSERT INTO Exemplar VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getCodigo());
		ps.setString(2, t.getNome());
		ps.setInt(3, t.getQtdPaginas());
		ps.execute();

		SQL = "INSERT INTO Livro VALUES (?, ?, ?)";
		ps = c.prepareStatement(SQL);
		ps.setInt(3, t.getCodigo());
		ps.setString(1, t.getISBN());
		ps.setInt(2, t.getEdicao());
		ps.execute();

		ps.close();
		c.close();

	}

	@Override
	public void update(Livro t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "UPDATE exemplar SET nome=?, qtdPaginas=? WHERE codigo=?";
		PreparedStatement ps = c.prepareStatement(SQL);

		ps.setString(1, t.getNome());
		ps.setInt(2, t.getQtdPaginas());
		ps.setInt(3, t.getCodigo());
		ps.execute();

		SQL = "UPDATE livro SET isbn=?, edicao=? WHERE ExemplarCodigo=?";
		ps = c.prepareStatement(SQL);
		ps.setString(1, t.getISBN());
		ps.setInt(2, t.getEdicao());
		ps.setInt(3, t.getCodigo());

		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void delete(Livro t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "DELETE FROM livro WHERE ExemplarCodigo=?";
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
	public Livro findOne(Livro t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT t.isbn AS isbn, t.edicao AS edicao, ");
		sql.append("e.codigo AS codigoExemplar, e.nome AS nome, e.qtdPaginas AS paginas ");
		sql.append("FROM livro t, exemplar e ");
		sql.append("WHERE t.ExemplarCodigo = e.codigo ");
		sql.append("AND t.ExemplarCodigo = ? ");

		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, t.getCodigo());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			t.setCodigo(rs.getInt("codigoExemplar"));
			t.setNome(rs.getString("nome"));
			t.setISBN(rs.getString("isbn"));
			t.setQtdPaginas(rs.getInt("paginas"));
			t.setEdicao(rs.getInt("edicao"));
		}

		rs.close();
		ps.close();
		c.close();

		return t;
	}

	@Override
	public List<Livro> findAll() throws SQLException, ClassNotFoundException {
		List<Livro> livros = new ArrayList();
		Connection c = gDao.getConnection();

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT t.isbn AS isbn, t.edicao AS edicao, ");
		sql.append("e.codigo AS codigoExemplar, e.nome AS nome, e.qtdPaginas AS paginas ");
		sql.append("FROM livro t, exemplar e ");
		sql.append("WHERE t.ExemplarCodigo = e.codigo ");


		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Livro t = new Livro();
			t.setCodigo(rs.getInt("codigoExemplar"));
			t.setNome(rs.getString("nome"));
			t.setISBN(rs.getString("isbn"));
			t.setQtdPaginas(rs.getInt("paginas"));
			t.setEdicao(rs.getInt("edicao"));
			livros.add(t);
		}

		rs.close();
		ps.close();
		c.close();

		return livros;
	}

}
