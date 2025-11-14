import java.util.Scanner;

public class cronometro {
    static void main(String[] args) throws InterruptedException {

        var console = new Scanner(System.in);

        IO.println("\n***** CRONOMETRO EN JAVA *****\n");
        //solocitamos la configuracion del cronometro
        IO.print("- Configurara el cronometro:\n");
        IO.print("-> Ingresar las horas: ");
        var hora = Integer.parseInt(console.nextLine());
        IO.print("-> Ingresar los minutos: ");
        var minuto = Integer.parseInt(console.nextLine());
        IO.print("-> Ingrese los segundos: ");
        var segundo = Integer.parseInt(console.nextLine());

        IO.println("\n--------------------------");
        //inicializamos un ciclo infinito
        while (true){
            //primera condicion: si la hora, minuto y segundo lleguen a 0 avise que el tiempo se acabo
            if (hora == 0 && minuto == 0 && segundo == 0){
                IO.println("\n¡Tiempo agotado!");
                break; //sale del ciclo
            }
            //le damos un segundo por iteracion
            Thread.sleep(1000);
            //y restamos un segundo por iteracion
            segundo--;
            //si segundo es menor a 0, iguale segundo a 59
            if (segundo < 0){
                segundo = 59;
                minuto--; //y reste un minuto
            }
            //si mimuto es menor a 0, iguale minuto a 59
            if (minuto < 0){
                minuto = 59;
                hora--; //y reste una hora
            }
            //si hora es menor a 0, iguale a la hora a 0
            if (hora < 0){
                hora = 0;
            }
            //con los operadores ternarios agregamos el 0 a numeros de un solo digito
            String horaFormato = (hora < 10) ? "0" + hora : String.valueOf(hora);
            String minutoFormato = (minuto < 10) ? "0" + minuto : String.valueOf(minuto);
            String segundoFormato = (segundo < 10) ? "0" + segundo : String.valueOf(segundo);
            //imprimimos el cronometro en cuenta regresiva
            IO.print("\r-> Cronometro: "+horaFormato+":"+minutoFormato+":"+segundoFormato);
        }

    }
}
