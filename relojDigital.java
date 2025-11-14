import java.util.Scanner;

class relojDigital {
    public static void main(String[] args) throws InterruptedException {
        try (var console = new Scanner(System.in)) {
            
            IO.println("\n***** RELOJ DIGITAL CON JAVA *****\n");

            IO.println("- Configura el reloj con la hora actual:\n");
            //Solicitamos la configuracion de la hora actual
            IO.print("-> Ingrese la hora (0 a 23): ");
            var hora = Integer.parseInt(console.nextLine());
            IO.print("-> Ingrese los minutos (0 a 60): ");
            var minuto = Integer.parseInt(console.nextLine());
            IO.print("-> Ingrese los segundos (0 a 60): ");
            var segundo = Integer.parseInt(console.nextLine());

            IO.println("-------------------------------------");

            //Iniciamos un ciclo infinito
            while (true) {
                //paramos un segundo por iteracion
                Thread.sleep(1000);
                segundo++; //y sumamos un segundo

                //primera condicion: si llega a 0 los segundos
                if (segundo == 60) {
                    segundo = 0;
                    minuto++;
                }
                //segunda condicion: si minutos llega a 0
                if (minuto == 60) {
                    minuto = 0;
                    hora++;
                }
                //tercera condicion: si hora llega a 24
                if (hora == 24) {
                    hora = 0;
                }

                //con operadores ternario agregamos el cero a la izquierda cuando el numero es de un solo digito
                String horaFormato = (hora < 10) ? "0" + hora : String.valueOf(hora);
                String minutoFormato = (minuto < 10) ? "0" + minuto : String.valueOf(minuto);
                String segundoFormato = (segundo < 10) ? "0" + segundo : String.valueOf(segundo);

                //Imprimimos la hora configurada
                IO.print("\r-> Hora Actual: "+horaFormato+":"+minutoFormato+":"+segundoFormato);
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}