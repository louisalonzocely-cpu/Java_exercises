/*
 * Escribe un programa que muestre por consola (con un print) los
 * números de 1 a 100 (ambos incluidos y con un salto de línea entre
 * cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 */

public class FizzBuzz {
    public static void main(String[] args) {
        //Inicializamos un ciclo for que itere desde 1 hasta 100
        for (int i = 1; i < 101; i++) {            
            //Declaramos dods variables para validar por iteracion si son nultiplos de 3 y de 5
            var multiploDeTres = i % 3 == 0 ;
            var multiploDeCinco = i % 5 == 0;
             //aplicamos la primera condicion: si es multiplo de cinco y de tres imprima un mensaje al lado del numero
            if (multiploDeTres && multiploDeCinco) {
                System.out.println(i + " fizzbuzz");
                //si es multiplo de cinco imprima buzz al lado del numero
            } else if (multiploDeCinco) {
                System.out.println(i + " buzz");
                //si es multiplo de tres, imprima fizz al lado del numero
            } else if (multiploDeTres) {
                System.out.println(i + " fizz");
                //si el numero no cumple con nunguna de las tres condiciones, solo imprima el numero
            } else {
                System.out.println(i);
            }
        }
        
    }
}
