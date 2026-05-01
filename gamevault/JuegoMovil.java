package gamevault;

import java.math.BigDecimal;

public class JuegoMovil extends VideoJuego{

    //Atributo de la clase hija JuegoMovil
    private String esGratuito;
    private String tieneCompra;

    //Constructor de la clase hija con parametros
    public JuegoMovil(String titulo, String genero, BigDecimal precio, int anioLanzamiento, double calificacion,
            String esGratuito, String tieneCompra) {
        super(titulo, genero, precio, anioLanzamiento, calificacion);
        this.esGratuito = esGratuito;
        this.tieneCompra = tieneCompra;
    }

    //Getters y Setters
    public String getEsGratuito() {
        return esGratuito;
    }

    public void setEsGratuito(String esGratuito) {
        this.esGratuito = esGratuito;
    }

    public String getTieneCompra() {
        return tieneCompra;
    }

    public void setTieneCompra(String tieneCompra) {
        this.tieneCompra = tieneCompra;
    }

    //Metodo toString()
    @Override
    public String toString() {
        return super.toString() +
               "| ¿Es gratuito?: " + this.esGratuito + "\n" +
               "| ¿Tiene compras?: " + this.tieneCompra + "\n";
    }

}
