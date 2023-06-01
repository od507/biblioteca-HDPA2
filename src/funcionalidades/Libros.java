package funcionalidades;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/** @author ANTONIO*/
public class Libros {
    
    //Declaracion de atributos

    private String codigo;
    private String titulo;
    private String autor;
    private String editorial;
    private int version;
    private int cantidad;
    
    //Constructor con la inicilizacion de los atributos
    public Libros(String codigo, String titulo,String autor, String editorial,int version, int cantidad) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.version = version;
        this.cantidad = cantidad;
    }
    
    // Metodos para acceder a los atributos
    public String obtenerCodigo() {
        return this.codigo;
    }
    
    public String obtenerTitulo() {
        return this.titulo;
    }
    
    public String obtenerAutor() {
        return this.autor;
    }
    
    public String obtenerEditorial() {
        return this.editorial;
    }
    
    public int obtenerVersion() {
        return this.version;
    }
    
    public int obtenerCantidad() {
        return this.cantidad;
    }
    
    public String mensajeCantidadLibros(int cantidadLibros){
        if (cantidadLibros == 1)
            return "No podemos prestar nuestra ultima copia del libro";
        else
            return"";
    }
    
    public void libroDevuelto(){
        this.cantidad++;
    }
    
    public void libroPrestado() {
        this.cantidad--;
    }
}
