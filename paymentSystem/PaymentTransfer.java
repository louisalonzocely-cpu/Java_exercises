package paymentSystem;

import java.math.BigDecimal;

public class PaymentTransfer extends Payment{

    //daughter class constructor
    public PaymentTransfer(int id, BigDecimal amound, String description) {
        super(id, amound, PaymentType.TRANSFER, description);
    }

    //method passed by the parent class
    @Override
    public BigDecimal calculateTotal() {
        return amount.subtract(amount.multiply(new BigDecimal("0.3")));
    }
}
