/*
 * Este cdigo se comienza el dia 15 de agosto del 2016, con el fin de crear un control automatizado de un sistema de riego. 
 * Este es el frame de ingreso de la aplicación, en este lo que hacemos basicamente es verificar los datos suministrados
 * por el usuario y de esta manera poder darle acceso a ciertas opciones dentro de la aplicacion.
 */

package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Gustavo Patiño Salas.
 */
public class frmIngreso extends javax.swing.JFrame {
    
    // le pedimos al sistema que nos traiga los diferentes estilos diponibles en un array y de esa forma poder
    // una apariencia diferente a nuestra aplicacion.
    private UIManager.LookAndFeelInfo[] apariencia;

    /**
     * Creates new form frmIngreso
     */
    public frmIngreso() {
        initComponents();
        //ubico el frame en el centro de la pantalla.
        this.setLocationRelativeTo(null);
        //defino el tamaño del frame.
        this.setSize(480, 330);
        this.setMinimumSize(new Dimension(476, 330));
        this.setResizable(false);
        //obtengo los estilos instalados en el OS y llamo al metodo con el que le asigno el estilo a mi aplicación.
        this.apariencia = UIManager.getInstalledLookAndFeels();
        this.cambiarApariencia(3);
        
    }
    //con este metodo defino el estilo que quiero usar para mi aplicacion.
    private void cambiarApariencia(int item){
        
        try{
            UIManager.setLookAndFeel(this.apariencia[item].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
            String estilo = this.apariencia[item].getClassName();
            this.getContentPane().setBackground(new Color(240, 240, 240));    
        } catch (InstantiationException ex) {
            Logger.getLogger(frmIngreso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmIngreso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmIngreso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //con este metodo cargo la imagen.
    private void cargarImagen(){
        
        //ImageIcon imagen = new ImageIcon("src//imagenes//SENA-300x300.png");
        //Icon icnono = new ImageIcon(imagen.getImage().getScaledInstance(this.lblImagen.getWidth(), this.lblImagen.getHeight(), Image.SCALE_DEFAULT));
        //this.lblImagen.setIcon(icnono);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbOpciones = new javax.swing.JToolBar();
        pnlIngresoDatos = new javax.swing.JPanel();
        btnIngreso = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(476, 321));
        setResizable(false);

        jtbOpciones.setRollover(true);
        jtbOpciones.setMaximumSize(new java.awt.Dimension(476, 150));
        jtbOpciones.setMinimumSize(new java.awt.Dimension(476, 150));
        jtbOpciones.setPreferredSize(new java.awt.Dimension(476, 150));

        pnlIngresoDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso"));
        pnlIngresoDatos.setMaximumSize(new java.awt.Dimension(246, 140));
        pnlIngresoDatos.setMinimumSize(new java.awt.Dimension(246, 140));
        pnlIngresoDatos.setPreferredSize(new java.awt.Dimension(246, 140));

        btnIngreso.setText("Ingresar");

        lblUsuario.setText("Usuario:");

        txtUsuario.setMaximumSize(new java.awt.Dimension(160, 20));
        txtUsuario.setMinimumSize(new java.awt.Dimension(160, 20));
        txtUsuario.setPreferredSize(new java.awt.Dimension(160, 20));

        jLabel1.setText("Password:");

        jTextField1.setMaximumSize(new java.awt.Dimension(160, 20));
        jTextField1.setMinimumSize(new java.awt.Dimension(160, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(160, 20));

        javax.swing.GroupLayout pnlIngresoDatosLayout = new javax.swing.GroupLayout(pnlIngresoDatos);
        pnlIngresoDatos.setLayout(pnlIngresoDatosLayout);
        pnlIngresoDatosLayout.setHorizontalGroup(
            pnlIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIngresoDatosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIngresoDatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIngresoDatosLayout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnIngreso, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        pnlIngresoDatosLayout.setVerticalGroup(
            pnlIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIngresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIngreso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SENA-300x300.png"))); // NOI18N
        lblImagen.setMaximumSize(new java.awt.Dimension(140, 140));
        lblImagen.setMinimumSize(new java.awt.Dimension(140, 140));
        lblImagen.setPreferredSize(new java.awt.Dimension(140, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jtbOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlIngresoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlIngresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jtbOpciones;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlIngresoDatos;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
