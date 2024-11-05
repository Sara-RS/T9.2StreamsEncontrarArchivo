
package encontrararchivo;
import java.io.*;
import java.util.TreeSet;

public class EncontrarArchivo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Ingresa como argumento la ruta del archivo");
            return;
        }
        String ruta = args[0];
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            System.out.println("El archivo " + ruta + " no existe");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            TreeSet<Estudiante> estudiantes = (TreeSet<Estudiante>) ois.readObject();
            System.out.println("Lista de estudiantes:");

            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
