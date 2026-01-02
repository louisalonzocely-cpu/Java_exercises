import java.util.Random;

public class ordenamientoNumAleatorios {
    static void main(String[] args) {

        var aleatorios = new Random();

        var numAleatorios = new int[30];

        //almacenamos los numeros aleatorios e imprimimos
        for (int i = 0; i < numAleatorios.length; i++) {
            numAleatorios[i] = aleatorios.nextInt(0,99);
            if (i == 0){
                IO.print("\n-> Arreglo numero aleatorios:               ");
            }
            IO.print("["+numAleatorios[i]+"] ");
        }

        //organizamos los numeros aleatorios
        for (int i = 0; i < numAleatorios.length - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < numAleatorios.length; j++) {
                if (numAleatorios[j] < numAleatorios[indiceMenor]){
                    indiceMenor = j;
                }
            }

            if (indiceMenor != i){
                int temp = numAleatorios[i];
                numAleatorios[i] = numAleatorios[indiceMenor];
                numAleatorios[indiceMenor] = temp;
            }
        }

        //imprimimos los numero aleatorios organizados
        for (int i = 0; i < numAleatorios.length; i++) {
            if (i == 0){
                IO.print("\n-> Arreglo de numeros aleatorios ordenados: ");
            }
            IO.print("["+numAleatorios[i]+"] ");
        }
        IO.print("\n");
    }
}
