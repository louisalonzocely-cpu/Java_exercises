package gamevault;

import java.math.BigDecimal;

public class VideoJuego {

    //Atributos de la clase padre VideoJuego
    protected String titulo;
    protected String genero;
    protected BigDecimal precio;
    protected int anioLanzamiento;
    protected double calificacion;

    //COnstructo de la clase padre con parametros
    public VideoJuego(String titulo, String genero, BigDecimal precio, int anioLanzamiento, double calificacion) {
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
        this.anioLanzamiento = anioLanzamiento;
        this.calificacion = calificacion;
    }

    //Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    //Metodo para multiplicar las estrellas
    public String multiplicarEstrellas() {
        return "⭐".repeat((int) this.calificacion);
    }

    //Metodo toString()
    @Override
    public String toString() {
        return "\n| Titulo: " + this.titulo + "\n" +
               "| Genero: " + this.genero + "\n" +
               "| Precio: $" + String.format("%.2f", this.precio) + "COP\n" +
               "| Año de lanzamiento: " + this.anioLanzamiento + "\n" +
               "| Calificacion: " + multiplicarEstrellas() + "\n";
    }

}
