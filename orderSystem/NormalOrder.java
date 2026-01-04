package orderSystem;

import java.math.BigDecimal;

public class NormalOrder extends Order{

    public NormalOrder(int id, String client, BigDecimal baseValue) {
        super(id, client, OrderType.NORMAL, baseValue);
    }
    
    @Override
    public BigDecimal calculateTotal() {
        return baseValue.add(baseValue.multiply(new BigDecimal("0.05")));
    }
}
