import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BajaDeudas {
	public void eliminar(String segundo, String deuda, String fecha) throws SQLException
	{
		//- Establece la conexion -//
		Connection con= new Conexion().conectar();

		//-Crea la sentencia a pasar a MySQL-//
		Statement s = con.createStatement();
		String insercion = "DELETE FROM deudas WHERE Deuda='"+deuda+"' AND Segundo='"+segundo+"' AND FechaDeuda='"+fecha+"'";

		//-Ejecuta la sentencia y cierra las conexiones-//
		s.executeUpdate(insercion);
		JOptionPane.showMessageDialog(null, "Entrada borrada!", "EXITO", JOptionPane.INFORMATION_MESSAGE);
		s.close();
		con.close();

	}	
}
