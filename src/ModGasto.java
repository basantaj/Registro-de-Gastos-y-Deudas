import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModGasto {
	public void modificar(String compra, String fecha, String costo, String vendedor, String tarjeta, String importado) throws SQLException
	{
		//- Establece la conexion -//
		Connection con= new Conexion().conectar();

		//-Crea la sentencia a pasar a MySQL-//
		Statement s = con.createStatement();
		String insercion = "UPDATE gastos SET Fecha='"+fecha+"', Costo="+costo+", Vendedor='"+vendedor+"', Tarjeta='"+tarjeta+"', Importado='"+importado+"' WHERE Compra='"+compra+"'";

		//-Ejecuta la sentencia y cierra las conexiones-//
		s.executeUpdate(insercion);
		JOptionPane.showMessageDialog(null, "Modificacion realizada!", "EXITO", JOptionPane.INFORMATION_MESSAGE);
		s.close();
		con.close();

	}
}
