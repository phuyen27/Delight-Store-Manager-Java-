/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DatabaseHelper;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class KhachHangPanel extends javax.swing.JPanel {

    /**
     * Creates new form KhachHangPanel
     */
    String query = "SELECT MaKH, HoKH, TenKH, SDTKH, NgaySinhKH, GioiTinh,DiaChi,EmailKH FROM KhachHang";
        
      
    
    public KhachHangPanel() {
        initComponents();
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Image/profile.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        lblThem.setIcon(resizedIcon);

        
        ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/Image/bin.png"));
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Sửa thành originalIcon1
        ImageIcon resizedIcon1 = new ImageIcon(scaledImage1);  // Sửa thành scaledImage1
        lblXoa.setIcon(resizedIcon1);

        ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/Image/loop.png"));
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Sửa thành originalIcon2
        ImageIcon resizedIcon2 = new ImageIcon(scaledImage2);  // Sửa thành scaledImage2
        lblLoad.setIcon(resizedIcon2);

        ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/Image/pen.png"));
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Sửa thành originalIcon3
        ImageIcon resizedIcon3 = new ImageIcon(scaledImage3);  // Sửa thành scaledImage3
        lblSua.setIcon(resizedIcon3);
        
        
        ImageIcon originalIcon4 = new ImageIcon(getClass().getResource("/Image/search.png"));
        Image scaledImage4 = originalIcon4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);  // Sửa thành originalIcon3
        ImageIcon resizedIcon4 = new ImageIcon(scaledImage4);  // Sửa thành scaledImage3
        lblTimKiem.setIcon(resizedIcon4);
        
        ImageIcon originalIcon5 = new ImageIcon(getClass().getResource("/Image/btnDau.png"));
        Image scaledImage5 = originalIcon5.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);  // Sửa thành originalIcon3
        ImageIcon resizedIcon5 = new ImageIcon(scaledImage5);  // Sửa thành scaledImage3
        lblDau.setIcon(resizedIcon5);
        
        ImageIcon originalIcon6 = new ImageIcon(getClass().getResource("/Image/btnTruoc.png"));
        Image scaledImage6 = originalIcon6.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);  // Sửa thành originalIcon3
        ImageIcon resizedIcon6 = new ImageIcon(scaledImage6);  // Sửa thành scaledImage3
        lblTruoc.setIcon(resizedIcon6);
        
        ImageIcon originalIcon7 = new ImageIcon(getClass().getResource("/Image/btnSau.png"));
        Image scaledImage7 = originalIcon7.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);  // Sửa thành originalIcon3
        ImageIcon resizedIcon7 = new ImageIcon(scaledImage7);  // Sửa thành scaledImage3
        lblKe.setIcon(resizedIcon7);
        
        ImageIcon originalIcon8 = new ImageIcon(getClass().getResource("/Image/btnCuoi.png"));
        Image scaledImage8 = originalIcon8.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);  // Sửa thành originalIcon3
        ImageIcon resizedIcon8 = new ImageIcon(scaledImage8);  // Sửa thành scaledImage3
        lblCuoi.setIcon(resizedIcon8);
         tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Mã KH", "Họ KH", "Tên KH", "SĐT", "Ngày Sinh", "Giới Tính","Địa chỉ","Email"
            }
        ));
        jScrollPane1.setViewportView(tbKhachHang);
        loadDataKhachHang(query);
        DefaultComboBoxModel<String> modelTK = new DefaultComboBoxModel<>();
        modelTK.addElement("Tìm theo mã khách");
        modelTK.addElement("Tìm theo địa chỉ");
        modelTK.addElement("Tìm theo tên");
        cbTimKiem.setModel(modelTK);
        
        DefaultComboBoxModel<String> modelSX = new DefaultComboBoxModel<>();
        modelSX.addElement("Sắp xếp theo Mã KH");
        modelSX.addElement("Sắp xếp theo Tên KH");
        modelSX.addElement("Sắp xếp theo tuổi");
        cbSapXep.setModel(modelSX);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdbNam = new javax.swing.JRadioButton();
        rdbNu = new javax.swing.JRadioButton();
        txtTimKiem = new java.awt.TextField();
        lblTimKiem = new javax.swing.JLabel();
        cbSapXep = new javax.swing.JComboBox<>();
        lblDau = new javax.swing.JLabel();
        lblTruoc = new javax.swing.JLabel();
        lblKe = new javax.swing.JLabel();
        lblCuoi = new javax.swing.JLabel();
        txtSDT = new java.awt.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgaySinh = new java.awt.TextField();
        lblThem = new javax.swing.JLabel();
        lblXoa = new javax.swing.JLabel();
        lblLoad = new javax.swing.JLabel();
        lblSua = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtHoKH = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        txtTenKH = new java.awt.TextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new java.awt.TextField();
        txtDiaChi = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JLabel();
        cbTimKiem = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        rdbNam.setBackground(new java.awt.Color(255, 255, 255));
        rdbNam.setText("Nam");

        rdbNu.setBackground(new java.awt.Color(255, 255, 255));
        rdbNu.setText("Nữ");

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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

        lblCuoi.setText("jLabel12");
        lblCuoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCuoiMouseClicked(evt);
            }
        });

        txtSDT.setColumns(16);

        jLabel4.setText("Tên khách hàng");

        jLabel5.setText("Số điện thoại");

        txtNgaySinh.setColumns(16);

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

        jLabel6.setText("Email");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel2.setText("QUẢN LÝ KHÁCH HÀNG");

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        jLabel3.setText("Mã KH");

        txtHoKH.setColumns(16);

        jLabel7.setText("Họ khách hàng");

        txtTenKH.setColumns(16);
        txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        jLabel8.setText("Ngày sinh (yyyy/mm/dd)");

        jLabel9.setText("Giới tính");

        txtEmail.setColumns(16);

        txtDiaChi.setColumns(16);

        jLabel1.setText("Địa chỉ");

        txtMaKH.setText("jLabel10");

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(rdbNam)
                                .addGap(37, 37, 37)
                                .addComponent(rdbNu))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaKH))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                            .addComponent(txtHoKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblKe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCuoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(85, 85, 85))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaKH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(1, 1, 1)
                        .addComponent(txtHoKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(1, 1, 1)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbNam)
                            .addComponent(rdbNu))
                        .addGap(61, 61, 61))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTimKiemMouseClicked
        // TODO add your handling code here:
         String searchQuery = txtTimKiem.getText().trim();
        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin khách hàng cần tìm!");
            return;
        }

        String queryTK = "";
        String searchType = cbTimKiem.getSelectedItem().toString(); 

        if (searchType.equals("Tìm theo mã khách")) {
        
            queryTK = query + " WHERE MaKH = " + searchQuery;
        } else if (searchType.equals("Tìm theo địa chỉ")) {
            
             queryTK = query+" WHERE DiaChi LIKE '%" + searchQuery + "%'";
        }
       else if (searchType.equals("Tìm theo tên")) {
            queryTK = query + " WHERE (TenKH LIKE '%" + searchQuery + "%' OR HoKH LIKE '%" + searchQuery + "%')";
        }

        // Gọi hàm loadDataDonDH để hiển thị dữ liệu theo câu truy vấn
        
        loadDataKhachHang(queryTK);
    }//GEN-LAST:event_lblTimKiemMouseClicked

     private void loadDataKhachHang(String query) {
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng trước khi tải lại dữ liệu

        Connection conn = DatabaseHelper.connect(); // Kết nối tới cơ sở dữ liệu
        if (conn != null) {
            try {
                // Truy vấn dữ liệu từ bảng NhanVien
               Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                // Duyệt qua kết quả truy vấn và thêm dữ liệu vào bảng
                while (rs.next()) {
                    Vector<String> row = new Vector<>();
                    row.add(rs.getString("MaKH"));
                    row.add(rs.getString("HoKH"));
                    row.add(rs.getString("TenKH"));
                    row.add(rs.getString("SDTKH"));
                    row.add(rs.getString("NgaySinhKH"));
                    row.add(rs.getString("GioiTinh"));
                    row.add(rs.getString("DiaChi"));
                    row.add(rs.getString("EmailKH"));
                    
                    System.out.println("Đang load khách hàng...");
             
                    model.addRow(row);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close(); // Đóng kết nối sau khi truy vấn xong
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    private void cbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepActionPerformed
        // TODO add your handling code here:

        // Lấy giá trị chọn từ ComboBox
        String selectedOption = cbSapXep.getSelectedItem().toString();

        // Tạo câu lệnh truy vấn dựa trên lựa chọn của người dùng
        String querySX = "";
        switch (selectedOption) {
            case "Sắp xếp theo Mã KH":
            querySX = query+" ORDER BY MaKH";
            break;
            case "Sắp xếp theo Tên KH":
            querySX =query + " ORDER BY TenKH";
            break;
            case "Sắp xếp theo tuổi":
            querySX =query + " ORDER BY NgaySinhKH";
            break;
            default:
            querySX = query; // Mặc định không sắp xếp
            break;
        }

        // Gọi hàm loadDataNhanVien với câu truy vấn đã tạo
        loadDataKhachHang(querySX);

    }//GEN-LAST:event_cbSapXepActionPerformed

    private void updateKHInfo(int rowIndex) {
        // Lấy dữ liệu từ dòng của bảng
        String maNV = tbKhachHang.getValueAt(rowIndex, 0).toString();
        String hoNV = tbKhachHang.getValueAt(rowIndex, 1).toString();
        String tenNV = tbKhachHang.getValueAt(rowIndex, 2).toString();
        String sdtNV = tbKhachHang.getValueAt(rowIndex, 3).toString();
        String ngaySinhNV = tbKhachHang.getValueAt(rowIndex, 4).toString();
        String gioiTinhNV = tbKhachHang.getValueAt(rowIndex, 5).toString();
        String diaChi = tbKhachHang.getValueAt(rowIndex, 6).toString();
        String email = tbKhachHang.getValueAt(rowIndex, 7).toString();

        // Cập nhật thông tin vào các trường (nếu có)
        txtHoKH.setText(hoNV);
        txtTenKH.setText(tenNV);
        txtSDT.setText(sdtNV);
        txtNgaySinh.setText(ngaySinhNV);
        txtDiaChi.setText(diaChi);
        txtEmail.setText(email);
        if ("Nam".equals(gioiTinhNV)) {
            rdbNam.setSelected(true);
        } else {
            rdbNu.setSelected(true);
        }
       
    }
    
    private void lblDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDauMouseClicked
        // TODO add your handling code here:
        int rowCount = tbKhachHang.getRowCount();
        if (rowCount > 0) {
            // Chọn dòng đầu tiên trong bảng
            tbKhachHang.setRowSelectionInterval(0, 0);
            updateKHInfo(0);
        }
    }//GEN-LAST:event_lblDauMouseClicked

    private void lblTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruocMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbKhachHang.getSelectedRow();

        // Nếu nhân viên không phải ở dòng đầu tiên
        if (selectedRow > 0) {
            // Chọn dòng phía trên dòng hiện tại (dòng trước đó)
            tbKhachHang.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
            // Cập nhật thông tin cho nhân viên phía trên
            updateKHInfo(selectedRow - 1);
        }
    }//GEN-LAST:event_lblTruocMouseClicked

    private void lblKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbKhachHang.getSelectedRow();

        // Lấy tổng số dòng trong bảng
        int rowCount = tbKhachHang.getRowCount();

        // Nếu không phải ở dòng cuối cùng
        if (selectedRow >= 0 && selectedRow < rowCount - 1) {
            // Chọn dòng tiếp theo
            tbKhachHang.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);

            // Cập nhật thông tin cho nhân viên tiếp theo
            updateKHInfo(selectedRow + 1);
        }
    }//GEN-LAST:event_lblKeMouseClicked

    private void lblCuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCuoiMouseClicked
        // TODO add your handling code here:
        int rowCount = tbKhachHang.getRowCount();
        if (rowCount > 0) {
            // Lấy chỉ số dòng cuối cùng trong bảng
            int lastRow = rowCount - 1;

            // Chọn dòng cuối cùng
            tbKhachHang.setRowSelectionInterval(lastRow, lastRow);

            // Cập nhật thông tin cho nhân viên cuối cùng
            updateKHInfo(lastRow);
        }
    }//GEN-LAST:event_lblCuoiMouseClicked

    private void lblThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseClicked
        // TODO add your handling code here:
        // Lấy giá trị từ các trường nhập liệu
        String hoNV = txtHoKH.getText();
        String tenNV = txtTenKH.getText();
        String sdt = txtSDT.getText();
        String ngaySinhStr = txtNgaySinh.getText();
        String gioiTinh = rdbNam.isSelected() ? "Nam" : "Nữ"; 
        String DiaChi = txtDiaChi.getText();
        String Email = txtEmail.getText();

        // Chuyển đổi chuỗi ngày sinh thành java.sql.Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date ngaySinhUtil = null;
        try {
            ngaySinhUtil = sdf.parse(ngaySinhStr); // Phân tích chuỗi ngày tháng
        } catch (Exception e) {
            e.printStackTrace();
            return; // Nếu không phân tích được, dừng lại
        }

        java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinhUtil.getTime()); // Chuyển đổi thành java.sql.Date

        // Tạo câu lệnh SQL để thêm nhân viên vào cơ sở dữ liệu
        String sql = "INSERT INTO KhachHang (HoKH, TenKH, SDTKH, NgaySinhKH, GioiTinh, DiaChi, EmailKH) VALUES (?, ?, ?, ?, ?, ?,?)";

        // Kết nối và thực thi câu lệnh
        Connection conn = DatabaseHelper.connect();
        if (conn != null) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, hoNV);
                stmt.setString(2, tenNV);
                stmt.setString(3, sdt);
                stmt.setDate(4, ngaySinhSQL); // Sử dụng java.sql.Date
                stmt.setString(5, gioiTinh);
                stmt.setString(6, DiaChi);
                stmt.setString(7, Email);

                int rowsAffected = stmt.executeUpdate(); // Thực thi câu lệnh
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Khách hàng đã được thêm thành công!");
                    loadDataKhachHang(query);
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
        // TODO add your handling code here:
        if (tbKhachHang.isEditing()) {
        tbKhachHang.getCellEditor().stopCellEditing();
    }

    int selectedRow = tbKhachHang.getSelectedRow();
    if (selectedRow != -1) {
        String maNV = tbKhachHang.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(null,
            "Bạn có chắc chắn muốn xóa khách hàng này không?",
            "Xác nhận xóa",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, maNV);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        loadDataKhachHang(query);
                        JOptionPane.showMessageDialog(null, "Khách hàng đã được xóa thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng để xóa!");
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
        JOptionPane.showMessageDialog(null, "Hãy chọn một nhân viên để xóa!");
    }

    }//GEN-LAST:event_lblXoaMouseClicked

    private void lblLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoadMouseClicked
        // TODO add your handling code here:
        loadDataKhachHang(query);
        txtHoKH.setText("");
        txtTenKH.setText("");
        txtMaKH.setText("");
        txtDiaChi.setText("");
        txtNgaySinh.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        rdbNam.setSelected(false);
        rdbNu.setSelected(false);
    }//GEN-LAST:event_lblLoadMouseClicked

    private void lblSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuaMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selectedRow = tbKhachHang.getSelectedRow(); // Lấy dòng được chọn trong bảng
        if (selectedRow != -1) {
            // Lấy Mã NV từ cột đầu tiên của dòng được chọn
            String maKH = tbKhachHang.getValueAt(selectedRow, 0).toString();

            // Lấy giá trị từ các trường nhập liệu
            String hoNV = txtHoKH.getText();
            String tenNV = txtTenKH.getText();
            String sdt = txtSDT.getText();
            String ngaySinhStr = txtNgaySinh.getText();
            String gioiTinh = rdbNam.isSelected() ? "Nam" : "Nữ"; // Lấy giới tính
            String DiaChi = txtDiaChi.getText();
            String Email = txtEmail.getText();
            // Chuyển đổi chuỗi ngày sinh thành java.sql.Date
            // Chuyển đổi chuỗi ngày sinh thành java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Đổi định dạng thành "yyyy-MM-dd"
            java.util.Date ngaySinhUtil = null;
            try {
                ngaySinhUtil = sdf.parse(ngaySinhStr); // Phân tích chuỗi ngày tháng
            } catch (Exception e) {
                e.printStackTrace();
                return; // Nếu không phân tích được, dừng lại
            }

            java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinhUtil.getTime()); // Chuyển đổi thành java.sql.Date

            // Tạo câu lệnh SQL để sửa thông tin nhân viên
            String sql = "UPDATE KhachHang SET HoKH = ?, TenKH = ?, SDTKH = ?, NgaySinhKH = ?, GioiTinh = ?, DiaChi = ?,EmailKH=? WHERE MaKH = ?";

            // Kết nối và thực thi câu lệnh
            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    // Thiết lập các tham số cho câu lệnh SQL
                    stmt.setString(1, hoNV);
                    stmt.setString(2, tenNV);
                    stmt.setString(3, sdt);
                    stmt.setDate(4, ngaySinhSQL); 
                    stmt.setString(5, gioiTinh);
                    stmt.setString(6, DiaChi);
                    stmt.setString(7, Email); 
                     stmt.setString(8, maKH); 

                    int rowsAffected = stmt.executeUpdate(); // Thực thi câu lệnh
                    if (rowsAffected > 0) {
                        // Nếu sửa thành công, làm mới bảng nhân viên
                        loadDataKhachHang(query);
                        JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng để sửa!");
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
            JOptionPane.showMessageDialog(null, "Hãy chọn một khách hàng để sửa!");
        }

    }//GEN-LAST:event_lblSuaMouseClicked

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbKhachHang.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();

            String maKH = model.getValueAt(selectedRow, 0).toString();
            String hoKH = model.getValueAt(selectedRow, 1).toString();
            String tenKH = model.getValueAt(selectedRow, 2).toString();
            String sdt = model.getValueAt(selectedRow, 3).toString();
            String ngaySinh = model.getValueAt(selectedRow, 4).toString();
            String gioiTinh = model.getValueAt(selectedRow, 5).toString();
            String diaChi = model.getValueAt(selectedRow,6).toString();
            String email =model.getValueAt(selectedRow,7).toString();
            
            txtMaKH.setText(maKH);
            txtHoKH.setText(hoKH);
            txtTenKH.setText(tenKH);
            txtSDT.setText(sdt);
            txtNgaySinh.setText(ngaySinh);
            txtDiaChi.setText(diaChi);
            txtEmail.setText(email);

            if (gioiTinh.equalsIgnoreCase("Nam")) {
                rdbNam.setSelected(true);
            } else if (gioiTinh.equalsIgnoreCase("Nữ")) {
                rdbNu.setSelected(true);
            }

            
          
        }
    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbSapXep;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCuoi;
    private javax.swing.JLabel lblDau;
    private javax.swing.JLabel lblKe;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblSua;
    private javax.swing.JLabel lblThem;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTruoc;
    private javax.swing.JLabel lblXoa;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JTable tbKhachHang;
    private java.awt.TextField txtDiaChi;
    private java.awt.TextField txtEmail;
    private java.awt.TextField txtHoKH;
    private javax.swing.JLabel txtMaKH;
    private java.awt.TextField txtNgaySinh;
    private java.awt.TextField txtSDT;
    private java.awt.TextField txtTenKH;
    private java.awt.TextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
