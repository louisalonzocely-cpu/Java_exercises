package orderSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {

    private Scanner console = new Scanner(System.in);
    private final ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void mainMenu() {
        IO.println("""
        \nMain Menu:
        1. Register Order.
        2. Check Order by Id.
        3. Highest Order.
        4. Total Orders.
        5. Balance.
        6. Exit.
                """);
    }

    @Override
    public String validateStringData(String message) {
        String input;
        do {
            IO.print(message);
            input = console.nextLine();
            if (input.isEmpty()) {
                IO.println("ERROR: Empty field.");
            }
        } while (input.isEmpty());
        return input;
    }

    @Override
    public int validateNumberData(String message) {
        while (true) {
            try {
                return Integer.parseInt(validateStringData(message));
            } catch (NumberFormatException e) {
                IO.println("ERROR: Non numeric data.");
            }
        }
    }

    @Override
    public OrderType validateOrderType() {
        while (true) {
            for (OrderType type : OrderType.values()) {
                IO.println("- " + type);
            }
            try {
                return OrderType.valueOf(validateStringData("Order Type: ").toUpperCase());
            } catch (IllegalArgumentException e) {
                IO.println("ERROR: Invalid Order type.");
            }
        }
    }

    @Override
    public BigDecimal validateBigDecimalData(String message) {
        while (true) {
            String input = validateStringData(message);
            try {
                BigDecimal bigDecimalData = new BigDecimal(input);
                if (bigDecimalData.compareTo(BigDecimal.ZERO) < 0) {
                    IO.println("ERROR: Negative data.");
                }
                return bigDecimalData;
            } catch (NumberFormatException e) {
                IO.println("ERROR: Non numeric data.");
            }
        }
    }

    @Override
    public void addOrder() {
        
        IO.println("\n-> Add Order:");
        int id = validateNumberData("Id Order: ");
        
        for (Order order : orders) {
            if (order.getId() == id) {
                IO.println("Id already exists.");
                return;
            }
        }

        String client = validateStringData("Client'name: ");
        OrderType type = validateOrderType();
        BigDecimal baseValue = validateBigDecimalData("Base value: ");

        Order newOrder = (type == OrderType.NORMAL) 
        ? new NormalOrder(id, client, baseValue) : new ExpressOrder(id, client, baseValue);

        orders.add(newOrder);
    }

    @Override
    public Order findById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order higherOrder() {
        if (orders.isEmpty()) return null;

        Order major = orders.get(0);
        for (Order order : orders) {
            if (order.calculateTotal().compareTo(major.calculateTotal()) > 0) {
                major = order;
            }
        }
        return major;
    }

    @Override
    public int totalOrder() {
        return orders.size();
    }

    @Override
    public boolean existById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public BigDecimal balance() {
        BigDecimal total = BigDecimal.ZERO;
        for (Order order : orders) {
            total = total.add(order.calculateTotal());
        }
        return total;
    }
}
