package acts;

import java.io.IOException;

import com.google.protobuf.TextFormat.ParseException;

public class Principal {
	public static void main(String[] args) throws ParseException, IOException{
		
		Vista vista = new Vista();
		Modelo model = new Modelo();
		Controlador controlador = new Controlador(vista, model);
		
	}
}
