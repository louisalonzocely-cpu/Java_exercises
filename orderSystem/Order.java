package orderSystem;

import java.math.BigDecimal;

public abstract class Order {

    //atributes
    protected int id;
    protected String client;
    protected OrderType orderType;
    protected BigDecimal baseValue;
    
    //Constructor parent class
    public Order(int id, String client, OrderType orderType, BigDecimal baseValue) {
        this.id = id;
        this.client = client;
        this.orderType = orderType;
        this.baseValue = baseValue;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(BigDecimal baseValue) {
        this.baseValue = baseValue;
    }

    public abstract BigDecimal calculateTotal();

    @Override
    public String toString() {
        return """
                Client name: %s
                Ordet type: %s
                Base value: %s
                Total: %s
                """.formatted(client, orderType, baseValue, calculateTotal());
    }
 
}
