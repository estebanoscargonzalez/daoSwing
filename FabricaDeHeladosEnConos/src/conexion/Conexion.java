package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion {

	// conexion base de datos

	private static final String DRIVER_SQLITE = "org.sqlite.JDBC";
	private static final String DBURL_SQLITE = "jdbc:sqlite:DB_Esteban_Gonzalez.sqlite";

	public static Connection createConnection() {

		Connection conexion = null;

		try {

			Class.forName(DRIVER_SQLITE);
			conexion = DriverManager.getConnection(DBURL_SQLITE);

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);

		} catch (SQLException ex) {
			System.out.println(ex);
		}

		return conexion;
	}

}