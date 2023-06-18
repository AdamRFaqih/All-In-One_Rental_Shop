/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JGUI;

import Controller.BrowseController;
import Item.Item;
import java.util.ArrayList;

/**
 *
 * @author rahma
 */
public class BrowseView extends javax.swing.JPanel {

    /**
     * Creates new form BrowseView
     */
    public BrowseView() {
        initComponents();
        // call ItemCollection.renderCollection( ) with list of item panel as the parameter!
        // --> this.itemCollection.renderCollection(items);
        this.itemCollection.renderCollection(new ArrayList<Item>(){});
    }
    /**
     * Creates new form BrowseView
     * @param items
     */
    public BrowseView(ArrayList<Item> items) {
        initComponents();
        // call ItemCollection.renderCollection( ) with list of item panel as the parameter!
        // --> this.itemCollection.renderCollection(items);
        this.itemCollection.renderCollection(items);
    }
    
    public void showRecomendationItem(int count){
        this.getItemCollection().renderCollection(
                BrowseController.generateRecomendationItem(count)
        );
    }
    
    public void browseItem(){
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        itemCollection = new JGUI.ItemCollection();

        jButton1.setText("Search");

        jTextField1.setText("cari nama atau merek barang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemCollection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemCollection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JGUI.ItemCollection itemCollection;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the itemCollection
     */
    public JGUI.ItemCollection getItemCollection() {
        return itemCollection;
    }

    /**
     * @param itemCollection the itemCollection to set
     */
    public void setItemCollection(JGUI.ItemCollection itemCollection) {
        this.itemCollection = itemCollection;
    }

}
