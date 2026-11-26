package vista;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import modelo.RegistroCompra;
import modelo.RepositorioDatos;

public class CatalogoView extends javax.swing.JFrame {  
    private final ArrayList<Libro> listaLibros = RepositorioDatos.getLibros();
    private final ArrayList<RegistroCompra> historialCompras = RepositorioDatos.getHistorial();


    private final ArrayList<Libro> carrito = new ArrayList<>();
    private final ArrayList<Libro> listaDeseos = new ArrayList<>();
    private String usuarioActual = "invitado";
    private DefaultTableModel modeloTabla;
    
public CatalogoView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Catálogo y Marketplace - Librería Virtual");
        configurarTabla();
        actualizarTabla("");
        configurarPermisosMarketplace();
    }
public CatalogoView(String usuarioActual) {
        this();
        if (usuarioActual != null && !usuarioActual.isBlank()) {
            this.usuarioActual = usuarioActual;
        }
        this.setTitle("Catálogo y Marketplace - Usuario: " + this.usuarioActual);
        configurarPermisosMarketplace();
    }
private void configurarTabla() {
        modeloTabla = new DefaultTableModel(
                new Object[]{"ISBN", "Título", "Autor", "Categoría", "Precio", "Stock"},
                0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblLibros.setModel(modeloTabla);
    }
private void configurarPermisosMarketplace() {
        if (btnPanelAdmin != null) {
            btnPanelAdmin.setVisible(true);
            btnPanelAdmin.setEnabled(true);
        }
    }
      
public void actualizarTabla(String filtro) {
        if (modeloTabla == null) {
            return;
        }
        modeloTabla.setRowCount(0);
        String criterio = (filtro != null) ? filtro.trim().toLowerCase() : "";

        for (Libro l : listaLibros) {
            boolean coincide = criterio.isEmpty()
                    || l.getTitulo().toLowerCase().contains(criterio)
                    || l.getAutor().toLowerCase().contains(criterio)
                    || l.getCategoria().toLowerCase().contains(criterio)
                    || l.getIsbn().toLowerCase().contains(criterio);

            if (coincide) {
                modeloTabla.addRow(new Object[]{
                    l.getIsbn(),
                    l.getTitulo(),
                    l.getAutor(),
                    l.getCategoria(),
                    String.format("%.2f", l.getPrecio()),
                    l.getStock()
                });
            }
        }
        }
private Libro obtenerLibroSeleccionado() {
        int fila = tblLibros.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor selecciona un libro de la tabla.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
            );
            return null;
        }

        String isbn = tblLibros.getValueAt(fila, 0).toString();
        for (Libro l : listaLibros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
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
        btnAgregarDeseos = new javax.swing.JButton();
        btnVerDeseos = new javax.swing.JButton();
        btnHistorialActionPerformed = new javax.swing.JButton();
        btnPanelAdmin = new javax.swing.JButton();

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

        btnAgregarDeseos.setText("Añadir a lista de deseados");
        btnAgregarDeseos.addActionListener(this::btnAgregarDeseosActionPerformed);

        btnVerDeseos.setText("Ver lista de deseados");
        btnVerDeseos.addActionListener(this::btnVerDeseosActionPerformed);

        btnHistorialActionPerformed.setText("Historial de compra");
        btnHistorialActionPerformed.addActionListener(this::btnHistorialActionPerformedActionPerformed);

        btnPanelAdmin.setText("Ventana de administrador");
        btnPanelAdmin.addActionListener(this::btnPanelAdminActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHistorialActionPerformed)
                        .addGap(44, 44, 44)
                        .addComponent(btnCerrarSesion)
                        .addGap(18, 18, 18)
                        .addComponent(btnPanelAdmin)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(569, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnAgregarCarrito)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerCarrito)
                        .addGap(18, 18, 18)
                        .addComponent(btnComprar)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerDetalle)
                        .addGap(22, 22, 22)
                        .addComponent(btnAgregarDeseos)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerDeseos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPanelAdmin)
                    .addComponent(btnCerrarSesion)
                    .addComponent(btnHistorialActionPerformed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprar)
                    .addComponent(btnAgregarCarrito)
                    .addComponent(btnVerCarrito)
                    .addComponent(btnAgregarDeseos)
                    .addComponent(btnVerDeseos)
                    .addComponent(btnVerDetalle))
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
if (!carrito.isEmpty()) {
            // Devuelve al stock los artículos no comprados en el carrito antes de salir
            for (Libro l : carrito) {
                l.setStock(l.getStock() + 1);
            }
            carrito.clear();
        }
        LoginView login = new LoginView();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
actualizarTabla(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
Libro libro = obtenerLibroSeleccionado();
        if (libro == null) {
            return;
        }

        String infoHtml = "<html><body style='width: 260px;'>"
                + "<h2>" + libro.getTitulo() + "</h2>"
                + "<p><b>ISBN:</b> " + libro.getIsbn() + "<br>"
                + "<b>Autor:</b> " + libro.getAutor() + "<br>"
                + "<b>Categoría:</b> " + libro.getCategoria() + "<br>"
                + "<b>Precio:</b> $" + String.format("%.2f", libro.getPrecio()) + "<br>"
                + "<b>Stock disponible:</b> " + libro.getStock() + " unidades</p>"
                + "</body></html>";

        JPanel panelDetalle = new JPanel();
        JLabel lblTexto = new JLabel(infoHtml);

        if (libro.getRutaImagen() != null && !libro.getRutaImagen().isBlank()) {
            File archivoImg = new File(libro.getRutaImagen());
            if (archivoImg.exists()) {
                ImageIcon iconoOriginal = new ImageIcon(libro.getRutaImagen());
                Image imgEscalada = iconoOriginal.getImage().getScaledInstance(130, 180, Image.SCALE_SMOOTH);
                JLabel lblPortada = new JLabel(new ImageIcon(imgEscalada));
                panelDetalle.add(lblPortada);
            }
        }

        panelDetalle.add(lblTexto);
        JOptionPane.showMessageDialog(this, panelDetalle, "Detalle del Libro", JOptionPane.PLAIN_MESSAGE);
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
Libro libro = obtenerLibroSeleccionado();
        if (libro == null) {
            return;
        }

        if (libro.getStock() <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "No hay unidades disponibles de '" + libro.getTitulo() + "'.",
                    "Sin stock",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String cantStr = JOptionPane.showInputDialog(
                this,
                "Libro: " + libro.getTitulo() + "\nStock disponible: " + libro.getStock() + "\n\n¿Cuántas unidades deseas agregar?",
                "Agregar al Carrito",
                JOptionPane.QUESTION_MESSAGE
        );

        if (cantStr == null) {
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantStr.trim());
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.", "Cantidad inválida", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (cantidad > libro.getStock()) {
                JOptionPane.showMessageDialog(this, "Solo hay " + libro.getStock() + " unidades disponibles.", "Stock insuficiente", JOptionPane.WARNING_MESSAGE);
                return;
            }

            for (int i = 0; i < cantidad; i++) {
                carrito.add(libro);
            }
            libro.setStock(libro.getStock() - cantidad);
            actualizarTabla(txtBuscar.getText());

            JOptionPane.showMessageDialog(
                    this,
                    "Se agregaron " + cantidad + " unidad(es) de '" + libro.getTitulo() + "' al carrito.",
                    "Carrito Actualizado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa un número entero válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

    private void btnVerCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCarritoActionPerformed
if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tu carrito de compras está vacío.", "Carrito de Compras", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        LinkedHashMap<Libro, Integer> resumenCantidades = new LinkedHashMap<>();
        for (Libro l : carrito) {
            resumenCantidades.put(l, resumenCantidades.getOrDefault(l, 0) + 1);
        }

        ArrayList<Libro> librosUnicos = new ArrayList<>(resumenCantidades.keySet());
        StringBuilder sb = new StringBuilder("=============== CARRITO DE COMPRAS ===============\n");
        double totalGeneral = 0.0;

        for (int i = 0; i < librosUnicos.size(); i++) {
            Libro lib = librosUnicos.get(i);
            int cant = resumenCantidades.get(lib);
            double subtotal = lib.getPrecio() * cant;
            totalGeneral += subtotal;

            sb.append((i + 1)).append(". ").append(lib.getTitulo())
                    .append(" | Cant.: ").append(cant)
                    .append(" | Unit.: $").append(String.format("%.2f", lib.getPrecio()))
                    .append(" | Subtotal: $").append(String.format("%.2f", subtotal)).append("\n");
        }
        sb.append("--------------------------------------------------\n");
        sb.append("TOTAL A PAGAR: $").append(String.format("%.2f", totalGeneral)).append("\n");
        sb.append("==================================================\n");

        String[] opciones = {"Confirmar y Pagar", "Quitar un Libro (Devolver Stock)", "Cerrar"};
        int seleccion = JOptionPane.showOptionDialog(
                this,
                sb.toString() + "\n¿Qué deseas hacer?",
                "Carrito de Compras",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion == 0) {
            for (Map.Entry<Libro, Integer> entry : resumenCantidades.entrySet()) {
                Libro lib = entry.getKey();
                int cant = entry.getValue();
                double subtotal = lib.getPrecio() * cant;
                RepositorioDatos.registrarCompra(new RegistroCompra(usuarioActual, lib, cant, subtotal));
            }
            RepositorioDatos.guardarLibrosEnArchivo();
            carrito.clear();

            JOptionPane.showMessageDialog(
                    this,
                    "¡Compra procesada con éxito!\nTotal cancelado: $" + String.format("%.2f", totalGeneral) + "\n¡Gracias por tu compra!",
                    "Pago Exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else if (seleccion == 1) {
            String numStr = JOptionPane.showInputDialog(
                    this,
                    "Ingresa el número (1 al " + librosUnicos.size() + ") del libro que deseas quitar del carrito:",
                    "Quitar del Carrito",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (numStr == null) {
                return;
            }

            try {
                int idx = Integer.parseInt(numStr.trim()) - 1;
                if (idx < 0 || idx >= librosUnicos.size()) {
                    JOptionPane.showMessageDialog(this, "Número de libro inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Libro libroQuitar = librosUnicos.get(idx);
                int devueltos = 0;
                while (carrito.remove(libroQuitar)) {
                    devueltos++;
                }
                libroQuitar.setStock(libroQuitar.getStock() + devueltos);
                actualizarTabla(txtBuscar.getText());

                JOptionPane.showMessageDialog(
                        this,
                        "Se retiró '" + libroQuitar.getTitulo() + "' y se devolvieron " + devueltos + " unidad(es) al stock.",
                        "Ítem Retirado",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingresa un número válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnVerCarritoActionPerformed

    private void btnAgregarDeseosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDeseosActionPerformed
Libro libro = obtenerLibroSeleccionado();
        if (libro == null) {
            return;
        }

        if (listaDeseos.contains(libro)) {
            JOptionPane.showMessageDialog(this, "'" + libro.getTitulo() + "' ya está en tu lista de deseos.", "Ya guardado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        listaDeseos.add(libro);
        JOptionPane.showMessageDialog(this, "¡Se añadió '" + libro.getTitulo() + "' a tu lista de deseos!", "Lista de Deseos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAgregarDeseosActionPerformed

    private void btnVerDeseosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDeseosActionPerformed
if (listaDeseos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tu lista de deseos está vacía.", "Lista de Deseos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("=============== LISTA DE DESEOS ===============\n");
        for (int i = 0; i < listaDeseos.size(); i++) {
            Libro l = listaDeseos.get(i);
            sb.append((i + 1)).append(". ").append(l.getTitulo())
                    .append(" - $").append(String.format("%.2f", l.getPrecio()))
                    .append(" (Stock: ").append(l.getStock()).append(")\n");
        }
        sb.append("===============================================\n");

        String[] opciones = {"Mover al Carrito", "Quitar de la Lista", "Cerrar"};
        int seleccion = JOptionPane.showOptionDialog(
                this,
                sb.toString() + "\n¿Qué acción deseas realizar?",
                "Gestionar Lista de Deseos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion == 0 || seleccion == 1) {
            String indiceStr = JOptionPane.showInputDialog(
                    this,
                    "Ingresa el número (1 al " + listaDeseos.size() + ") del libro:",
                    seleccion == 0 ? "Mover al Carrito" : "Quitar de la Lista",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (indiceStr == null) {
                return;
            }

            try {
                int idx = Integer.parseInt(indiceStr.trim()) - 1;
                if (idx < 0 || idx >= listaDeseos.size()) {
                    JOptionPane.showMessageDialog(this, "Número de libro inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Libro libroElegido = listaDeseos.get(idx);

                if (seleccion == 0) {
                    if (libroElegido.getStock() <= 0) {
                        JOptionPane.showMessageDialog(this, "No hay stock disponible para mover este libro al carrito.", "Sin stock", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    carrito.add(libroElegido);
                    libroElegido.setStock(libroElegido.getStock() - 1);
                    listaDeseos.remove(idx);
                    actualizarTabla(txtBuscar.getText());
                    JOptionPane.showMessageDialog(this, "Se movió 1 unidad de '" + libroElegido.getTitulo() + "' al carrito.", "Movido al Carrito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    listaDeseos.remove(idx);
                    JOptionPane.showMessageDialog(this, "Se eliminó '" + libroElegido.getTitulo() + "' de la lista de deseos.", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingresa un número entero válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnVerDeseosActionPerformed

    private void btnHistorialActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformedActionPerformed
if (historialCompras.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aún no hay compras registradas.", "Historial de Compras", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("=============== HISTORIAL DE COMPRAS ===============\n");
        for (int i = 0; i < historialCompras.size(); i++) {
            RegistroCompra reg = historialCompras.get(i);
            sb.append((i + 1)).append(". [").append(reg.getFechaHora()).append("] ")
                    .append("Comprador: ").append(reg.getUsuarioComprador())
                    .append(" | Libro: ").append(reg.getLibro().getTitulo())
                    .append(" | Cant.: ").append(reg.getCantidad())
                    .append(" | Total: $").append(String.format("%.2f", reg.getTotalPagado())).append("\n");
        }
        sb.append("====================================================\n");

        JOptionPane.showMessageDialog(this, sb.toString(), "Historial de Compras", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnHistorialActionPerformedActionPerformed

    private void btnPanelAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelAdminActionPerformed
        AdminView adminVentana = new AdminView(listaLibros, historialCompras, this, usuarioActual);
        adminVentana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPanelAdminActionPerformed
public int contarCompradoresPorLibro(String isbn) {
    java.util.HashSet<String> compradores = new java.util.HashSet<>();
    for (modelo.RegistroCompra reg : historialCompras) {
        if (reg.getLibro().getIsbn().equals(isbn)) {
            compradores.add(reg.getUsuarioComprador());
        }
    }
    return compradores.size();
}
    /**
     * @param args the command line arguments
     */
   
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CatalogoView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JButton btnAgregarDeseos;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnHistorialActionPerformed;
    private javax.swing.JButton btnPanelAdmin;
    private javax.swing.JButton btnVerCarrito;
    private javax.swing.JButton btnVerDeseos;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
