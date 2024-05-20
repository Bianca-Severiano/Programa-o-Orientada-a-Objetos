package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Time;

public class TimesDao implements ICrud<Time>{

	private GenericDao gDao;
	
	
	
	
	public TimesDao(GenericDao gDao) {
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
	public void inserir(Time t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "INSERT INTO time VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getCodigo());
		ps.setString(2, t.getNome());
		ps.setString(3, t.getCidade());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void atualizar(Time t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "UPDATE time SET nome=?, cidade=? WHERE Codigo=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setString(1, t.getNome());
		ps.setString(2, t.getCidade());
		ps.setInt(3, t.getCodigo());
		ps.execute();
		ps.close();
		c.close();
		
	}

	@Override
	public void excluir(Time t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "DELETE FROM time WHERE Codigo=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getCodigo());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public Time consultar(Time t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "SELECT Codigo, nome, cidade FROM time WHERE Codigo=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getCodigo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			t.setCodigo(rs.getInt("Codigo"));
			t.setNome(rs.getString("nome"));
			t.setCidade(rs.getString("cidade"));
		}
		rs.close();
		ps.close();
		c.close();
		return t;
	}

	@Override
	public List<Time> listar() throws SQLException, ClassNotFoundException {
		List<Time> times = new ArrayList();
		Connection c = gDao.getConnection();
		String SQL = "SELECT Codigo, nome, cidade FROM time";
		PreparedStatement ps = c.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Time t = new Time ();
			t.setCodigo(rs.getInt("Codigo"));
			t.setNome(rs.getString("nome"));
			t.setCidade(rs.getString("cidade"));
			times.add(t);
		}
		rs.close();
		ps.close();
		c.close();
		
		return times;
	}

}
