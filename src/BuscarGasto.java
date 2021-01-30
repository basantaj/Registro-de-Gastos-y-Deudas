import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BuscarGasto {
	public String compra, fecha, costo, vendedor, tarjeta, importado;

	//- Establece la conexion -//
	Connection con = new Conexion().conectar();

	//-Devuelve valor boolean a modo de chequear si existe la entrada o no-//
	public boolean buscar(String nom) {

		try { 

			//-Crea la sentencia a pasar a MySQL-//
			Statement sentencia = con.createStatement();
			String consulta = "SELECT * FROM gastos WHERE Compra ='"+nom+"'";        

			//-Ejecuta la consulta y guarda el set de resultados devuelto-//
			ResultSet  rs = sentencia.executeQuery(consulta);


			//-Recorre el set de resultados y guarda los datos en la instancia-//
			while ( rs.next() ) {

				compra = rs.getString("Compra");
				fecha = rs.getString("Fecha");
				costo = rs.getString("Costo");
				vendedor = rs.getString("Vendedor");
				tarjeta= rs.getString("Tarjeta");
				importado= rs.getString("Importado");
				

			}

			//-Si no encuentra clave primaria muestra un error, cierra las conexiones y devuelve un valor falso-//
			if(compra==null){
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
