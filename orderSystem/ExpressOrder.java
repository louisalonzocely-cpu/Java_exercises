package orderSystem;

import java.math.BigDecimal;

public class ExpressOrder extends Order{

    public ExpressOrder(int id, String client, BigDecimal baseValue) {
        super(id, client, OrderType.EXPRESS, baseValue);
    }

    @Override
    public BigDecimal calculateTotal() {
        return baseValue.add(baseValue.multiply(new BigDecimal("0.10")));
    }
}
