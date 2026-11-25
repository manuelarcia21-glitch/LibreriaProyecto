package vista;
import java.util.HashMap;
import javax.swing.JOptionPane;
import modelo.RepositorioDatos;

public class LoginView extends javax.swing.JFrame {
    private static final HashMap<String, String> usuariosRegistrados = new HashMap<>(); 

public LoginView() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setTitle("Login - Librería en Línea");
        RepositorioDatos.inicializar();
        usuariosRegistrados.putIfAbsent("admin", "1234");
        usuariosRegistrados.putIfAbsent("usuario", "1234");
    }


private String obtenerContrasenaIngresado() {
        return new String(txtContrasena.getPassword()).trim();
    }

    private void abrirCatalogoParaUsuario(String usuario) {
        CatalogoView catalogo = new CatalogoView(usuario);
        catalogo.setVisible(true);
        this.dispose();
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        txtUsuario.addActionListener(this::txtUsuarioActionPerformed);

        jLabel2.setText("Contraseña:");

        btnIngresar.setText("Iniciar sesion");
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);

        txtContrasena.addActionListener(this::txtContrasenaActionPerformed);

        btnRegistrar.setText("Registrarse");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnIngresar)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtContrasena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)))
                .addContainerGap(580, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnIngresar)
                .addGap(34, 34, 34)
                .addComponent(btnRegistrar)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String usuario = txtUsuario.getText().trim();
        String password =obtenerContrasenaIngresado();

        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor ingresa tu usuario y contraseña.",
                    "Campos vacíos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

if (!usuariosRegistrados.containsKey(usuario)) {
            JOptionPane.showMessageDialog(
                    this,
                    "El usuario '" + usuario + "' no está registrado.",
                    "Usuario no encontrado",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String passwordGuardada = usuariosRegistrados.get(usuario);
        if (!passwordGuardada.equals(password)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Contraseña incorrecta.",
                    "Error de autenticación",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "¡Bienvenido, " + usuario + "!\nPuedes explorar el catálogo, comprar o publicar libros en el marketplace.",
                "Acceso concedido",
                JOptionPane.INFORMATION_MESSAGE
        );

        abrirCatalogoParaUsuario(usuario);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String usuario = txtUsuario.getText().trim();
        String password =obtenerContrasenaIngresado();        
if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Completa usuario y contraseña para crear tu cuenta.",
                    "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (usuariosRegistrados.containsKey(usuario)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ese nombre de usuario ya existe. Elige otro.",
                    "Usuario duplicado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        usuariosRegistrados.put(usuario, password);
        JOptionPane.showMessageDialog(
                this,
                "Usuario '" + usuario + "' registrado con éxito.\nIngresando al catálogo y marketplace...",
                "Registro completado",
                JOptionPane.INFORMATION_MESSAGE
        );

        abrirCatalogoParaUsuario(usuario);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new LoginView().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
