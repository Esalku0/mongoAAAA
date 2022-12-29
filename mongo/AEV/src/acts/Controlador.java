package acts;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import org.bson.conversions.Bson;

import com.google.protobuf.TextFormat.ParseException;

public class Controlador {
	private Vista vista;
	private Modelo model;
	private int contadorLibros = 15;

	

	public Controlador(Vista vista, Modelo mode) throws ParseException, IOException {
		this.vista = vista;
		this.model = mode;
		initEventHandler();
		vista.cbTipoFiltro.setVisible(false);
		vista.cbTipoCampo.setVisible(false);
		vista.txtValorAaplicar.setVisible(false);
		vista.btnHacerConsulta.setVisible(false);
		vista.lblRandom1.setVisible(false);
		vista.lblTitulo.setVisible(false);
		vista.txtTitulo.setVisible(false);
		vista.lblAutor.setVisible(false);
		vista.txtAutor.setVisible(false);
		vista.lblNacimiento.setVisible(false);
		vista.txtNacimiento.setVisible(false);
		vista.lblPublicacion.setVisible(false);
		vista.txtPublicacion.setVisible(false);
		vista.lblEditorial.setVisible(false);
		vista.txtEditorial.setVisible(false);
		vista.lblPaginas.setVisible(false);
		vista.txtPaginas.setVisible(false);
		vista.btnAnyadir.setVisible(false);
		vista.scrollPane.setVisible(false);
		vista.btnMostrarContingut.setVisible(false);
		vista.txtNomColeccio.setVisible(false);
		vista.btnEsborrarConexio.setVisible(false);
		vista.txtContenido.setVisible(false);
		vista.lblTexto.setVisible(false);
		vista.txtNombreBusquedaActualitzar.setVisible(false);
		vista.lblTituloRandom2.setVisible(false);
		vista.lblNombreLibroBusqueda.setVisible(false);
		vista.txtNombreBusquedaActualitzar.setVisible(false);
		vista.lblActualizarTitulo.setVisible(false);
		vista.txtActualitzarTitulo.setVisible(false);
		vista.lblActualizarAutor.setVisible(false);
		vista.txtActualitzarAutor.setVisible(false);
		vista.lblActualizarNacimiento.setVisible(false);
		vista.txtActualitzarNacimiento.setVisible(false);
		vista.lblActualizarPublicacion.setVisible(false);
		vista.txtActualitzarPublicacion.setVisible(false);
		vista.lblActualizarEditorial.setVisible(false);
		vista.txtActualitzarEditorial.setVisible(false);
		vista.lblActualizarPaginas.setVisible(false);
		vista.txtActualitzarPaginas.setVisible(false);
		vista.btnActualitzar.setVisible(false);
		vista.lblTituloRandom3.setVisible(false);
		vista.lblNombreLibro2.setVisible(false);
		vista.txtNombreParaBorrar.setVisible(false);
		vista.btnBorrar.setVisible(false);
		vista.lblTexto.setVisible(false);
		vista.lblNumero.setVisible(false);
		vista.scrollPane_1.setVisible(false);
	}

	/**
	 * Metode que ens ompli la taula principal amb la informacion dels llibres
	 * @throws IOException
	 * @throws ParseException
	 */
	public void cargarTabla() throws IOException, ParseException {
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Bson query = null;
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		List<Libros> lista = Modelo.mostrarInfo(query);
		for (int i = 0; i < lista.size(); i++) {
			modelo.addRow(new Object[] { String.valueOf(lista.get(i).getId()), lista.get(i).getTitulo() });
		}

		vista.tblLibros.setModel(modelo);
		vista.tblLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TableColumnModel column = vista.tblLibros.getColumnModel();
		TableColumn tc = column.getColumn(1);
		tc.setPreferredWidth(300);// Ajustar las columnas al tamaño que mas se adecua

		vista.tblLibros.setRowSelectionInterval(0, 0);
		vista.lblNumero.setText(String.valueOf(lista.size()));
	}
	
	/**
	 * Metode per a retornar els bytes de la imatge convertida
	 * @param imageString
	 * @return
	 */
	public static byte[] decodeToImage(String imageString) {
        return Base64.getDecoder().decode(imageString);
    }
	
	/**
	 * Este metodo nos permite crear la imagen que seleccionamos y vamos a utilizar
	 * @param campos
	 * @return
	 * @throws IOException
	 */
    public Image crearImage(String[] campos) throws IOException {
        byte[] b = decodeToImage(campos[7]);
        return new ImageIcon(b).getImage().getScaledInstance(158, 158, Image.SCALE_SMOOTH);
    }
    
    /**
     * Aquest metode ens permet carregar la informacio dels llibres
     * @param Id
     * @throws ParseException
     * @throws IOException
     */
    public void cargarInfo(int Id) throws ParseException, IOException {
    	String info = Modelo.mostrarInfoId(Id);
    	String infoContenido = "";
    	String[] campos = info.split("\n");
    	for (int i = 0; i < 6; i++) {
    		infoContenido += campos[i] + "\n";
    	}
    	vista.lblImagen.setIcon(new ImageIcon(crearImage(campos)));
    	vista.txtContenido.setText(infoContenido);
    }

	String rutaImagen = "";

	private void initEventHandler() throws ParseException, IOException {
		
		cargarTabla();
		
		MouseListener imagen = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				TableModel modelo=vista.tblLibros.getModel();
                if (vista.tblLibros.getSelectedRow() != -1) {
                     String codigo = (String) modelo.getValueAt(vista.tblLibros.getSelectedRow(), 1);
                    // Lo imprimimos en pantalla
                     try {
						cargarInfo(vista.tblLibros.getSelectedRow());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } else {
                    System.out.println("Seleccione un renglon primero");
                }
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		

		ActionListener anyadirLlibre = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser();
				j.showOpenDialog(j);

				String imagen = j.getSelectedFile().getPath();

				rutaImagen = imagen;

				try {
					model.iniciarConexion();

					String tituloString = vista.getTxtTitulo().getText();
					String autor = vista.getTxtAutor().getText();
					int nacimiento = Integer.parseInt(vista.getTxtNacimiento().getText());
					int publicacion = Integer.parseInt(vista.getTxtPublicacion().getText());
					String editorial = vista.getTxtEditorial().getText();
					int paginas = Integer.parseInt(vista.getTxtPaginas().getText());
					String imagenCodificada = Modelo.transformarImagen(rutaImagen);

					Modelo.anyadirLlibre(contadorLibros, tituloString, autor, nacimiento, publicacion, editorial,
							paginas, imagenCodificada);

					contadorLibros++;
					Modelo.mostrarInfo(null);
					cargarTabla();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		};
		vista.getBtnAnyadir().addActionListener(anyadirLlibre);

		ActionListener iniciarSesion = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				try {
					model.iniciarConexion();
					

					

					String usuari = vista.getTxtUsuario().getText();

					String con1 = vista.getTxtContrasenya().getText();
					

					if (model.iniciarSesio(usuari, con1)) {

						JOptionPane.showMessageDialog(null, "SESIO CORRECTA");
						vista.cbTipoFiltro.setVisible(true);
						vista.cbTipoCampo.setVisible(true);
						vista.txtValorAaplicar.setVisible(true);
						vista.btnHacerConsulta.setVisible(true);
						vista.lblRandom1.setVisible(true);
						vista.lblTitulo.setVisible(true);
						vista.txtTitulo.setVisible(true);
						vista.lblAutor.setVisible(true);
						vista.txtAutor.setVisible(true);
						vista.lblNacimiento.setVisible(true);
						vista.txtNacimiento.setVisible(true);
						vista.lblPublicacion.setVisible(true);
						vista.txtPublicacion.setVisible(true);
						vista.lblEditorial.setVisible(true);
						vista.txtEditorial.setVisible(true);
						vista.lblPaginas.setVisible(true);
						vista.txtPaginas.setVisible(true);
						vista.btnAnyadir.setVisible(true);
						vista.scrollPane.setVisible(true);
						vista.btnMostrarContingut.setVisible(true);
						vista.txtNomColeccio.setVisible(true);
						vista.btnEsborrarConexio.setVisible(true);
						vista.txtContenido.setVisible(true);
						vista.lblTexto.setVisible(true);
						vista.lblTituloRandom2.setVisible(true);
						vista.lblNombreLibroBusqueda.setVisible(true);
						vista.txtNombreBusquedaActualitzar.setVisible(true);
						vista.lblActualizarTitulo.setVisible(true);
						vista.txtActualitzarTitulo.setVisible(true);
						vista.lblActualizarAutor.setVisible(true);
						vista.txtActualitzarAutor.setVisible(true);
						vista.lblActualizarNacimiento.setVisible(true);
						vista.txtActualitzarNacimiento.setVisible(true);
						vista.lblActualizarPublicacion.setVisible(true);
						vista.txtActualitzarPublicacion.setVisible(true);
						vista.lblActualizarEditorial.setVisible(true);
						vista.txtActualitzarEditorial.setVisible(true);
						vista.lblActualizarPaginas.setVisible(true);
						vista.txtActualitzarPaginas.setVisible(true);
						vista.btnActualitzar.setVisible(true);
						vista.lblTituloRandom3.setVisible(true);
						vista.lblNombreLibro2.setVisible(true);
						vista.txtNombreParaBorrar.setVisible(true);
						vista.btnBorrar.setVisible(true);
						vista.lblTexto.setVisible(true);
						vista.lblNumero.setVisible(true);
						vista.lblConjuntoLogin.setVisible(false);
						vista.lblUsuario.setVisible(false);
						vista.txtUsuario.setVisible(false);
						vista.lblContrasenya.setVisible(false);
						vista.txtContrasenya.setVisible(false);
						vista.btnLogin.setVisible(false);
						vista.scrollPane_1.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(null, "CONEXIO ERRRONEA");
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		vista.getBtnLogin().addActionListener(iniciarSesion);

		ActionListener mostrarTodo = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					model.iniciarConexion();
					String contenido = model.mostrarCamposLlibres();
					vista.getTxtContenido().setText(contenido);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};

		vista.getBtnMostrarContingut().addActionListener(mostrarTodo);

		ActionListener eliminarColeccio = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String nombreColeccionString = vista.getTxtNomColeccio().getText();

				Modelo.borrarColeccio(nombreColeccionString);
			}
		};
		vista.getBtnEsborrarConexio().addActionListener(eliminarColeccio);

		ActionListener realitzarConsulta = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					model.iniciarConexion();

					String tipoFiltro = vista.getCbTipoFiltro().getSelectedItem().toString();
					System.out.println(tipoFiltro);

					String tipoCampo = vista.getCbTipoCampo().getSelectedItem().toString();
					System.out.println(tipoCampo);
					String valorAplicar = vista.getTxtValorAaplicar().getText();
					System.out.println(valorAplicar);

					if (tipoFiltro.equals("")) {
						String txt = model.mostrarAmbFiltres(tipoCampo, tipoFiltro, valorAplicar);
						vista.getTxtContenido().setText(txt);
						System.out.println("ye");
					} else if (tipoFiltro.equals("eq")) {
						String txt = model.mostrarAmbFiltres(tipoCampo, tipoFiltro, valorAplicar);
						vista.getTxtContenido().setText(txt);
						System.out.println("ye");
					} else if (tipoFiltro.equals("gte")) {
						String txt = model.mostrarAmbFiltres(tipoCampo, tipoFiltro, valorAplicar);
						vista.getTxtContenido().setText(txt);
						System.out.println("ye");
					} else {
						String txt = model.mostrarAmbFiltres(tipoCampo, tipoFiltro, valorAplicar);
						vista.getTxtContenido().setText(txt);
						System.out.println("ye");
					}
					cargarTabla();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		};
		
		
		ActionListener actualitzarLlibre = new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				try {
				String TituloBusqueda = vista.getTextField().getText();
				String Titulo = vista.getTxtActualitzarTitulo().getText();
				String Autor = vista.getTxtAutor().getText();
				int Anyo_nacimiento = Integer.parseInt(vista.getTxtActualitzarNacimiento().getText());
				int Anyo_publicacion = Integer.parseInt(vista.getTxtActualitzarPublicacion().getText());
				String Editorial = vista.getTxtEditorial().getText();
				int Numero_paginas =Integer.parseInt(vista.getTxtPaginas().getText());
				
				JFileChooser j = new JFileChooser();
				j.showOpenDialog(j);

				String imagen = j.getSelectedFile().getPath();

				rutaImagen = imagen;
				
				
					String imagenCodificada = Modelo.transformarImagen(rutaImagen);
				    int dialogButton = JOptionPane.YES_NO_OPTION;
				    JOptionPane.showConfirmDialog (null, "Estas seguro?", "...", dialogButton);
				    if (dialogButton == JOptionPane.YES_OPTION) {
					
					model.actualitzarLlibre(contadorLibros, TituloBusqueda, Titulo,Autor, Anyo_nacimiento, Anyo_publicacion, Editorial, Numero_paginas, imagenCodificada);
					
					Modelo.mostrarInfo(null);
					cargarTabla();
				    }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		vista.getBtnActualitzar().addActionListener(actualitzarLlibre);
		
		ActionListener borrarLlibre = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				    int dialogButton = JOptionPane.YES_NO_OPTION;
				    JOptionPane.showConfirmDialog (null, "Estas seguro?", "...",dialogButton);
				    if (dialogButton == JOptionPane.YES_OPTION) {
				    
					String Titulo = vista.getTxtNombreParaBorrar().getText();
					model.borrarLlibre(Titulo);
					
						Modelo.mostrarInfo(null);
						cargarTabla();
				    }
		
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		vista.getBtnBorrar().addActionListener(borrarLlibre);
		

		vista.getBtnHacerConsulta().addActionListener(realitzarConsulta);
		vista.tblLibros.addMouseListener(imagen);
	}

}

