package paymentSystem;

import java.math.BigDecimal;

public abstract class Payment {
    
    //attributes of the parent class
    protected int id;
    protected BigDecimal amount;
    protected PaymentType paymentType;
    protected String description;

    //empty constructor for Spring
    public Payment() {}

    //constructor with parameters
    public Payment(int id, BigDecimal amount, PaymentType paymentType, String description) {
        this.id = id;
        this.amount = amount;
        this.paymentType = paymentType;
        this.description = description;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //method for calculating the total
    public abstract BigDecimal calculateTotal();

    //method toString
    @Override
    public String toString() {
        return """
                Amound: $%s
                Payment type: %s
                Descripcion: %s
                Total: $%s
                """.formatted(amount, paymentType, description, calculateTotal());
    }

}
