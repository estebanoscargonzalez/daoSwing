import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import conexion.Cliente;
import entidades.Clientes;
import interfaces.InterfazCliente;

public class FrameCompraDigitalCliente{

	private JFrame frmBienvenido;
	private JTextField txtLegajo;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	private Connection conexion;
	
	private void registrarDatos() {	
							
			InterfazCliente dao = new Cliente();
			Clientes cl = new Clientes(txtLegajo.getText(), txtApellido.getText(), txtNombre.getText(), txtCantidad.getText());
			dao.registrar(cl);			

			//JOptionPane;
			txtLegajo.setText("");
			txtApellido.setText("");
			txtNombre.setText("");
			txtCantidad.setText("");
		
			JOptionPane.showMessageDialog(null, "El cliente se registro con exito");
	}
	
	private void buscarDatos() {
		InterfazCliente dao = new Cliente();
		Clientes cliente = dao.buscarCliente(txtLegajo.getText());
		
		if (cliente == null) {	
			JOptionPane.showMessageDialog(null, "No existe el cliente");
			System.out.println("No se encontraron resultados para la búsqueda");
			
		} else {
			System.out.println("Resultado de la búsqueda del cliente: " + cliente.toString());
			
			txtApellido.setText(cliente.getApellido());
			txtNombre.setText(cliente.getNombre());
			txtCantidad.setText(cliente.getCantidad());
		}			
		
	}
	
	private void eliminarDatos() {
		InterfazCliente dao = new Cliente();
		Clientes cliente =  dao.eliminar(txtLegajo.getText());;
		
		if (cliente == null) {	
			JOptionPane.showMessageDialog(null, "No existe el cliente");
			txtLegajo.setText("");
			txtApellido.setText("");
			txtNombre.setText("");
			txtCantidad.setText("");
			System.out.println("No se encontraron resultados para la búsqueda");
			
		} else {	
			
			txtLegajo.setText("");
			txtApellido.setText("");
			txtNombre.setText("");
			txtCantidad.setText("");
			
			JOptionPane.showMessageDialog(null, "El cliente se elimino con exito");
		}			
		
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCompraDigitalCliente window = new FrameCompraDigitalCliente();
					window.frmBienvenido.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameCompraDigitalCliente() {
		initialize();
		
		try {
			conexion = DriverManager.getConnection("jdbc:sqlite:DB_Esteban_Gonzalez.sqlite");
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBienvenido = new JFrame();
		frmBienvenido.setTitle("Bienvenido a nuestro sistema de ventas digital!");
		frmBienvenido.setBounds(100, 100, 1200, 100);
		frmBienvenido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmBienvenido.getContentPane().add(panel, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Porfavor, ingrese los siguientes datos...");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmBienvenido.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel LEGAJO = new JLabel("Legajo");
		panel.add(LEGAJO);
		
		txtLegajo = new JTextField();
		panel.add(txtLegajo);
		txtLegajo.setColumns(10);
		
		JLabel APELLIDO = new JLabel("Apellido");
		panel.add(APELLIDO);
		
		txtApellido = new JTextField();
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel NOMBRE = new JLabel("Nombre");
		panel.add(NOMBRE);
		
		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel CANTIDAD_HELADOS_COMPRA = new JLabel("Cantidad de helados comprados");
		panel.add(CANTIDAD_HELADOS_COMPRA);
		
		txtCantidad = new JTextField();
		panel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarDatos();
			}
		});
		panel.add(btnRegistrar);
		
		JButton btnBuscar = new JButton("Buscar cliente");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarDatos();
			}
		});
		panel.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar cliente");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarDatos();
			}
		});
		panel.add(btnEliminar);	
        }
}
