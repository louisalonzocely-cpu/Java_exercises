import java.util.Scanner;

public class cronometro {
    static void main(String[] args) throws InterruptedException {

        var console = new Scanner(System.in);

        IO.println("\n***** CRONOMETRO EN JAVA *****\n");

        IO.print("- Configurara el cronometro:\n");
        IO.print("-> Ingresar las horas: ");
        var hora = Integer.parseInt(console.nextLine());
        IO.print("-> Ingresar los minutos: ");
        var minuto = Integer.parseInt(console.nextLine());
        IO.print("-> Ingrese los segundos: ");
        var segundo = Integer.parseInt(console.nextLine());

        IO.println("\n--------------------------");

        while (true){

            if (hora == 0 && minuto == 0 && segundo == 0){
                IO.println("\n¡Tiempo agotado!");
                break;
            }

            Thread.sleep(1000);
            segundo--;

            if (segundo < 0){
                segundo = 59;
                minuto--;
            }

            if (minuto < 0){
                minuto = 59;
                hora--;
            }

            if (hora < 0){
                hora = 0;
            }

            String horaFormato = (hora < 10) ? "0" + hora : String.valueOf(hora);
            String minutoFormato = (minuto < 10) ? "0" + minuto : String.valueOf(minuto);
            String segundoFormato = (segundo < 10) ? "0" + segundo : String.valueOf(segundo);

            IO.print("\r-> Cronometro: "+horaFormato+":"+minutoFormato+":"+segundoFormato);
        }

    }
}
