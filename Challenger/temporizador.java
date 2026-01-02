import java.util.Scanner;

public class temporizador {
    static void main(String[] args) throws InterruptedException {

        var console = new Scanner(System.in);

        IO.println("\n***** TEMPORIZADOR EN JAVA *****\n");

        //Solicitamos la configuracion del temporizador
        IO.print("- Configurara el temporizador:\n");
        IO.print("-> Ingresar las horas: ");
        var hora = Integer.parseInt(console.nextLine());
        IO.print("-> Ingresar los minutos: ");
        var minuto = Integer.parseInt(console.nextLine());
        IO.print("-> Ingrese los segundos: ");
        var segundo = Integer.parseInt(console.nextLine());

        IO.println("\n--------------------------");
        
        //Inicializamos un bucle infinito
        while (true){
            //En esta condicion cuando se cumpla el tiempo configurado, se saldra del ciclo
            if (hora == 0 && minuto == 0 && segundo == 0){
                IO.println("\n¡Tiempo agotado!");
                break;
            }
            //Esperamos un segundo por iteracion
            Thread.sleep(1000);
            segundo--; //Restamos un segundo por iteracion

            //Si segundo es menor a 0, segundo se iguala a 59 y se reste un minuto
            if (segundo < 0){
                segundo = 59;
                minuto--;
            }

            //Si minuto es menor a 0, minuto se iguala a 59 y se resta una hora
            if (minuto < 0){
                minuto = 59;
                hora--;
            }

            //Si la hora es menor a 0, esta se iguala a 0
            if (hora < 0){
                hora = 0;
            }

            //Con operadores ternario agregamos el 0 a los numeros de un digito para dar formato de hora
            String horaFormato = (hora < 10) ? "0" + hora : String.valueOf(hora);
            String minutoFormato = (minuto < 10) ? "0" + minuto : String.valueOf(minuto);
            String segundoFormato = (segundo < 10) ? "0" + segundo : String.valueOf(segundo);

            //Imprimimos el temporizador con las variables inicializadas con los operadores ternarios
            IO.print("\r-> Temporizador: "+horaFormato+":"+minutoFormato+":"+segundoFormato);
        }

    }
}
