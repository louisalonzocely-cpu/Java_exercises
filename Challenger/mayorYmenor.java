import java.util.Scanner;

public class mayorYmenor {

    static void main(String[] args) {

        var console = new Scanner(System.in);

        int mayor = 0;
        int menor = 0;

        IO.println("\n***** Numero mayor y menor de 3 numeros *****\n");

        for (int i = 1; i <= 3; i++) {

            IO.print("Ingresar #"+ i+": ");
            var num = Integer.parseInt(console.nextLine());

            if (i == 1){
                mayor = num;
                menor = num;
            } else {
                if (num > mayor){
                    mayor = num;
                }
                if (num < menor){
                    menor = num;
                }
            }

        }
        IO.println(mayor);
        IO.println(menor);

    }

}
