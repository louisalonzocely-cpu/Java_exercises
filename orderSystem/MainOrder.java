package orderSystem;

public class MainOrder {

    public static void main(String[] args) {
        
        OrderService services = new OrderServiceImpl();

        boolean exit = false;

        while (!exit) {

            services.mainMenu();
            int option = services.validateNumberData("Select option: ");

            switch (option) {
                case 1 -> services.addOrder();
                case 2 -> {
                    IO.println("\n-> Find Order:");
                    int id = services.validateNumberData("Check Order Id: ");
                    Order order = services.findById(id);
                    IO.println(order != null ? order : "Order not found.");
                } 
                case 3 -> {
                    IO.println("\n-> Highest order:");
                    IO.print(services.higherOrder());
                }
                case 4 -> IO.println("\n-> Total orders: " + services.totalOrder());
                case 5 -> IO.println("\n-> Balance: " + services.balance());
                case 6 -> exit = true;
                default -> IO.println("ERROR: Invalid option.");
            }
        }
    }
}
