package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunosDao implements ICRUDDaoGenerico<Aluno> {
	
	private GenericDao gDao;

	public AlunosDao(GenericDao gDao) {
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
	public void insert(Aluno t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "INSERT INTO Aluno VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getRA());
		ps.setString(2, t.getNome());
		ps.setString(3, t.getEmail());
		ps.execute();
		ps.close();
		c.close();
		
	}


	@Override
	public void update(Aluno t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "UPDATE aluno SET nome=?, email=? WHERE ra=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setString(1, t.getNome());
		ps.setString(2, t.getEmail());
		ps.setInt(3, t.getRA());
		ps.execute();
		ps.close();
		c.close();
	}


	@Override
	public void delete(Aluno t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "DELETE FROM aluno WHERE ra=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getRA());
		ps.execute();
		ps.close();
		c.close();
	}


	@Override
	public Aluno findOne(Aluno t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		
		String SQL = "SELECT ra, nome, email FROM aluno WHERE ra=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getRA());
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			t.setRA(rs.getInt("ra"));
			t.setNome(rs.getString("nome"));
			t.setEmail(rs.getString("email"));
		}
		
		rs.close();
		ps.close();
		c.close();
		return t;
	}


	@Override
	public List<Aluno> findAll() throws SQLException, ClassNotFoundException {
		List<Aluno> alunos = new ArrayList();
		
		Connection c = gDao.getConnection();
		
		String SQL = "SELECT ra, nome, email FROM aluno";

		
		PreparedStatement ps = c.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Aluno a = new Aluno ();
			a.setRA(rs.getInt("ra"));
			a.setNome(rs.getString("nome"));
			a.setEmail(rs.getString("email"));
			alunos.add(a);
		}
		rs.close();
		ps.close();
		c.close();
		return alunos;
	}


}
