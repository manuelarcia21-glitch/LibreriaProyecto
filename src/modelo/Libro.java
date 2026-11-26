package modelo;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private double precio;
    private int stock;
    private String rutaImagen;

    public Libro(String isbn, String titulo, String autor, String categoria, double precio, int stock, String rutaImagen) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.rutaImagen = rutaImagen;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getRutaImagen() { return rutaImagen; }
}