package cuenta_bancaria3;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

    //Atributos de la clase
    private Long numeroCuenta;
    private String titular;
    private BigDecimal saldo;
    private int totalDepositos;
    private int totalRetiros;
    private int totalTranferencias;
    private List<Transacciones> historial;

    //Constructor con parametro
    public CuentaBancaria(Long numeroCuenta, String titular, BigDecimal saldo,
         int totalDepositos, int totalRetiros, int totalTranferencias) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.totalDepositos = totalDepositos;
        this.totalRetiros = totalRetiros;
        this.totalTranferencias = totalTranferencias;
        this.historial = new ArrayList<>();
    }

    //Getters y Setters
    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getTotalDepositos() {
        return totalDepositos;
    }

    public void setTotalDepositos(int totalDepositos) {
        this.totalDepositos = totalDepositos;
    }

    public int getTotalRetiros() {
        return totalRetiros;
    }

    public void setTotalRetiros(int totalRetiros) {
        this.totalRetiros = totalRetiros;
    }

    public int getTotalTranferencias(){
        return totalTranferencias;
    }

    public void setTotalTransacciones(int totalTranferencias) {
        this.totalTranferencias = totalTranferencias;
    }

    public List<Transacciones> getHistorial() {
        return historial;
    }

    public void setHIstorial(List<Transacciones> historial) {
        this.historial = historial;
    }
    
    //Metodo para depositar
    public BigDecimal depositar(BigDecimal monto) {
        this.saldo = this.saldo.add(monto);
        this.historial.add(new Transacciones("Depositar", monto, LocalDateTime.now()));
        this.totalDepositos++;
        return this.saldo;
    }

    //Metodo para retirar
    public boolean retirar(BigDecimal monto) {
        if (monto.compareTo(this.saldo) > 0) {
            return false;
        } else {
            this.saldo = this.saldo.subtract(monto);
            this.historial.add(new Transacciones("Retirar", monto, LocalDateTime.now()));
            this.totalRetiros++;
            return true;
        }
    }

    //Metodo para tranferir
    public boolean tranferir(CuentaBancaria destino, BigDecimal monto) {
        if (destino == null || monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        if (this.saldo.compareTo(monto) < 0) {
            return false;
        }
        this.saldo = this.saldo.subtract(monto);
        destino.saldo = destino.saldo.add(monto);
        this.historial.add(new Transacciones("Tranferencia Origen", monto, LocalDateTime.now()));
        destino.historial.add(new Transacciones("Tranferencia Destino", monto, LocalDateTime.now()));
        this.totalTranferencias++;
        destino.totalTranferencias++;
        return true;
    }

    //Metodo toString()
    public String toString() {
        return "\nNumero de cuenta: " + this.numeroCuenta + "\n" +
               "Titular: " + this.titular;
    }

}
