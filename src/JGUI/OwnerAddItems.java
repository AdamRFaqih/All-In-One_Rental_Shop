/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JGUI;

/**
 *
 * @author kamalmlzka
 */
public class OwnerAddItems extends NavigatableJFrame {

    /**
     * Creates new form OwnerAddItems
     */
    public OwnerAddItems() {
        initComponents();
        this.setLocationRelativeTo(null);
        label5.hide();
        field5.hide();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addMobil = new javax.swing.JRadioButton();
        addMotor = new javax.swing.JRadioButton();
        addGame = new javax.swing.JRadioButton();
        addMovie = new javax.swing.JRadioButton();
        field1 = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        field2 = new javax.swing.JTextField();
        field3 = new javax.swing.JTextField();
        field4 = new javax.swing.JTextField();
        confirmAddItem = new javax.swing.JButton();
        field5 = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel2.setText("Rental Shop");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("All In One");

        jLabel3.setText("Add New Item");

        buttonGroup1.add(addMobil);
        addMobil.setText("Mobil");
        addMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMobilActionPerformed(evt);
            }
        });

        buttonGroup1.add(addMotor);
        addMotor.setText("Motor");
        addMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMotorActionPerformed(evt);
            }
        });

        buttonGroup1.add(addGame);
        addGame.setText("Game");
        addGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGameActionPerformed(evt);
            }
        });

        buttonGroup1.add(addMovie);
        addMovie.setText("Movie");
        addMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMovieActionPerformed(evt);
            }
        });

        label1.setLabelFor(field1);
        label1.setText("pabrikan");

        label2.setLabelFor(field2);
        label2.setText("model");

        label3.setLabelFor(field3);
        label3.setText("tahunKeluaran");

        label4.setLabelFor(field4);
        label4.setText("Bahan bakar");

        confirmAddItem.setText("Add Item");
        confirmAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAddItemActionPerformed(evt);
            }
        });

        label5.setLabelFor(field5);
        label5.setText("label5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmAddItem))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1))
                        .addGap(112, 112, 112)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addMobil)
                                .addGap(18, 18, 18)
                                .addComponent(addMotor)
                                .addGap(48, 48, 48)
                                .addComponent(addGame)
                                .addGap(18, 18, 18)
                                .addComponent(addMovie)
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(label1))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(label3)
                                                .addComponent(label4)
                                                .addComponent(label2)))
                                        .addGap(16, 16, 16))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(field2)
                                    .addComponent(field1)
                                    .addComponent(field3)
                                    .addComponent(field4)
                                    .addComponent(field5, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMobil)
                    .addComponent(addMotor)
                    .addComponent(addGame)
                    .addComponent(addMovie))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label4)
                    .addComponent(field4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(confirmAddItem)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMobilActionPerformed
        // TODO add your handling code here:
        label1.setText("pabrikan");
        label2.setText("model");
        label3.setText("tahunKeluar");
        label4.setText("bahanBakar");
        field4.show();
        label5.hide();
        field5.hide();
        
    }//GEN-LAST:event_addMobilActionPerformed

    private void addMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMotorActionPerformed
        // TODO add your handling code here:
        label1.setText("pabrikan");
        label2.setText("model");
        label3.setText("tahunKeluar");
        label4.setText("");
        field4.hide();
        label5.hide();
        field5.hide();
    }//GEN-LAST:event_addMotorActionPerformed

    private void addGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGameActionPerformed
        // TODO add your handling code here:
        label1.setText("title");
        label2.setText("genre");
        label3.setText("publisher");
        label4.setText("condition");
        field4.show();
        label5.hide();
        field5.hide();
    }//GEN-LAST:event_addGameActionPerformed

    private void addMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMovieActionPerformed
        // TODO add your handling code here:
        label1.setText("title");
        label2.setText("genre");
        label3.setText("releaseYear");
        label4.setText("director");
        label5.setText("condition");
        label5.show();
        field5.show();
    }//GEN-LAST:event_addMovieActionPerformed

    private void confirmAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAddItemActionPerformed
        // TODO add your handling code here:
        this.hide();
        prevFrame.show();
    }//GEN-LAST:event_confirmAddItemActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        prevFrame.show();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(OwnerAddItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerAddItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerAddItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerAddItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OwnerAddItems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addGame;
    private javax.swing.JRadioButton addMobil;
    private javax.swing.JRadioButton addMotor;
    private javax.swing.JRadioButton addMovie;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton confirmAddItem;
    private javax.swing.JTextField field1;
    private javax.swing.JTextField field2;
    private javax.swing.JTextField field3;
    private javax.swing.JTextField field4;
    private javax.swing.JTextField field5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    // End of variables declaration//GEN-END:variables
}
