/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidades;
import java.util.ArrayList;

/**
 *
 * @author ANTONIO
 */
public class Biblioteca {
        public  static ArrayList<Libros> listaLibros;
        public static ArrayList<Usuarios> listaUsuarios;
        
        public Biblioteca() {
            listaLibros = new ArrayList<Libros>();
            listaUsuarios = new ArrayList<Usuarios>();
        }
        
        /*Nuestros metodos evitan que un usuario no habilitado
        pueda recibir un libro o que la bilioteca se quede sin su
        ultimo ejemplar*/
        
        public static boolean usuarioHabilitado(int posicion) {
            /*Los usuarios que ya tengan un libro prestado
              no pueden pedir hasta que devuelvan el libro  */
            
            return listaUsuarios.get(posicion).obtenerPuedeAlquilar();
        }
        
        public static void agregarLibro(Libros libro){
            listaLibros.add(libro);
        }
        
        public static void agregarUsuario(Usuarios usuario) {
            listaUsuarios.add(usuario);
        }
        
        public static boolean verificarLibroDisp(int posicion) {
            //La biblioteca necesita tener al menos una copia en todo momento
            return listaLibros.get(posicion).obtenerCantidad() > 1;
        }
        
        public static int encontrarPosLibro(String titulo){
            
            int pos;
            for(int i = 0 ; i<listaLibros.size();i++) {
                if (listaLibros.get(i).obtenerTitulo().equals(titulo)) {
                    pos =i;
                    return pos;
                }  
            }
            return -1; 
        }
        
        public static int encontrarPosUsuario(String primerNombre, String apellido){
            int pos;
           String nombreCompleto = primerNombre + " " + apellido;
            for(int i = 0; i<listaUsuarios.size();i++) {
                if (listaUsuarios.get(i).obtenerNombreCompleto().equals(nombreCompleto)) {
                    pos =i;
                    return pos;
                }
            }
            return -1;   
        }
        
        public static boolean verificaPrestarLibro(int posicionLibro, int posicionUsuario) {
            /*Solamente prestaremos libros si tenemos en inventario
              y si el usuario no tiene un libro de la biblioteca*/
            return verificarLibroDisp(posicionLibro) & usuarioHabilitado(posicionUsuario);
        }
        
        public static void recibirLibro(int posicionLibro, int posicionUsuario) {
            /*Cuanto recibimos un libro, incrementamos la cantidad en inventario
            y actualizamos que el usuario es elegible para volver a pedir
            */
            listaLibros.get(posicionLibro).libroDevuelto();
            listaUsuarios.get(posicionUsuario).actualizarPuedeAlquilar(true);
        }
        
        public static void prestarLibro(int posicionLibro, int posicionUsuario) {
            /*Cuanto prestamos un libro, reducimos la cantidad en inventario
            y actualizamos que el usuario no es elegible para volver a pedir
            */
            listaLibros.get(posicionLibro).libroPrestado();
            listaUsuarios.get(posicionUsuario).actualizarPuedeAlquilar(false);
        }
}
