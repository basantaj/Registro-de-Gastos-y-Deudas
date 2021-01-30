import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarDeudas {
	
	public void mostrar(String mes, String año, String segundo, String deudor) throws ClassNotFoundException{
		Connection con = new Conexion().conectar();
		try
		{


			JFrame frame =new JFrame("Mostrar Deudas");
			frame.setLocation(400, 200);

			// crea el modelo de Tabla
			DefaultTableModel modelo= new DefaultTableModel();

			// se crea la Tabla con el modelo DefaultTableModel
			final JTable table = new JTable(modelo);
			//crea un array que contiene los nombre de las columnas
			final String[] columnNames = {"Segundo","Deuda","Deudor","FechaDeuda","FechaResolucion"};
			// insertamos las columnas
			for(int column = 0; column < columnNames.length; column++){
				//agrega las columnas a la tabla
				modelo.addColumn(columnNames[column]);
			}


			//Variable que permite ejecutar una sentencia a la bd
			Statement sentencia = con.createStatement();
			//sentencia que selecciona todos los registros de la BD
			ResultSet rs=null;
			
			String sent="SELECT * FROM deudas WHERE segundo=segundo";
			
			//-Agregamos filtros-//
			if(!mes.equals("No")){
				sent=sent+" AND MONTH(FechaDeuda)="+mes; 
			}
			
			if(!año.equals("No")){
				sent=sent+" AND YEAR(FechaDeuda)="+año;
			}
			if(!segundo.equals("No")){
				sent=sent+" AND Segundo='"+segundo+"'";
			}
			if(!deudor.equals("No")){
				sent=sent+" AND Deudor='"+deudor+"'";
			}
			
			sent=sent+" ORDER BY FechaDeuda"; 
			
			//-Ejecutamos-//
			rs = sentencia.executeQuery(sent);
			
			
			
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				// Se crea un array que será una de las filas de la tabla. 
				Object [] fila = new Object[columnNames.length]; 
				// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				for (int i=0;i<columnNames.length;i++){
					fila[i] = rs.getObject(i+1);// Hay tres columnas en la tabla
				}
				// Se añade al modelo la fila completa.
				modelo.addRow(fila); 
				//System.out.println(modelo);
			}

			//se define el tamaño de la tabla
			table.setPreferredScrollableViewportSize(new Dimension(600, 100));
			//Creamos un JscrollPane y le agregamos la JTable
			JScrollPane scrollPane = new JScrollPane(table);
			//crea el panel
			JPanel panel = new JPanel();
			//definimos un layout
			//Agregamos el JScrollPane al contenedor
			panel.add(scrollPane, BorderLayout.CENTER);		

			frame.add(panel);
			frame.pack();

			frame.setVisible(true);
		}
		catch (SQLException e) { e.printStackTrace();  }


	}

	

}
