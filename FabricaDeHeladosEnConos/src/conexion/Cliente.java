package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entidades.Clientes;
import interfaces.InterfazCliente;

public class Cliente extends Conexion implements InterfazCliente {

	public void crearTabla() {

		Connection conexion = null;
		Statement statement = null;

		try {

			conexion = createConnection();
			statement = conexion.createStatement();

			statement.executeUpdate("CREATE TABLE CLIENTES" + "(LEGAJO VARCHAR(45) NOT NULL, " + "APELLIDO VARCHAR(45), "
					+ "NOMBRE VARCHAR(45), " + "CANTIDAD_HELADOS_COMPRA VARCHAR(45)(45))");

			System.out.println("¡Tabla CLIENTES creada satisfactoriamente!");

		}

		catch (SQLException ex) {
			System.out.println(ex);
		}

		finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			}

			catch (SQLException ex) {
				System.out.println(ex);
			}

		}
	}

	public void registrar(Clientes cl) {

		Connection conexion = null;
		Statement statement = null;

		try {
			conexion = createConnection();
			statement = conexion.createStatement();
			statement.executeUpdate("INSERT INTO CLIENTES VALUES (" + cl.getLegajo() + ",' " + cl.getApellido() + "','"
					+ cl.getNombre() + "','" + cl.getCantidad() + "')");
		} catch (SQLException ex) {
			System.out.println(ex);

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			}

		}

	}

	public Clientes buscarCliente(String legajo) {

		Clientes cliente = null;
		Connection conexion = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			conexion = createConnection();
			statement = conexion.createStatement();

			rs = statement.executeQuery("SELECT * FROM CLIENTES WHERE CLIENTES.LEGAJO=" + legajo);

			while (rs.next()) {
				cliente = new Clientes(rs.getString("LEGAJO"), rs.getString("APELLIDO"), rs.getString("NOMBRE"),
						rs.getString("CANTIDAD_HELADOS_COMPRA"));
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return cliente;
	}

	public Clientes eliminar(String legajo) {
		Clientes cliente = null;
		ResultSet rs = null;
		Connection conexion = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;

		try {
			conexion = createConnection();
			statement = conexion.createStatement();

			rs = statement.executeQuery("SELECT * FROM CLIENTES WHERE CLIENTES.LEGAJO=" + legajo);

			preparedStatement = conexion.prepareStatement("DELETE FROM CLIENTES WHERE LEGAJO=" + legajo);
			preparedStatement.executeUpdate();
			
			while (rs.next()) {
				cliente = new Clientes(rs.getString("LEGAJO"), rs.getString("APELLIDO"), rs.getString("NOMBRE"),
						rs.getString("CANTIDAD_HELADOS_COMPRA"));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
		
		return cliente;

	}

}