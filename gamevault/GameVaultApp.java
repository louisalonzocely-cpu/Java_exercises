package gamevault;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GameVaultApp {

    static List<VideoJuego> catalogo = new ArrayList<>();
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            clearConsole();
            menuPrincipal();
            opcion = validarDatoNumerico("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> {
                        clearConsole();
                        registrarJuegoConsola();
                        pausar();
                    }
                case 2 -> {
                        clearConsole();
                        registrarJuegoPC();
                        pausar();
                    }
                case 3 -> {
                        clearConsole();
                        registrarJuegoMovil();
                        pausar();
                    }
                case 4 -> {
                        clearConsole();
                        listarVideoJuegos();
                        pausar();
                    }
                case 5 -> {
                        clearConsole();
                        buscarPorTitulo();
                        pausar();
                    }
                case 6 -> {
                        clearConsole();
                        filtrarPorPrecio();
                        pausar();
                    }
                case 7 -> {
                        clearConsole();
                        System.out.println(estadistica());
                        pausar();
                    }
                case 8 -> {
                        clearConsole();
                        eliminarJuego();
                        pausar();
                    }
                case 9 -> {
                        clearConsole();
                        ordenarLista();
                        pausar();
                    }
                case 10 -> {
                        clearConsole();
                        listaJuegosGratuitos();
                        pausar();
                    }
                case 11 -> {
                        clearConsole();
                        actulizarPrecio();
                        pausar();
                    }
                case 0 -> { 
                    System.out.println("\n-> Gracias por usar nuestro sistema...\n"); 
                    break;
                    }

                default -> System.out.println("\n-> ERROR: Opcion invalida.");
            }

        } while (opcion != 0);
    }



    //Metodo para el menu principal
    public static void menuPrincipal() {
        System.out.printf("""
                \n***** Tienda GameVault *****\n
                -> Menu Principal
                1. Registrar juego de consola
                2. Registrar juego de PC
                3. Registrar juego Movil
                4. Listar todos los juegos
                5. Buscar por titulo
                6. Filtrar por rango de precio
                7. Estadistica del catalogo
                8. Eliminar juego por titulo
                9. Ordenar juegos por precio
                10. Lista de juegos gratuitos
                11. Actualizar precio
                0. Salir
                """);
    }

    //Metodo para solicitar datos comunes del juego
    public static Object[] solicitarDatosComunes() {
        String titulo = validarCampoVacio("Titulo: ");
        String genero = validarCampoVacio("Genero: ");
        BigDecimal precio = validarDatoBigDecimal("Precio: $COP");
        int anioLanzamiento = validarDatoNumerico("Año de lanzamiento: ");
        double calificacion = validarCalificacion("Calificacion: ⭐ ");

        return new Object[]{titulo, genero, precio, anioLanzamiento, calificacion};
    }

    //Metodo para registrar Juego de consola
    public static void registrarJuegoConsola() {
        System.out.println("\n-> Registrar Juego de consola:");
        Object[] o = solicitarDatosComunes();
        String consola = validarCampoVacio("Tipo consola: ");
        String requiereInternet = validarRespuesta("¿Requiere internet?(si/no): ");

        JuegoConsola juegoConsola = new JuegoConsola((String) o[0], (String) o[1], (BigDecimal) o[2], 
        (int) o[3], (double) o[4], consola, requiereInternet);
        
        catalogo.add(juegoConsola);
        System.out.println("\n-> Juego agregado correctamente.");
    }

    //Metodo para registrar Juego de PC
    public static void registrarJuegoPC() {
        System.out.println("\n-> Registrar Juego de PC:");
        Object[] o = solicitarDatosComunes();
        int ramMinimaGB = validarDatoNumerico("Minima de RAM en GB: ");
        int almacenamientoGB = validarDatoNumerico("Almacenamiento en GB: ");

        JuegoPC juegoPC = new JuegoPC((String) o[0], (String) o[1], (BigDecimal) o[2], 
        (int) o[3], (double) o[4], ramMinimaGB, almacenamientoGB);
        
        catalogo.add(juegoPC);
        System.out.println("\n-> Juego agregado correctamente.");
    }

    //Metodo para registrar Juego de Movil
    public static void registrarJuegoMovil() {
        System.out.println("\n-> Registrar Juego Movil:");
        Object[] o = solicitarDatosComunes();
        String esGratuito = validarRespuesta("¿Juego gratuito?(si/no): ");
        String tieneCompra = validarRespuesta("¿Tiene compra en linea?(si/no): ");

        JuegoMovil juegoMovil = new JuegoMovil((String) o[0], (String) o[1], (BigDecimal) o[2], 
        (int) o[3], (double) o[4], esGratuito, tieneCompra);
        
        catalogo.add(juegoMovil);
        System.out.println("\n-> Juego agregado correctamente.");
    }

    //Metodo para listar todos los video juegos
    public static void listarVideoJuegos() {
        System.out.println("\n-> Lista de juegos:");
        if (catalogo.isEmpty()) {
           System.out.println("\n-> Aun no hay registros.");
        } else {
            for (VideoJuego v : catalogo) {
                System.out.println(v.toString());
            }
        }
    }

    //Metodo para buscar por titulo de video juego
    public static void buscarPorTitulo() {
        System.out.println("\n-> Buscar juego por titulo:");

        if (catalogo.isEmpty()) {
            System.out.println("\n-> Aun no hay registros.");
        } else {
            String buscarTitulo = validarCampoVacio("Titulo a buscar: ");

            boolean encontrado = false;

            for (VideoJuego v : catalogo) {
                if (v.getTitulo().equalsIgnoreCase(buscarTitulo)) {
                    System.out.println(v.toString());
                    encontrado = true;
                } 
            }

            if (!encontrado) {
                System.out.println("\n-> Titulo no encontrado.");
            }
        }
        
    }

    //Metodo para filtrar por precio
    public static void filtrarPorPrecio() {
        System.out.println("\n-> Filtrar por precio:");
        if (catalogo.isEmpty()) {
            System.out.println("\n-> Aun no hay registros.");
        } else {
            BigDecimal valorMinimo = validarDatoBigDecimal("Precio minimo: $");
            BigDecimal valorMaximo = validarDatoBigDecimal("Precio maximo: $");

            if (valorMinimo.compareTo(valorMaximo) > 0) {
                System.out.println("\n-> ERROR: El precio minimo no puede ser mayor al precio maximo.");
                return;
            }

            boolean encontrado = false;
            for (VideoJuego v : catalogo) {
                if (v.getPrecio().compareTo(valorMinimo) >= 0 && v.getPrecio().compareTo(valorMaximo) <= 0) {
                    System.out.println(v.toString());
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("\n-> Juegos no encontrados.");
            }
        }
    }

    //Metodo para saber cantidad de juegos de consola
    public static int cantidadJuegosConsola() {
        int contJuegoConsola = 0;
        for (VideoJuego v : catalogo) {
            String tipo = v.getClass().getSimpleName();
            if (tipo.equals("JuegoConsola")) contJuegoConsola ++;
        }
        return contJuegoConsola;
    }

    //Metodo para saber cantidad de juegos de PC
    public static int cantidadJuegosPC() {
        int contJuegoPC = 0;
        for (VideoJuego v : catalogo) {
            String tipo = v.getClass().getSimpleName();
            if (tipo.equals("JuegoPC")) contJuegoPC ++;
        }
        return contJuegoPC;
    }

    //Metodo para saber cantidad de juegos Moviles
    public static int cantidadJuegoMovil() {
        int contJuegoMovil = 0;
        for (VideoJuego v : catalogo) {
            String tipo = v.getClass().getSimpleName();
            if (tipo.equals("JuegoMovil")) contJuegoMovil ++;
        }
        return contJuegoMovil;
    }

    //Metodo para listar los juegos gratuitos
    public static void listaJuegosGratuitos() {
        System.out.println("\n-> Lista de juegos gratuitos:");
        if (catalogo.isEmpty()) {
            System.out.println("\n-> Aun no hay registros.");
            return;
        }
        boolean encontrado = false;
        for (VideoJuego v : catalogo) {
            boolean esGratisPrecio = v.getPrecio().compareTo(BigDecimal.ZERO) == 0;
            boolean esGratisMovil = v instanceof JuegoMovil && ((JuegoMovil) v).getEsGratuito().equalsIgnoreCase("si");

            if (esGratisPrecio || esGratisMovil) {
                System.out.println(v.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("\n-> Juegos no encontrados.");
        }
    }

    //Metodo para actulizar el precio
    public static void actulizarPrecio() {
        System.out.println("\n-> Actualizar precio:");
        if (catalogo.isEmpty()) {
            System.out.println("\n-> Aun no hay registros.");
            return;
        }
        String actualizarJuego = validarCampoVacio("Titulo del juego actualizar: ");
        for (VideoJuego v : catalogo) {
            if (v.getTitulo().equalsIgnoreCase(actualizarJuego)) {
                BigDecimal nuevoPrecio = validarDatoBigDecimal("Nuevo precio($COP" + v.getPrecio() + "): $COP");
                v.setPrecio(nuevoPrecio);
            }
        }
        System.out.println("\n-> Precio actualizado correctamente.");
    }

    //Metodo para calcular el precio promedio
    public static BigDecimal calcularPrecioPromedio() {
        BigDecimal sumaPrecios = BigDecimal.ZERO;
        int totalJuegos = catalogo.size();
        for (VideoJuego v : catalogo) {
            sumaPrecios = sumaPrecios.add(v.getPrecio());
        }
        return sumaPrecios.divide(new BigDecimal(totalJuegos));
    }

    //Metodo para saber el juego mas caro
    public static String masCaro() {
        VideoJuego masCaro = catalogo.get(0);
        for (VideoJuego v : catalogo) {
            if (v.getPrecio().compareTo(masCaro.getPrecio()) > 0) {
                masCaro = v;
            }
        }
        return "-> Juego mas caro:" + "\n" +
               "| Nombre: " + masCaro.getTitulo() + "\n" +
               "| Precio: " + masCaro.getPrecio(); 
    }

    //Metodo para saber el juego con mayor calificacion
    public static String mayorCalificacion() {
        VideoJuego mayorCalificacion = catalogo.get(0);
        String estrellas = mayorCalificacion.multiplicarEstrellas();
        for (VideoJuego v : catalogo) {
            if (v.getCalificacion() > mayorCalificacion.getCalificacion()) {
                mayorCalificacion = v;
            }
        }
        return "-> Juego con mejor calificacion:" + "\n" +
               "| Nombre: " + mayorCalificacion.getTitulo() + "\n" +
               "| Calificacion: " + mayorCalificacion.getCalificacion() + " " + estrellas;
    }

    //Metodo para estadistica()
    public static String estadistica() {
        System.out.println("\n-> Estadisticas:");
        if (catalogo.isEmpty()) {
            System.out.println("\n-> Aun no hay registros.");
        }
        return "\n| Total de Juegos registrados: " + catalogo.size() + "\n" +
               "| Total Juegos de consola: " + cantidadJuegosConsola() + "\n" +
               "| Total Juegos de PC: " + cantidadJuegosPC() + "\n" +
               "| Total Juegos moviles: " + cantidadJuegoMovil() + "\n" +
               "| Precio promedio: $COP" + calcularPrecioPromedio() + "\n" +
               "| " + masCaro() + "\n" +
               "| " + mayorCalificacion();
    }

    //Metodo para eliminar juegos
    public static void eliminarJuego() {
        System.out.println("\n-> Eliminar juego:");

        if (catalogo.isEmpty()) {
            System.out.println("\n-> Aun no hay registros.");
            return;
        }

        String tituloEliminar = validarCampoVacio("Titulo del juego a eliminar: ");
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getTitulo().equalsIgnoreCase(tituloEliminar)) {
                catalogo.remove(i);
                break;
            } else {
                System.out.println("\n-> Juego no encontrado.");
            }
        }
    }

    //Metodo para ordenar la lista
    public static void ordenarLista() {
        System.out.println("\n-> Ordenar juegos por precio:");

        if (catalogo.isEmpty()) {
            System.out.println("\n-> Aun no hay registros.");
            return;
        }

        Comparator<VideoJuego> ordenadoPorPrecio = Comparator.comparing(VideoJuego::getPrecio);

        catalogo.sort(ordenadoPorPrecio);

        listarVideoJuegos();
    }




    //------------------------- Metodos de validacion -------------------------------


    //Metodo para validar la respuesta
    public static String validarRespuesta(String mensaje) {
        while (true) {
            String input = validarCampoVacio(mensaje).trim();
            if (!input.equalsIgnoreCase("no") && !input.equalsIgnoreCase("si")) {
                System.out.println("\n-> ERROR: Respuesta invalida.");
            } else {
                return input;
            }
        }
    }

    //Metodo para validar campos vacios
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

    //Metodo para validar datos BigDecimal
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

    //Metodo para validar datos numericos
    public static int validarDatoNumerico(String mensaje) {
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

    //Metodo para validar datos numericos
    public static double validarDatoDouble(String mensaje) {
        while (true) {
            try {
                double input = Double.parseDouble(validarCampoVacio(mensaje));
                if (input < 0) {
                   System.out.println("\n-> ERROR: Dato negativo.");
                } else {
                    return input;
                }
            } catch (Exception e) {
                System.out.println("\n-> ERROR: Dato no numerico.");
            }
        }
    }

    //Metodo para validar calificacion
    public static double validarCalificacion(String mensaje) {
        while (true) {
           double input = validarDatoDouble(mensaje);
           if (input < 0 || input > 5) {
              System.out.println("\n-> ERROR: Calificacion fuera de rango.");
           } else {
                return input;
           }
        }
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
