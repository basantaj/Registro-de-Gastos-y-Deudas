import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BajaGasto {
	public void eliminar(String nom) throws SQLException
	{
		//- Establece la conexion -//
		Connection con= new Conexion().conectar();

		//-Crea la sentencia a pasar a MySQL-//
		Statement s = con.createStatement();
		String insercion = "DELETE FROM gastos WHERE Compra='"+nom+"'";

		//-Ejecuta la sentencia y cierra las conexiones-//
		s.executeUpdate(insercion);
		JOptionPane.showMessageDialog(null, "Entrada borrada!", "EXITO", JOptionPane.INFORMATION_MESSAGE);
		s.close();
		con.close();

	}	
	
}
