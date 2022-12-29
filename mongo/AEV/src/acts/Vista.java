package acts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Vista extends JFrame {

	private JPanel QDAS;
	JTextField txtTitulo;
	JTextField txtAutor;
	JTextField txtNacimiento;
	JTextField txtPublicacion;
	JTextField txtEditorial;
	JTextField txtPaginas;
	JButton btnAnyadir;
	 JTextField txtUsuario;
	JTextField txtNomColeccio;
	 JButton btnLogin;
	JScrollPane scrollPane;
	JLabel lblRandom1;
	JLabel	lblTitulo;
	JLabel lblAutor;
	JLabel lblNacimiento;
	JLabel lblPublicacion;
	JLabel lblEditorial;
	JLabel lblPaginas;
	 JLabel lblUsuario;
	 JLabel lblContrasenya;
	 JLabel lblConjuntoLogin;
	JButton btnMostrarContingut;
	JTextArea txtContenido;
	JButton btnEsborrarConexio;
	JTextField txtValorAaplicar;
	JButton btnHacerConsulta;
	JComboBox cbTipoCampo;
	JComboBox cbTipoFiltro;
	JTable tblLibros;
	protected Object lblCantidad;
	JLabel lblNumero;
	JLabel lblImagen;
	 JLabel lblTexto;
	 JTextField txtActualitzarTitulo;
	 JTextField txtActualitzarAutor;
	 JTextField txtActualitzarNacimiento;
	 JTextField txtActualitzarPublicacion;
	 JTextField txtActualitzarEditorial;
	 JTextField txtActualitzarPaginas;
	 JTextField txtNombreBusquedaActualitzar;
	 JLabel lblTituloRandom2;
	 JLabel lblTituloRandom3;
	 JLabel lblNombreLibro2;
	 JTextField txtNombreParaBorrar;
	 JButton btnBorrar;
	 JButton btnActualitzar;
	 JLabel lblNombreLibroBusqueda;
	 JLabel lblActualizarPaginas;
	 JLabel lblActualizarTitulo;
	 JLabel lblActualizarAutor;
	 JLabel lblActualizarEditorial;
	 JLabel lblActualizarPublicacion;
	 JLabel lblActualizarNacimiento;
	 JPasswordField txtContrasenya;
	 JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1205, 663);
		QDAS = new JPanel();
		QDAS.setBackground(new Color(0, 128, 192));
		QDAS.setForeground(new Color(0, 128, 192));
		QDAS.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(QDAS);
		QDAS.setLayout(null);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(864, 173, 86, 20);
		QDAS.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(864, 204, 86, 20);
		txtAutor.setColumns(10);
		QDAS.add(txtAutor);
		
		txtNacimiento = new JTextField();
		txtNacimiento.setBounds(864, 235, 86, 20);
		txtNacimiento.setColumns(10);
		QDAS.add(txtNacimiento);
		
		txtPublicacion = new JTextField();
		txtPublicacion.setBounds(864, 266, 86, 20);
		txtPublicacion.setColumns(10);
		QDAS.add(txtPublicacion);
		
		txtEditorial = new JTextField();
		txtEditorial.setBounds(864, 297, 86, 20);
		txtEditorial.setColumns(10);
		QDAS.add(txtEditorial);
		
		txtPaginas = new JTextField();
		txtPaginas.setBounds(864, 328, 86, 20);
		txtPaginas.setColumns(10);
		QDAS.add(txtPaginas);
		
		 btnAnyadir = new JButton("Anyadir");
		 btnAnyadir.setBounds(861, 359, 89, 23);
		QDAS.add(btnAnyadir);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 174, 278, 343);
		QDAS.add(scrollPane);
		
		tblLibros = new JTable();
		scrollPane.setViewportView(tblLibros);
		
		 lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(807, 176, 46, 14);
		QDAS.add(lblTitulo);
		
		 lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(807, 207, 46, 14);
		QDAS.add(lblAutor);
		
		 lblNacimiento = new JLabel("Fecha Nac:");
		lblNacimiento.setBounds(778, 238, 86, 14);
		QDAS.add(lblNacimiento);
		
		 lblPublicacion = new JLabel("Fecha Pub:");
		lblPublicacion.setBounds(778, 269, 86, 14);
		QDAS.add(lblPublicacion);
		
		 lblEditorial = new JLabel("Editorial:");
		lblEditorial.setBounds(797, 300, 57, 14);
		QDAS.add(lblEditorial);
		
		 lblPaginas = new JLabel("Paginas:");
		lblPaginas.setBounds(797, 331, 57, 14);
		QDAS.add(lblPaginas);
		
		 lblRandom1 = new JLabel("INSERCIO DE LLIBRE");
		lblRandom1.setBounds(807, 112, 182, 37);
		lblRandom1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRandom1.setBackground(new Color(128, 128, 192));
		QDAS.add(lblRandom1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(87, 66, 86, 20);
		txtUsuario.setColumns(10);
		QDAS.add(txtUsuario);
		
		 lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(31, 69, 46, 14);
		QDAS.add(lblUsuario);
		
		 lblContrasenya = new JLabel("Contrasenya:");
		lblContrasenya.setBounds(10, 112, 71, 14);
		QDAS.add(lblContrasenya);
		
		 lblConjuntoLogin = new JLabel("LOGIN");
		lblConjuntoLogin.setBounds(66, 18, 86, 37);
		lblConjuntoLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConjuntoLogin.setBackground(new Color(128, 128, 192));
		QDAS.add(lblConjuntoLogin);
		
		 btnMostrarContingut = new JButton("MOSTRAR");
		btnMostrarContingut.setBounds(665, 483, 103, 37);
		QDAS.add(btnMostrarContingut);
		 
		 scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(308, 174, 460, 280);
		 QDAS.add(scrollPane_1);
		
		 txtContenido = new JTextArea();
		 scrollPane_1.setViewportView(txtContenido);
		 txtContenido.setFont(new Font("Monospaced", Font.PLAIN, 17));
		 txtContenido.setVisible(false);
		
		 btnEsborrarConexio = new JButton("BORRAR COLEXIO");
		btnEsborrarConexio.setForeground(new Color(255, 0, 0));
		btnEsborrarConexio.setBackground(new Color(255, 128, 128));
		btnEsborrarConexio.setBounds(112, 559, 140, 37);
		QDAS.add(btnEsborrarConexio);
		
		txtNomColeccio = new JTextField();
		txtNomColeccio.setColumns(10);
		txtNomColeccio.setBounds(10, 567, 86, 20);
		QDAS.add(txtNomColeccio);
		
		 btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(183, 79, 103, 37);
		QDAS.add(btnLogin);
		
		 cbTipoFiltro = new JComboBox();
		cbTipoFiltro.setModel(new DefaultComboBoxModel(new String[] {"", "eq", "gte", "lte"}));
		cbTipoFiltro.setBounds(20, 141, 86, 22);
		QDAS.add(cbTipoFiltro);
		
		 cbTipoCampo = new JComboBox();
		cbTipoCampo.setModel(new DefaultComboBoxModel(new String[] {"", "Id", "Titulo", "Autor", "Anyo_nacimiento", "Anyo_publicacion", "Editorial", "Numero_paginas", "Thumbnail"}));
		cbTipoCampo.setBounds(116, 141, 86, 22);
		QDAS.add(cbTipoCampo);
		
		txtValorAaplicar = new JTextField();
		txtValorAaplicar.setColumns(10);
		txtValorAaplicar.setBounds(212, 142, 86, 20);
		QDAS.add(txtValorAaplicar);
		
		 btnHacerConsulta = new JButton("EXECUTAR");
		 btnHacerConsulta.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		btnHacerConsulta.setBounds(308, 140, 89, 23);
		QDAS.add(btnHacerConsulta);
		
		lblNumero = new JLabel("");
		lblNumero.setBounds(128, 528, 86, 20);
		QDAS.add(lblNumero);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(318, 462, 163, 151);
		QDAS.add(lblImagen);
		
		lblTexto = new JLabel("Nombre de llibres:");
		lblTexto.setBounds(20, 528, 103, 20);
		QDAS.add(lblTexto);
		
		txtActualitzarTitulo = new JTextField();
		txtActualitzarTitulo.setBounds(1078, 204, 86, 20);
		QDAS.add(txtActualitzarTitulo);
		txtActualitzarTitulo.setColumns(10);
		
		txtActualitzarAutor = new JTextField();
		txtActualitzarAutor.setColumns(10);
		txtActualitzarAutor.setBounds(1078, 235, 86, 20);
		QDAS.add(txtActualitzarAutor);
		
		txtActualitzarNacimiento = new JTextField();
		txtActualitzarNacimiento.setColumns(10);
		txtActualitzarNacimiento.setBounds(1078, 266, 86, 20);
		QDAS.add(txtActualitzarNacimiento);
		
		txtActualitzarPublicacion = new JTextField();
		txtActualitzarPublicacion.setColumns(10);
		txtActualitzarPublicacion.setBounds(1078, 297, 86, 20);
		QDAS.add(txtActualitzarPublicacion);
		
		txtActualitzarEditorial = new JTextField();
		txtActualitzarEditorial.setColumns(10);
		txtActualitzarEditorial.setBounds(1078, 328, 86, 20);
		QDAS.add(txtActualitzarEditorial);
		
		txtActualitzarPaginas = new JTextField();
		txtActualitzarPaginas.setColumns(10);
		txtActualitzarPaginas.setBounds(1078, 359, 86, 20);
		QDAS.add(txtActualitzarPaginas);
		
		 lblActualizarTitulo = new JLabel("Titulo:");
		lblActualizarTitulo.setBounds(1022, 207, 46, 14);
		QDAS.add(lblActualizarTitulo);
		
		 lblActualizarAutor = new JLabel("Autor:");
		lblActualizarAutor.setBounds(1022, 238, 46, 14);
		QDAS.add(lblActualizarAutor);
		
		 lblActualizarNacimiento = new JLabel("Nacimiento:");
		lblActualizarNacimiento.setBounds(1002, 269, 66, 14);
		QDAS.add(lblActualizarNacimiento);
		
		 lblActualizarPublicacion = new JLabel("Publicacion:");
		lblActualizarPublicacion.setBounds(1002, 300, 66, 14);
		QDAS.add(lblActualizarPublicacion);
		
		 lblActualizarEditorial = new JLabel("Editorial:");
		lblActualizarEditorial.setBounds(1022, 331, 46, 14);
		QDAS.add(lblActualizarEditorial);
		
		 lblActualizarPaginas = new JLabel("Paginas:");
		lblActualizarPaginas.setBounds(1022, 362, 46, 14);
		QDAS.add(lblActualizarPaginas);
		
		txtNombreBusquedaActualitzar = new JTextField();
		txtNombreBusquedaActualitzar.setColumns(10);
		txtNombreBusquedaActualitzar.setBounds(1066, 173, 113, 20);
		QDAS.add(txtNombreBusquedaActualitzar);
		
		 lblNombreLibroBusqueda = new JLabel("Nombre:");
		lblNombreLibroBusqueda.setBounds(1010, 176, 46, 14);
		QDAS.add(lblNombreLibroBusqueda);
		
		lblTituloRandom2 = new JLabel("ACTUALITZAR");
		lblTituloRandom2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloRandom2.setBounds(1041, 119, 118, 27);
		QDAS.add(lblTituloRandom2);
		
		 btnActualitzar = new JButton("Actualitzar");
		btnActualitzar.setBounds(1078, 391, 89, 23);
		QDAS.add(btnActualitzar);
		
		lblTituloRandom3 = new JLabel("BORRAR");
		lblTituloRandom3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloRandom3.setBounds(946, 426, 83, 27);
		QDAS.add(lblTituloRandom3);
		
		lblNombreLibro2 = new JLabel("Nombre:");
		lblNombreLibro2.setBounds(882, 469, 46, 14);
		QDAS.add(lblNombreLibro2);
		
		txtNombreParaBorrar = new JTextField();
		txtNombreParaBorrar.setColumns(10);
		txtNombreParaBorrar.setBounds(932, 466, 113, 20);
		QDAS.add(txtNombreParaBorrar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(946, 494, 89, 23);
		QDAS.add(btnBorrar);
		
		txtContrasenya = new JPasswordField();
		txtContrasenya.setEchoChar('*');
		txtContrasenya.setBounds(87, 109, 86, 20);
		QDAS.add(txtContrasenya);
		setVisible(true);
		
		cbTipoFiltro.setVisible(false);
		cbTipoCampo.setVisible(false);
		txtValorAaplicar.setVisible(false);
		btnHacerConsulta.setVisible(false);
		lblRandom1.setVisible(false);
		lblTitulo.setVisible(false);
		txtTitulo.setVisible(false);
		lblAutor.setVisible(false);
		txtAutor.setVisible(false);
		lblNacimiento.setVisible(false);
		txtNacimiento.setVisible(false);
		lblPublicacion.setVisible(false);
		txtPublicacion.setVisible(false);
		lblEditorial.setVisible(false);
		txtEditorial.setVisible(false);
		lblPaginas.setVisible(false);
		txtPaginas.setVisible(false);
		btnAnyadir.setVisible(false);
		scrollPane.setVisible(false);
		btnMostrarContingut.setVisible(false);
		txtNomColeccio.setVisible(false);
		btnEsborrarConexio.setVisible(false);
		
	}

	public JPanel getQDAS() {
		return QDAS;
	}

	public void setQDAS(JPanel qDAS) {
		QDAS = qDAS;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public JTextField getTxtNacimiento() {
		return txtNacimiento;
	}

	public void setTxtNacimiento(JTextField txtNacimiento) {
		this.txtNacimiento = txtNacimiento;
	}

	public JTextField getTxtPublicacion() {
		return txtPublicacion;
	}

	public void setTxtPublicacion(JTextField txtPublicacion) {
		this.txtPublicacion = txtPublicacion;
	}

	public JTextField getTxtEditorial() {
		return txtEditorial;
	}

	public void setTxtEditorial(JTextField txtEditorial) {
		this.txtEditorial = txtEditorial;
	}

	public JTextField getTxtPaginas() {
		return txtPaginas;
	}

	public void setTxtPaginas(JTextField txtPaginas) {
		this.txtPaginas = txtPaginas;
	}

	public JButton getBtnAnyadir() {
		return btnAnyadir;
	}

	public void setBtnAnyadir(JButton btnAnyadir) {
		this.btnAnyadir = btnAnyadir;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}



	public JTextField getTxtNomColeccio() {
		return txtNomColeccio;
	}

	public void setTxtNomColeccio(JTextField txtNomColeccio) {
		this.txtNomColeccio = txtNomColeccio;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JLabel getLblRandom1() {
		return lblRandom1;
	}

	public void setLblRandom1(JLabel lblRandom1) {
		this.lblRandom1 = lblRandom1;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblAutor() {
		return lblAutor;
	}

	public void setLblAutor(JLabel lblAutor) {
		this.lblAutor = lblAutor;
	}

	public JLabel getLblNacimiento() {
		return lblNacimiento;
	}

	public void setLblNacimiento(JLabel lblNacimiento) {
		this.lblNacimiento = lblNacimiento;
	}

	public JLabel getLblPublicacion() {
		return lblPublicacion;
	}

	public void setLblPublicacion(JLabel lblPublicacion) {
		this.lblPublicacion = lblPublicacion;
	}

	public JLabel getLblEditorial() {
		return lblEditorial;
	}

	public void setLblEditorial(JLabel lblEditorial) {
		this.lblEditorial = lblEditorial;
	}

	public JLabel getLblPaginas() {
		return lblPaginas;
	}

	public void setLblPaginas(JLabel lblPaginas) {
		this.lblPaginas = lblPaginas;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public JLabel getLblContrasenya() {
		return lblContrasenya;
	}

	public void setLblContrasenya(JLabel lblContrasenya) {
		this.lblContrasenya = lblContrasenya;
	}

	public JLabel getLblConjuntoLogin() {
		return lblConjuntoLogin;
	}

	public void setLblConjuntoLogin(JLabel lblConjuntoLogin) {
		this.lblConjuntoLogin = lblConjuntoLogin;
	}

	public JButton getBtnMostrarContingut() {
		return btnMostrarContingut;
	}

	public void setBtnMostrarContingut(JButton btnMostrarContingut) {
		this.btnMostrarContingut = btnMostrarContingut;
	}

	public JTextArea getTxtContenido() {
		return txtContenido;
	}

	public void setTxtContenido(JTextArea txtContenido) {
		this.txtContenido = txtContenido;
	}

	public JButton getBtnEsborrarConexio() {
		return btnEsborrarConexio;
	}

	public void setBtnEsborrarConexio(JButton btnEsborrarConexio) {
		this.btnEsborrarConexio = btnEsborrarConexio;
	}

	public JTextField getTxtValorAaplicar() {
		return txtValorAaplicar;
	}

	public void setTxtValorAaplicar(JTextField txtValorAaplicar) {
		this.txtValorAaplicar = txtValorAaplicar;
	}

	public JButton getBtnHacerConsulta() {
		return btnHacerConsulta;
	}

	public void setBtnHacerConsulta(JButton btnHacerConsulta) {
		this.btnHacerConsulta = btnHacerConsulta;
	}

	public JComboBox getCbTipoCampo() {
		return cbTipoCampo;
	}

	public void setCbTipoCampo(JComboBox cbTipoCampo) {
		this.cbTipoCampo = cbTipoCampo;
	}

	public JComboBox getCbTipoFiltro() {
		return cbTipoFiltro;
	}

	public void setCbTipoFiltro(JComboBox cbTipoFiltro) {
		this.cbTipoFiltro = cbTipoFiltro;
	}

	public JTable getTblLibros() {
		return tblLibros;
	}

	public void setTblLibros(JTable tblLibros) {
		this.tblLibros = tblLibros;
	}

	public Object getLblCantidad() {
		return lblCantidad;
	}

	public void setLblCantidad(Object lblCantidad) {
		this.lblCantidad = lblCantidad;
	}

	public JLabel getLblNumero() {
		return lblNumero;
	}

	public void setLblNumero(JLabel lblNumero) {
		this.lblNumero = lblNumero;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public JLabel getLblTexto() {
		return lblTexto;
	}

	public void setLblTexto(JLabel lblTexto) {
		this.lblTexto = lblTexto;
	}

	public JTextField getTxtActualitzarTitulo() {
		return txtActualitzarTitulo;
	}

	public void setTxtActualitzarTitulo(JTextField txtActualitzarTitulo) {
		this.txtActualitzarTitulo = txtActualitzarTitulo;
	}

	public JTextField getTxtActualitzarAutor() {
		return txtActualitzarAutor;
	}

	public void setTxtActualitzarAutor(JTextField txtActualitzarAutor) {
		this.txtActualitzarAutor = txtActualitzarAutor;
	}

	public JTextField getTxtActualitzarNacimiento() {
		return txtActualitzarNacimiento;
	}

	public void setTxtActualitzarNacimiento(JTextField txtActualitzarNacimiento) {
		this.txtActualitzarNacimiento = txtActualitzarNacimiento;
	}

	public JTextField getTxtActualitzarPublicacion() {
		return txtActualitzarPublicacion;
	}

	public void setTxtActualitzarPublicacion(JTextField txtActualitzarPublicacion) {
		this.txtActualitzarPublicacion = txtActualitzarPublicacion;
	}

	public JTextField getTxtActualitzarEditorial() {
		return txtActualitzarEditorial;
	}

	public void setTxtActualitzarEditorial(JTextField txtActualitzarEditorial) {
		this.txtActualitzarEditorial = txtActualitzarEditorial;
	}

	public JTextField getTxtActualitzarPaginas() {
		return txtActualitzarPaginas;
	}

	public void setTxtActualitzarPaginas(JTextField txtActualitzarPaginas) {
		this.txtActualitzarPaginas = txtActualitzarPaginas;
	}

	public JTextField getTextField() {
		return txtNombreBusquedaActualitzar;
	}

	public void setTextField(JTextField textField) {
		this.txtNombreBusquedaActualitzar = textField;
	}

	public JLabel getLblTituloRandom2() {
		return lblTituloRandom2;
	}

	public void setLblTituloRandom2(JLabel lblTituloRandom2) {
		this.lblTituloRandom2 = lblTituloRandom2;
	}

	public JLabel getLblTituloRandom3() {
		return lblTituloRandom3;
	}

	public void setLblTituloRandom3(JLabel lblTituloRandom3) {
		this.lblTituloRandom3 = lblTituloRandom3;
	}

	public JLabel getLblNombreLibro2() {
		return lblNombreLibro2;
	}

	public void setLblNombreLibro2(JLabel lblNombreLibro2) {
		this.lblNombreLibro2 = lblNombreLibro2;
	}

	public JTextField getTxtNombreParaBorrar() {
		return txtNombreParaBorrar;
	}

	public void setTxtNombreParaBorrar(JTextField txtNombreParaBorrar) {
		this.txtNombreParaBorrar = txtNombreParaBorrar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JTextField getTxtNombreBusquedaActualitzar() {
		return txtNombreBusquedaActualitzar;
	}

	public void setTxtNombreBusquedaActualitzar(JTextField txtNombreBusquedaActualitzar) {
		this.txtNombreBusquedaActualitzar = txtNombreBusquedaActualitzar;
	}

	public JButton getBtnActualitzar() {
		return btnActualitzar;
	}

	public void setBtnActualitzar(JButton btnActualitzar) {
		this.btnActualitzar = btnActualitzar;
	}

	public JLabel getLblNombreLibroBusqueda() {
		return lblNombreLibroBusqueda;
	}

	public void setLblNombreLibroBusqueda(JLabel lblNombreLibroBusqueda) {
		this.lblNombreLibroBusqueda = lblNombreLibroBusqueda;
	}

	public JLabel getLblActualizarPaginas() {
		return lblActualizarPaginas;
	}

	public void setLblActualizarPaginas(JLabel lblActualizarPaginas) {
		this.lblActualizarPaginas = lblActualizarPaginas;
	}

	public JLabel getLblActualizarTitulo() {
		return lblActualizarTitulo;
	}

	public void setLblActualizarTitulo(JLabel lblActualizarTitulo) {
		this.lblActualizarTitulo = lblActualizarTitulo;
	}

	public JLabel getLblActualizarAutor() {
		return lblActualizarAutor;
	}

	public void setLblActualizarAutor(JLabel lblActualizarAutor) {
		this.lblActualizarAutor = lblActualizarAutor;
	}

	public JLabel getLblActualizarEditorial() {
		return lblActualizarEditorial;
	}

	public void setLblActualizarEditorial(JLabel lblActualizarEditorial) {
		this.lblActualizarEditorial = lblActualizarEditorial;
	}

	public JLabel getLblActualizarPublicacion() {
		return lblActualizarPublicacion;
	}

	public void setLblActualizarPublicacion(JLabel lblActualizarPublicacion) {
		this.lblActualizarPublicacion = lblActualizarPublicacion;
	}

	public JLabel getLblActualizarNacimiento() {
		return lblActualizarNacimiento;
	}

	public void setLblActualizarNacimiento(JLabel lblActualizarNacimiento) {
		this.lblActualizarNacimiento = lblActualizarNacimiento;
	}

	public JPasswordField getTxtContrasenya() {
		return txtContrasenya;
	}

	public void setTxtContrasenya(JPasswordField txtContrasenya) {
		this.txtContrasenya = txtContrasenya;
	}
}
