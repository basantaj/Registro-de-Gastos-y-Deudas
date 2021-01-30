import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class IngresoDeuda {
	//- Establece la conexion -//
			private Connection c = new Conexion().conectar();
			public void agregarDeuda(String segundo, String deuda, String deudor, String fechadeuda, String fecharesolucion, boolean resuelto) throws SQLException{
				//-Crea la sentencia a pasar a MySQL-//
				Statement s = c.createStatement();
				
				//-Si la deuda se ingresa ya resuelta, agrega las comillas al string ingresado(ya que null no las lleva)-//
				if(resuelto){fecharesolucion="'"+fecharesolucion+"'";}
				
				String insercion = "INSERT INTO deudas VALUES ('"+segundo+"','"+deuda+"','"+deudor+"','"+fechadeuda+"',"+fecharesolucion+")";
				
				//-Ejecuta la sentencia y cierra las conexiones-//
				s.executeUpdate(insercion);
				s.close();
				c.close();
				
				System.out.println("Base actualizada!");
				JOptionPane.showMessageDialog(null,"Base actualizada!");
	}
	
}
