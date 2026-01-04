package orderSystem;

import java.math.BigDecimal;

public interface OrderService {

    void mainMenu();
    void addOrder();
    Order findById(int id);
    Order higherOrder();
    int totalOrder();
    boolean existById(int id);
    String validateStringData(String message);
    int validateNumberData(String message);
    OrderType validateOrderType();
    BigDecimal validateBigDecimalData(String message);
    BigDecimal balance();

}
