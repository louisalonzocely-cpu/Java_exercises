import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class FacturacionServices {

    private Scanner console = new Scanner(System.in);

    //metodo para moetrar el menu principal
    public void menuFacturacion() {
        IO.print("""
        \n-> Menu Principal:
        1. Registrar factura.
        2. Consultar factura.
        3. Modificar factura.
        4. Eliminar factura.
        5. Listar facturas.
        6. Salir.
            """);
    }

    //metodo para validar campos vacios de datos 
    public String validarCamposVacios(String mensaje) {
        //declaramos la variable que almacenara el dato
        String input;
        //inicializamos un ciclo que mientras se cumple la condicion se ejecute
        do {
            //solicitamos el dato
            IO.print(mensaje);
            input = console.nextLine();

            //inicializamos la condicion: si el campo esta vacion muestre un mensaje de error
            if (input.isEmpty()) {
                IO.println("ERROR: Campo vacio.");
            }

        } while (input.isEmpty());
        //sino se sale del ciclo y retorna el dato
        return input;
    }

    //metodo para validar datos numericos
    public int validarDatosNumericos(String mensaje) {
        //inicializamos un ciclo que mientras se cumpla la condicion se itere cuantas veces sea necesario
        while (true) {
            //validamos que el dato sea numerico
            try {
                return Integer.parseInt(validarCamposVacios(mensaje));
            } catch (NumberFormatException e) {
                IO.println("ERROR: Dato no numerico.");
            }
        }
    }

    //metodo para validar datos tipo BigDecimal
    public BigDecimal validarDatosBigDecimal(String mensaje) {

        while (true) {
            String input = validarCamposVacios(mensaje);
            try {
                BigDecimal dato = new BigDecimal(input);

                if (dato.compareTo(BigDecimal.ZERO) < 0) {
                    IO.println("ERROR: Valor negativo.");
                } else {
                    return dato;
                }
            } catch (NumberFormatException e) {
                IO.println("ERROR: Dato no numerico.");
            }
        }
    }

    //metodo para validar el tipo de factura
    public TipoFactura validarTipoFactura() {
        //inicializamos un ciclo para iterar cada vez que el dato sea incorrecto
        while (true) {
            //mostramos los tipos de facturas que estan en el enum
            IO.println("Tipo de factura:");
            for (TipoFactura tipo : TipoFactura.values()) {
                IO.println("- " + tipo);
            }
            //validamos que el tipo de factura ingresado sean los del enum
            try {
                return TipoFactura.valueOf(validarCamposVacios("Tipo de factura: ").toUpperCase());
            } catch (IllegalArgumentException e) {
                IO.println("ERROR: Tipo de factura incorrecto.");
            }
        }
    }

    //metodo para realizar un registro de factura
    public void registrarFactura(ArrayList<Facturacion> facturas) {
        
        IO.println("\n-> Registrar facturas:");

        //solicitamos los datos de la factura y realizamos sus validaciones
        int id = validarDatosNumericos("Id de la factura: ");
        String cliente = validarCamposVacios("Nombre del cliente: ");
        TipoFactura tipo = validarTipoFactura();
        BigDecimal valorBase = validarDatosBigDecimal("Valor base: ");

        //aplicamos una condicion de operador ternario para registrar segun el tipo de factura
        Facturacion facturacion = (tipo == TipoFactura.INTERNACIONAL)
        ? new FacturaInternacional(id, cliente, valorBase)
        : new FacturacionNacional(id, cliente, valorBase);

        //almacenamos en el arreglo los datos segun el tipo de factura
        facturas.add(facturacion);
        IO.println("Registro de la efactura exitoso.");

    }

    //metodo para consultar factura por id
    public void consultarFacturaPorId(ArrayList<Facturacion> facturas) {

        IO.println("\n-> Consultar factura:");
        //solicitamos el id de la factura a consultar y validamos el campo
        int id = validarDatosNumericos("Id de la factura: ");

        //inicializamos un ciclo foreach para buscar el registro en el arreglo
        for (Facturacion facturacion : facturas) {
            //evaluamos que el id ingesado sea igual al registrado
            if (facturacion.getId() == id) {
                IO.print("""
                Nombre del cliente: %s
                Tipo de factura: %s
                Valor base: %s
                Impuesto: %s
                Total a pagar: %s
                """.formatted(facturacion.getCliente(), facturacion.getTipoFactura(), facturacion.getValorBase(), facturacion.calcularImpuesto(), facturacion.calcularTotal()));
                return;
            }    
        }
         IO.println("Registro no encontrado.");
    }

    //metodo para modificar una factura registrada
    public void modificarFactura(ArrayList<Facturacion> facturas) {

        IO.println("\n-> Modificar factura:");
        //consultamos la factura que vamos a modificar
        int id = validarDatosNumericos("Id de la factura a modificar: ");

        //inicializamos un ciclo foreach para recorer nuestra lista
        for (Facturacion facturacion : facturas) {
            //aplicamos una condicion, si el id se encuentra en la lista solicite los nuevos datos a modificar
            if (facturacion.getId() == id) {
                //solicitamos los nuevos valores para los atributos 
                String nuevoCliente = validarCamposVacios("Nuevo nombre del cliente: ");
                TipoFactura nuevaFactura = validarTipoFactura();
                BigDecimal nuevoValorBase = validarDatosBigDecimal("Nuevo valor base: ");

                //asignamos los nuevos valores llamando los set
                facturacion.setCliente(nuevoCliente);
                facturacion.setTipoFactura(nuevaFactura);
                facturacion.setValorBase(nuevoValorBase);

                //confirmamos que la factura fue modificada
                IO.println("Factura modificada con exito.");
                return;
            } 
        }
        IO.println("Factura no encontrada.");
    }

    //metodo para eliminar registro de la lista
    public void eliminarFactura(ArrayList<Facturacion> facturas) {

        IO.println("\n-> Eliminar factura:");
        //solicitamos el id de la factura a eliminar
        int id = validarDatosNumericos("Id a eliminar: ");

        //recorremosla lista con un foreach para encontrar la factura
        for (Facturacion facturacion : facturas) {
            //si la factura esta en la lista se cumple la accion dentro de la condicion
            if (facturacion.getId() == id) {
                facturas.remove(facturacion);
                IO.println("Factura eliminada con exito.");
                return;
            }       
        }
        IO.println("La factura no se encuentra registrada.");
    }

    //metodo para listar las facturas registradas
    public void listarFacturas(ArrayList<Facturacion> facturas) {

        int contador = 1;
        //inicializamos un ciclo foreach
        for (Facturacion facturacion : facturas) {
            IO.print("""
            \n-> Factura #%d
            Id factura: %d
            Nombre del cliente: %s
            Tipo de factura: %s
            Valor base: %s
            Impuesto: %s
            Total a pagar: %s
                    """.formatted(contador, facturacion.getId(), facturacion.getCliente(), facturacion.getTipoFactura(),
                    facturacion.getValorBase(), facturacion.calcularImpuesto(), facturacion.calcularTotal()));
            
            contador++;
        }
    }

}
