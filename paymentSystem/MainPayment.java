package paymentSystem;

import java.util.ArrayList;

public class MainPayment {
    public static void main(String[] args) {
        
        ArrayList<Payment> payments = new ArrayList<>();
        PaymentService service = new PaymentService();

        boolean exit = false;

        while (!exit) {
            service.paymentMenu();
            int option = service.validatingNumericData("Select a option: ");

            switch (option) {
                case 1 -> service.registeringPayment(payments);
                case 2 -> service.checkPayment(payments);
                case 3 -> service.modifyPayment(payments);
                case 4 -> service.deletePayment(payments);
                case 5 -> service.listPayments(payments);
                case 6 -> IO.println(service.higherPayment(payments));
                case 7 -> exit = true;
                default -> IO.println("ERROR: Invalid option.");
            }
        }
    }
}
