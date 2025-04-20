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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author USER
 */
public class NhaCungCapPanel extends javax.swing.JPanel {

    /**
     * Creates new form NhaCungCapPanel
     */
    String query = "SELECT MaNCC, TenNCC, DiaChi,SDTNCC, EmailNCC,WebsiteNCC FROM NhaCungCap";
    public NhaCungCapPanel() {
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
        
        

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Mã NCC", "Tên NCC", "Địa chỉ", "SĐT", "Email", "Website"
            }
        ));
        jScrollPane1.setViewportView(tbNhanVien);
           
        loadDataNhaCungCap(query);
        loadCombobox();
        designTable(tbNhanVien);
    }

    private void loadDataNhaCungCap(String query) {
        DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
        model.setRowCount(0); 

        Connection conn = DatabaseHelper.connect(); 
        if (conn != null) {
            try {     
               Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Vector<String> row = new Vector<>();
                    row.add(rs.getString("MaNCC"));
                    row.add(rs.getString("TenNCC"));
                    row.add(rs.getString("DiaChi"));
                    row.add(rs.getString("SDTNCC"));
                    row.add(rs.getString("EmailNCC"));
                    row.add(rs.getString("WebsiteNCC"));
                   
                    
                    System.out.println("Đang load nhà cung cấp...");
             
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

    private void loadCombobox() {   
        
        DefaultComboBoxModel<String> modelSX = new DefaultComboBoxModel<>();
       
        modelSX.addElement("Sắp xếp theo Mã NCC");
     modelSX.addElement("Sắp xếp theo Tên NCC");
        cbSapXep.setModel(modelSX);
        
       
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTimKiem = new javax.swing.JLabel();
        cbSapXep = new javax.swing.JComboBox<>();
        lblDau = new javax.swing.JLabel();
        lblTruoc = new javax.swing.JLabel();
        lblKe = new javax.swing.JLabel();
        lblCuoi = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblThem = new javax.swing.JLabel();
        lblXoa = new javax.swing.JLabel();
        lblLoad = new javax.swing.JLabel();
        lblSua = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMaNCC = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtWeb = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 0));
        jLabel5.setText("Số điện thoại");

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("QUẢN LÝ NHÀ CUNG CẤP");

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 0));
        jLabel2.setText("Mã nhà cung cấp");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 0));
        jLabel3.setText("Tên nhà cung cấp");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 102, 0));
        jLabel7.setText("Địa chỉ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 0));
        jLabel4.setText("Email");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 102, 0));
        jLabel8.setText("Website");

        txtTenNCC.setColumns(10);

        txtDiaChi.setColumns(10);

        txtSDT.setColumns(10);

        txtEmail.setColumns(10);

        txtWeb.setColumns(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lblMaNCC)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTenNCC, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtWeb, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(94, 94, 94))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblMaNCC))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)
                        .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTimKiemMouseClicked
        String searchQuery = txtTimKiem.getText().trim();

        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhà cung cấp cần tìm!");
            return;
        }

        String queryTK = query + " WHERE TenNCC LIKE '%" + searchQuery + "%'";

        loadDataNhaCungCap(queryTK);
    }//GEN-LAST:event_lblTimKiemMouseClicked

    private void cbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepActionPerformed
        // TODO add your handling code here:

        // Lấy giá trị chọn từ ComboBox
        String selectedOption = cbSapXep.getSelectedItem().toString();

        // Tạo câu lệnh truy vấn dựa trên lựa chọn của người dùng
        String querySX = "";
        switch (selectedOption) {
            case "Sắp xếp theo Mã NCC":
            querySX = query+" ORDER BY MaNCC";
            break;
            case "Sắp xếp theo Tên NCC":
            querySX = query +" ORDER BY TenNCC";
            break;
           
            default:
            querySX = query; // Mặc định không sắp xếp
            break;
        }

      
        loadDataNhaCungCap(querySX);

    }//GEN-LAST:event_cbSapXepActionPerformed
   private void updateEmployeeInfo(int rowIndex) {
      
        String maNCC = tbNhanVien.getValueAt(rowIndex, 0).toString();
        String tenNCC = tbNhanVien.getValueAt(rowIndex, 1).toString();
        String diaChi = tbNhanVien.getValueAt(rowIndex, 2).toString();       
        String sdt = tbNhanVien.getValueAt(rowIndex, 3).toString();
        String email = tbNhanVien.getValueAt(rowIndex, 4).toString();
        String web = tbNhanVien.getValueAt(rowIndex, 4).toString();
       

        lblMaNCC.setText(maNCC);
       
        txtTenNCC.setText(tenNCC);
        txtDiaChi.setText(diaChi);
        txtSDT.setText(sdt);
        txtEmail.setText(email);
        txtWeb.setText(web);
    }
    
    private void lblDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDauMouseClicked
        int rowCount = tbNhanVien.getRowCount();
        if (rowCount > 0) {
            tbNhanVien.setRowSelectionInterval(0, 0);
            updateEmployeeInfo(0);
        }
    }//GEN-LAST:event_lblDauMouseClicked

    private void lblTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruocMouseClicked

        int selectedRow = tbNhanVien.getSelectedRow();

        if (selectedRow > 0) {
            tbNhanVien.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
            updateEmployeeInfo(selectedRow - 1);
        }
    }//GEN-LAST:event_lblTruocMouseClicked

    private void lblKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeMouseClicked

        int selectedRow = tbNhanVien.getSelectedRow();

        int rowCount = tbNhanVien.getRowCount();

        if (selectedRow >= 0 && selectedRow < rowCount - 1) {
            // Chọn dòng tiếp theo
            tbNhanVien.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);

            // Cập nhật thông tin cho nhân viên tiếp theo
            updateEmployeeInfo(selectedRow + 1);
        }
    }//GEN-LAST:event_lblKeMouseClicked

    private void lblCuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCuoiMouseClicked

        int rowCount = tbNhanVien.getRowCount();
        if (rowCount > 0) {

            int lastRow = rowCount - 1;

            tbNhanVien.setRowSelectionInterval(lastRow, lastRow);

            updateEmployeeInfo(lastRow);
        }
    }//GEN-LAST:event_lblCuoiMouseClicked

    private void lblThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseClicked

        
        String tenNCC = txtTenNCC.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String email = txtEmail.getText();
        String web = txtWeb.getText();

        

        String sql = "INSERT INTO NhaCungCap (TenNCC, DiaChi, SDTNCC, EmailNCC, WebsiteNCC) VALUES (?, ?, ?, ?, ?)";

        Connection conn = DatabaseHelper.connect();
        if (conn != null) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, tenNCC);
                stmt.setString(2, diaChi);
                stmt.setString(3, sdt);
                stmt.setString(4, email);
                stmt.setString(5, web);
                
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
        
        
           if (tbNhanVien.isEditing()) {
        tbNhanVien.getCellEditor().stopCellEditing();
    }

    int selectedRow = tbNhanVien.getSelectedRow();
    if (selectedRow != -1) {
        String maNV = tbNhanVien.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(null,
            "Bạn có chắc chắn muốn xóa nhà cung cấp này không?",
            "Xác nhận xóa",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM NhaCungCap WHERE MaNCC = ?";
            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, maNV);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        loadDataNhaCungCap(query);
                        JOptionPane.showMessageDialog(null, "Nhà cung cấp đã được xóa thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp để xóa!");
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
        JOptionPane.showMessageDialog(null, "Hãy chọn một nhà cung cấp để xóa!");
    }


    }//GEN-LAST:event_lblXoaMouseClicked

    private void lblLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoadMouseClicked
        loadDataNhaCungCap(query);
    }//GEN-LAST:event_lblLoadMouseClicked

    private void lblSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuaMouseClicked

        int selectedRow = tbNhanVien.getSelectedRow();
        if (selectedRow != -1) {

            String maNCC = tbNhanVien.getValueAt(selectedRow, 0).toString();

            String tenNCC = txtTenNCC.getText();
            String diaChi = txtDiaChi.getText();
            String sdt = txtSDT.getText();
            String email = txtEmail.getText();
            String web = txtWeb.getText();

            String sql = "UPDATE NhaCungCap SET TenNCC = ?, DiaChi = ?, SDTNCC = ?, EmailNCC = ?, WebsiteNCC = ? WHERE MaNCC = ?";

            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, tenNCC);
                    stmt.setString(2, diaChi);
                    stmt.setString(3, sdt);               
                    stmt.setString(4, email);
                    stmt.setString(5, web);
                    stmt.setString(6, maNCC); 

                    int rowsAffected = stmt.executeUpdate(); // Thực thi câu lệnh
                    if (rowsAffected > 0) {
                        // Nếu sửa thành công, làm mới bảng nhân viên
                        loadDataNhaCungCap(query);
                        JOptionPane.showMessageDialog(null, "Cập nhật thông tin nhà cung cấp thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp để sửa!");
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
            JOptionPane.showMessageDialog(null, "Hãy chọn một nhà cung cấp để sửa!");
        }

    }//GEN-LAST:event_lblSuaMouseClicked

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        int selectedRow = tbNhanVien.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();

            String maNCC = model.getValueAt(selectedRow, 0).toString();
            String tenNCC = model.getValueAt(selectedRow, 1).toString();
            String diaChi = model.getValueAt(selectedRow, 2).toString();
            String sdt = model.getValueAt(selectedRow, 3).toString();
            String email = model.getValueAt(selectedRow, 4).toString();
            String web = model.getValueAt(selectedRow, 5).toString();

            lblMaNCC.setText(maNCC);
            txtTenNCC.setText(tenNCC);
            txtEmail.setText(email);
            txtSDT.setText(sdt);
            txtDiaChi.setText(diaChi);
            txtWeb.setText(web);
           
        }
    }//GEN-LAST:event_tbNhanVienMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbSapXep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCuoi;
    private javax.swing.JLabel lblDau;
    private javax.swing.JLabel lblKe;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblMaNCC;
    private javax.swing.JLabel lblSua;
    private javax.swing.JLabel lblThem;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTruoc;
    private javax.swing.JLabel lblXoa;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}
