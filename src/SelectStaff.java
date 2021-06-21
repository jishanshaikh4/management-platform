
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanu
 */
public class SelectStaff extends javax.swing.JFrame {

    /**
     * Creates new form SelectStaff
     */private Connection con;
     private PreparedStatement ps;
    public SelectStaff() {
        initComponents();
        con=Data.connect();
        SelectDatas();
    }
    void SelectDatas() 
    {
         String sql="select*from staff";
        Statement stm;
         try {
             stm = con.createStatement();
             String[] tableColumnsName={"Id","passoword","name","mobile","address","work","email"};
             
             
             
             
             
             
             
             DefaultTableModel aModel=(DefaultTableModel)Table1.getModel();
           aModel.setColumnIdentifiers(tableColumnsName); 
              ResultSet rs=  stm.executeQuery(sql);
              ResultSetMetaData rsmd=rs.getMetaData();
              int colno=rsmd.getColumnCount();
              while(rs.next())
              {
               Object[] obj=new Object[colno];
               for(int i=0;i<colno;i++)
               {
                obj[i]=rs.getObject(i+1);
               }
               aModel.addRow(obj);
              }
              Table1.setModel(aModel);
         } catch (SQLException ex) {
             Logger.getLogger(SelectStaff.class.getName()).log(Level.SEVERE, null, ex);
         }
            
     
    }
   /* int id;
    String password,name,mobile,address,work,email;
    public SelectStaff(int v1,String v2,String v3,String v4,String v5,String v6,String v7)
    {
    initComponents();
    this.id=v1;
    this.password=v2;
    this.name=v3;
    this.mobile=v4;
    this.address=v5;
    this.work=v6;
    this.email=v7;
    AddDataToTable();
    
    }
 void AddDataToTable()
 {
     DefaultTableModel aModel=(DefaultTableModel)Table1.getModel();   
     Vector v=new Vector();
     for(int i=0;i<4;i++)
     {
     v.add(id);
     v.add(password);
     v.add(name);
     v.add(mobile);
     v.add(address);
      v.add(work);
      v.add(email);
      aModel.addRow(v);
     }
 }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Password", "Name", "Mobile", "Address", "Work", "Email"
            }
        ));
        jScrollPane1.setViewportView(Table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SelectStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
