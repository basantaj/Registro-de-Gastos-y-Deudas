import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BuscarDeuda {
	public String segundo, deuda, deudor, fechaDeuda, fechaResolucion;

	//- Establece la conexion -//
	Connection con = new Conexion().conectar();

	//-Devuelve valor boolean a modo de chequear si existe la entrada o no-//
	public boolean buscar(String deu, String fecha) {

		try { 

			//-Crea la sentencia a pasar a MySQL-//
			Statement sentencia = con.createStatement();
			String consulta = "SELECT * FROM deudas WHERE Deuda ='"+deu+"' AND FechaDeuda='"+fecha+"'";        

			//-Ejecuta la consulta y guarda el set de resultados devuelto-//
			ResultSet  rs = sentencia.executeQuery(consulta);


			//-Recorre el set de resultados y guarda los datos en la instancia-//
			while ( rs.next() ) {

				segundo = rs.getString("Segundo");
				deuda = rs.getString("Deuda");
				deudor = rs.getString("Deudor");
				fechaDeuda = rs.getString("FechaDeuda");
				fechaResolucion= rs.getString("FechaResolucion");
				
				

			}

			//-Si no encuentra clave primaria muestra un error, cierra las conexiones y devuelve un valor falso-//
			if(deuda==null || fechaDeuda==null){
				JOptionPane.showMessageDialog(null, "Entrada no encontrada", "ERROR", JOptionPane.WARNING_MESSAGE);
				sentencia.close();
				con.close();
				return false;
			}

			//-Cierra las conexiones y devuelve valor verdadero-//
			sentencia.close();
			con.close();
			return true;
		}


		catch (SQLException e) { e.printStackTrace();  }
		return false;
	}
}
