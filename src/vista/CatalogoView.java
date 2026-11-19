package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;

public class CatalogoView extends javax.swing.JFrame {
    private final ArrayList<Libro> carrito = new ArrayList<>();
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
                return false; 
            }
        };
        tblLibros.setModel(modeloTabla);
    }

    private void cargarLibrosIniciales() {
        listaLibros.add(new Libro("978-0134685991", "Effective Java", "Joshua Bloch", "Programación", 45.00, 12, "img/effective_java.jpg"));
        listaLibros.add(new Libro("978-0132350884", "Clean Code", "Robert C. Martin", "Ingeniería de Software", 38.50, 8,"img/clean_code.jpg" ));
        listaLibros.add(new Libro("978-8497592208", "Cien años de soledad", "Gabriel García Márquez", "Literatura", 22.00, 15, "img/cien_anos_de_soledad.jpg"));
        listaLibros.add(new Libro("978-0201633610", "Design Patterns", "Erich Gamma et al.", "Arquitectura", 50.00, 5, "img/design_patern.jpg"));
        listaLibros.add(new Libro("978-8445000663", "El Señor de los Anillos: La comunidad del anillo", "J.R.R. Tolkien", "Fantasía", 29.90, 10, "img/señor_de_los_anillos.jpg"));
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
        btnAgregarCarrito = new javax.swing.JButton();
        btnVerCarrito = new javax.swing.JButton();

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

        btnAgregarCarrito.setText("Agregar al Carrito");
        btnAgregarCarrito.addActionListener(this::btnAgregarCarritoActionPerformed);

        btnVerCarrito.setText("Ver Carrito");
        btnVerCarrito.addActionListener(this::btnVerCarritoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(569, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAgregarCarrito)
                .addGap(90, 90, 90)
                .addComponent(btnVerCarrito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnComprar)
                .addGap(71, 71, 71)
                .addComponent(btnVerDetalle)
                .addGap(92, 92, 92)
                .addComponent(btnCerrarSesion)
                .addGap(20, 20, 20))
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
                    .addComponent(btnComprar)
                    .addComponent(btnAgregarCarrito)
                    .addComponent(btnVerCarrito))
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
    Libro libroSeleccionado = null;
    for (Libro l : listaLibros) {
        if (l.getIsbn().equals(isbn)) {
            libroSeleccionado = l;
            break;
        }
    }

    if (libroSeleccionado == null) return;


    javax.swing.ImageIcon iconoPortada = null;
    try {
        // Carga la imagen desde la ruta especificada
        java.awt.Image img = new javax.swing.ImageIcon(libroSeleccionado.getRutaImagen()).getImage();

        java.awt.Image imgEscalada = img.getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH);
        iconoPortada = new javax.swing.ImageIcon(imgEscalada);
    } catch (Exception e) {
 
    }

    String info = "ISBN: " + libroSeleccionado.getIsbn() + "\n"
                + "Título: " + libroSeleccionado.getTitulo() + "\n"
                + "Autor: " + libroSeleccionado.getAutor() + "\n"
                + "Categoría: " + libroSeleccionado.getCategoria() + "\n"
                + "Precio: $" + String.format("%.2f", libroSeleccionado.getPrecio()) + "\n"
                + "Stock disponible: " + libroSeleccionado.getStock();


    JOptionPane.showMessageDialog(this, info, "Ficha y Portada del Libro", JOptionPane.INFORMATION_MESSAGE, iconoPortada);
    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
    int filaSeleccionada = tblLibros.getSelectedRow();
    
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro de la tabla para realizar la compra.", "Sin selección", JOptionPane.WARNING_MESSAGE);
        return;
    }


    String isbnTabla = tblLibros.getValueAt(filaSeleccionada, 0).toString();


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


    String cantidadStr = JOptionPane.showInputDialog(this, 
        "Libro: " + libroSeleccionado.getTitulo() + "\n" +
        "Stock disponible: " + libroSeleccionado.getStock() + "\n" +
        "Precio unitario: $" + String.format("%.2f", libroSeleccionado.getPrecio()) + "\n\n" +
        "Ingrese la cantidad que desea comprar:", 
        "Procesar Compra", JOptionPane.QUESTION_MESSAGE);

    if (cantidadStr == null) {
        return; 
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

    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoActionPerformed
int filaSeleccionada = tblLibros.getSelectedRow();
    
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un libro de la tabla para agregar al carrito.", "Sin selección", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String isbnTabla = tblLibros.getValueAt(filaSeleccionada, 0).toString();
    Libro libroSeleccionado = null;
    
    for (Libro l : listaLibros) {
        if (l.getIsbn().equals(isbnTabla)) {
            libroSeleccionado = l;
            break;
        }
    }

    if (libroSeleccionado == null) return;

    if (libroSeleccionado.getStock() <= 0) {
        JOptionPane.showMessageDialog(this, "Lo sentimos, este libro está agotado.", "Sin stock", JOptionPane.ERROR_MESSAGE);
        return;
    }


String cantidadStr = JOptionPane.showInputDialog(this, 
        "Libro: " + libroSeleccionado.getTitulo() + "\n" +
        "Stock disponible: " + libroSeleccionado.getStock() + "\n\n" +
        "Ingrese la cantidad que desea agregar al carrito:", 
        "Cantidad a comprar", JOptionPane.QUESTION_MESSAGE);
    

if (cantidadStr == null) return; // Si cancela

    try {
        int cantidad = Integer.parseInt(cantidadStr.trim());

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidad > libroSeleccionado.getStock()) {
            JOptionPane.showMessageDialog(this, "No hay suficiente stock disponible. Stock actual: " + libroSeleccionado.getStock(), "Stock insuficiente", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        for (int i = 0; i < cantidad; i++) {
            carrito.add(libroSeleccionado);
        }
        
        libroSeleccionado.setStock(libroSeleccionado.getStock() - cantidad);
        actualizarTabla(txtBuscar.getText());

        JOptionPane.showMessageDialog(this, "¡Se agregaron " + cantidad + " unidad(es) al carrito!", "Carrito Actualizado", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

    private void btnVerCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCarritoActionPerformed
if (carrito.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tu carrito de compras está vacío.", "Carrito Vacío", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    String[] opciones = {"Pagar / Checkout", "Quitar un libro", "Cerrar"};
    
    double totalGeneral = 0.0;
    StringBuilder detalleCarrito = new StringBuilder("=============== TU CARRITO DE COMPRAS ===============\n");

    for (int i = 0; i < carrito.size(); i++) {
        Libro l = carrito.get(i);
        detalleCarrito.append((i + 1) + ". " + l.getTitulo() + " - $" + String.format("%.2f", l.getPrecio()) + "\n");
        totalGeneral += l.getPrecio();
    }

    detalleCarrito.append("--------------------------------------------------------------------\n");
    detalleCarrito.append("TOTAL A PAGAR: $" + String.format("%.2f", totalGeneral) + "\n");
    detalleCarrito.append("====================================================\n");

    int seleccionAccion = JOptionPane.showOptionDialog(this,
            detalleCarrito.toString() + "\n¿Qué deseas hacer?",
            "Gestión del Carrito",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opciones,
            opciones[0]);

    if (seleccionAccion == 0) {

        JOptionPane.showMessageDialog(this, "¡Compra procesada con éxito!\nTotal cancelado: $" + String.format("%.2f", totalGeneral) + "\n¡Gracias por tu compra!", "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
        carrito.clear();
    } 
    else if (seleccionAccion == 1) {

        String indiceStr = JOptionPane.showInputDialog(this, "Ingresa el número (1 al " + carrito.size() + ") del libro que deseas quitar del carrito:", "Quitar Libro", JOptionPane.QUESTION_MESSAGE);
        
        if (indiceStr != null) {
            try {
                int index = Integer.parseInt(indiceStr.trim()) - 1;
                if (index >= 0 && index < carrito.size()) {
                    Libro libroQuitado = carrito.remove(index);
                    // Devolver el stock al inventario
                    libroQuitado.setStock(libroQuitado.getStock() + 1);
                    actualizarTabla(txtBuscar.getText());
                    JOptionPane.showMessageDialog(this, "Se ha eliminado '" + libroQuitado.getTitulo() + "' del carrito.", "Libro Retirado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Número de ítem inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_btnVerCarritoActionPerformed

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
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnVerCarrito;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
