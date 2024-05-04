package gui;
import database.*;
import management.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    public Register() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        registerPanel = new javax.swing.JPanel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        mobilePhoneField = new javax.swing.JTextField();
        homePhoneField = new javax.swing.JTextField();
        studentRadioButton = new javax.swing.JRadioButton();
        instructorRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        registerPanel.setBackground(new java.awt.Color(249, 249, 249));

        firstNameField.setBackground(new java.awt.Color(249, 249, 249));
        firstNameField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        firstNameField.setForeground(new java.awt.Color(125, 218, 114));
        firstNameField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        lastNameField.setBackground(new java.awt.Color(249, 249, 249));
        lastNameField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lastNameField.setForeground(new java.awt.Color(125, 218, 114));
        lastNameField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Soyad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        addressField.setBackground(new java.awt.Color(249, 249, 249));
        addressField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        addressField.setForeground(new java.awt.Color(125, 218, 114));
        addressField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ev Adresi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        registerButton.setBackground(new java.awt.Color(125, 218, 114));
        registerButton.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        registerButton.setForeground(new java.awt.Color(51, 50, 44));
        registerButton.setText("Kaydet");
        registerButton.setBorder(null);
        registerButton.setBorderPainted(false);
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerButtonMousePressed(evt);
            }
        });
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(51, 50, 44));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        titleLabel.setText("Kayıt");
        titleLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        emailField.setBackground(new java.awt.Color(249, 249, 249));
        emailField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        emailField.setForeground(new java.awt.Color(125, 218, 114));
        emailField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "E-Posta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        mobilePhoneField.setBackground(new java.awt.Color(249, 249, 249));
        mobilePhoneField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        mobilePhoneField.setForeground(new java.awt.Color(125, 218, 114));
        mobilePhoneField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cep Telefonu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        homePhoneField.setBackground(new java.awt.Color(249, 249, 249));
        homePhoneField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        homePhoneField.setForeground(new java.awt.Color(125, 218, 114));
        homePhoneField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ev Telefonu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        buttonGroup1.add(studentRadioButton);
        studentRadioButton.setForeground(new java.awt.Color(51, 50, 44));
        studentRadioButton.setText("Kursiyer");
        studentRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(instructorRadioButton);
        instructorRadioButton.setForeground(new java.awt.Color(51, 50, 44));
        instructorRadioButton.setText("Öğretmen");
        instructorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(registerPanelLayout.createSequentialGroup()
                                .addComponent(homePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(registerPanelLayout.createSequentialGroup()
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(mobilePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(registerPanelLayout.createSequentialGroup()
                                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(417, 417, 417)
                        .addComponent(studentRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(instructorRadioButton))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(titleLabel)))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerPanelLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(30, 30, 30)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentRadioButton)
                    .addComponent(instructorRadioButton))
                .addGap(18, 18, 18)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobilePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButtonMousePressed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        String name = firstNameField.getText();
        String surname = lastNameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String mobilePhone = mobilePhoneField.getText();
        String homePhone = homePhoneField.getText();
        
        if (studentRadioButton.isSelected()) {
            DatabaseHelper.registerStudent(name, surname, email, mobilePhone, homePhone, address);
        } else if (instructorRadioButton.isSelected()) {
            DatabaseHelper.registerInstructor(name, surname, email, mobilePhone, homePhone, address);
        }
        
        dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }//GEN-LAST:event_registerButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButtonMouseClicked

    private void studentRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentRadioButtonActionPerformed

    private void instructorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instructorRadioButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField homePhoneField;
    private javax.swing.JRadioButton instructorRadioButton;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField mobilePhoneField;
    private javax.swing.JButton registerButton;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JRadioButton studentRadioButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}