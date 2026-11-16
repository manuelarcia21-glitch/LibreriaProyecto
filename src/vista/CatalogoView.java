package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;

public class CatalogoView extends javax.swing.JFrame {

    private final ArrayList<Libro> listaLibros = new ArrayList<>();
    private DefaultTableModel modeloTabla;

    public CatalogoView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Catálogo - Librería Virtual");
        configurarTabla();
        cargarLibrosIniciales();
        actualizarTabla("");
    }
private void configurarTabla() {
        modeloTabla = new DefaultTableModel(
            new Object[]{"ISBN", "Título", "Autor", "Categoría", "Precio ($)", "Stock"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Evita que el usuario edite las celdas directamente
            }
        };
        tblLibros.setModel(modeloTabla);
    }

    private void cargarLibrosIniciales() {
        listaLibros.add(new Libro("978-0134685991", "Effective Java", "Joshua Bloch", "Programación", 45.00, 12));
        listaLibros.add(new Libro("978-0132350884", "Clean Code", "Robert C. Martin", "Ingeniería de Software", 38.50, 8));
        listaLibros.add(new Libro("978-8497592208", "Cien años de soledad", "Gabriel García Márquez", "Literatura", 22.00, 15));
        listaLibros.add(new Libro("978-0201633610", "Design Patterns", "Erich Gamma et al.", "Arquitectura", 50.00, 5));
        listaLibros.add(new Libro("978-8445000663", "El Señor de los Anillos", "J.R.R. Tolkien", "Fantasía", 29.90, 10));
    }

    private void actualizarTabla(String filtro) {
        modeloTabla.setRowCount(0);
        String busqueda = filtro.toLowerCase().trim();

        for (Libro libro : listaLibros) {
            boolean coincide = libro.getTitulo().toLowerCase().contains(busqueda)
                    || libro.getAutor().toLowerCase().contains(busqueda)
                    || libro.getCategoria().toLowerCase().contains(busqueda);

            if (busqueda.isEmpty() || coincide) {
                modeloTabla.addRow(new Object[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getCategoria(),
                    String.format("%.2f", libro.getPrecio()),
                    libro.getStock()
                });
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        btnVerDetalle = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLibros);

        btnVerDetalle.setText("Ver detalles del libro");
        btnVerDetalle.addActionListener(this::btnVerDetalleActionPerformed);

        btnCerrarSesion.setText("Cerrar sesion");
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        jLabel1.setText("CATÁLOGO DE LIBROS DISPONIBLES");

        jLabel2.setText("Buscador:");

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(this::btnComprarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(397, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnComprar)
                        .addGap(71, 71, 71)
                        .addComponent(btnVerDetalle)
                        .addGap(92, 92, 92)
                        .addComponent(btnCerrarSesion)
                        .addGap(20, 20, 20))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerDetalle)
                    .addComponent(btnCerrarSesion)
                    .addComponent(btnComprar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
new LoginView().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
actualizarTabla(txtBuscar.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
int filaSeleccionada = tblLibros.getSelectedRow();
    
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un libro de la tabla primero.", "Sin selección", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String isbn = tblLibros.getValueAt(filaSeleccionada, 0).toString();
    String titulo = tblLibros.getValueAt(filaSeleccionada, 1).toString();
    String autor = tblLibros.getValueAt(filaSeleccionada, 2).toString();
    String categoria = tblLibros.getValueAt(filaSeleccionada, 3).toString();
    String precio = tblLibros.getValueAt(filaSeleccionada, 4).toString();
    String stock = tblLibros.getValueAt(filaSeleccionada, 5).toString();

    String info = "ISBN: " + isbn + "\n"
                + "Título: " + titulo + "\n"
                + "Autor: " + autor + "\n"
                + "Categoría: " + categoria + "\n"
                + "Precio: $" + precio + "\n"
                + "Unidades disponibles: " + stock;

    JOptionPane.showMessageDialog(this, info, "Ficha del Libro", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
    int filaSeleccionada = tblLibros.getSelectedRow();
    
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro de la tabla para realizar la compra.", "Sin selección", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Obtener el ISBN de la fila seleccionada en la tabla
    String isbnTabla = tblLibros.getValueAt(filaSeleccionada, 0).toString();

    // Buscar el libro correspondiente en la lista general de objetos
    Libro libroSeleccionado = null;
    for (Libro l : listaLibros) {
        if (l.getIsbn().equals(isbnTabla)) {
            libroSeleccionado = l;
            break;
        }
    }

    if (libroSeleccionado == null) return;

    if (libroSeleccionado.getStock() <= 0) {
        JOptionPane.showMessageDialog(this, "Lo sentimos, este libro se encuentra agotado.", "Sin stock", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Solicitar la cantidad a comprar mediante una ventana emergente
    String cantidadStr = JOptionPane.showInputDialog(this, 
        "Libro: " + libroSeleccionado.getTitulo() + "\n" +
        "Stock disponible: " + libroSeleccionado.getStock() + "\n" +
        "Precio unitario: $" + String.format("%.2f", libroSeleccionado.getPrecio()) + "\n\n" +
        "Ingrese la cantidad que desea comprar:", 
        "Procesar Compra", JOptionPane.QUESTION_MESSAGE);

    if (cantidadStr == null) {
        return; // Si el usuario presiona Cancelar
    }

    try {
        int cantidad = Integer.parseInt(cantidadStr.trim());

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.", "Cantidad inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidad > libroSeleccionado.getStock()) {
            JOptionPane.showMessageDialog(this, "No hay suficiente stock disponible. Stock actual: " + libroSeleccionado.getStock(), "Stock insuficiente", JOptionPane.ERROR_MESSAGE);
            return;
        }


        libroSeleccionado.setStock(libroSeleccionado.getStock() - cantidad);
        double totalPagar = cantidad * libroSeleccionado.getPrecio();


        actualizarTabla(txtBuscar.getText());


        String ticket = "=============== TICKET DE COMPRA ===============" + "\n"
                      + "• Libro: " + libroSeleccionado.getTitulo() + "\n"
                      + "• Autor: " + libroSeleccionado.getAutor() + "\n"
                      + "• Cantidad adquirida: " + cantidad + "\n"
                      + "• Precio Unitario: $" + String.format("%.2f", libroSeleccionado.getPrecio()) + "\n"
                      + "---------------------------------------------------------" + "\n"
                      + "TOTAL PAGADO: $" + String.format("%.2f", totalPagar) + "\n"
                      + "Nuevo stock restante: " + libroSeleccionado.getStock() + "\n"
                      + "=================================================" + "\n\n"
                      + "¡Gracias por su compra en la librería virtual!";

        JOptionPane.showMessageDialog(this, ticket, "¡Compra Exitosa!", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnComprarActionPerformed

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatalogoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
