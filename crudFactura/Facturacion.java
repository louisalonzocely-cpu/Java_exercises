import java.math.BigDecimal;

public abstract class Facturacion {
    //Atributos de la clase padre
    protected int id;
    protected String cliente;
    protected BigDecimal valorBase;
    protected TipoFactura tipoFactura;
    
    //Constructor de la clase padre
    public Facturacion(int id, String cliente, BigDecimal valorBase, TipoFactura tipoFactura) {
        this.id = id;
        this.cliente = cliente;
        this.valorBase = valorBase;
        this.tipoFactura = tipoFactura;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorBase() {
        return valorBase;
    }

    public void setValorBase(BigDecimal valorBase) {
        this.valorBase = valorBase;
    }

    public TipoFactura getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoFactura tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    //metodo abstracto para calcular el impuesto
    public abstract BigDecimal calcularImpuesto();
    
    //metodo abtracto para calcular el total de la factura
    public abstract BigDecimal calcularTotal();
    
}
