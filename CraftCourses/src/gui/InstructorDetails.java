package gui;

import database.DatabaseHelper;

public class InstructorDetails extends javax.swing.JFrame {
    private static int instructorIDin;
    public InstructorDetails(int instructorID) {
        initComponents();
        InstructorDetails.instructorIDin= instructorID;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        craftList = new javax.swing.JList<>();
        timeLabel = new javax.swing.JLabel();
        craftsLabel = new javax.swing.JLabel();
        feeLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        timeList = new javax.swing.JList<>();
        daySpinner = new javax.swing.JSpinner();
        feeField = new javax.swing.JTextField();
        feeLabel2 = new javax.swing.JLabel();
        addSessionButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        sessionsForInstructorTable = new javax.swing.JTable();
        saveAndGoBackButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        craftsForInstructorTable = new javax.swing.JTable();
        addCraftButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        craftList.setBackground(new java.awt.Color(153, 181, 155));
        craftList.setForeground(new java.awt.Color(35, 39, 42));
        craftList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(craftList);

        timeLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(51, 50, 44));
        timeLabel.setText("Öğretmenin eğitim verebileceği zamanlar:");
        timeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        craftsLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        craftsLabel.setForeground(new java.awt.Color(51, 50, 44));
        craftsLabel.setText("Öğretmenin eğitim verebileceği dersler:");
        craftsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        feeLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        feeLabel.setForeground(new java.awt.Color(51, 50, 44));
        feeLabel.setText("Saatlik Eğitim Ücreti (Hafta içi):");
        feeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        timeList.setBackground(new java.awt.Color(153, 181, 155));
        timeList.setForeground(new java.awt.Color(35, 39, 42));
        timeList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "09.00 - 10.00", "10.00 - 11.00", "11.00 - 12.00", "13.00 -14.00", "14.00 -15.00", "15.00 -16.00", "16.00 - 17.00" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(timeList);

        daySpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"}));

        feeField.setBackground(new java.awt.Color(249, 249, 249));
        feeField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        feeField.setForeground(new java.awt.Color(125, 218, 114));
        feeField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        feeLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        feeLabel2.setForeground(new java.awt.Color(51, 50, 44));
        feeLabel2.setText("TL");
        feeLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        addSessionButton.setBackground(new java.awt.Color(125, 218, 114));
        addSessionButton.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        addSessionButton.setForeground(new java.awt.Color(51, 50, 44));
        addSessionButton.setText("Ekle");
        addSessionButton.setBorder(null);
        addSessionButton.setBorderPainted(false);
        addSessionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSessionButtonActionPerformed(evt);
            }
        });

        sessionsForInstructorTable.setBackground(new java.awt.Color(153, 181, 155));
        sessionsForInstructorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gün", "Saat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(sessionsForInstructorTable);
        if (sessionsForInstructorTable.getColumnModel().getColumnCount() > 0) {
            sessionsForInstructorTable.getColumnModel().getColumn(1).setResizable(false);
        }

        saveAndGoBackButton.setBackground(new java.awt.Color(125, 218, 114));
        saveAndGoBackButton.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        saveAndGoBackButton.setForeground(new java.awt.Color(51, 50, 44));
        saveAndGoBackButton.setText("Geri");
        saveAndGoBackButton.setBorder(null);
        saveAndGoBackButton.setBorderPainted(false);
        saveAndGoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAndGoBackButtonActionPerformed(evt);
            }
        });

        craftsForInstructorTable.setBackground(new java.awt.Color(153, 181, 155));
        craftsForInstructorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dersler"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(craftsForInstructorTable);

        addCraftButton.setBackground(new java.awt.Color(125, 218, 114));
        addCraftButton.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        addCraftButton.setForeground(new java.awt.Color(51, 50, 44));
        addCraftButton.setText("Ekle");
        addCraftButton.setBorder(null);
        addCraftButton.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveAndGoBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timeLabel)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(daySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addSessionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(addCraftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(craftsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(feeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(feeField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(feeLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feeLabel)
                    .addComponent(feeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feeLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(craftsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCraftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(timeLabel)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(daySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addSessionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveAndGoBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened
    
    private void saveAndGoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAndGoBackButtonActionPerformed
        dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_saveAndGoBackButtonActionPerformed

    private void addSessionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSessionButtonActionPerformed
        // TODO add your handling code here:
        String dayValue = (String) daySpinner.getValue(); // Veya uygun tipe dönüştürün
        String feeText = feeField.getText();
// JList'ten seçilen öğeleri al
        String selectedTime = timeList.getSelectedValue() ;
        System.out.println(dayValue + selectedTime);
        // Haftanın günlerini temsil eden string değerler
        String[] daysOfWeek = {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"};

        // DayValue'yi haftanın günlerine karşılık gelen sayısal değere dönüştürme
        int dayNumericValue = -1; // Varsayılan olarak -1 ayarlanmış
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (dayValue.equals(daysOfWeek[i])) {
                dayNumericValue = i + 1; // Haftanın 0'dan başlayan indeksi 1'den başlayan güne dönüştürüldü
                break;
            }
        }

        // SelectedTime'dan başlangıç saati kısmını alarak integer değere dönüştürme
        String[] timeParts = selectedTime.split(" - ");
        String startTime = timeParts[0];
        int startHour = Integer.parseInt(startTime.split("\\.")[0]); // Saati alırken "." karakterine göre ayırıyoruz

        // İşlem sonuçlarını kontrol etme
        //System.out.println("Day Numeric Value: " + dayNumericValue);
        //System.out.println("Start Hour: " + startHour);
        double feeValue = Double.parseDouble(feeText);
        DatabaseHelper.addWorkingHours(instructorIDin, dayNumericValue, startHour, feeValue);
        
    }//GEN-LAST:event_addSessionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InstructorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstructorDetails(instructorIDin).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCraftButton;
    private javax.swing.JButton addSessionButton;
    private javax.swing.JList<String> craftList;
    private javax.swing.JTable craftsForInstructorTable;
    private javax.swing.JLabel craftsLabel;
    private javax.swing.JSpinner daySpinner;
    private javax.swing.JTextField feeField;
    private javax.swing.JLabel feeLabel;
    private javax.swing.JLabel feeLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton saveAndGoBackButton;
    private javax.swing.JTable sessionsForInstructorTable;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JList<String> timeList;
    // End of variables declaration//GEN-END:variables
}
