package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroCompra {
    private final String usuarioComprador;
    private final Libro libro;
    private final int cantidad;
    private final double totalPagado;
    private final String fechaHora;

    public RegistroCompra(String usuarioComprador, Libro libro, int cantidad, double totalPagado) {
        this.usuarioComprador = usuarioComprador;
        this.libro = libro;
        this.cantidad = cantidad;
        this.totalPagado = totalPagado;
        this.fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public String getUsuarioComprador() {
        return usuarioComprador;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public String getFechaHora() {
        return fechaHora;
    }
}