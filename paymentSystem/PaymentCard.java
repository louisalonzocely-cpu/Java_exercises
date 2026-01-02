package paymentSystem;

import java.math.BigDecimal;

public class PaymentCard extends Payment{
    
    //daughter class constructor
    public PaymentCard(int id, BigDecimal amound, String description) {
        super(id, amound, PaymentType.CARD, description);
    }

    //method passed by the parent class
    @Override
    public BigDecimal calculateTotal() {
        return amount.subtract(amount.multiply(new BigDecimal("0.06")));
    }
}
