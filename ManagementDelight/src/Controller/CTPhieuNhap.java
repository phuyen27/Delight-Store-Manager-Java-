/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DatabaseHelper;
import View.TrangChu;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class CTPhieuNhap extends javax.swing.JFrame {

    /**
     * Creates new form CTPhieuNhap
     */
    String MaPNH = "";
    String query = "SELECT MaPNH, MaSP,SoLuong,DonGiaNhap FROM ChiTietPhieuNhap WHERE MaPNH = " +MaPNH;
    public CTPhieuNhap(String maPNH) {
        
         MaPNH = maPNH;
        query = "SELECT MaPNH, MaSP,SoLuong,DonGiaNhap FROM ChiTietPhieuNhap WHERE MaPNH = " +MaPNH;
        initComponents();
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Image/profile.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        lblThem.setIcon(resizedIcon);

        ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/Image/bin.png"));
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);  
        ImageIcon resizedIcon1 = new ImageIcon(scaledImage1);  
        lblXoa.setIcon(resizedIcon1);

        ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/Image/loop.png"));
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);  
        ImageIcon resizedIcon2 = new ImageIcon(scaledImage2);  
        lblLoad.setIcon(resizedIcon2);

        ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/Image/pen.png"));
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);  
        ImageIcon resizedIcon3 = new ImageIcon(scaledImage3);  
        lblSua.setIcon(resizedIcon3);
        
        
        ImageIcon originalIcon4 = new ImageIcon(getClass().getResource("/Image/search.png"));
        Image scaledImage4 = originalIcon4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon4 = new ImageIcon(scaledImage4);  
        lblTimKiem.setIcon(resizedIcon4);
        
        ImageIcon originalIcon5 = new ImageIcon(getClass().getResource("/Image/btnDau.png"));
        Image scaledImage5 = originalIcon5.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);  
        ImageIcon resizedIcon5 = new ImageIcon(scaledImage5);  
        lblDau.setIcon(resizedIcon5);
        
        ImageIcon originalIcon6 = new ImageIcon(getClass().getResource("/Image/btnTruoc.png"));
        Image scaledImage6 = originalIcon6.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);  
        ImageIcon resizedIcon6 = new ImageIcon(scaledImage6);  
        lblTruoc.setIcon(resizedIcon6);
        
        ImageIcon originalIcon7 = new ImageIcon(getClass().getResource("/Image/btnSau.png"));
        Image scaledImage7 = originalIcon7.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon7 = new ImageIcon(scaledImage7);  
        lblKe.setIcon(resizedIcon7);
        
        ImageIcon originalIcon8 = new ImageIcon(getClass().getResource("/Image/btnCuoi.png"));
        Image scaledImage8 = originalIcon8.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);  
        ImageIcon resizedIcon8 = new ImageIcon(scaledImage8);  
        lblCuoi.setIcon(resizedIcon8);
        
        ImageIcon originalIcon9 = new ImageIcon(getClass().getResource("/Image/back.png"));
        Image scaledImage9 = originalIcon9.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);  
        ImageIcon resizedIcon9 = new ImageIcon(scaledImage9);  
        lblBack.setIcon(resizedIcon9);
  
        tbCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                 "Mã PNH", "Mã SP", "Số lượng", "Đơn giá nhập"
            }
        ));
       
        lblMaDH.setText(maPNH);
        loadDataNhaCungCap(query);
        loadCombobox();
        
    }
    
     private void loadDataNhaCungCap(String query) {
        DefaultTableModel model = (DefaultTableModel) tbCT.getModel();
        model.setRowCount(0); 

        Connection conn = DatabaseHelper.connect(); 
        if (conn != null) {
            try {     
               Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
   
                while (rs.next()) {
                    Vector<String> row = new Vector<>();
                 
                    row.add(rs.getString("MaPNH"));
                    row.add(rs.getString("MaSP"));
                    row.add(rs.getString("SoLuong"));
                    row.add(rs.getString("DonGiaNhap"));
                   
                    
                    System.out.println("Đang load chi tiết đơn hàng...");
             
                    model.addRow(row);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close(); 
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
      private void updateEmployeeInfo(int rowIndex) {
      
      
        String maPN = tbCT.getValueAt(rowIndex, 0).toString();
        String maSP = tbCT.getValueAt(rowIndex, 1).toString();       
        String soLuong = tbCT.getValueAt(rowIndex, 2).toString();
        String donGia = tbCT.getValueAt(rowIndex, 3).toString();
       

       
       cbMaSP.setSelectedItem(maSP);
        txtSoLuong.setText(soLuong);
        txtDonGia.setText(donGia);
       
    }
      
      private void loadCombobox() {   
        
        DefaultComboBoxModel<String> modelSX = new DefaultComboBoxModel<>();
        modelSX.addElement("Sắp xếp theo số lượng");
        modelSX.addElement("Sắp xếp theo đơn giá");       
        cbSapXep.setModel(modelSX);
        
        DefaultComboBoxModel<String> modelTK = new DefaultComboBoxModel<>();
        modelTK.addElement("Tìm theo mã sản phẩm");
        modelTK.addElement("Tìm theo đơn giá");
        cbTimKiem.setModel(modelTK);
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        cbMaSP.setModel(model);
       
       
        Connection conn = DatabaseHelper.connect();
        if (conn != null) {
            try {             
                String query = "SELECT MaSP FROM SanPham";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String maKH = rs.getString("MaSP");
                    model.addElement(maKH); 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
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
        txtTimKiem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblKe = new javax.swing.JLabel();
        cbTimKiem = new javax.swing.JComboBox<>();
        cbMaSP = new javax.swing.JComboBox<>();
        lblCuoi = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        lblThem = new javax.swing.JLabel();
        lblMaDH = new javax.swing.JLabel();
        lblXoa = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        cbSapXep = new javax.swing.JComboBox<>();
        lblDau = new javax.swing.JLabel();
        lblLoad = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCT = new javax.swing.JTable();
        lblSua = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTruoc = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(252, 248, 239));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 102, 0));
        jLabel14.setText("Số lượng");

        lblKe.setText("lblKe");
        lblKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeMouseClicked(evt);
            }
        });

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMaSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCuoi.setText("jLabel12");
        lblCuoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCuoiMouseClicked(evt);
            }
        });

        txtSoLuong.setColumns(15);

        lblThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemMouseClicked(evt);
            }
        });

        lblMaDH.setText("jLabel1");

        lblXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblXoaMouseClicked(evt);
            }
        });

        txtDonGia.setColumns(15);

        cbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSapXep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSapXepActionPerformed(evt);
            }
        });

        lblDau.setText("jLabel9");
        lblDau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDauMouseClicked(evt);
            }
        });

        lblLoad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoadMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 102, 0));
        jLabel10.setText("Mã phiếu nhập");

        tbCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCT);

        lblSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSuaMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 102, 0));
        jLabel11.setText("Mã sản phẩm");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel12.setText("QUẢN LÝ CHI TIẾT PHIẾU NHẬP");

        lblTruoc.setText("jLabel9");
        lblTruoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruocMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 102, 0));
        jLabel13.setText("Đơn giá");

        lblTimKiem.setText("jLabel9");
        lblTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTimKiemMouseClicked(evt);
            }
        });

        lblBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBack.setText("Quay lại");
        lblBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblKe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(cbMaSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMaDH))
                                    .addComponent(txtSoLuong)
                                    .addComponent(txtDonGia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem)
                                .addGap(18, 18, 18)
                                .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(11, 11, 11)))
                .addGap(79, 79, 79))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblMaDH))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void lblKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeMouseClicked

        int selectedRow = tbCT.getSelectedRow();

        int rowCount = tbCT.getRowCount();

        if (selectedRow >= 0 && selectedRow < rowCount - 1) {
            // Chọn dòng tiếp theo
            tbCT.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);

            // Cập nhật thông tin cho nhân viên tiếp theo
            updateEmployeeInfo(selectedRow + 1);
        }
    }//GEN-LAST:event_lblKeMouseClicked

    private void lblCuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCuoiMouseClicked

        int rowCount = tbCT.getRowCount();
        if (rowCount > 0) {

            int lastRow = rowCount - 1;

            tbCT.setRowSelectionInterval(lastRow, lastRow);

            updateEmployeeInfo(lastRow);
        }
    }//GEN-LAST:event_lblCuoiMouseClicked

    private void lblThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseClicked

        String maSP = cbMaSP.getSelectedItem().toString();

        String soLuong = txtSoLuong.getText();
        String donGia = txtDonGia.getText();

        String sql = "INSERT INTO ChiTietPhieuNhap (MaPNH, MaSP, SoLuong, DonGiaNhap) VALUES (?, ?, ?, ?)";

        Connection conn = DatabaseHelper.connect();
        if (conn != null) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, MaPNH);
                stmt.setString(2, maSP);
                stmt.setString(3, soLuong);
                stmt.setString(4, donGia);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    loadDataNhaCungCap(query);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_lblThemMouseClicked

    private void lblXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXoaMouseClicked
        int selectedRow = tbCT.getSelectedRow();
        if (selectedRow != -1) {
            String maNV = tbCT.getValueAt(selectedRow, 0).toString();
            String maSP = tbCT.getValueAt(selectedRow, 0).toString();
            String sql = "DELETE FROM ChiTietPhieuNhap WHERE MaPNH = ? and MaSP";

            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, maNV);
                    stmt.setString(2, maSP);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        loadDataNhaCungCap(query);
                        JOptionPane.showMessageDialog(null, "Chi tiết phiếu nhập đã được xóa thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết phiếu nhập để xóa!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn một chi tiết phiếu nhập để xóa!");
        }
    }//GEN-LAST:event_lblXoaMouseClicked

    private void cbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepActionPerformed
        // TODO add your handling code here:

        // Lấy giá trị chọn từ ComboBox
        String selectedOption = cbSapXep.getSelectedItem().toString();

        // Tạo câu lệnh truy vấn dựa trên lựa chọn của người dùng
        String querySX = "";
        switch (selectedOption) {
            case "Sắp xếp theo đơn giá":
            querySX = query+" ORDER BY DonGiaNhap";
            break;
            case "Sắp xếp theo số lượng":
            querySX = query +" ORDER BY SoLuong";
            break;

            default:
            querySX = query; // Mặc định không sắp xếp
            break;
        }

        loadDataNhaCungCap(querySX);
    }//GEN-LAST:event_cbSapXepActionPerformed

    private void lblDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDauMouseClicked
        int rowCount = tbCT.getRowCount();
        if (rowCount > 0) {
            tbCT.setRowSelectionInterval(0, 0);
            updateEmployeeInfo(0);
        }
    }//GEN-LAST:event_lblDauMouseClicked

    private void lblLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoadMouseClicked
        loadDataNhaCungCap(query);
    }//GEN-LAST:event_lblLoadMouseClicked

    private void tbCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTMouseClicked
        int selectedRow = tbCT.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tbCT.getModel();

            String maDH = model.getValueAt(selectedRow, 0).toString();
            String maSP = model.getValueAt(selectedRow, 1).toString();
            String soLuong = model.getValueAt(selectedRow, 2).toString();
            String donGia = model.getValueAt(selectedRow, 3).toString();

            cbMaSP.setSelectedItem(maSP);
            txtSoLuong.setText(soLuong);
            txtDonGia.setText(donGia);

        }
    }//GEN-LAST:event_tbCTMouseClicked

    private void lblSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuaMouseClicked

        int selectedRow = tbCT.getSelectedRow();
        if (selectedRow != -1) {

            String maCT = tbCT.getValueAt(selectedRow, 0).toString();
            String MaSP = tbCT.getValueAt(selectedRow, 1).toString();

            String soLuong = txtSoLuong.getText();
            String donGia = txtDonGia.getText();

            String sql = "UPDATE ChiTietPhieuNhap SoLuong = ?, DonGia  WHERE MaPNH = ? And MaSP = ?";

            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                   
                    stmt.setString(1, soLuong);
                    stmt.setString(2, donGia);
                    stmt.setString(3, maCT);
                    stmt.setString(4, MaSP);

                    int rowsAffected = stmt.executeUpdate(); // Thực thi câu lệnh
                    if (rowsAffected > 0) {
                        // Nếu sửa thành công, làm mới bảng nhân viên
                        loadDataNhaCungCap(query);
                        JOptionPane.showMessageDialog(null, "Cập nhật thông tin chi tiết phiếu nhập thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết phiếu nhập để sửa!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn một chi tiết phiếu nhập để sửa!");
        }
    }//GEN-LAST:event_lblSuaMouseClicked

    private void lblTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruocMouseClicked

        int selectedRow = tbCT.getSelectedRow();

        if (selectedRow > 0) {
            tbCT.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
            updateEmployeeInfo(selectedRow - 1);
        }
    }//GEN-LAST:event_lblTruocMouseClicked

    private void lblTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTimKiemMouseClicked
        String searchQuery = txtTimKiem.getText().trim();
        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin phiếu nhập cần tìm!");
            return;
        }

        String queryTK = "";
        String searchType = cbTimKiem.getSelectedItem().toString(); // Lấy lựa chọn từ ComboBox tìm kiếm

        if (searchType.equals("Tìm theo mã sản phẩm")) {
            // Tìm theo mã khách hàng (MaKH)
            queryTK = query + " WHERE MaSP = " + searchQuery;
        } else if (searchType.equals("Tìm theo giá")) {
            // Tìm theo trạng thái (TrangThai)
            queryTK = query + " WHERE DonGiaNhap = " + searchQuery;
        }

        // Gọi hàm loadDataDonDH để hiển thị dữ liệu theo câu truy vấn
        loadDataNhaCungCap(queryTK);
    }//GEN-LAST:event_lblTimKiemMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        // TODO add your handling code here:
        new TrangChu().setVisible(true);

        // Đóng cửa sổ đăng nhập
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

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
            java.util.logging.Logger.getLogger(CTPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CTPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CTPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CTPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMaSP;
    private javax.swing.JComboBox<String> cbSapXep;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCuoi;
    private javax.swing.JLabel lblDau;
    private javax.swing.JLabel lblKe;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblMaDH;
    private javax.swing.JLabel lblSua;
    private javax.swing.JLabel lblThem;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTruoc;
    private javax.swing.JLabel lblXoa;
    private javax.swing.JTable tbCT;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
