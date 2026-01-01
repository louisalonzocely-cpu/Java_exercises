import java.math.BigDecimal;

public class FacturaInternacional extends Facturacion{

    //Constructor de la clase hija
    public FacturaInternacional(int id, String cliente, BigDecimal valorBase) {
        super(id, cliente, valorBase, TipoFactura.INTERNACIONAL);
    }

    //metodo para calcular el impuesto
    @Override
    public BigDecimal calcularImpuesto() {
        return valorBase.multiply(new BigDecimal("0.30"));
    }

    @Override
    public BigDecimal calcularTotal() {
        return valorBase.add(calcularImpuesto());
    }
}
