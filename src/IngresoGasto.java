import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class IngresoGasto {
	//- Establece la conexion -//
		private Connection c = new Conexion().conectar();
		public void agregarGasto(String compra, String fecha, String costo, String vendedor, String tarjeta, String importado) throws SQLException{
			//-Crea la sentencia a pasar a MySQL-//
			Statement s = c.createStatement();
			String insercion = "INSERT INTO gastos VALUES ('"+compra+"','"+fecha+"',"+costo+",'"+vendedor+"','"+tarjeta+"','"+importado+"')";
			
			//-Ejecuta la sentencia y cierra las conexiones-//
			s.executeUpdate(insercion);
			s.close();
			c.close();
			
			System.out.println("Base actualizada!");
			JOptionPane.showMessageDialog(null,"Base actualizada!");
}
		
}
