/*Programa que convierte un numero decimal ingresado por consola
* a binario*/

import java.util.Scanner;

public class conversorDecimalAbinario {
    static void main(String[] args) {

        var console = new Scanner(System.in);

        //Declaracion de variables
        int num = 0;
        boolean validacion = false;
        String binario = "";
        String resultBinario = "";

        IO.println("\n***** CONVERSOR DE DECIMAL A BINARIO *****\n");

        //Ciclo para validacion del dato a ingresar
        while (!validacion){
            //Solicitamos el numero a convertir
            IO.print("-> Ingresar el decimal a convertir: ");
            String entrada = console.nextLine();

            //validamos el dato ingresado
            try {
                //cuando el dato si sea un numero la validacion es verdadera
                num = Integer.parseInt(entrada);
                validacion = true;
              //En caso de que el dato ingresado sea caracter
            } catch (NumberFormatException e) {
                //Mostramos este mensaje y vuelve a solicitar el numero
                System.out.println("ERROR: Valor ingresado invalido.");
            }

        }
        //Con este ciclo iteramos el numero ingresado hasta que este llegue a 0
        while (num > 0) {
            //calculamos el modulo del numero para que nos de el numero binario
            var resto = num % 2;
            //convertimos el resto a un dato String para no tener conflicto de tipo de datos
            String restoString = String.valueOf(resto);
            //por iteracion almacenamos en la variable binario inicializado
            binario += restoString;
            //y recuperamos el cociente
            num = num / 2;

        }
        //con este ciclo buscamos inventir el resultado
        //i recorre la cadena almacenada en la variable binario de atras adelante
        for (int i = binario.length()-1; i >= 0 ; i--) {
            //en esta linea obtenemos el caracter ubicado en la posicion actual de i y lo almacena en la variable resultBinario
            resultBinario += binario.charAt(i);
        }

        IO.println("\n-------------------------------------");
        //Imprimimos el resultado de la operacion.
        IO.println("-> Resultado en binario: "+ resultBinario);
    }

}
