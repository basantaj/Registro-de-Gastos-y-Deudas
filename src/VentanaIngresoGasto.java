import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class VentanaIngresoGasto extends JFrame {
	public VentanaIngresoGasto() {
	}

	private JPanel contentPane;
	private JTextField compraTxt;
	private JTextField fechaTxt;
	private JTextField costoTxt;
	private JTextField vendedorTxt;

	
	public void mostrar() {
		setTitle("Ingreso de Gastos");
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
		
		costoTxt = new JTextField();
		costoTxt.setBounds(234, 101, 86, 20);
		contentPane.add(costoTxt);
		costoTxt.setColumns(10);
		
		vendedorTxt = new JTextField();
		vendedorTxt.setBounds(330, 101, 104, 20);
		contentPane.add(vendedorTxt);
		vendedorTxt.setColumns(10);
		
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
		
		JButton confirmarBtn = new JButton("Confirmar");
		confirmarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoGasto in = new IngresoGasto();
				if(confirmarEntrada(compraTxt.getText(), fechaTxt.getText(), costoTxt.getText(), vendedorTxt.getText())){
					try {
						in.agregarGasto(compraTxt.getText(), fechaTxt.getText(), costoTxt.getText(), vendedorTxt.getText(), tarjetaCombo.getSelectedItem().toString(), importadoCombo.getSelectedItem().toString());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "ERROR, PUEDE QUE LA ENTRADA YA EXISTA", "ERROR", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
					
				}
			}
		});
		confirmarBtn.setBounds(100, 221, 105, 23);
		contentPane.add(confirmarBtn);
		
		JButton cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelarBtn.setBounds(213, 221, 107, 23);
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
		
		JLabel lblIngresoDeGasto = new JLabel("INGRESO DE GASTO (ACLARAR MONEDA)");
		lblIngresoDeGasto.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblIngresoDeGasto.setBounds(20, 11, 430, 44);
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

	//-Función que controla si hay espacios en blanco en un string-//
	private boolean espacioBlanco(String str){
		for(int i=0; i<str.length();i++){

			if(Character.isWhitespace(str.charAt(i))){
				JOptionPane.showMessageDialog(null, "Hay un espacio en blanco en un campo donde no es aceptado", "ERROR DE ENTRADA", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}return true;

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
