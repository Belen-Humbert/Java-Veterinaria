package petshop;
import java.io.*;

class LocalStorage{
    // Serializaci�n
public static void setItem(String nombre, Object objeto){
	try {
	    FileOutputStream archivoSalida = new FileOutputStream(nombre);
	    ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);
	    objetoSalida.writeObject(objeto);
	    objetoSalida.close();
	    archivoSalida.close();
            System.out.println("guardado completo");
	} catch (IOException e) {
	    e.printStackTrace();
	}        
}

	public static Object getItem(String nomArchivo){
	       // Deserializaci�n
		Object objetoDeserializado = null;
		try {
		    FileInputStream archivoEntrada = new FileInputStream(nomArchivo);
		    ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);
		    objetoDeserializado = objetoEntrada.readObject();
		    objetoEntrada.close();
		    archivoEntrada.close();
                    System.out.println("recuperado correctamente");
		} catch (IOException | ClassNotFoundException e) {
		    e.printStackTrace();
		}
		return objetoDeserializado;
	}
}