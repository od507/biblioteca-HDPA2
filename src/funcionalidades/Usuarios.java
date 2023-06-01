/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidades;

/**
 *
 * @author ANTONIO
 */
public class Usuarios {
    //Declaracion de atributos
    private String nombre;
    private String apellido;
    private String dni;
    private boolean puedeAlquilar;
    
    public Usuarios(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.puedeAlquilar = true; // Los usuarios nuevos no tienen libros alquilados 
    }
    
    public void actualizarPuedeAlquilar(boolean estado) {
        this.puedeAlquilar = estado;
    }
    
    public String mensajeStatusUsuario(boolean estado) {
        if (estado)
            return "El usuario puede retirar";
        else
            return "El usuario necesita retornar el libro prestado antes de pedir otro";
    }
    
    public String obtenerNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }
    
    public String obtenerDni() {
        return this.dni;
    }
    
    public boolean obtenerPuedeAlquilar() {
        return this.puedeAlquilar;
        //Verifica si ya tiene un libro en su posesion
    }
}
    