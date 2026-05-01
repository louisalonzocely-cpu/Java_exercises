package gamevault;

import java.math.BigDecimal;

public class JuegoConsola extends VideoJuego{

    //Atributos de la clase hija JuegoConsola
    private String consola;
    private String requiereInternet;

    //Constructor de la clase hija heredando atributos de la clase padre
    public JuegoConsola(String titulo, String genero, BigDecimal precio, int anioLanzamiento, double calificacion,
            String consola, String requiereInternet) {
        super(titulo, genero, precio, anioLanzamiento, calificacion);
        this.consola = consola;
        this.requiereInternet = requiereInternet;
    }

    //Getters y Setters
    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getRequiereInternet() {
        return requiereInternet;
    }

    public void setRequiereInternet(String requiereInternet) {
        this.requiereInternet = requiereInternet;
    }

    //Metodo toString()
    @Override
    public String toString() {
        return super.toString() +
               "| Consola: " + this.consola + "\n" +
               "| ¿Requiere Internet?: " + this.requiereInternet + "\n"; 
    }
    
}
