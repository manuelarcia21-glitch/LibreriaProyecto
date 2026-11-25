package vista;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import modelo.RegistroCompra;
import modelo.RepositorioDatos;

public class AdminView extends javax.swing.JFrame {

    private final ArrayList<Libro> listaLibros;
    private final ArrayList<RegistroCompra> historialCompras;
    private final CatalogoView catalogoPadre;
    private final String usuarioAdmin;
    private DefaultTableModel modeloTabla;
    
    public AdminView() {
        this(RepositorioDatos.getLibros(), RepositorioDatos.getHistorial(), null, "admin");
    }

public AdminView(ArrayList<Libro> listaLibros,
                     ArrayList<RegistroCompra> historialCompras,
                     CatalogoView catalogoPadre,
                     String usuarioAdmin) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.listaLibros = (listaLibros != null) ? listaLibros : RepositorioDatos.getLibros();
        this.historialCompras = (historialCompras != null) ? historialCompras : RepositorioDatos.getHistorial();
        this.catalogoPadre = catalogoPadre;
        this.usuarioAdmin = (usuarioAdmin != null && !usuarioAdmin.isBlank()) ? usuarioAdmin : "admin";

        this.setTitle("Marketplace y Gestión de Inventario - Usuario: " + this.usuarioAdmin);
        if (txtRutaImagen != null && txtRutaImagen.getText().isBlank()) {
            txtRutaImagen.setText("img/portada.jpg");
        }

        configurarTabla();
        refrescarTabla();
    }

private void configurarTabla() {
        modeloTabla = new DefaultTableModel(
                new Object[]{"ISBN", "Título", "Autor", "Categoría", "Precio", "Stock", "Compradores"},
                0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblAdminLibros.setModel(modeloTabla);
    }
public int contarCompradoresPorLibro(String isbn) {
        HashSet<String> compradores = new HashSet<>();
        for (RegistroCompra reg : historialCompras) {
            if (reg.getLibro() != null && isbn.equals(reg.getLibro().getIsbn())) {
                compradores.add(reg.getUsuarioComprador());
            }
        }
        return compradores.size();
    }
private int contarUnidadesVendidas(String isbn) {
        int totalUnidades = 0;
        for (RegistroCompra reg : historialCompras) {
            if (reg.getLibro() != null && isbn.equals(reg.getLibro().getIsbn())) {
                totalUnidades += reg.getCantidad();
            }
        }
        return totalUnidades;
    }
private void refrescarTabla() {
        modeloTabla.setRowCount(0);
        for (Libro l : listaLibros) {
            int compradores = contarCompradoresPorLibro(l.getIsbn());
            modeloTabla.addRow(new Object[]{
                l.getIsbn(),
                l.getTitulo(),
                l.getAutor(),
                l.getCategoria(),
                String.format("%.2f", l.getPrecio()),
                l.getStock(),
                compradores
            });
        }
    }
private Libro buscarLibroPorIsbn(String isbn) {
        for (Libro l : listaLibros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

private void limpiarCampos() {
        txtIsbn.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtCategoria.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtRutaImagen.setText("img/portada.jpg");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JScrollPane = new javax.swing.JScrollPane();
        tblAdminLibros = new javax.swing.JTable();
        txtIsbn = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtRutaImagen = new javax.swing.JTextField();
        btnAgregarLibro = new javax.swing.JButton();
        btnActualizarStock = new javax.swing.JButton();
        btnEliminarLibro = new javax.swing.JButton();
        btnVerCompradores = new javax.swing.JButton();
        btnVolverCatalogo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAdminLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JScrollPane.setViewportView(tblAdminLibros);

        txtIsbn.addActionListener(this::txtIsbnActionPerformed);

        txtPrecio.addActionListener(this::txtPrecioActionPerformed);

        btnAgregarLibro.setText("Agregar libro");
        btnAgregarLibro.addActionListener(this::btnAgregarLibroActionPerformed);

        btnActualizarStock.setText("Actualizar stock");
        btnActualizarStock.addActionListener(this::btnActualizarStockActionPerformed);

        btnEliminarLibro.setText("Eliminar libro");
        btnEliminarLibro.addActionListener(this::btnEliminarLibroActionPerformed);

        btnVerCompradores.setText("Historial compra");
        btnVerCompradores.addActionListener(this::btnVerCompradoresActionPerformed);

        btnVolverCatalogo.setText("Volver");
        btnVolverCatalogo.addActionListener(this::btnVolverCatalogoActionPerformed);

        jLabel1.setText("ISBN:");

        jLabel2.setText("Titulo:");

        jLabel3.setText("Autor:");

        jLabel4.setText("Categoria:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Stock:");

        jLabel7.setText("Imagen:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(txtTitulo)
                    .addComponent(txtAutor))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnAgregarLibro)
                .addGap(98, 98, 98)
                .addComponent(btnActualizarStock)
                .addGap(78, 78, 78)
                .addComponent(btnEliminarLibro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnVerCompradores)
                .addGap(35, 35, 35)
                .addComponent(btnVolverCatalogo)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarLibro)
                    .addComponent(btnActualizarStock)
                    .addComponent(btnVerCompradores)
                    .addComponent(btnEliminarLibro)
                    .addComponent(btnVolverCatalogo))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsbnActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroActionPerformed
        String isbn = txtIsbn.getText().trim();
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String categoria = txtCategoria.getText().trim();
        String precioStr = txtPrecio.getText().trim();
        String stockStr = txtStock.getText().trim();
        String rutaImg = txtRutaImagen.getText().trim();

        if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty() || categoria.isEmpty()
                || precioStr.isEmpty() || stockStr.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Complete todos los campos obligatorios del libro.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (buscarLibroPorIsbn(isbn) != null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ya existe un libro registrado con ese ISBN.",
                    "ISBN duplicado",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            double precio = Double.parseDouble(precioStr.replace(",", "."));
            int stock = Integer.parseInt(stockStr);

            if (precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "El precio y el stock no pueden ser negativos.",
                        "Valores inválidos",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (rutaImg.isEmpty()) {
                rutaImg = "img/portada.jpg";
            }

            Libro nuevo = new Libro(isbn, titulo, autor, categoria, precio, stock, rutaImg);
            listaLibros.add(nuevo);
            RepositorioDatos.guardarLibrosEnArchivo();
            refrescarTabla();
            limpiarCampos();

            JOptionPane.showMessageDialog(
                    this,
                    "Libro publicado y guardado correctamente en el catálogo.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese valores numéricos válidos para Precio y Stock.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
    }//GEN-LAST:event_btnAgregarLibroActionPerformed

    private void btnActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarStockActionPerformed
int fila = tblAdminLibros.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un libro en la tabla para actualizar su stock.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String isbn = tblAdminLibros.getValueAt(fila, 0).toString();
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro == null) {
            return;
        }

        String nuevoStockStr = JOptionPane.showInputDialog(
                this,
                "Libro: " + libro.getTitulo() + "\nStock actual: " + libro.getStock() + "\n\nIngrese el nuevo stock:",
                "Actualizar Stock",
                JOptionPane.QUESTION_MESSAGE
        );

        if (nuevoStockStr == null) {
            return;
        }

        try {
            int nuevoStock = Integer.parseInt(nuevoStockStr.trim());
            if (nuevoStock < 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "El stock no puede ser negativo.",
                        "Valor inválido",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            libro.setStock(nuevoStock);
            RepositorioDatos.guardarLibrosEnArchivo();
            refrescarTabla();

            JOptionPane.showMessageDialog(
                    this,
                    "Stock actualizado a " + nuevoStock + " unidades.",
                    "Actualizado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese un número entero válido.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnActualizarStockActionPerformed

    private void btnEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLibroActionPerformed
int fila = tblAdminLibros.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un libro en la tabla para eliminarlo.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String isbn = tblAdminLibros.getValueAt(fila, 0).toString();
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro == null) {
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas eliminar '" + libro.getTitulo() + "' del inventario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            listaLibros.remove(libro);
            RepositorioDatos.guardarLibrosEnArchivo();
            refrescarTabla();

            JOptionPane.showMessageDialog(
                    this,
                    "Libro eliminado del inventario.",
                    "Eliminado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_btnEliminarLibroActionPerformed

    private void btnVerCompradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCompradoresActionPerformed
int fila = tblAdminLibros.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un libro para consultar sus compradores.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String isbn = tblAdminLibros.getValueAt(fila, 0).toString();
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro == null) {
            return;
        }

        int distinctBuyers = contarCompradoresPorLibro(isbn);
        int totalUnits = contarUnidadesVendidas(isbn);

        JOptionPane.showMessageDialog(
                this,
                "Libro: " + libro.getTitulo() + " (" + libro.getIsbn() + ")\n"
                + "Compradores distintos: " + distinctBuyers + "\n"
                + "Unidades totales vendidas: " + totalUnits + "\n"
                + "Stock actual: " + libro.getStock(),
                "Estadísticas de Venta del Libro",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_btnVerCompradoresActionPerformed

    private void btnVolverCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverCatalogoActionPerformed
if (catalogoPadre != null) {
            catalogoPadre.actualizarTabla("");
            catalogoPadre.setVisible(true);
        } else {
            CatalogoView catalogo = new CatalogoView(usuarioAdmin);
            catalogo.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnVolverCatalogoActionPerformed

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AdminView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton btnActualizarStock;
    private javax.swing.JButton btnAgregarLibro;
    private javax.swing.JButton btnEliminarLibro;
    private javax.swing.JButton btnVerCompradores;
    private javax.swing.JButton btnVolverCatalogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTable tblAdminLibros;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRutaImagen;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
