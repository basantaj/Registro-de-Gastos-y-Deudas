import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {

	private static Connection conexion;


	public Connection conectar(){
		try { 
			//-Registro de driver-// 
			Class.forName("com.mysql.jdbc.Driver");

			//-Conexi�n con la base de datos-//
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/plata","USUARIO","CONTRASE�A");
			


		}

		catch( ClassNotFoundException e )   { e.printStackTrace(); 
		JOptionPane.showMessageDialog(null, "NO SE PUDO CONECTAR A LA BASE", "ERROR", JOptionPane.ERROR_MESSAGE);}

		catch (SQLException e) { e.printStackTrace();
		JOptionPane.showMessageDialog(null, "NO SE PUDO CONECTAR A LA BASE", "ERROR", JOptionPane.ERROR_MESSAGE);}

		return conexion;


	}	



}
