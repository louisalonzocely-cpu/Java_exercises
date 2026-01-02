import java.util.Scanner;

public class conversorBinarioDecimal {
    
    public static void main(String[] args) {
        
        var consola = new Scanner(System.in);
        var binario = "";

        IO.print("\n-> Ingrese numero binario a convertir: ");
        binario = consola.nextLine();

        // El método Integer.parseInt() convierte la cadena (String) a un entero (int)
        // El '2' indica que la cadena está en base binaria
        var decimal = Integer.parseInt(binario, 2);

        IO.println("\n-> El numero binario: "+ binario);
        IO.println("-> El numero decimal: "+ decimal);

    }

}
