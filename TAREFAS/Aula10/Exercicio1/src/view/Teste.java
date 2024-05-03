package view;

import java.sql.Connection;
import java.sql.SQLException;

import persistence.GenericDaoMySql;

public class Teste {

	public static void main(String[] args) {
		GenericDaoMySql gDaoMySQL = new GenericDaoMySql();
		
		try {
			Connection c = gDaoMySQL.getConnection();
			String sgbd = c.getMetaData().getDatabaseProductName();
			System.out.println(sgbd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
