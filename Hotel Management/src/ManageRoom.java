
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class ManageRoom extends javax.swing.JFrame {

    Connection con=null;
        Statement st=null;
        PreparedStatement pat=null;
        java.sql.ResultSet rs=null;
    public ManageRoom() {
        initComponents();
        try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","hariom");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ShowRecordInTable();
    }
    
    public void ShowRecordInTable(){
        int c=0;
        try {
             pat= con.prepareStatement("select*from room");
              rs=pat.executeQuery();
              ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
              c=rsmd.getColumnCount();
              DefaultTableModel DModel=(DefaultTableModel) jTable1.getModel();
              DModel.setRowCount(0);
              while(rs.next()){
                  Vector column=new Vector();
                  for (int i = 0; i <=c; i++) {
                      column.add(rs.getString("roomnumber"));
                       column.add(rs.getString("roomtype"));
                        column.add(rs.getString("bed"));
                         column.add(rs.getString("price"));
                          column.add(rs.getString("status"));
                  }
                  DModel.addRow(column);
                  
              }
        } catch (Exception e) {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        roomnumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        roomtypecombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        bedcombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\phoos\\managehotel2.png")); // NOI18N
        jLabel1.setText("ManageRoom");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 14, 290, 100));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Room Number", "Room Type", "Bed Type", "Price", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1220, 410));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\phoos\\close.jpg")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 51, 46));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setText("Room Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 576, 194, 22));

        roomnumber.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roomnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomnumberActionPerformed(evt);
            }
        });
        getContentPane().add(roomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 610, 194, 42));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Room Type");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 576, 199, 22));

        roomtypecombo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roomtypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ac", "Non-Ac" }));
        getContentPane().add(roomtypecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 610, 199, 42));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setText(" Bed");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 673, 194, 28));

        bedcombo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        bedcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double" }));
        getContentPane().add(bedcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 710, 194, 35));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel5.setText("Price");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 670, 199, 34));

        price.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 710, 199, 28));

        jButton2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton2.setText("Add Room Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 610, 162, 42));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\phoos\\tabel4.jpg")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 1300, 1300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomnumberActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(roomnumber.getText().equals("")){
           JOptionPane.showMessageDialog(this, "All field is required");
           roomnumber.requestFocus();
       }
       else if(price.getText().equals("")){
           JOptionPane.showMessageDialog(this, "All field is required");
           price.requestFocus();
       }
       else{
           try {
               pat=con.prepareStatement("select*from room where roomnumber=?");
               pat.setString(1, roomnumber.getText());
               rs=pat.executeQuery();
               if(rs.next()){
                   JOptionPane.showMessageDialog(this, "Room Number Alredy Exist"); 
               }
               else {
                   pat=con.prepareStatement("insert into room(roomnumber,roomtype,bed,price,status) values(?,?,?,?,?)");
                   pat.setString(1, roomnumber.getText());
                    pat.setString(2, roomtypecombo.getItemAt(roomtypecombo.getSelectedIndex()));
                     pat.setString(3, bedcombo.getItemAt(bedcombo.getSelectedIndex()));
                      pat.setString(4, price.getText());
                       pat.setString(5, "Not-booked");
                       pat.executeUpdate();
                       JOptionPane.showMessageDialog(this, "Room Added"); 
                         ShowRecordInTable();
                       roomnumber.setText("");
                       price.setText("");
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           
       }
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bedcombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField price;
    private javax.swing.JTextField roomnumber;
    private javax.swing.JComboBox<String> roomtypecombo;
    // End of variables declaration//GEN-END:variables
}