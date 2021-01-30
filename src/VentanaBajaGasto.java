import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaBajaGasto extends JFrame {

	private JPanel contentPane;
	private JTextField compraTxt;
	private JTextField fechaTxt;
	private JTextField costoTxt;
	private JTextField vendedorTxt;

	public void mostrar() {
		setTitle("Baja de Gastos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 466, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		compraTxt = new JTextField();
		compraTxt.setBounds(10, 101, 118, 20);
		contentPane.add(compraTxt);
		compraTxt.setColumns(10);
		
		
		fechaTxt = new JTextField();
		fechaTxt.setBounds(138, 101, 86, 20);
		contentPane.add(fechaTxt);
		fechaTxt.setColumns(10);
		fechaTxt.setEditable(false);
		
		costoTxt = new JTextField();
		costoTxt.setBounds(234, 101, 86, 20);
		contentPane.add(costoTxt);
		costoTxt.setColumns(10);
		costoTxt.setEditable(false);
		
		vendedorTxt = new JTextField();
		vendedorTxt.setBounds(330, 101, 104, 20);
		contentPane.add(vendedorTxt);
		vendedorTxt.setColumns(10);
		vendedorTxt.setEditable(false);
		
		final JComboBox tarjetaCombo = new JComboBox();
		tarjetaCombo.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		tarjetaCombo.setBounds(108, 157, 57, 20);
		contentPane.add(tarjetaCombo);
		
		
		final JComboBox importadoCombo = new JComboBox();
		importadoCombo.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		importadoCombo.setBounds(213, 157, 57, 20);
		contentPane.add(importadoCombo);
		
		
		JLabel lblCompra = new JLabel("Compra:");
		lblCompra.setLabelFor(compraTxt);
		lblCompra.setBounds(10, 76, 91, 14);
		contentPane.add(lblCompra);
		
		JLabel lblCosto = new JLabel("Fecha:");
		lblCosto.setLabelFor(costoTxt);
		lblCosto.setBounds(138, 76, 67, 14);
		contentPane.add(lblCosto);
		
		JLabel lblCosto_1 = new JLabel("Costo:");
		lblCosto_1.setLabelFor(costoTxt);
		lblCosto_1.setBounds(234, 76, 46, 14);
		contentPane.add(lblCosto_1);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setLabelFor(vendedorTxt);
		lblVendedor.setBounds(330, 76, 91, 14);
		contentPane.add(lblVendedor);
		
		JLabel lblTarjeta = new JLabel("Tarjeta:");
		lblTarjeta.setLabelFor(tarjetaCombo);
		lblTarjeta.setBounds(108, 132, 57, 14);
		contentPane.add(lblTarjeta);
		
		JLabel lblImportado = new JLabel("Importado:");
		lblImportado.setBounds(213, 132, 67, 14);
		contentPane.add(lblImportado);
		
		final JButton borraBtn = new JButton("Borrar");
		borraBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaGasto ba = new BajaGasto();
				BuscarGasto bu = new BuscarGasto();
				try {
					if (bu.buscar(compraTxt.getText())){
					ba.eliminar(compraTxt.getText());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		borraBtn.setBounds(60, 221, 105, 23);
		contentPane.add(borraBtn);
		borraBtn.setEnabled(false);
		
		JButton buscarBtn = new JButton("Buscar");
		buscarBtn.setBounds(169, 221, 107, 23);
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!compraTxt.getText().equals("")){
					BuscarGasto bu = new BuscarGasto();
					bu.buscar(compraTxt.getText());
					fechaTxt.setText(bu.fecha);
					costoTxt.setText(bu.costo);
					vendedorTxt.setText(bu.vendedor);
					tarjetaCombo.setSelectedItem(bu.tarjeta);
					importadoCombo.setSelectedItem(bu.importado);
					
					borraBtn.setEnabled(true);
				}
				
			}
		});
		contentPane.add(buscarBtn);
		
		JButton cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelarBtn.setBounds(280, 221, 107, 23);
		contentPane.add(cancelarBtn);
		
		JButton btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListadoGastos liG = new VentanaListadoGastos();
				liG.mostrar();
			}
		});
		btnL.setBounds(379, 171, 47, 38);
		contentPane.add(btnL);
		
		JLabel lblIngresoDeGasto = new JLabel("ELIMINADO DE GASTO");
		lblIngresoDeGasto.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIngresoDeGasto.setBounds(108, 11, 302, 44);
		contentPane.add(lblIngresoDeGasto);
		
		setVisible(true);
	}
	
	public boolean confirmarEntrada(String compra, String fecha, String costo, String vendedor){
		if(!compra.equals("")&&!fecha.equals("") && !costo.equals("") && !vendedor.equals("")){
			if(esFecha(fecha)&&esNumero(costo)){
				return true;
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "RELLENAR TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return false;
	}
	
	private boolean esNumero(String str)  
	{  

		try  
		{ 
			//-Si el dato no puede ser aplicado como numero, lanza una excepcion y devuelve falso-//
			int i = Integer.parseInt(str);  
			return true;  
		}  
		catch(NumberFormatException e)  
		{  
			JOptionPane.showMessageDialog(null, "Revise que haya valores numericos en los campos apropiados!", "ERROR DE ENTRADA", JOptionPane.ERROR_MESSAGE);
			return false;  
		}  

	}

	
	
	private boolean esFecha(String fc){
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		df.setLenient(false);
		try {

			Date d = df.parse(fc);
			System.out.println("Fecha correcta!");
			System.out.println(fc);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Revise las fechas!", "ERROR DE FORMATO", JOptionPane.ERROR_MESSAGE);
			return false;

		}
		return true;
	}

}