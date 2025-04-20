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
public class CTDonDatHang extends javax.swing.JFrame {

    /**
     * Creates new form CTDonDatHang
     */

    String maDDH = "";
    String query = "SELECT MaCTDH, MaDH, MaSP, SoLuong,DonGia FROM ChiTietDH Where MaDH = " + maDDH;
    
    public CTDonDatHang(String maDH) {
        initComponents();
        maDDH =maDH;
        query = "SELECT MaCTDH, MaDH, MaSP, SoLuong,DonGia FROM ChiTietDH Where MaDH = " + maDDH;
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
                "Mã CTDH", "Mã ĐH", "Mã SP", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tbCT);
        lblMaDH.setText(maDDH);
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
                    row.add(rs.getString("MaCTDH"));
                    row.add(rs.getString("MaDH"));
                    row.add(rs.getString("MaSP"));
                    row.add(rs.getString("SoLuong"));
                    row.add(rs.getString("DonGia"));
                   
                    
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
      
        String maCTDH = tbCT.getValueAt(rowIndex, 0).toString();
        String maDH = tbCT.getValueAt(rowIndex, 1).toString();
        String maSP = tbCT.getValueAt(rowIndex, 2).toString();       
        String soLuong = tbCT.getValueAt(rowIndex, 3).toString();
        String donGia = tbCT.getValueAt(rowIndex, 4).toString();
       

        lblMaCT.setText(maCTDH);
       
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
        modelTK.addElement("Tìm theo mã CTDH");
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        cbSapXep = new javax.swing.JComboBox<>();
        txtDonGia = new javax.swing.JTextField();
        lblDau = new javax.swing.JLabel();
        lblTruoc = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        lblKe = new javax.swing.JLabel();
        cbTimKiem = new javax.swing.JComboBox<>();
        lblCuoi = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblThem = new javax.swing.JLabel();
        lblXoa = new javax.swing.JLabel();
        lblLoad = new javax.swing.JLabel();
        lblSua = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCT = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMaCT = new javax.swing.JLabel();
        cbMaSP = new javax.swing.JComboBox<>();
        lblMaDH = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel2.setText("QUẢN LÝ KHÁCH HÀNG");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(252, 242, 242));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel3.setText("QUẢN LÝ CHI TIẾT ĐƠN HÀNG");

        lblTimKiem.setText("jLabel9");
        lblTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTimKiemMouseClicked(evt);
            }
        });

        txtSoLuong.setColumns(15);

        cbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSapXep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSapXepActionPerformed(evt);
            }
        });

        txtDonGia.setColumns(15);

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

        lblCuoi.setText("jLabel12");
        lblCuoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCuoiMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 0));
        jLabel5.setText("Số lượng");

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
        jScrollPane1.setViewportView(tbCT);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 0));
        jLabel4.setText("Mã chi tiết");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 0));
        jLabel6.setText("Mã đơn hàng");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 102, 0));
        jLabel7.setText("Mã sản phẩm");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 102, 0));
        jLabel8.setText("Đơn giá");

        lblMaCT.setText("jLabel6");

        cbMaSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblMaDH.setText("jLabel1");

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
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblKe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblMaCT))
                                        .addComponent(cbMaSP, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblMaDH))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKiem)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 68, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblMaCT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblMaDH))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTimKiemMouseClicked
        String searchQuery = txtTimKiem.getText().trim();
        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin đơn hàng cần tìm!");
            return;
        }

        String queryTK = "";
        String searchType = cbTimKiem.getSelectedItem().toString(); // Lấy lựa chọn từ ComboBox tìm kiếm

        if (searchType.equals("Tìm theo mã sản phẩm")) {
            // Tìm theo mã khách hàng (MaKH)
            queryTK = query + " WHERE MaSP = " + searchQuery;
        } else if (searchType.equals("Tìm theo mã CTDH")) {
            // Tìm theo trạng thái (TrangThai)
            queryTK = query + " WHERE MaCTDH = " + searchQuery;
        }

        // Gọi hàm loadDataDonDH để hiển thị dữ liệu theo câu truy vấn
        loadDataNhaCungCap(queryTK);
    }//GEN-LAST:event_lblTimKiemMouseClicked

    private void cbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepActionPerformed
        // TODO add your handling code here:

        // Lấy giá trị chọn từ ComboBox
        String selectedOption = cbSapXep.getSelectedItem().toString();

        // Tạo câu lệnh truy vấn dựa trên lựa chọn của người dùng
        String querySX = "";
        switch (selectedOption) {
            case "Sắp xếp theo đơn giá":
            querySX = query+" ORDER BY DonGia";
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

    private void lblTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruocMouseClicked

        int selectedRow = tbCT.getSelectedRow();

        if (selectedRow > 0) {
            tbCT.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
            updateEmployeeInfo(selectedRow - 1);
        }
    }//GEN-LAST:event_lblTruocMouseClicked

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
       
        String sql = "INSERT INTO ChiTietDH (MaDH, MaSP, SoLuong, DonGia) VALUES (?, ?, ?, ?)";

        Connection conn = DatabaseHelper.connect();
        if (conn != null) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, maDDH);
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
        if (tbCT.isEditing()) {
        tbCT.getCellEditor().stopCellEditing();
    }

    int selectedRow = tbCT.getSelectedRow();
    if (selectedRow != -1) {
        String maCTDH = tbCT.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(null,
            "Bạn có chắc chắn muốn xóa chi tiết đơn hàng này không?",
            "Xác nhận xóa",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM ChiTietDH WHERE MaCTDH = ?";

            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, maCTDH);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        loadDataNhaCungCap(query); // Giả sử hàm load lại tên là vậy
                        JOptionPane.showMessageDialog(null, "Chi tiết đơn hàng đã được xóa thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết đơn hàng để xóa!");
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
        JOptionPane.showMessageDialog(null, "Hãy chọn một chi tiết đơn hàng để xóa!");
    }
    }//GEN-LAST:event_lblXoaMouseClicked

    private void lblLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoadMouseClicked
        loadDataNhaCungCap(query);
    }//GEN-LAST:event_lblLoadMouseClicked

    private void lblSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuaMouseClicked

        int selectedRow = tbCT.getSelectedRow();
        if (selectedRow != -1) {

            String maCTDH = tbCT.getValueAt(selectedRow, 0).toString();

            String maSP = cbMaSP.getSelectedItem().toString();
     
            String soLuong = txtSoLuong.getText();
            String donGia = txtDonGia.getText();


            String sql = "UPDATE NhaCungCap SET MaSP = ?, SoLuong = ?, DonGia  WHERE maCTDH = ?";

            Connection conn = DatabaseHelper.connect();
            if (conn != null) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, maSP);
                    stmt.setString(2, soLuong);
                    stmt.setString(3, donGia);
                    stmt.setString(5, maCTDH);
                   
                    int rowsAffected = stmt.executeUpdate(); // Thực thi câu lệnh
                    if (rowsAffected > 0) {
                        // Nếu sửa thành công, làm mới bảng nhân viên
                        loadDataNhaCungCap(query);
                        JOptionPane.showMessageDialog(null, "Cập nhật thông tin chi tiết đơn hàng thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết đơn hàng để sửa!");
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
            JOptionPane.showMessageDialog(null, "Hãy chọn một chi tiết đơn hàng để sửa!");
        }
    }//GEN-LAST:event_lblSuaMouseClicked

    private void tbCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTMouseClicked
        int selectedRow = tbCT.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tbCT.getModel();

            String maCTDH = model.getValueAt(selectedRow, 0).toString();
            String maDH = model.getValueAt(selectedRow, 1).toString();
            String maSP = model.getValueAt(selectedRow, 2).toString();
            String soLuong = model.getValueAt(selectedRow, 3).toString();
            String donGia = model.getValueAt(selectedRow, 4).toString();
            
            
        lblMaCT.setText(maCTDH);
       
       cbMaSP.setSelectedItem(maSP);
        txtSoLuong.setText(soLuong);
        txtDonGia.setText(donGia);

        }
    }//GEN-LAST:event_tbCTMouseClicked

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
            java.util.logging.Logger.getLogger(CTDonDatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CTDonDatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CTDonDatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CTDonDatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCuoi;
    private javax.swing.JLabel lblDau;
    private javax.swing.JLabel lblKe;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblMaCT;
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
