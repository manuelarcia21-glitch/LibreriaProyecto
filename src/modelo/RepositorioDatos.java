package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RepositorioDatos {

    private static final String ARCHIVO_LIBROS = "datos_libros.txt";
    private static final String ARCHIVO_HISTORIAL = "datos_historial.txt";

    private static ArrayList<Libro> libros;
    private static ArrayList<RegistroCompra> historial;
    private static boolean inicializado = false;
    private static boolean inicializando = false;

    private RepositorioDatos() {
    }

    public static void inicializar() {
        if (inicializado || inicializando) {
            return;
        }
        inicializando = true;
        try {
            libros = new ArrayList<>();
            historial = new ArrayList<>();

            leerLibrosInterno();
            if (libros.isEmpty()) {
                cargarLibrosPorDefecto();
                escribirLibrosInterno();
            }

            leerHistorialInterno();
            inicializado = true;
        } finally {
            inicializando = false;
        }
    }

    public static ArrayList<Libro> getLibros() {
        if (!inicializado && !inicializando) {
            inicializar();
        }
        return libros;
    }

    public static ArrayList<RegistroCompra> getHistorial() {
        if (!inicializado && !inicializando) {
            inicializar();
        }
        return historial;
    }

    private static void cargarLibrosPorDefecto() {
        libros.add(new Libro("978-0134685991", "Effective Java", "Joshua Bloch", "Programación", 45.00, 12, "img/effective_java.jpg"));
        libros.add(new Libro("978-0132350884", "Clean Code", "Robert C. Martin", "Programación", 38.50, 8, "img/clean_code.jpg"));
        libros.add(new Libro("978-0307474728", "Cien años de soledad", "Gabriel García Márquez", "Literatura", 24.00, 15, "img/cien_anos.jpg"));
    }

    public static void guardarLibrosEnArchivo() {
        if (!inicializado && !inicializando) {
            inicializar();
        }
        escribirLibrosInterno();
    }

    private static void escribirLibrosInterno() {
        if (libros == null) {
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_LIBROS))) {
            for (Libro l : libros) {
                String linea = escapar(l.getIsbn()) + "|"
                        + escapar(l.getTitulo()) + "|"
                        + escapar(l.getAutor()) + "|"
                        + escapar(l.getCategoria()) + "|"
                        + l.getPrecio() + "|"
                        + l.getStock() + "|"
                        + escapar(l.getRutaImagen());
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException ex) {
            System.err.println("Error guardando libros: " + ex.getMessage());
        }
    }

    private static void leerLibrosInterno() {
        File archivo = new File(ARCHIVO_LIBROS);
        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split("\\|", -1);
                if (partes.length >= 7) {
                    String isbn = desescapar(partes[0]);
                    String titulo = desescapar(partes[1]);
                    String autor = desescapar(partes[2]);
                    String categoria = desescapar(partes[3]);
                    double precio = Double.parseDouble(partes[4]);
                    int stock = Integer.parseInt(partes[5]);
                    String rutaImg = desescapar(partes[6]);
                    libros.add(new Libro(isbn, titulo, autor, categoria, precio, stock, rutaImg));
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.err.println("Error cargando libros: " + ex.getMessage());
        }
    }

    public static void registrarCompra(RegistroCompra registro) {
        if (!inicializado && !inicializando) {
            inicializar();
        }
        if (registro != null && historial != null) {
            historial.add(registro);
            escribirHistorialInterno();
        }
    }

    public static void guardarHistorialEnArchivo() {
        if (!inicializado && !inicializando) {
            inicializar();
        }
        escribirHistorialInterno();
    }

    private static void escribirHistorialInterno() {
        if (historial == null) {
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_HISTORIAL))) {
            for (RegistroCompra r : historial) {
                if (r.getLibro() == null) {
                    continue;
                }
                String linea = escapar(r.getUsuarioComprador()) + "|"
                        + escapar(r.getLibro().getIsbn()) + "|"
                        + escapar(r.getLibro().getTitulo()) + "|"
                        + escapar(r.getLibro().getAutor()) + "|"
                        + escapar(r.getLibro().getCategoria()) + "|"
                        + r.getLibro().getPrecio() + "|"
                        + r.getLibro().getStock() + "|"
                        + escapar(r.getLibro().getRutaImagen()) + "|"
                        + r.getCantidad() + "|"
                        + r.getTotalPagado() + "|"
                        + escapar(r.getFechaHora());
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException ex) {
            System.err.println("Error guardando historial: " + ex.getMessage());
        }
    }

    private static void leerHistorialInterno() {
        File archivo = new File(ARCHIVO_HISTORIAL);
        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split("\\|", -1);
                if (partes.length >= 11) {
                    String comprador = desescapar(partes[0]);
                    Libro lib = new Libro(
                            desescapar(partes[1]),
                            desescapar(partes[2]),
                            desescapar(partes[3]),
                            desescapar(partes[4]),
                            Double.parseDouble(partes[5]),
                            Integer.parseInt(partes[6]),
                            desescapar(partes[7])
                    );
                    int cantidad = Integer.parseInt(partes[8]);
                    double total = Double.parseDouble(partes[9]);

                    RegistroCompra reg = new RegistroCompra(comprador, lib, cantidad, total);
                    historial.add(reg);
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.err.println("Error cargando historial: " + ex.getMessage());
        }
    }

    private static String escapar(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.replace("\\", "\\\\").replace("|", "\\p").replace("\n", "\\n");
    }

    private static String desescapar(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.replace("\\n", "\n").replace("\\p", "|").replace("\\\\", "\\");
    }
}