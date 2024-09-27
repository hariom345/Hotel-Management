
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class CustomerCheckin extends javax.swing.JFrame {

    
    Connection con=null;
        Statement st=null;
        PreparedStatement pat=null;
        java.sql.ResultSet rs=null;
    public CustomerCheckin() {
        initComponents();
        SimpleDateFormat obj=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        txtdate.setText(obj.format(date));
          try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","hariom");
        } catch (Exception e) {
            e.printStackTrace();
        }
          hariom();
    }
    
    
    public void hariom(){
        try {
            pat=con.prepareStatement("select roomnumber from room where bed=? and roomtype=? and status=?");
            pat.setString(1, combobed.getItemAt(combobed.getSelectedIndex()));
             pat.setString(2, comboroomtype.getItemAt(comboroomtype.getSelectedIndex()));
              pat.setString(3,"Not-booked");
              rs=pat.executeQuery();
              comboroomno.removeAllItems();
              while(rs.next()){
                comboroomno.addItem(rs.getString("roomnumber"));
                 
              }
              pat=con.prepareStatement("select price from room where roomnumber=?");
              pat.setString(1, comboroomno.getItemAt(comboroomno.getSelectedIndex()));
              rs=pat.executeQuery();
              if(rs.next()){
                  txtprice.setText(rs.getString("price"));
              }
              
                  
              
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCheckin.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combogender = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtnationality = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtaadhar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboroomtype = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        combobed = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btncheckin = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        comboroomno = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\phoos\\checkin.png")); // NOI18N
        jLabel1.setText("Customer Checkin");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 24, 190, 67));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 120, 220, 37));

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 192, 220, 33));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Mobile No");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 267, 223, 35));

        txtmobile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobileActionPerformed(evt);
            }
        });
        getContentPane().add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 330, 223, 33));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Gender");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 417, 223, 35));

        combogender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        combogender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other", " " }));
        getContentPane().add(combogender, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 502, 223, 35));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Nationality");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 223, 29));

        txtnationality.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtnationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 223, 34));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Aadhar Number");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 740, 223, 28));

        txtaadhar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtaadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 790, 240, 33));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Check In Date");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 119, 140, 38));

        txtdate.setEditable(false);
        txtdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });
        getContentPane().add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 192, 220, 32));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Bed Type");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 267, 222, 35));

        comboroomtype.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        comboroomtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "Non-AC", " " }));
        comboroomtype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboroomtypeItemStateChanged(evt);
            }
        });
        comboroomtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboroomtypeActionPerformed(evt);
            }
        });
        getContentPane().add(comboroomtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 502, 222, 35));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("Room Type");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 419, 222, 30));

        combobed.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        combobed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double" }));
        combobed.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobedItemStateChanged(evt);
            }
        });
        getContentPane().add(combobed, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 330, 222, 33));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("Price");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 222, 29));

        btncheckin.setBackground(new java.awt.Color(255, 0, 0));
        btncheckin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btncheckin.setText("Check in Now");
        btncheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncheckinActionPerformed(evt);
            }
        });
        getContentPane().add(btncheckin, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 790, -1, -1));

        btnclear.setBackground(new java.awt.Color(255, 0, 0));
        btnclear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 790, 130, 33));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\phoos\\close.jpg")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1245, 0, 49, 51));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(242, 242, 242));
        jLabel12.setText("Room Number");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 730, 278, 38));

        txtprice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 650, 230, -1));

        getContentPane().add(comboroomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 792, 245, 32));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\phoos\\checkin BAckground.png")); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 1300, 1300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobileActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboroomtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboroomtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboroomtypeActionPerformed

    private void btncheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncheckinActionPerformed
        if(txtname.getText().equals("")){
            txtname.requestFocus();
            JOptionPane.showMessageDialog(this, "All field is require");
        }
        else if(txtmobile.getText().equals("")){
            txtmobile.requestFocus();
            JOptionPane.showMessageDialog(this, "All field is require");
        }
         else if(txtnationality.getText().equals("")){
            txtnationality.requestFocus();
            JOptionPane.showMessageDialog(this, "All field is require");
        }
          else if(txtaadhar.getText().equals("")){
            txtaadhar.requestFocus();
            JOptionPane.showMessageDialog(this, "All field is require");
        }
          else{
            try {
                pat=con.prepareStatement("insert into customer(name,mobile,gendre,id,nationality,joindate,roomnumber,bed,roomtype,price,status)values(?,?,?,?,?,?,?,?,?,?,?) ");
                pat.setString(1, txtname.getText());
                pat.setString(2, txtmobile.getText());
                pat.setString(3, combogender.getItemAt(combogender.getSelectedIndex()));
                pat.setString(4, txtaadhar.getText());
                pat.setString(5, txtnationality.getText());
                pat.setString(6, txtdate.getText());
                pat.setString(7, comboroomno.getItemAt(comboroomno.getSelectedIndex()));
                 pat.setString(8, combobed.getItemAt(combobed.getSelectedIndex()));
                pat.setString(9, comboroomtype.getItemAt(comboroomtype.getSelectedIndex()));
                pat.setString(10, txtprice.getText());
                pat.setString(11, "null");
                pat.executeUpdate();
                JOptionPane.showMessageDialog(this, "Customer checked in Successfully");
                txtname.setText("");
                txtaadhar.setText("");
                txtmobile.setText("");
                txtnationality.setText("");
                
                pat=con.prepareStatement("update room set status=? where roomnumber=?");
                pat.setString(1, "Booked");
                pat.setString(2, comboroomno.getItemAt(comboroomno.getSelectedIndex()));
                pat.executeUpdate();
                     hariom();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerCheckin.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_btncheckinActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateActionPerformed

    private void combobedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobedItemStateChanged
       hariom();
    }//GEN-LAST:event_combobedItemStateChanged

    private void comboroomtypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboroomtypeItemStateChanged
       hariom();
    }//GEN-LAST:event_comboroomtypeItemStateChanged

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtaadhar.setText("");
        txtmobile.setText("");
        txtname.setText("");
        txtnationality.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerCheckin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerCheckin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncheckin;
    private javax.swing.JButton btnclear;
    private javax.swing.JComboBox<String> combobed;
    private javax.swing.JComboBox<String> combogender;
    private javax.swing.JComboBox<String> comboroomno;
    private javax.swing.JComboBox<String> comboroomtype;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTextField txtaadhar;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnationality;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables
}