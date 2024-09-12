package gui;

import database.DatabaseHelper;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import management.Course;
import management.Craft;

public class CourseCreation extends javax.swing.JFrame {
    
    public CourseCreation() {
        initComponents();
        Craft.displayAllCraftsDependingDays(true, craftTable);
    }
    
    private int getCraftID() {
        int selectedCraft = craftTable.getSelectedRow();
        int craftID = -1;
        
        if (selectedCraft != -1) {
            craftID = (int) craftTable.getValueAt(selectedCraft, 0);
        }
        
        return craftID;
    }
    
    private boolean getIsWeekday() {
        String selectedOption = (String) weekComboBox.getSelectedItem();
        
        if (selectedOption.equals("Hafta içi")) {
            return true;
        }
        
        return false;
    }
    
    public boolean getExistingCraft(String craftName) {
        DefaultTableModel model = (DefaultTableModel) courseDetailsTable.getModel();
        boolean isAlreadyExist = false;
        
        if (model.getRowCount() != 0) {
            int rowIndex = 0;
            while (rowIndex < model.getRowCount() && !isAlreadyExist) {
                String existingCraftName = (String) model.getValueAt(rowIndex, 1);
                if (existingCraftName.equals(craftName)) {
                    isAlreadyExist = true;
                }
                rowIndex++;
            }
        }
        
        return isAlreadyExist;
    }
    
    public void displayCourseDetails() {
        int selectedCraft = craftTable.getSelectedRow();
        int craftID = (int) craftTable.getValueAt(selectedCraft, 0);
        String craftName = craftTable.getValueAt(selectedCraft, 1).toString();
        
        if (getExistingCraft(craftName)) return;
        
        int selectedInstructor = instructorsTable.getSelectedRow();
        String instructorFullName = instructorsTable.getValueAt(selectedInstructor, 1).toString();
        String day = instructorsTable.getValueAt(selectedInstructor, 2).toString();
        int startHour = (int) instructorsTable.getValueAt(selectedInstructor, 3);
        int workingHourID = (int) instructorsTable.getValueAt(selectedInstructor, 4);
        int instructorID = (int) instructorsTable.getValueAt(selectedInstructor, 0);
        
        DefaultTableModel model = (DefaultTableModel) courseDetailsTable.getModel();
        model.addRow(new Object[]{craftID, craftName, instructorFullName , day, startHour, workingHourID, instructorID});
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
        chooseDateLabel = new javax.swing.JLabel();
        weekComboBox = new javax.swing.JComboBox<>();
        craftLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        startDateField = new javax.swing.JTextField();
        finishDateLabel = new javax.swing.JLabel();
        choosenCraftLabel = new javax.swing.JLabel();
        choosenCraftField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        instructorsTable = new javax.swing.JTable();
        addToCourseButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        courseDetailsTable = new javax.swing.JTable();
        expLabel6 = new javax.swing.JLabel();
        feeField = new javax.swing.JTextField();
        feeLabel = new javax.swing.JLabel();
        feeLabel2 = new javax.swing.JLabel();
        saveCourseButton = new javax.swing.JButton();
        endDateField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        craftTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        chooseDateLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        chooseDateLabel.setForeground(new java.awt.Color(51, 50, 44));
        chooseDateLabel.setText("Kurs zamanını seçiniz:");
        chooseDateLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        weekComboBox.setBackground(new java.awt.Color(153, 181, 155));
        weekComboBox.setForeground(new java.awt.Color(35, 39, 42));
        weekComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hafta içi", "Hafta sonu" }));
        weekComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weekComboBoxActionPerformed(evt);
            }
        });

        craftLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        craftLabel.setForeground(new java.awt.Color(51, 50, 44));
        craftLabel.setText("Kursa eklenebilecekler dersler:");
        craftLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        startDateLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        startDateLabel.setForeground(new java.awt.Color(51, 50, 44));
        startDateLabel.setText("Başlangıç Tarihi:");
        startDateLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        startDateField.setBackground(new java.awt.Color(249, 249, 249));
        startDateField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        startDateField.setForeground(new java.awt.Color(125, 218, 114));
        startDateField.setText("01.01.2000");
        startDateField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N
        startDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateFieldActionPerformed(evt);
            }
        });

        finishDateLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        finishDateLabel.setForeground(new java.awt.Color(51, 50, 44));
        finishDateLabel.setText("Bitiş Tarihi:");
        finishDateLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        choosenCraftLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        choosenCraftLabel.setForeground(new java.awt.Color(51, 50, 44));
        choosenCraftLabel.setText("Seçilen Ders:");
        choosenCraftLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        choosenCraftField.setBackground(new java.awt.Color(249, 249, 249));
        choosenCraftField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        choosenCraftField.setForeground(new java.awt.Color(125, 218, 114));
        choosenCraftField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        instructorsTable.setBackground(new java.awt.Color(153, 181, 155));
        instructorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Öğretmen ID", "Ad Soyad", "Gün", "Saat", "WH ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(instructorsTable);

        addToCourseButton.setBackground(new java.awt.Color(125, 218, 114));
        addToCourseButton.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        addToCourseButton.setForeground(new java.awt.Color(51, 50, 44));
        addToCourseButton.setText("Dersi Ekle");
        addToCourseButton.setBorder(null);
        addToCourseButton.setBorderPainted(false);
        addToCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCourseButtonActionPerformed(evt);
            }
        });

        courseDetailsTable.setBackground(new java.awt.Color(153, 181, 155));
        courseDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ders ID", "Ders", "Öğretmen", "Gün", "Saat", "WH ID", "Öğ. ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(courseDetailsTable);

        expLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        expLabel6.setForeground(new java.awt.Color(51, 50, 44));
        expLabel6.setText("Eklenen dersler:");
        expLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        feeField.setBackground(new java.awt.Color(249, 249, 249));
        feeField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        feeField.setForeground(new java.awt.Color(125, 218, 114));
        feeField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N

        feeLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        feeLabel.setForeground(new java.awt.Color(51, 50, 44));
        feeLabel.setText("Toplam Ücret:");
        feeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        feeLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        feeLabel2.setForeground(new java.awt.Color(51, 50, 44));
        feeLabel2.setText("TL");
        feeLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        saveCourseButton.setBackground(new java.awt.Color(125, 218, 114));
        saveCourseButton.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        saveCourseButton.setForeground(new java.awt.Color(51, 50, 44));
        saveCourseButton.setText("Kaydet");
        saveCourseButton.setBorder(null);
        saveCourseButton.setBorderPainted(false);
        saveCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCourseButtonActionPerformed(evt);
            }
        });

        endDateField.setBackground(new java.awt.Color(249, 249, 249));
        endDateField.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        endDateField.setForeground(new java.awt.Color(125, 218, 114));
        endDateField.setText("31.12.2000");
        endDateField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("LingWai TC", 0, 18), new java.awt.Color(51, 50, 44))); // NOI18N
        endDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateFieldActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(125, 218, 114));
        backButton.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        backButton.setForeground(new java.awt.Color(51, 50, 44));
        backButton.setText("Geri");
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        craftTable.setBackground(new java.awt.Color(153, 181, 155));
        craftTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ders İsmi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        craftTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        craftTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        craftTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                craftTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(craftTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addToCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(choosenCraftLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choosenCraftField, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addGap(48, 48, 48))
                    .addComponent(craftLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(chooseDateLabel)
                        .addGap(18, 18, 18)
                        .addComponent(weekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(startDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finishDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(expLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(feeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(feeField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(feeLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveCourseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chooseDateLabel)
                            .addComponent(weekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(craftLabel)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(choosenCraftLabel)
                            .addComponent(choosenCraftField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addToCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(expLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateLabel)
                            .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finishDateLabel)
                            .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(feeLabel)
                            .addComponent(feeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(feeLabel2))))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened
    
    private void saveCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCourseButtonActionPerformed
        
        String startDateString = startDateField.getText();
        String endDateString = endDateField.getText();
        java.sql.Date startDate;
        java.sql.Date endDate;
        double fee;
        int rowCount = courseDetailsTable.getRowCount();
        
        if(rowCount == 0){
            JOptionPane.showMessageDialog(null, "Kursu oluşturmak için ders eklemelisiniz!");
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");

            try{
                fee = Double.parseDouble(feeField.getText());
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Lütfen geçerli bir ücret giriniz!");
                return;
            }

            try{
                java.util.Date parsedStartDate = sdf.parse(startDateString);
                java.util.Date parsedEndDate = sdf.parse(endDateString);
                startDate = new Date(parsedStartDate.getTime());
                endDate = new Date(parsedEndDate.getTime());

                int courseID = DatabaseHelper.insertCourse(startDate, endDate, getIsWeekday(), fee);
                
                for (int i = 0; i < rowCount; i++) {
                    String craftIDStr = courseDetailsTable.getValueAt(i, 0).toString();
                    String workingHourIDStr = courseDetailsTable.getValueAt(i, 5).toString();
                    String instructorIDStr = (courseDetailsTable.getValueAt(i, 6)).toString();
                    
                    
                    int craftID = Integer.parseInt(craftIDStr);
                    int workingHourID = Integer.parseInt(workingHourIDStr);
                    int instructorID = Integer.parseInt(instructorIDStr);
                    
                    DatabaseHelper.insertSection(instructorID , workingHourID, craftID, courseID);
                }

                dispose();
                new Dashboard().setVisible(true);
            } catch(ParseException e){
                JOptionPane.showMessageDialog(null, "Lütfen GG.AA.YYYY formatında tarihler giriniz!");
            }
        }
    }//GEN-LAST:event_saveCourseButtonActionPerformed
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed
        
    private void craftTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_craftTableMouseClicked
        int selectedRow = craftTable.getSelectedRow();
        if (selectedRow != -1) {
            String selectedCraft = craftTable.getValueAt(selectedRow, 1).toString();
            choosenCraftField.setText(selectedCraft);
            Course.displayInstructorsForCourseCreation(instructorsTable, getCraftID(), getIsWeekday());
        }
        else {
            JOptionPane.showMessageDialog(null, "Lütfen bir ders seçiniz!");
        }
    }//GEN-LAST:event_craftTableMouseClicked
        
    private void addToCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCourseButtonActionPerformed
        int selectedCraft = craftTable.getSelectedRow();
        int selectedInstructor = instructorsTable.getSelectedRow();
        
        if (selectedCraft != -1 && selectedInstructor != -1) {
            String craftName = craftTable.getValueAt(selectedCraft, 1).toString();
            
            if (courseDetailsTable.getRowCount() > 0){
                String example = courseDetailsTable.getValueAt(0, 1).toString();
                try {
                    if (DatabaseHelper.checkIfItsCompatible(example) != DatabaseHelper.checkIfItsCompatible(craftName)){
                       JOptionPane.showMessageDialog(null, "Haftasonu ve haftaiçi dersleri aynı kursta bulunamaz!");  
                       return;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (getExistingCraft(craftName)) return;
            displayCourseDetails();  
        }
        else {
            if (selectedCraft==-1) {
                JOptionPane.showMessageDialog(null, "Lütfen bir ders seçiniz!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Lütfen bir öğretmen seçiniz!");
            }
            
            return;
        }
    }//GEN-LAST:event_addToCourseButtonActionPerformed
    
    private void startDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateFieldActionPerformed
    
    private void endDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateFieldActionPerformed

    private void weekComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekComboBoxActionPerformed
        Craft.displayAllCraftsDependingDays(getIsWeekday(), craftTable);
    }//GEN-LAST:event_weekComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(CourseCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseCreation().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCourseButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel chooseDateLabel;
    private javax.swing.JTextField choosenCraftField;
    private javax.swing.JLabel choosenCraftLabel;
    private javax.swing.JTable courseDetailsTable;
    private javax.swing.JLabel craftLabel;
    private javax.swing.JTable craftTable;
    private javax.swing.JTextField endDateField;
    private javax.swing.JLabel expLabel6;
    private javax.swing.JTextField feeField;
    private javax.swing.JLabel feeLabel;
    private javax.swing.JLabel feeLabel2;
    private javax.swing.JLabel finishDateLabel;
    private javax.swing.JTable instructorsTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton saveCourseButton;
    private javax.swing.JTextField startDateField;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JComboBox<String> weekComboBox;
    // End of variables declaration//GEN-END:variables
}
