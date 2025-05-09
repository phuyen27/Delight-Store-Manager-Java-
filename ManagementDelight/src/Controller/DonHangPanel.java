/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StatisticsHelper;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author USER
 */
public class DonHangPanel extends javax.swing.JPanel {

    /**
     * Creates new form DonHangPanel
     */
    private CardLayout cardLayout;
    public DonHangPanel() {
        initComponents();
        
         ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Image/order_1.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        jLabel1.setIcon(resizedIcon);

        ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/Image/checklist.png"));
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);  
        ImageIcon resizedIcon1 = new ImageIcon(scaledImage1);  
        jLabel2.setIcon(resizedIcon1);
        
         int totalOrders = StatisticsHelper.getTotalOrders();
         int tongPhieuNhap = StatisticsHelper.getTotalPhieuNhap();
        
        lblTongDonHang.setText("Tổng đơn hàng: " + totalOrders);
        lblTongPhieuNhap.setText("Tổng phiếu nhập: " + tongPhieuNhap);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTongDonHang = new javax.swing.JLabel();
        lblTongPhieuNhap = new javax.swing.JLabel();
        btnDonHang = new javax.swing.JButton();
        btnPhieuNhap = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        lblTongDonHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTongDonHang.setForeground(new java.awt.Color(0, 102, 0));
        lblTongDonHang.setText("Tổng đơn hàng:");

        lblTongPhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTongPhieuNhap.setForeground(new java.awt.Color(0, 102, 0));
        lblTongPhieuNhap.setText("Tổng phiếu nhập");

        btnDonHang.setBackground(new java.awt.Color(0, 102, 0));
        btnDonHang.setForeground(new java.awt.Color(255, 255, 255));
        btnDonHang.setText("Xem đơn hàng");
        btnDonHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonHangActionPerformed(evt);
            }
        });

        btnPhieuNhap.setBackground(new java.awt.Color(0, 102, 0));
        btnPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnPhieuNhap.setText("Xem phiếu nhập");
        btnPhieuNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTongDonHang)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDonHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongPhieuNhap, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPhieuNhap, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongDonHang)
                    .addComponent(lblTongPhieuNhap))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDonHang)
                    .addComponent(btnPhieuNhap))
                .addContainerGap(189, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonHangActionPerformed
        // TODO add your handling code here:
    DonDatHang donDatHangFrame = new DonDatHang();
    donDatHangFrame.setVisible(true);
    donDatHangFrame.setLocationRelativeTo(null);
    JFrame topFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
    topFrame.dispose();
    }//GEN-LAST:event_btnDonHangActionPerformed

    private void btnPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuNhapActionPerformed
        // TODO add your handling code here:
    PhieuNhapHang phieuNhapFrame = new PhieuNhapHang();
    phieuNhapFrame.setVisible(true);
    phieuNhapFrame.setLocationRelativeTo(null);
    JFrame topFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
    topFrame.dispose();
    }//GEN-LAST:event_btnPhieuNhapActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonHang;
    private javax.swing.JButton btnPhieuNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTongDonHang;
    private javax.swing.JLabel lblTongPhieuNhap;
    // End of variables declaration//GEN-END:variables

   
}
