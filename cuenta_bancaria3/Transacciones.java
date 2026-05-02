package cuenta_bancaria3;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacciones {

    //Atributos de la clase
    private String tipo;
    private BigDecimal monto;
    private LocalDateTime fecha;

    //Constructor con parametro
    public Transacciones(String tipo, BigDecimal monto, LocalDateTime fecha) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    //Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

}
