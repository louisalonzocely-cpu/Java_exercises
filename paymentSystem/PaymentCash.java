package paymentSystem;

import java.math.BigDecimal;

public class PaymentCash extends Payment{

    //daughter class constructor
    public PaymentCash(int id, BigDecimal amound, String description) {
        super(id, amound, PaymentType.CASH, description);
    }

    //method passed by the parent class
    @Override
    public BigDecimal calculateTotal() {
        return amount.subtract(amount.multiply(new BigDecimal("0.05")));
    }

}
