package acts;

import org.apache.commons.codec.binary.Base64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.google.protobuf.TextFormat.ParseException;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import static com.mongodb.client.model.Filters.*;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import static com.mongodb.client.model.Filters.*;

public class Modelo {

	static String ipString;
	static int port;
	static String bbddString;
	static String collectionBooks;
	static String collectionUsers;
	static MongoClient mongoClient;
	static MongoCollection<Document> coleccionBooks;
	static MongoCollection<Document> coleccionUsers;
	static int contadorLlibres = 0;
	static int contadorUsuaris = 0;
	
	
	/**
	 * Metode per a comprobar si un valor es numeric o no
	 * @param el valor
	 * @return true o false
	 */
	public static boolean isNumeric(String s) {
		if (s == null || s.equals("")) {
			return false;
		}

		return s.chars().allMatch(Character::isDigit);
	}
	
	
	/**
	 * Aquest metode ens pasa la contrasenya string a un hash codificat timidet
	 * @param password 
	 * @return la contrasenya encriptada
	 */
	
	public static String generarHashContrasenya(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();

		for (byte b : hash) {
			sb.append(String.format("%02x", b));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	
	/**
	 * En aquest metode podem inicialitzar la conexio llegint el archiu json
	 * @throws IOException
	 */
	
	public static void iniciarConexion() throws IOException {
		File f1 = new File("./conexion.txt");

		FileReader fReader = new FileReader(f1);
		BufferedReader br = new BufferedReader(fReader);
		String linea = br.readLine();
		String cont = linea;

		do {
			linea = br.readLine();
			cont += linea;
		} while (linea != null);

		JSONObject obj = new JSONObject(cont);

		ipString = obj.getString("IP");
		port = obj.getInt("port");
		bbddString = obj.getString("bbdd");
		collectionBooks = obj.getString("coleccio1");
		collectionUsers = obj.getString("coleccio2");

		System.out.println(collectionBooks);
		mongoClient = new MongoClient(ipString, port);
		MongoDatabase database = mongoClient.getDatabase(bbddString);
		coleccionBooks = database.getCollection(collectionBooks);
		coleccionUsers = database.getCollection(collectionUsers);

	}
	/**
	 * Aquest metode ens permet realitzar una consulta amb un filtre i visualitzar el valor resultat
	 * @param campo
	 * @param filtro
	 * @param valor
	 * @return El camp que es ha trobat
	 */
	public static String mostrarAmbFiltres(String campo, String filtro, String valor) {

		String resultado = "";
		System.out.println(filtro);
		if (filtro.equals("")) {
			MongoCursor<Document> cursor = coleccionBooks.find().iterator();
			while (cursor.hasNext()) {
				System.out.println("el owo");
				JSONObject obj = new JSONObject(cursor.next().toJson());
				System.out.println(obj.getString("Titulo"));
				resultado += obj.getInt("Id") + " " + obj.getString("Titulo") + " " + obj.getString("Autor") + " "
						+ obj.getInt("Anyo_nacimiento") + " " + obj.getInt("Anyo_publicacion") + " "
						+ obj.getString("Editorial") + "\n";

			}
			System.out.println(resultado);
		} else {

			if (filtro.equals("eq")) {
				System.out.println("entramos en el eq");

				Bson query;
				int caracterInt;
				if (isNumeric(valor)) {
					caracterInt = Integer.parseInt(valor);
					query = eq(campo, caracterInt);
				} else {
					query = eq(campo, valor);
				}

				System.out.println(query);
				MongoCursor<Document> cursor = coleccionBooks.find(query).iterator();
				System.out.println(collectionBooks);
				System.out.println(cursor);
				while (cursor.hasNext()) {
					JSONObject obj = new JSONObject(cursor.next().toJson());
					System.out.println(obj.getString("Titulo"));
					resultado += obj.getInt("Id") + " " + obj.getString("Titulo") + " " + obj.getString("Autor") + " "
							+ obj.getInt("Anyo_nacimiento") + "" + obj.getInt("Anyo_publicacion") + ""
							+ obj.getString("Editorial") + "\n";
				}
				System.out.println(resultado);
				// owo
			} else if (filtro.equals("gte")) {
				System.out.println("FALTA POR ARREGLAR");
				Bson query;
				int caracterInt;
				if (isNumeric(valor)) {
					caracterInt = Integer.parseInt(valor);
					query = gte(campo, caracterInt);
					System.out.println("numero");
				} else {
					query = gte(campo, valor);
					System.out.println("letra");
				}
				System.out.println(query);
				MongoCursor<Document> cursor = coleccionBooks.find(query).iterator();
				while (cursor.hasNext()) {
					JSONObject obj = new JSONObject(cursor.next().toJson());
					System.out.println(obj.getString("Titulo"));
					resultado += obj.getInt("Id") + " " + obj.getString("Titulo") + " " + obj.getString("Autor") + " "
							+ obj.getInt("Anyo_nacimiento") + "" + obj.getInt("Anyo_publicacion") + ""
							+ obj.getString("Editorial") + "\n";
				}
				System.out.println(resultado);
			} else {
				Bson query;
				int caracterInt;
				if (isNumeric(valor)) {
					caracterInt = Integer.parseInt(valor);
					query = lte(campo, caracterInt);
				} else {
					query = lte(campo, valor);
				}
				MongoCursor<Document> cursor = coleccionBooks.find(query).iterator();
				while (cursor.hasNext()) {
					JSONObject obj = new JSONObject(cursor.next().toJson());
					System.out.println(obj.getString("Titulo"));
					resultado += obj.getInt("Id") + " " + obj.getString("Titulo") + " " + obj.getString("Autor") + " " + obj.getInt("Anyo_publicacion") + ""
							+ obj.getString("Editorial") + "\n";
				}
				System.out.println(resultado);
			}

		}

		return resultado;

	}

	/**
	 * Desde açi podem mostrar tots els llibres i un camp important predefinit
	 * @return Un string amb tots els llibres de la bbdd
	 */
	public static String mostrarCamposLlibres() {
		String contenidoString = "";

		MongoCursor<Document> cursor = coleccionBooks.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			contadorLlibres++;
			System.out.println(contadorLlibres + "- " + obj.getString("Titulo"));
			contenidoString += contadorLlibres + "- " + obj.getString("Titulo") + "\n";
		}
		return contenidoString;
	}

	/**
	 * Metode per a mostrar la info de un camp en concret amb un filtre
	 * @param query
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public static List<Libros> mostrarInfo(Bson query) throws IOException, ParseException {
		iniciarConexion();
		List<Libros> lista = new ArrayList<Libros>();
		if (query == null) {
			MongoCursor<Document> cursor = coleccionBooks.find().iterator();
			while (cursor.hasNext()) {
				JSONObject obj = new JSONObject(cursor.next().toJson());
				int id = obj.getInt("Id");
				String titulo = obj.getString("Titulo");
				lista.add(new Libros(id, titulo));
			}
			return lista;
		} else {
			MongoCursor<Document> cursor = coleccionBooks.find(query).iterator();
			while (cursor.hasNext()) {
				JSONObject obj = new JSONObject(cursor.next().toJson());
				int id = obj.getInt("Id");
				String titulo = obj.getString("Titulo");
				lista.add(new Libros(id, titulo));
			}
			return lista;
		}
	}
	
	/**
	 * En aquest metode podem mostrar la info d'un llibre amb x ID
	 * @param id
	 * @return La info del llibre resultant
	 * @throws IOException
	 * @throws ParseException
	 */
	public static String mostrarInfoId(int id) throws IOException, ParseException {
		iniciarConexion();
        String info = "";
        Bson query = Filters.eq("Id", id);
        MongoCursor<Document> cursor = coleccionBooks.find(query).iterator();
        while (cursor.hasNext()) {
            JSONObject obj = new JSONObject(cursor.next().toJson());
            info += (obj.getInt("Id") + "\n" + "Titol: " + obj.getString("Titulo") + "\n" + "Autor: " + obj.getString("Autor") + "\n" + 
            "Any de naixement: " + obj.getInt("Anyo_nacimiento") + "\n" + "Any de publicació: " + obj.getInt("Anyo_publicacion") + "\n" + "Editorial: " + obj.getString("Editorial") + "\n" +
            "Nombre de pàgines: " + obj.getInt("Numero_paginas") + "\n" + obj.getString("Thumbnail"));
        }
        return info;
    }

	/**
	 * En aquest metode podem mostrar tots els usuaris
	 * @return Un string amb els usuaris
	 */
	public static String mostrarCamposUsuari() {

		String contenidoString = "";

		MongoCursor<Document> cursor = coleccionUsers.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			contadorUsuaris++;
			System.out.println(contadorUsuaris + "- " + obj.getString("user"));
			contenidoString += contadorUsuaris + "- " + obj.getString("user") + "\n";
		}
		return contenidoString;
	}

	/**
	 * Aquest metode ens permet transfomrar la image a un format string encriptat
	 * @param imagen
	 * @return  string encriptat
	 * @throws IOException
	 */
	public static String transformarImagen(String imagen) throws IOException {
		File fitxer = new File(imagen);
		Image imatge = ImageIO.read(fitxer);
		ImageIcon imatgeIcona = new ImageIcon(imatge);
		JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, imatgeIcona);

		byte[] fileContent = Files.readAllBytes(fitxer.toPath());
		String encodedString = Base64.encodeBase64String(fileContent);
		System.out.println(encodedString);
		return encodedString;
	}

	/**
	 * Metode per a anyadir un llibre a mongo db
	 * @param Id
	 * @param Titulo
	 * @param Autor
	 * @param Nacimiento
	 * @param Publicacion
	 * @param Editorial
	 * @param Paginas
	 * @param Imagen
	 */
	public static void anyadirLlibre(int Id, String Titulo, String Autor, int Nacimiento, int Publicacion,
			String Editorial, int Paginas, String Imagen) {
		Document doc = new Document();
		doc.append("Id", Id);
		doc.append("Titulo", Titulo);
		doc.append("Autor", Autor);
		doc.append("Anyo_nacimiento", Nacimiento);
		doc.append("Anyo_publicacion", Publicacion);
		doc.append("Editorial", Editorial);
		doc.append("Numero_paginas", Paginas);
		doc.append("Thumbnail", Imagen);

		coleccionBooks.insertOne(doc);
	}

	/**
	 * Metode per a borrar un llibrre
	 * @param Titulo
	 */
	public static void borrarLlibre(String Titulo) {
		coleccionBooks.deleteMany(eq("Titulo", Titulo));
	}

	/**
	 * Metode per a actualitzar un llibrre
	 * @param Id
	 * @param Busqueda
	 * @param Titulo
	 * @param Autor
	 * @param Nacimiento
	 * @param Publicacion
	 * @param Editorial
	 * @param Paginas
	 * @param Imagen
	 */
	public static void actualitzarLlibre(int Id, String Busqueda, String Titulo, String Autor, int Nacimiento, int Publicacion,
			String Editorial, int Paginas, String Imagen) {
		Document doc = new Document();
		doc.append("Id", Id);
		doc.append("Titulo", Titulo);
		doc.append("Autor", Autor);
		doc.append("Anyo_nacimiento", Nacimiento);
		doc.append("Anyo_publicacion", Publicacion);
		doc.append("Editorial", Editorial);
		doc.append("Numero_paginas", Paginas);
		doc.append("Thumbnail", Imagen);

		coleccionBooks.updateMany(eq("Titulo", Busqueda), new Document("$set", doc));
	}

	/**
	 * Metode que ens permet comprobar si una contrasenya es la correcta amb el usuari
	 * @param usuari
	 * @param contrasenya
	 * @return
	 */
	public static boolean iniciarSesio(String usuari, String contrasenya) {

		Document filterDoc = new Document();
		boolean comprobacion = false;
		String hashString = generarHashContrasenya(contrasenya);

		System.out.println(hashString);
		MongoCursor<Document> cursor = coleccionUsers.find(and(eq("user", usuari), eq("pass", hashString))).iterator();
		System.out.println("w");
		if (cursor.hasNext()) {
			System.out.println("estoy");
			comprobacion = true;
		} else {
			System.out.println("no estoy");
			comprobacion = false;
		}

		return comprobacion;
	}

	/**
	 * Aquest metode tanca la conexio a mongodb
	 */
	public void cerrarConexion() {
		mongoClient.close();
	}

	/**
	 * Aquest metode ens permet eliminar una coleccio revent el nom de la mateixa
	 * @param nomColeccio
	 */
	public static void borrarColeccio(String nomColeccio) {
		if (nomColeccio.equals("llibres")) {
			coleccionBooks.drop();
		} else {
			coleccionUsers.drop();
		}
	}

}
