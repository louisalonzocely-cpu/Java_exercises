import java.util.Scanner;

public class conversoDecimalBinario {

    public static void main(String[] args) {
        
        var consola = new Scanner(System.in);

        //Solicitamos el numero decimal
        IO.print("\n-> Ingrese decimal a convertir: ");
        var num = Integer.parseInt(consola.nextLine()); //Almacenamos el numero decimal en la variable

        //Almacenamos el numero en una variable temporal
        var decimal = num;
        //Declaramos una variable String vacia para almacenar el modulo de cada iteracion
        String binario = "";
        String resultBinario = "";

        //Inicializamos un ciclo while para que nos calcule el modulo y lo almacene en binario
        //Mientas decimal sea mayor a 0, se repita el ciclo
        while (decimal > 0) {
            
          //Calculamos el modulo
          var resto = decimal % 2;
          //Almacenamos el resto en la variable binario
          binario = binario + resto;
          //calculamos el siguiente cociente para la siguiente iteracion
          decimal = decimal / 2;

        }

        for (int i = binario.length()-1; i >= 0 ; i--) {
            resultBinario += binario.charAt(i);
        }
        //StringBuilder sb = new StringBuilder(binario);
        //String resultBinario = sb.reverse().toString();

        //Imprimimos en pantalla el resultado
        IO.println("\n-> Numero decimal: "+ num);
        IO.println("-> Numero binario: "+ resultBinario);

    }
    
}
