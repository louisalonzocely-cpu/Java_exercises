import java.util.ArrayList;

public class MainFacturacion {
    public static void main(String[] args) {
        
        ArrayList<Facturacion> facturas = new ArrayList<>();
        FacturacionServices services = new FacturacionServices();

        boolean salir = false;
        
        while (!salir) {
            services.menuFacturacion();
            int opcion = services.validarDatosNumericos("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> services.registrarFactura(facturas);
                case 2 -> services.consultarFacturaPorId(facturas);
                case 3 -> services.modificarFactura(facturas);
                case 4 -> services.eliminarFactura(facturas);
                case 5 -> services.listarFacturas(facturas);
                case 6 -> salir = true;
                default -> IO.println("ERROR: Opcion invalida.");
            }
        }

    }
}
