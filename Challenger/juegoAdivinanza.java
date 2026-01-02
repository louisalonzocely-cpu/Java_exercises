import java.util.Random;
import java.util.Scanner;

public class juegoAdivinanza {
    static void main(String[] args) {

        var console = new Scanner(System.in);
        var aleatorio = new Random();

        boolean validacion;
        var cont = 1;

        IO.println("\n***** JUEGOS DE ADIVINANZAS *****");

        do {

            var numAleatorio = aleatorio.nextInt(1, 3);

            IO.println("\nROUND "+cont);

            IO.print("Adivina el numero aleatorio de 1 a 3.\n");
            IO.print("-> Ingresa el numero que crees que es el correcto: ");
            var num = Integer.parseInt(console.nextLine());

            validacion = num == numAleatorio;

            IO.println("Numero aleatorio: "+ numAleatorio);

            cont++;

            if (validacion){
                IO.println("Felicidades, haz ganado la partida");
            } else {
                IO.println("Haz perdido la partida.");
            }

        } while (cont < 4);

    }

}
