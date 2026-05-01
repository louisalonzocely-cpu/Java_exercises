package gamevault;

import java.math.BigDecimal;

public class JuegoPC extends VideoJuego{

    //Atributos de la clase hija JuegoPC
    private int ramMinimaGB;
    private int almacenamientoGB;

    //Contructor de la clase hija con parametros
    public JuegoPC(String titulo, String genero, BigDecimal precio, int anioLanzamiento, double calificacion,
            int ramMinimaGB, int almacenamientoGB) {
        super(titulo, genero, precio, anioLanzamiento, calificacion);
        this.ramMinimaGB = ramMinimaGB;
        this.almacenamientoGB = almacenamientoGB;
    }

    //Getters y Setters
    public int getRamMinimaGB() {
        return ramMinimaGB;
    }

    public void setRamMinimaGB(int ramMinimaGB) {
        this.ramMinimaGB = ramMinimaGB;
    }

    public int getAlmacenamientoGB() {
        return almacenamientoGB;
    }

    public void setAlmacenamientoGB(int almacenamientoGB) {
        this.almacenamientoGB = almacenamientoGB;
    }

    //Metodo toString()
    @Override
    public String toString() {
        return super.toString() +
               "| Ram minima en GB: " + this.ramMinimaGB + "GB\n" +
               "| Almacenamiento en GB: " + this.almacenamientoGB + "GB\n";
    }

}
