/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package craftcourses;

import java.awt.*;

/**
 *
 * @author busramgural
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JLabel();
        bottomTitleLabel1 = new javax.swing.JLabel();
        bottomTitleLabel2 = new javax.swing.JLabel();
        bottomTitleLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        loginPanel.setBackground(new java.awt.Color(249, 249, 249));

        titleLabel.setFont(new java.awt.Font("LingWai TC", 0, 55)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(35, 39, 42));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        titleLabel.setText("GIDIKLANAN IPLIKLER EL SANATLARI");
        titleLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        usernameField.setBackground(new java.awt.Color(249, 249, 249));
        usernameField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        usernameField.setForeground(new java.awt.Color(125, 218, 114));
        usernameField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Kullanıcı Adı", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        passwordField.setBackground(new java.awt.Color(249, 249, 249));
        passwordField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        passwordField.setForeground(new java.awt.Color(125, 218, 114));
        passwordField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Şifre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        loginButton.setBackground(new java.awt.Color(125, 218, 114));
        loginButton.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        loginButton.setForeground(new java.awt.Color(51, 50, 44));
        loginButton.setText("Giriş Yap");
        loginButton.setBorder(null);
        loginButton.setBorderPainted(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(51, 50, 44));
        registerButton.setText("Personel kayıt için tıklayınız.");
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerButtonMousePressed(evt);
            }
        });

        bottomTitleLabel1.setFont(new java.awt.Font("Bodoni Ornaments", 0, 14)); // NOI18N
        bottomTitleLabel1.setForeground(new java.awt.Color(125, 218, 114));
        bottomTitleLabel1.setText("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");

        bottomTitleLabel2.setFont(new java.awt.Font("Bodoni Ornaments", 0, 36)); // NOI18N
        bottomTitleLabel2.setForeground(new java.awt.Color(125, 218, 114));
        bottomTitleLabel2.setText("4");

        bottomTitleLabel3.setFont(new java.awt.Font("Bodoni Ornaments", 0, 36)); // NOI18N
        bottomTitleLabel3.setForeground(new java.awt.Color(125, 218, 114));
        bottomTitleLabel3.setText("4");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(passwordField)
                    .addComponent(usernameField)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(registerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addComponent(bottomTitleLabel1)
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addComponent(bottomTitleLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(titleLabel)
                        .addGap(18, 18, 18)
                        .addComponent(bottomTitleLabel3)
                        .addGap(26, 26, 26))))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(bottomTitleLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(bottomTitleLabel3)))
                .addGap(53, 53, 53)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerButton)
                .addGap(144, 144, 144)
                .addComponent(bottomTitleLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setLocationRelativeTo(null);
                

    }//GEN-LAST:event_formWindowOpened

    private void registerButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMousePressed
        // TODO add your handling code here:
        new RegisterEmployee().setVisible(true);
    }//GEN-LAST:event_registerButtonMousePressed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bottomTitleLabel1;
    private javax.swing.JLabel bottomTitleLabel2;
    private javax.swing.JLabel bottomTitleLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel registerButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
