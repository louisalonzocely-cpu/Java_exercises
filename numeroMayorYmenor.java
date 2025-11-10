import java.util.Scanner;

public class numeroMayorYmenor {
    public static void main(String[] args) {
        
        try (var console = new Scanner(System.in)) {
            //declaramos e inicializamos las variables
            var num = 0;
            var menor = 0;
            var mayor = 0;
            
            IO.println("\n***** MAYOR Y MENOR DE 5 NUMEROS *****\n");
            
            //Solicitamos los numeros por medio de un ciclo for
            for (int i = 1; i < 6; i++) {

                boolean datoValido = false;

                //ciclo de validacion
                do {
                    IO.print("-> Ingrese numero "+i+": ");
                    String linea = console.nextLine();
                
                    //Evaluamos que el dato ingresado sea un numero
                    try {
                    num = Integer.parseInt(linea);
                    datoValido = true;
                    } catch (Exception e) {
                        System.err.println("Entrada no valida. Debe ingresar un numero.");
                    }
                } while (!datoValido);
                    
                //Condicion 1
                /*Evaluamos que en la primera iteracion las variables mayor y menor
                 * tomen el valor del numero ingresado.
                */
                if (i == 1) {
                   mayor = num;
                   menor = num;
                } else {
                    //Evaluamos con operador ternario para los otras iteraciones
                    mayor = (num > mayor) ? num : mayor; 
                    menor = (num < menor) ? num : menor;
                }
            }

            IO.println("--------------------------------");
            //Evaluamos para cuando los numeros son iguales
            if (mayor == menor) {
                IO.println("Los numeros ingresados son iguales.");
                //Sino, pasamos a imprimir el num mayor y menor
            } else {
                IO.println("-> El numero mayor es: "+ mayor);
                IO.println("-> El numero menor es: "+ menor);
            }
        }
    }
}
