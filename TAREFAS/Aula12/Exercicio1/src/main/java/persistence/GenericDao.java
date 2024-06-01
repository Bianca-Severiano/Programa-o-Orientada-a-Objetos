package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
	
	
	private Connection c;

	public GenericDao() {
		super();
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		String hostName = "localhost"; // IP da máquina do servidor
		String dbName = "Biblioteca"; // Nome da database
		String user = "root";
		String senha = "3108";

		Class.forName("com.mysql.cj.jdbc.Driver"); // Referência da classe da lib de conexão
		// Configuração da String de conexão com MySQL
		c = DriverManager.getConnection(String.format("jdbc:mysql://%s:3306/%s", hostName, dbName), user, senha);
		return c;
	}


}
