import java.math.BigDecimal;

public class FacturacionNacional extends Facturacion{

    //Constructor de la clase hija
    public FacturacionNacional(int id, String cliente, BigDecimal valorBase) {
        super(id, cliente, valorBase, TipoFactura.NACIONAL);
    }

    //metodo para calcular el impuesto
    @Override
    public BigDecimal calcularImpuesto() {
        return valorBase.multiply(new BigDecimal("0.19"));
    }

    @Override
    public BigDecimal calcularTotal() {
        return valorBase.add(calcularImpuesto());
    }
}
