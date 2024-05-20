package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogador;
import model.Time;

public class JogadoresDao implements ICrud<Jogador> {

	private GenericDao gDao;
	public JogadoresDao(GenericDao gDao) {
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
	public void inserir(Jogador t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "INSERT INTO jogador VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getId());
		ps.setString(2, t.getNome());
		ps.setDate(3, t.getData_nasc());
		ps.setFloat(4, t.getAltura());
		ps.setFloat(5, t.getPeso());
		ps.setInt(6, t.getTime().getCodigo());
		ps.execute();
		ps.close();
		c.close();

	}

	@Override
	public void atualizar(Jogador t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "UPDATE jogador SET nome=?, data_nasc=?, altura=?, peso=?, TimeCodigo=? WHERE id=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setString(1, t.getNome());
		ps.setDate(2, t.getData_nasc());
		ps.setFloat(3, t.getAltura());
		ps.setFloat(4, t.getPeso());
		ps.setInt(5, t.getTime().getCodigo());
		ps.setInt(6, t.getId());
		ps.execute();
		ps.close();
		c.close();

	}

	@Override
	public void excluir(Jogador t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String SQL = "DELETE FROM jogador WHERE id=?";
		PreparedStatement ps = c.prepareStatement(SQL);
		ps.setInt(1, t.getId());
		ps.execute();
		ps.close();
		c.close();

	}

	@Override
	public Jogador consultar(Jogador t) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.id AS id, t.nome AS nome, ");
		sql.append("t.data_nasc AS data_nasc, t.altura AS altura, ");
		sql.append("t.altura AS altura, t.peso AS peso,  ");
		sql.append("tt.Codigo AS CodTime, tt.nome AS NomeTime, tt.cidade AS CidadeTime ");
		sql.append("FROM time tt, jogador t ");
		sql.append("WHERE tt.codigo = t.TimeCodigo ");
		sql.append("AND t.id = ? ");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, t.getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Time tt = new Time();
			
			tt.setCodigo(rs.getInt("CodTime"));
			tt.setNome(rs.getString("NomeTime"));
			tt.setCidade(rs.getString("CidadeTime"));
			
			t.setId(rs.getInt("id"));
			t.setNome(rs.getString("nome"));
			t.setData_nasc(rs.getDate("data_nasc"));
			t.setAltura(rs.getFloat("altura"));
			t.setPeso(rs.getFloat("peso"));
			t.setTime(tt);
		}
		
		rs.close();
		ps.close();
		c.close();
		return t;
	}

	@Override
	public List<Jogador> listar() throws SQLException, ClassNotFoundException {
		List<Jogador> jogadores = new ArrayList();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.id AS id, t.nome AS nome, ");
		sql.append("t.data_nasc AS data_nasc, t.altura AS altura, ");
		sql.append("t.peso AS peso, t.altura AS altura, ");
		sql.append("tt.Codigo AS CodTime, tt.nome AS NomeTime, tt.cidade AS CidadeTime ");
		sql.append("FROM time tt, jogador t ");
		sql.append("WHERE tt.Codigo = t.TimeCodigo ");

		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Time tt = new Time();
			
			tt.setCodigo(rs.getInt("CodTime"));
			tt.setNome(rs.getString("NomeTime"));
			tt.setCidade(rs.getString("CidadeTime"));
			
			Jogador t = new Jogador();
			t.setId(rs.getInt("id"));
			t.setNome(rs.getString("nome"));
			t.setData_nasc(rs.getDate("data_nasc"));
			t.setAltura(rs.getFloat("altura"));
			t.setPeso(rs.getFloat("peso"));
			t.setTime(tt);
			
			jogadores.add(t);
		}
		rs.close();
		ps.close();
		c.close();
		return jogadores;
	}

}
