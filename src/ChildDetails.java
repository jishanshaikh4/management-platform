
import static com.oracle.jrockit.jfr.ContentType.Bytes;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanu
 */
public class ChildDetails extends javax.swing.JFrame  {

    /**
     * Creates new form ChildDetails
     */
    private Connection con;
    private PreparedStatement ps;
    // label3 = new JLabel();
    public ChildDetails() {
        initComponents();
        con=Data.connect();
          childData();    
          
          
    }
    void childData()
    {
     String sql="select*from child";
        Statement stm;
         try {
             stm = con.createStatement();
             String[] tableColumnsName={" Id","name","age","class","BloodG","HealthIss","image","Action"};
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
              //  JButton b=new JButton("adopt");
                
               }
               aModel.addRow(obj);
               
              }
            /*  JTable table=new JTable();
              table.setRowSelectionAllowed(true);
              if(table.getCellSelectionEnabled())
              {    
              table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
              int row=table.getSelectedRow();
              System.out.println("this is "+row);
              }
              Table1.setModel(aModel);
          int selectedRowIndex=Table1.getSelectedRow();
             TableModel model=Table1.getModel();
             String  id= model.getValueAt(selectedRowIndex,0).toString();
  */         
           int i=500;
                 int j=200;
                 int k=670;
                 int l=250;
                 
              ResultSet test = stm.executeQuery("select photo from child ");
                 System.out.println(test);
              if(test.next()) 
            {   
                System.out.println("Inside");
            byte[] imagedata = test.getBytes("photo") ;
              
            ImageIcon icon =new ImageIcon(imagedata);
                          Image im = icon.getImage();
                          Image myImg = im.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon newImage =new ImageIcon(myImg);
                System.out.println(newImage);
                setVisible(true);
                System.out.println("Here");
                JLabel label3;
                 label3 = new JLabel();
                 
                 label3.setBounds(i,j,k,l);
                 add(label3);
                label3.setIcon(newImage);
                i=i+100;
                j=j+100;
                k=k+100;
                l=l+100;
                System.out.println("LAST");
            }
              else
              {
                  System.out.println("No DAta");
                  //JoptionPane.showMessageDialog(null,"No data");
              }
      
           ///   Table1.setModel(aModel);
          //  int selectedRowIndex=Table1.getSelectedRow();
            // TableModel model=Table1.getModel();
             //String  id= model.getValueAt(selectedRowIndex,0).toString();
            // String sql1="Select photo from child where id=id";
              // ResultSet rs1=stm.executeQuery(sql1);
              /* while(rs.next())
               {
                byte[] b=rs.getBytes("photo");
                ImageIcon image=new ImageIcon(b);
                Image im=image.getImage();
                Image myImg=im.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage=new ImageIcon(myImg);
                jLabel3.setIcon(newImage);
                
               }*/
             //getText(aModel.getValueAdd(selectedRowIndex,0).toString());
            /* while(rs.next())
             {
              byte[] img=rs.getBytes("photo");
             Image image =getToolkit().createImage(img);
             ImageIcon icon=new ImageIcon(image);
             jLabel3.setIcon(icon);
             
             
             
             
             }*/
         } catch (SQLException ex) {
             Logger.getLogger(SelectStaff.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Child Details");

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Age", "Class", "bloodG", "healthIss", "image", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel1)
                        .addGap(221, 221, 221)))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Table1MouseClicked

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
            java.util.logging.Logger.getLogger(ChildDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChildDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChildDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChildDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChildDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

     //To change body of generated methods, choose Tools | Templates.
    

