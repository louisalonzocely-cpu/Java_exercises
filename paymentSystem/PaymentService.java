package paymentSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class PaymentService {

    private Scanner console = new Scanner(System.in);

    //method main menu 
    public void paymentMenu() {
        IO.print("""
        \n-> Main menu:
        1. Register payment.
        2. Check payment.
        3. Modify payment.
        4. Remove payment.
        5. List payments.
        6. Higher payment.
        7. Exit.
        """);
    }

    //method to validate empty field
    public String validateEmptyField(String message) {
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

    //method for validating numeric data
    public int validatingNumericData(String message) {
        while (true) {
            try {
                return Integer.parseInt(validateEmptyField(message));
            } catch (NumberFormatException e) {
                IO.println("ERROR: Non numeric data.");
            }
        }
    }

    //method for validating BigDecimal data
    public BigDecimal validatingBigDecimalData(String message) {
        while (true) {
            String input = validateEmptyField(message);
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

    //method for registering a payment
    public void registeringPayment(ArrayList<Payment> payments) {

        IO.println("\n-> Register payment:");

        int id = validatingNumericData("Payment Id: ");
        BigDecimal amound = validatingBigDecimalData("Amound: ");
        int paymentType = validatingNumericData("Payment type (1:cash/2:card/3:transfer): ");
        String description = validateEmptyField("Description: ");

        Payment payment;

        switch (paymentType) {
            case 1 -> payment = new PaymentCash(id, amound, description);
            case 2 -> payment = new PaymentCard(id, amound, description);
            case 3 -> payment = new PaymentTransfer(id, amound, description);
            default -> {
                IO.println("ERROR: Invalid payment type.");
                return;
            } 
        }

        payments.add(payment);
        IO.println("Payment successfully registred.");
    }

    //method to check a payment
    public void checkPayment(ArrayList<Payment> payments) {
        
        IO.println("\n-> Check payment:");

        int id = validatingNumericData("Id to consult: ");

        for (Payment payment : payments) {
            if (payment.getId() == id) {
                IO.println(payment);
                return;
            }
        }
        IO.println("Payment not recorded.");
    }

    //method to modify payment
    public void modifyPayment(ArrayList<Payment> payments) {
        
        IO.println("\n-> Modify Payment:");
        int id = validatingNumericData("Id to modify: ");

        for (Payment payment : payments) {
            if (payment.getId() == id) {
                BigDecimal newAmound = validatingBigDecimalData("New amound: ");
                String newDescription = validateEmptyField("New description: ");
        
                payment.setAmount(newAmound);
                payment.setDescription(newDescription);
                IO.println("Payment successfully modify.");
                return;
            }
        }
        IO.println("Payment not recorded.");

    }

    //method to delete registered payment
    public void deletePayment(ArrayList<Payment> payments) {
        
        IO.println("\n-> Deleted payment:");
        int id = validatingNumericData("Payment Id to be deleted: ");

        for (Payment payment : payments) {
            if (payment.getId() == id) {
                payments.remove(payment);
                IO.println("Payment successfully removed.");
                return;
            }
        }
        IO.println("Payment not recorded.");
    }

    //method to list payments
    public void listPayments(ArrayList<Payment> payments) {
        int count = 1;
        IO.println("\n-> List payments:");
        for (Payment payment : payments) {
            IO.print("""
            Payment #%d
            Id: %d
            Amoud: %s
            Payment type: %s
            Description: %s
            Total: %s
            """.formatted(count, payment.getId(), payment.getAmount(), payment.getPaymentType(),
            payment.getDescription(), payment.calculateTotal()));
            count++;
        }
    }

    //method to find out the highest payment
    public Payment higherPayment(ArrayList<Payment> payments) {
        IO.println("\n-> Higher Payment:");

        if (payments == null || payments.isEmpty()) {
          return null; 
        }

        Payment major = payments.get(0);
        
        for (Payment payment : payments) {
            if (payment.calculateTotal().compareTo(major.calculateTotal()) > 0) {
                 major = payment;
            }
        }
        return major;
    }

}
