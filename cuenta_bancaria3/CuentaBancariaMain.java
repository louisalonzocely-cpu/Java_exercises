package cuenta_bancaria3;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CuentaBancariaMain {

    static List<CuentaBancaria> cuentas = new ArrayList<>();
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        int opcion;

        do {
            clearConsole();
            menuPrincipal();
            opcion = validarDatoEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> registrarCuenta();
                case 2 -> depositar();
                case 3 -> retirar();
                case 4 -> tranferir();
                case 5 -> historial();
                case 6 -> consultarSaldo();
                case 0 -> System.out.println("\n-> Gracias por usar nuestro sistema.");
                    
                default -> System.out.println("\n-> Opcion invalida.");
            }

        } while (opcion != 0);

    }

    //-------------- Metodos de logica de servicio ---------------

    //Metodo para el menu
    public static void menuPrincipal() throws Exception {
        clearConsole();
        System.out.printf("""
                \n***** Banco SENA *****
                -> Menu Principal
                1. Crear cuenta
                2. Depositar
                3. Retirar
                4. Tranferir
                5. Historial de transacciones
                6. Consultar saldo
                0. Salir
                """);
    }

    //Metodo para registrar cuentas
    public static void registrarCuenta() throws Exception {
        clearConsole();
        System.out.println("\n-> Crear cuentas:\n");
        Long numeroCuenta = validarDatoLong("Numero de cuenta: ");
        if (validarDuplicados(numeroCuenta)) {
            System.out.println("\n-> ERROR: La cuenta ya se encuentra registrada.");
        } else {
            String titular = validarCampoVacio("Nombre del titular: ");
            BigDecimal saldo = validarDatoBigDecimal("Saldo inicial: $");

            cuentas.add(new CuentaBancaria(numeroCuenta, titular, saldo, 0, 0, 0));

            System.out.println("\n-> Cuenta creada exitosamente.");
        }
        pausar();
    }

    //Metodo para depositar
    public static void depositar() throws Exception {
        clearConsole();
        System.out.println("\n-> Depositar:\n");
        if (cuentas.isEmpty()) {
            System.out.println("\n-> Aun no hay cuentas registradas.");      
        } else {
            Long buscarCuenta = validarDatoLong("Numero de cuenta: ");
            boolean encontrado = false;
            for (CuentaBancaria c : cuentas) {
                if (c.getNumeroCuenta().equals(buscarCuenta)) {
                    encontrado = true;
                    BigDecimal monto = validarDatoBigDecimal("Monto a depositar: $");
                    c.depositar(monto);
                    System.out.println("\n-> Deposito exitoso.");
                    System.out.println("-> Nuevo saldo: $" + c.getSaldo());
                    break;
                } 
            }
            if (!encontrado) {
                System.out.println("\n-> Numero de cuenta no encontrado.");
            }
            
        }
        pausar();
    }

    //Metodo para retirar
    public static void retirar() throws Exception {
        clearConsole();
        System.out.println("\n-> Retirar:\n");
        if (cuentas.isEmpty()) {
            System.out.println("\n-> Aun no hay cuentas registradas.");
        } else {
            Long buscarCuenta = validarDatoLong("Numero de cuenta: ");
            boolean encontrado = false;
            
            for (CuentaBancaria c : cuentas) {
                if (c.getNumeroCuenta().equals(buscarCuenta)) {
                    BigDecimal monto = validarDatoBigDecimal("Monto a retirar: ");
                    encontrado = true;
                    if (c.retirar(monto)) {
                        System.out.println("\n-> Retiro exitoso.");
                        System.out.println("Nuevo saldo: " + c.getSaldo());
                    } else {
                        System.out.println("\n-> Saldo insuficiente.");
                    }
                    break;
                } 
            }
            if (!encontrado) {
                System.out.println("\n-> Numero de cuenta no encontrado.");
            }
        }
        pausar();
    }

    //Metodo para ver el conteo de transacciones
    public static void conteoDeTransacciones(CuentaBancaria cuenta) {
        System.out.println(cuenta);
        System.out.printf("""
                Total depositos: %d
                Total retiros: %d
                Total transferencias: %d
                """, cuenta.getTotalDepositos(), cuenta.getTotalRetiros(), cuenta.getTotalTranferencias());
    }

    //Metodo historial de transacciones
    public static void historial() throws Exception {
        clearConsole();
        int cont = 0;
        boolean encontrado = false;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("\n-> Historial de transacciones:");
        if (cuentas.isEmpty()) {
            System.out.println("\n-> Aun no hay cuentas registradas.");
        } else {
            Long buscarCuenta = validarDatoLong("Numero de cuenta: ");
            for (CuentaBancaria c : cuentas) {
                if (c.getNumeroCuenta().equals(buscarCuenta)) {
                    encontrado = true;
                    for (Transacciones t : c.getHistorial()) {
                        System.out.printf("""
                        \n-> Transaccion # %d
                        Tipo de transaccion: %s
                        Monto: $%s
                        Fecha: %s
                        """, cont + 1, t.getTipo(), t.getMonto(), t.getFecha().format(formato));
                        cont++;
                    }
                    conteoDeTransacciones(c);
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("\n-> Cuenta no encontrada.");
            }
        }
        pausar();
    }

    //Metodo para tranferir();
    public static void tranferir() throws Exception {
        clearConsole();
        if (cuentas.isEmpty()) {
            System.out.println("\n-> Aun no hay cuentas registradas.");
        } else {
            Long numeroCuentaOrigen = validarDatoLong("Numero de cuenta origen: ");
            Long numeroCuentaDestino = validarDatoLong("Numero de cuenta destino: ");
            BigDecimal monto = validarDatoBigDecimal("Cantidad a transferir: $");

            CuentaBancaria numeroDestino = null;
            CuentaBancaria numeroOrigen = null;

            for (CuentaBancaria c : cuentas) {
                if (c.getNumeroCuenta().equals(numeroCuentaOrigen)) {
                    numeroOrigen = c;
                }
                if (c.getNumeroCuenta().equals(numeroCuentaDestino)) {
                    numeroDestino = c;
                }
            }

            if (numeroOrigen == null) {
                System.out.println("\n-> Cuenta no registrada.");
            } else if (numeroDestino == null) {
                System.out.println("\n-> Cuenta no registrada.");
            } else if (numeroOrigen.equals(numeroDestino)) {
                System.out.println("\n-> ERROR: Numero de cuentas iguales.");
            } else if (numeroOrigen.tranferir(numeroDestino, monto)) {
                System.out.printf("""
                        \n-> Tranferencia exitosa
                        Tranferiste $%s a la cuenta de %s
                        Nuevo saldo: $%s
                        """, monto, numeroDestino.getTitular(), numeroOrigen.getSaldo());
            } else {
                System.out.println("\n-> ERROR: Saldo insuficiente.");
            }
        }
        pausar();
    }

    //Metodo para consultar saldo
    public static void consultarSaldo() throws Exception {
        clearConsole();
        boolean encontrada = false;
        System.out.println("\n-> Consultar saldo:\n");
        if (cuentas.isEmpty()) {
            System.out.println("\n-> Aun no hay cuentas registradas.");
        } else {
            Long numeroCuentaConsultar = validarDatoLong("Numero de cuenta: ");
            for (CuentaBancaria c : cuentas) {
                if (c.getNumeroCuenta().equals(numeroCuentaConsultar)) {
                    encontrada = true;
                    System.out.println("\nSu saldo es de $" + c.getSaldo());
                } 
            }
            if (!encontrada) {
                System.out.println("\n-> Cuenta no registrada.");
            }
        }
        pausar();
    }



    //--------------------- Metodos de validacion ------------------------

    //Metodo para validar campo vacio
    public static String validarCampoVacio(String mensaje) {
        String input;
        do {
            System.out.print(mensaje);
            input = console.nextLine();
            if (input.isEmpty()) {
                System.out.println("\n-> ERROR: Campo vacio.");
            }
        } while (input.isEmpty());
        return input;
    }

    //Metodo para validar dato entero
    public static int validarDatoEntero(String mensaje) {
        while (true) {
           try {
                int input = Integer.parseInt(validarCampoVacio(mensaje));
                if (input < 0) {
                    System.out.println("\n-> ERROR: Dato negativo.");
                 } else {
                    return input;
                 }
            } catch (NumberFormatException e) {
                System.out.println("\n-> ERROR: Dato no numerico.");
            }
        }
    }

    //Metodo para validar dato BigDecimal
    public static BigDecimal validarDatoBigDecimal(String mensaje) {
        while (true) {
            try {
                BigDecimal input = new BigDecimal(validarCampoVacio(mensaje));
                if (input.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("\n-> ERROR: Dato negativo.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                 System.out.println("\n-> ERROR: Dato no numerico.");
            }
        }
    }

    //Metodo para validar dato Long
    public static Long validarDatoLong(String mensaje) {
        while (true) {
            try {
                Long input = Long.parseLong(validarCampoVacio(mensaje));
                if (input < 0) {
                    System.out.println("\n-> ERROR: Dato negativo.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                 System.out.println("\n-> ERROR: Dato no numerico.");
            }
        }
    }

    //Metodo para valida cuentas duplicadas
    public static boolean validarDuplicados(Long numeroCuenta) {
        for (CuentaBancaria c : cuentas) {
            if (c.getNumeroCuenta().equals(numeroCuenta)) {
                return true;
            }
        }
        return false;
    }

    //Metodo para limpiar pantalla en consola
    public static void clearConsole() throws Exception {
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    }

    //Metodo para pausar
    public static void pausar() {
        System.out.print("\n-> Presione enter para continuar...");
        console.nextLine();
    }


}
