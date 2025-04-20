/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DatabaseHelper;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author USER
 */
public class LoaiSPPanel extends javax.swing.JPanel {

    /**
     * Creates new form SanPhamPanel
     */
    String querySP = "SELECT \n" +
"    lsp.MaLoaiSP, \n" +
"    lsp.TenLoaiSP, \n" +
"    COUNT(sp.MaSP) AS SoLuongSanPham\n" +
"FROM \n" +
"    LoaiSP lsp\n" +
"LEFT JOIN \n" +
"    SanPham sp ON lsp.MaLoaiSP = sp.MaLoaiSP\n" +
"GROUP BY \n" +
"    lsp.MaLoaiSP, lsp.TenLoaiSP ";
   
   public LoaiSPPanel() {
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
        
       
       
         tbLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
               "Mã loại", "Tên loại", "Số lượng"
            }
        ));
       
        loadDataSP(querySP);
        loadCombobox();
        designTable(tbLoaiSP);
    }

   
   private void designTable(JTable table) {
    // Màu pastel theo chủ đề Giáng Sinh
    Color pastelGreen = new Color(204, 255, 204); // xanh lá nhạt
    Color pastelRed = new Color(255, 204, 204);   // đỏ nhạt
    Color pastelBlue = new Color(204, 229, 255);  // xanh dương nhạt
    Color pastelWhite = new Color(255, 255, 255); // trắng
    Color pastelHeader = new Color(255, 230, 230); // tiêu đề hồng nhạt

    // Nền tổng thể của bảng
    table.setBackground(pastelWhite); 
    table.setForeground(Color.DARK_GRAY);

    // Màu khi chọn dòng
    table.setSelectionBackground(pastelGreen); 
    table.setSelectionForeground(Color.BLACK);

    // Màu đường lưới
    table.setGridColor(new Color(230, 230, 230)); // xám nhạt

    // Tùy chỉnh header bảng
    JTableHeader header = table.getTableHeader();
    header.setBackground(pastelHeader);
    header.setForeground(new Color(102, 0, 0)); // đỏ đậm
    header.setFont(new Font("Segoe UI", Font.BOLD, 13));
}

   
    private void loadDataSP(String query) {
        DefaultTableModel model = (DefaultTableModel) tbLoaiSP.getModel();
        model.setRowCount(0); 

        Connection conn = DatabaseHelper.connect(); 
        if (conn != null) {
            try {     
               Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Vector<String> row = new Vector<>();
                    row.add(rs.getString("MaLoaiSP"));
                    row.add(rs.getString("TenLoaiSP"));
                  row.add(rs.getString("SoLuongSanPham"));
                    
                    
                    System.out.println("Đang load sản phẩm...");
             
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

    private void loadCombobox() {   
        
        DefaultComboBoxModel<String> modelSX = new DefaultComboBoxModel<>();
       
        modelSX.addElement("Sắp xếp theo tên");
     modelSX.addElement("Sắp xếp số lượng sản phẩm");
        cbSapXep.setModel(modelSX);
        
        DefaultComboBoxModel<String> modelTK = new DefaultComboBoxModel<>();
        modelTK.addElement("Tìm theo mã loại");
        modelTK.addElement("Tìm theo tên loại");
        cbTimKiem.setModel(modelTK);
        
       
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
        jLabel5 = new javax.swing.JLabel();
        lblCuoi = new javax.swing.JLabel();
        lblThem = new javax.swing.JLabel();
        lblXoa = new javax.swing.JLabel();
        lblLoad = new javax.swing.JLabel();
        lblSua = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLoaiSP = new javax.swing.JTable();
        lblTimKiem = new javax.swing.JLabel();
        cbSapXep = new javax.swing.JComboBox<>();
        lblDau = new javax.swing.JLabel();
        lblTruoc = new javax.swing.JLabel();
        lblKe = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        cbTimKiem = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblSL = new javax.swing.JLabel();
        txtMaLoai = new java.awt.TextField();
        btnSanPham = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("QUẢN LÝ NHÀ CUNG CẤP");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("QUẢN LÝ LOẠI SẢN PHẨM");

        jLabel5.setText("Tên loại sản phẩm");

        lblCuoi.setText("jLabel12");
        lblCuoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCuoiMouseClicked(evt);
            }
        });

        lblThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemMouseClicked(evt);
            }
        });

        lblXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblXoaMouseClicked(evt);
            }
        });

        lblLoad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoadMouseClicked(evt);
            }
        });

        lblSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSuaMouseClicked(evt);
            }
        });

        tbLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tbLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLoaiSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbLoaiSP);

        lblTimKiem.setText("jLabel9");
        lblTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTimKiemMouseClicked(evt);
            }
        });

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

        lblTruoc.setText("jLabel9");
        lblTruoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruocMouseClicked(evt);
            }
        });

        lblKe.setText("lblKe");
        lblKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeMouseClicked(evt);
            }
        });

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Mã loại sản phẩm");

        txtTenLoai.setColumns(10);

        jLabel4.setText("Số lượng sản phẩm");

        lblSL.setText("jLabel6");

        btnSanPham.setBackground(new java.awt.Color(0, 102, 0));
        btnSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSanPham.setText("Xem sản phẩm");
        btnSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(lblMaSP)
                            .addGap(82, 82, 82)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblSL))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTenLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(76, 76, 76)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblKe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMaSP)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblSL))
                        .addGap(18, 18, 18)
                        .addComponent(btnSanPham)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
    }// </editor-fold>//GEN-END:initComponents

     private void updateSP(int rowIndex) {
      
        String maSP = tbLoaiSP.getValueAt(rowIndex, 0).toString();
        String tenSP = tbLoaiSP.getValueAt(rowIndex, 1).toString();
        String sl = tbLoaiSP.getValueAt(rowIndex, 2).toString();
       
     
        txtMaLoai.setText(maSP);
        txtTenLoai.setText(tenSP);
       lblSL.setText(sl);
    }
    
    private void lblCuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCuoiMouseClicked

        int rowCount = tbLoaiSP.getRowCount();
        if (rowCount > 0) {

            int lastRow = rowCount - 1;

            tbLoaiSP.setRowSelectionInterval(lastRow, lastRow);

            updateSP(lastRow);
        }
    }//GEN-LAST:event_lblCuoiMouseClicked

    private void lblThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseClicked

        String maLoai = txtMaLoai.getText();
        String tenLoai = txtTenLoai.getText();
       
       
        String sql = "INSERT INTO LoaiSP (TenLoaiSP) VALUES (?)";

        Connection conn = DatabaseHelper.connect();
        if (conn != null) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, tenLoai);
                
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Sản phẩm đã được thêm thành công!");
                    loadDataSP(querySP);
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
        if (tbLoaiSP.isEditing()) {
        tbLoaiSP.getCellEditor().stopCellEditing();
    }

    int selectedRow = tbLoaiSP.getSelectedRow();
    if (selectedRow != -1) {
        String maLoaiSP = tbLoaiSP.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(null,
            "Bạn có chắc chắn muốn xóa loại sản phẩm này không?",
            "Xác nhận xóa",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM LoaiSP WHERE MaLoaiSP = ?";
            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, maLoaiSP);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        loadDataSP(querySP);
                        JOptionPane.showMessageDialog(null, "Loại sản phẩm đã được xóa thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy loại sản phẩm để xóa!");
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
    } else {
        JOptionPane.showMessageDialog(null, "Hãy chọn một loại sản phẩm để xóa!");
    }

    }//GEN-LAST:event_lblXoaMouseClicked

    private void lblLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoadMouseClicked
        loadDataSP(querySP);
        txtMaLoai.setText("");
        txtTenLoai.setText("");
        lblSL.setText("");
    }//GEN-LAST:event_lblLoadMouseClicked

    private void lblSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuaMouseClicked

        int selectedRow = tbLoaiSP.getSelectedRow();
        if (selectedRow != -1) {

           String maLoai = txtMaLoai.getText();
            String tenSP = txtTenLoai.getText();
            
          
            String sql = "UPDATE LoaiSP SET TenLoaiSP = ? WHERE MaLoaiSP = ?";

            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, tenSP);
                   stmt.setString(2, maLoai);

                    int rowsAffected = stmt.executeUpdate(); // Thực thi câu lệnh
                    if (rowsAffected > 0) {
                        // Nếu sửa thành công, làm mới bảng nhân viên
                        loadDataSP(querySP);
                        JOptionPane.showMessageDialog(null, "Cập nhật thông tin sản phẩm thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên để sửa!");
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
            JOptionPane.showMessageDialog(null, "Hãy chọn một loại sản phẩm để sửa!");
        }

    }//GEN-LAST:event_lblSuaMouseClicked

    private void tbLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLoaiSPMouseClicked
        int selectedRow = tbLoaiSP.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tbLoaiSP.getModel();
            String maLoai = model.getValueAt(selectedRow, 0).toString();
            String tenLoai = model.getValueAt(selectedRow, 1).toString();
            String SL = model.getValueAt(selectedRow, 2).toString();
            
           
            txtTenLoai.setText(tenLoai);
            txtMaLoai.setText(maLoai);
            lblSL.setText(SL);
            
        }
    }//GEN-LAST:event_tbLoaiSPMouseClicked

    private void lblTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTimKiemMouseClicked
        String searchQuery = txtTimKiem.getText().trim();
        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin phiếu nhập cần tìm!");
            return;
        }

        String baseQuerySP = "SELECT \n" +
    "    lsp.MaLoaiSP, \n" +
    "    lsp.TenLoaiSP, \n" +
    "    COUNT(sp.MaSP) AS SoLuongSanPham\n" +
    "FROM \n" +
    "    LoaiSP lsp\n" +
    "LEFT JOIN \n" +
    "    SanPham sp ON lsp.MaLoaiSP = sp.MaLoaiSP\n";

        String searchType = cbTimKiem.getSelectedItem().toString(); 
        String queryTK = baseQuerySP; // bắt đầu với phần FROM

        if (searchType.equals("Tìm theo mã loại")) {
            queryTK += "WHERE lsp.MaLoaiSP = " + searchQuery + "\n";
        } else if (searchType.equals("Tìm theo tên sản phẩm")) {
            queryTK += "WHERE lsp.TenLoaiSP LIKE N'%" + searchQuery + "%'\n";
        }

        // Phần GROUP BY luôn phải đứng cuối
        queryTK += "GROUP BY lsp.MaLoaiSP, lsp.TenLoaiSP";

        loadDataSP(queryTK);

    }//GEN-LAST:event_lblTimKiemMouseClicked

    private void cbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepActionPerformed
 
        String selectedOption = cbSapXep.getSelectedItem().toString();

        // Tạo câu lệnh truy vấn dựa trên lựa chọn của người dùng
        String querySX = "";
        switch (selectedOption) {
           
            case "Sắp xếp theo đơn giá":
            querySX = querySP +" ORDER BY SoLuongSanPham";
            break;
            case "Sắp xếp theo tên":
            querySX = querySP +" ORDER BY TenLoaiSP ";
            break;
            default:
            querySX = querySP; // Mặc định không sắp xếp
            break;
        }

        // Gọi hàm loadDataNhanVien với câu truy vấn đã tạo
        loadDataSP(querySX);

    }//GEN-LAST:event_cbSapXepActionPerformed

    private void lblDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDauMouseClicked
        int rowCount = tbLoaiSP.getRowCount();
        if (rowCount > 0) {
            tbLoaiSP.setRowSelectionInterval(0, 0);
            updateSP(0);
        }
    }//GEN-LAST:event_lblDauMouseClicked

    private void lblTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruocMouseClicked

        int selectedRow = tbLoaiSP.getSelectedRow();

        if (selectedRow > 0) {
            tbLoaiSP.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
            updateSP(selectedRow - 1);
        }
    }//GEN-LAST:event_lblTruocMouseClicked

    private void lblKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeMouseClicked

        int selectedRow = tbLoaiSP.getSelectedRow();

        int rowCount = tbLoaiSP.getRowCount();

        if (selectedRow >= 0 && selectedRow < rowCount - 1) {
            // Chọn dòng tiếp theo
            tbLoaiSP.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);

            // Cập nhật thông tin cho nhân viên tiếp theo
            updateSP(selectedRow + 1);
        }
    }//GEN-LAST:event_lblKeMouseClicked

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        // TODO add your handling code here:
        String maSP = txtMaLoai.getText().trim();

        if (maSP.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin loại sản phẩm!");
        } else {
            SanPham sanPhamFrame = new SanPham(maSP);  // truyền maSP vào constructor
            sanPhamFrame.setVisible(true);
            sanPhamFrame.setLocationRelativeTo(null);

            JFrame topFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }

    }//GEN-LAST:event_btnSanPhamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSanPham;
    private javax.swing.JComboBox<String> cbSapXep;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCuoi;
    private javax.swing.JLabel lblDau;
    private javax.swing.JLabel lblKe;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblSL;
    private javax.swing.JLabel lblSua;
    private javax.swing.JLabel lblThem;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTruoc;
    private javax.swing.JLabel lblXoa;
    private javax.swing.JTable tbLoaiSP;
    private java.awt.TextField txtMaLoai;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
