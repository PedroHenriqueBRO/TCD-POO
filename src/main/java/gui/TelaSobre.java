/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
public class TelaSobre extends javax.swing.JFrame {

    /**
     * Creates new form TelaSobre
     */
    public TelaSobre() {
        initComponents();
        setLocationRelativeTo(null);
        
        
        
         jLabel1 = new javax.swing.JLabel();
         URL imageURL = getClass().getResource("/gui/Screenshot_1.png");
         if (imageURL != null) {
         jLabel1.setIcon(new ImageIcon(imageURL));
         } else {
         System.err.println("Imagem não encontrada!");
         }


         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Screenshot_1.png"))); // NOI18N

         jLabel1.setText("jLabel1");
         
         
       



       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTelaSobre = new javax.swing.JPanel();
        lblIntegrantes = new javax.swing.JLabel();
        lblCaio = new javax.swing.JLabel();
        lblPedro = new javax.swing.JLabel();
        lblVictor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIntegrantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIntegrantes.setText("INTEGRANTES DO GRUPO");

        lblCaio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCaio.setText("Caio Veloso Dias");

        lblPedro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPedro.setText("Pedro Henrique Braga dos Reis Oliveira");

        lblVictor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVictor.setText("Victor Pereira Barbosa");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\caiov\\OneDrive\\Área de Trabalho\\Screenshot_1.png")); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout pnlTelaSobreLayout = new javax.swing.GroupLayout(pnlTelaSobre);
        pnlTelaSobre.setLayout(pnlTelaSobreLayout);
        pnlTelaSobreLayout.setHorizontalGroup(
            pnlTelaSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelaSobreLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(lblPedro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                .addComponent(lblVictor)
                .addGap(65, 65, 65))
            .addGroup(pnlTelaSobreLayout.createSequentialGroup()
                .addGroup(pnlTelaSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTelaSobreLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblCaio)
                        .addGap(109, 109, 109)
                        .addComponent(lblIntegrantes))
                    .addGroup(pnlTelaSobreLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTelaSobreLayout.setVerticalGroup(
            pnlTelaSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaSobreLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblIntegrantes)
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(pnlTelaSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaio)
                    .addComponent(lblPedro)
                    .addComponent(lblVictor))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTelaSobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTelaSobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 410, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCaio;
    private javax.swing.JLabel lblIntegrantes;
    private javax.swing.JLabel lblPedro;
    private javax.swing.JLabel lblVictor;
    private javax.swing.JPanel pnlTelaSobre;
    // End of variables declaration//GEN-END:variables
}
