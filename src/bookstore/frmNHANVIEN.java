/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LTDo2w
 */
public class frmNHANVIEN extends javax.swing.JFrame {

    DefaultTableModel tbn = new DefaultTableModel();
    
    
    public frmNHANVIEN() {
        initComponents();
        loadData();
    }

    public void loadData(){
        try{
            dbConnection a = new dbConnection();
            Connection conn = a.getConnection();
            int number;
            Vector row, column = null;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM NHANVIEN");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount(); //Tra ve so cot
            
            for(int i=1; i<=number; i++){
                column.add(metadata.getColumnName(i));//Lay tieu de cac cot
            }
            tbn.setColumnIdentifiers(column);
            
            while(rs.next()){
                row = new Vector();
                for(int i=1; i<=number; i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                tblNHANVIEN.setModel(tbn);
            }
            
            tblNHANVIEN.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent e){
                    if(tblNHANVIEN.getSelectedRow() >= 0){
                        txtMANV.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 0) + "");
                        txtHOTEN.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 1) + "");
                        txtNGAYSINH.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 3) + "");
                        txtQUEQUAN.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 4) + "");
                        txtSDT.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 6) + "");
                        txtCMND.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 5) + "");
                        txtEMAIL.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 7) + "");
                        txtTENDN.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 9) + "");
                        txtMK.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 10) + "");
                        txtCHUCVU.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 8) + "");
                        txtLuong.setText(tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 11) + "");
                    }
                }
            });
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMANV = new javax.swing.JTextField();
        txtHOTEN = new javax.swing.JTextField();
        txtQUEQUAN = new javax.swing.JTextField();
        txtNGAYSINH = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        radNAM = new javax.swing.JRadioButton();
        radNU = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        txtEMAIL = new javax.swing.JTextField();
        txtTENDN = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        txtCHUCVU = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNHANVIEN = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh Sách Nhân Viên");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Nhân Viên:"));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã nhân viên:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Họ và tên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quê quán (tỉnh/TP):");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ngày sinh:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Giới tính:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("CMND:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Điện thoại:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Chức vụ:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Tên đăng nhập:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Mật khẩu:");

        txtMANV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtHOTEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtQUEQUAN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNGAYSINH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtCMND.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        radNAM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radNAM.setText("Nam");

        radNU.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radNU.setText("Nữ");

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTENDN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtCHUCVU.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Lương:");

        txtLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHOTEN, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMANV, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQUEQUAN, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radNAM, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radNU, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNGAYSINH, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtEMAIL)
                    .addComponent(txtSDT)
                    .addComponent(txtCHUCVU, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTENDN, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addComponent(txtMK)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMANV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHOTEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQUEQUAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtTENDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtCHUCVU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNGAYSINH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(radNAM)
                            .addComponent(radNU)))))
        );

        txtMANV.getAccessibleContext().setAccessibleName("txtMaNV");
        txtHOTEN.getAccessibleContext().setAccessibleName("txtTenNV");
        txtQUEQUAN.getAccessibleContext().setAccessibleName("txtDiaChi");
        txtNGAYSINH.getAccessibleContext().setAccessibleName("txtNgáyinh");
        txtCMND.getAccessibleContext().setAccessibleName("txtCMND");
        radNAM.getAccessibleContext().setAccessibleName("radNam");
        radNU.getAccessibleContext().setAccessibleName("radNu");
        txtSDT.getAccessibleContext().setAccessibleName("txtDienThoai");
        txtEMAIL.getAccessibleContext().setAccessibleName("txtEmail");
        txtTENDN.getAccessibleContext().setAccessibleName("txtTK");
        txtMK.getAccessibleContext().setAccessibleName("txtMK");

        tblNHANVIEN.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblNHANVIEN);

        btnThem.setIcon(new javax.swing.ImageIcon("E:\\Project\\JAVA\\BOOKSTORE\\src\\Image\\019-add.png")); // NOI18N
        btnThem.setText("Thêm nhân viên");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon("E:\\Project\\JAVA\\BOOKSTORE\\src\\Image\\023-remove.png")); // NOI18N
        btnXoa.setText("Xoá nhân viên");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon("E:\\Project\\JAVA\\BOOKSTORE\\src\\Image\\024-reload.png")); // NOI18N
        btnSua.setText("Cập nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setIcon(new javax.swing.ImageIcon("E:\\Project\\JAVA\\BOOKSTORE\\src\\Image\\save-file-option.png")); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnThoat.setIcon(new javax.swing.ImageIcon("E:\\Project\\JAVA\\BOOKSTORE\\src\\Image\\power-button-off.png")); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThoat)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSua)
                        .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat))
                    .addComponent(btnXoa)
                    .addComponent(btnThem))
                .addContainerGap())
        );

        btnThem.getAccessibleContext().setAccessibleName("btnThemNV");
        btnXoa.getAccessibleContext().setAccessibleName("btnXoaNV");
        btnSua.getAccessibleContext().setAccessibleName("btnSuaNV");
        btnLuu.getAccessibleContext().setAccessibleName("btnLuu");
        btnThoat.getAccessibleContext().setAccessibleName("btnThoat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        txtMANV.setText("");
        txtHOTEN.setText("");
        txtQUEQUAN.setText("");
        txtNGAYSINH.setText("");
        txtCMND.setText("");
        txtSDT.setText("");
        txtEMAIL.setText("");
        txtCHUCVU.setText("");
        txtTENDN.setText("");
        txtMK.setText("");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        MainForm main = new MainForm();
        main.setVisible(true);
        frmNHANVIEN.this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        try{
            dbConnection a = new dbConnection();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into NHANVIEN values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, txtMANV.getText());
            ps.setString(2, txtHOTEN.getText());
            ps.setString(4, txtNGAYSINH.getText());
            ps.setString(5, txtQUEQUAN.getText());
            ps.setString(6, txtCMND.getText());
            ps.setString(7, txtSDT.getText());
            ps.setString(8, txtEMAIL.getText());
            ps.setString(9, txtCHUCVU.getText());
            ps.setString(10, txtTENDN.getText());
            ps.setString(11, txtMK.getText());
            ps.setString(12, txtLuong.getText());
            if(radNAM.isSelected()){
                ps.setBoolean(3, true);
            }else{
                ps.setBoolean(3, false);
            }
            int chk = ps.executeUpdate();
            if(chk > 0){
                JOptionPane.showMessageDialog(this, "Them thanh cong!");
                tbn.setRowCount(0);
                loadData(); //truoc khi load data can load so cot ve 0 neu khong se load du lieu len bang them 1 lan nua 
            }else{
                
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try{
            dbConnection a = new dbConnection();
            Connection conn = a.getConnection();
            PreparedStatement comm = conn.prepareStatement("update NHANVIEN set TENNV=?, GIOITINH=?, NGAYSINH=?, QUEQUAN=?, CMND=?, SDT=?, EMAIL=?, CHUCVU=?, TENDN=?, MATKHAU=?, LUONG = ? where MANV=?");
            comm.setString(11, txtMANV.getText());
            comm.setString(1, txtHOTEN.getText());
            comm.setString(3, txtNGAYSINH.getText());
            comm.setString(4, txtQUEQUAN.getText());
            comm.setString(5, txtCMND.getText());
            comm.setString(6, txtSDT.getText());
            comm.setString(7, txtEMAIL.getText());
            comm.setString(8, txtCHUCVU.getText());
            comm.setString(9, txtTENDN.getText());
            comm.setString(10, txtMK.getText());
            comm.setString(12, txtLuong.getText());
            if(radNAM.isSelected()){
                comm.setBoolean(2, true);
            }else{
                comm.setBoolean(2, false);
            }
            comm.executeUpdate();
            tbn.setRowCount(0);
            loadData();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try{
            dbConnection a = new dbConnection();
            Connection conn = a.getConnection();
            PreparedStatement comm = conn.prepareStatement("delete NHANVIEN where MANV=?");
            comm.setString(1, tblNHANVIEN.getValueAt(tblNHANVIEN.getSelectedRow(), 0).toString());
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá nhân viên này?", "Xác nhận", 
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                comm.executeUpdate();
                tbn.setRowCount(0);
                loadData();
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(frmNHANVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNHANVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNHANVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNHANVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNHANVIEN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radNAM;
    private javax.swing.JRadioButton radNU;
    private javax.swing.JTable tblNHANVIEN;
    private javax.swing.JTextField txtCHUCVU;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtEMAIL;
    private javax.swing.JTextField txtHOTEN;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMANV;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtNGAYSINH;
    private javax.swing.JTextField txtQUEQUAN;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTENDN;
    // End of variables declaration//GEN-END:variables
}
