import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModDeuda {
	public void modificar(String segundo, String deuda, String deudor, String fechadeu, String fechares, boolean resuelto) throws SQLException
	{
		//- Establece la conexion -//
		Connection con= new Conexion().conectar();

		//-Crea la sentencia a pasar a MySQL-//
		Statement s = con.createStatement();
		
		//-Si la deuda se ingresa ya resuelta, agrega las comillas al string ingresado(ya que null no las lleva)-//
		if(resuelto){
			fechares="'"+fechares+"'";
		}
		
		String insercion = "UPDATE deudas SET Deudor='"+deudor+"',FechaResolucion="+fechares+" WHERE Deuda='"+deuda+"' AND Segundo='"+segundo+"' AND FechaDeuda='"+fechadeu+"'";

		//-Ejecuta la sentencia y cierra las conexiones-//
		s.executeUpdate(insercion);
		JOptionPane.showMessageDialog(null, "Entrada modificada!", "EXITO", JOptionPane.INFORMATION_MESSAGE);
		s.close();
		con.close();

	}	
}
