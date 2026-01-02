import java.util.Scanner;

public class relojDigital {

    public static void main(String[] args) throws InterruptedException {
        var consola = new Scanner(System.in);

        int hora, minuto, segundo;

        IO.println();

        do{
           IO.print("Ingresar la hora (0 a 23): ");
           hora = Integer.parseInt(consola.nextLine());
        } while (hora > 24);

        do{
            IO.print("Ingresar los minutos (0 a 60): ");
            minuto = Integer.parseInt(consola.nextLine());
        }while (minuto > 60); 

        do{
            IO.print("Ingresar los segundos (0 a 60): ");
            segundo = Integer.parseInt(consola.nextLine());
        }while (segundo > 60);

         IO.println();

        while (true) {
            Thread.sleep(1000);
            segundo ++;
            if (segundo == 60) {
                segundo = 0;
                minuto ++;
            }
            if (minuto == 60) {
                minuto = 0;
                hora ++;
            }
            if (hora == 24) {
                hora = 0;
            }

            String horaCadena = (hora < 10) ? "0" + hora : Integer.toString(hora);
            String minutoCadena = (minuto < 10) ? "0" + minuto : String.valueOf(minuto);
            String segundoCadena = (segundo < 10) ? "0" + segundo : String.valueOf(segundo);

            System.out.print("\r\033[0KHora Actual: "+ horaCadena +":"+ minutoCadena +":"+ segundoCadena);
            
        }

    }
    
}
