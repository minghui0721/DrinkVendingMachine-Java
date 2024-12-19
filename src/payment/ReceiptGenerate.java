/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package payment;

import index.VendingMachineContent;
import index.VendingMachineHeader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author mingh
 */
public class ReceiptGenerate extends javax.swing.JFrame {

    /**
     * Creates new form Receipt
     */
    public ReceiptGenerate() {
        initComponents();
        
        
        // Load data from the 'data/orders.txt' file and update jLabel3 and jLabel4
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/orders.txt"));
            String line;
            String lastLine = null;
            
            // Read each line until the last line
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
            
            if (lastLine != null) {
                String[] portions = lastLine.split("\\|");
                if (portions.length >= 2) {
                    jLabel3.setText(portions[0]); // Set portion 1 in jLabel3
                    jLabel4.setText(portions[1]); // Set portion 2 in jLabel4
                    jLabel16.setText(portions[2]); // Set portion 2 in jLabel4
                }
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Load data from the 'data/cart.txt' file and update drink records
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/cart.txt"));
            String line;
            ArrayList<String> drinkRecords = new ArrayList<>();
            // Create a HashMap to store drink name as key and its total quantity as value
            HashMap<String, Integer> drinkQuantityMap = new HashMap<>();

            // Read each line and add drink records to the list
            while ((line = reader.readLine()) != null) {
                String[] portions = line.split("\\|");
                if (portions.length >= 4) {
                    String drinkName = portions[1];  // Portion 2 is the drink name
                    String quantity = portions[2];   // Portion 3 is the quantity
                    String price = portions[3];      // Portion 4 is the price

                    int parsedQuantity = Integer.parseInt(quantity);
        
                    // Update the quantity for the existing drink in the drinkQuantityMap
                    int totalQuantity = drinkQuantityMap.getOrDefault(drinkName, 0) + parsedQuantity;
                    drinkQuantityMap.put(drinkName, totalQuantity);

                    // Check if the same drink name has already been added
                    boolean drinkExists = false;
                    for (String record : drinkRecords) {
                        if (record.contains(drinkName)) {
                            drinkExists = true;
                            break;
                        }
                    }

                    // If the drink does not exist in the list, add it
                    if (!drinkExists) {
                        String drinkRecord = drinkName + "|" + quantity + "|" + price;
                        drinkRecords.add(drinkRecord);
                    } 
                }
            }

             // Define jPanel1Layout and rowBox variables
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setAutoCreateGaps(true);
                jPanel1Layout.setAutoCreateContainerGaps(true);
                javax.swing.Box rowBox = javax.swing.Box.createVerticalBox();

            // Populate the drink records in the GUI
            int yOffset = 0; // Adjust this value to control vertical spacing
            int totalHeight = 0;
            int labelHeight = 20; // Adjust the height of each label as needed
            int gapHeight = 5;    // Adjust the gap height between labels as needed
            boolean isFirstRecord = true;

            for (String drinkRecord : drinkRecords) {
                totalHeight += labelHeight + gapHeight;
                String[] portions = drinkRecord.split("\\|");
                if (portions.length >= 3) {
                    String drinkName = portions[0];
                    String quantity = portions[1];
                    String price = portions[2];
    

                   // Create JLabels for drink name, quantity, and price
                    javax.swing.JLabel nameLabel = new javax.swing.JLabel(drinkName);
                     javax.swing.JLabel quantityLabel = new javax.swing.JLabel(Integer.toString(drinkQuantityMap.getOrDefault(drinkName, 0)));
                    javax.swing.JLabel priceLabel = new javax.swing.JLabel(price);
                    
    
                    // Add padding to labels
                    int labelPadding = 15; // Adjust the padding value as needed
                    int labelPadding2 = 35;
                    nameLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, labelPadding, labelPadding, 0));
                    priceLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, labelPadding2));
               
       

                    // Set font, size, and alignment properties for labels
                    nameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font and size as needed
                    quantityLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font and size as needed
                    priceLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font and size as needed
                    
               
             
                   
                 // Create a horizontal box for each row to hold the labels with proper alignment
                    javax.swing.Box drinkRowBox = javax.swing.Box.createHorizontalBox();
                    drinkRowBox.add(nameLabel);
                    drinkRowBox.add(Box.createHorizontalGlue());
                    drinkRowBox.add(quantityLabel);
                    drinkRowBox.add(Box.createHorizontalGlue());
                    drinkRowBox.add(priceLabel);

                    // Add the drinkRowBox to the main rowBox
                    rowBox.add(drinkRowBox);
                
                    // Add rowBox to jPanel1Layout
                            jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rowBox)
                            );

                            jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rowBox)
                            );
                    // Add vertical gap between rows
                    jPanel1.add(Box.createVerticalStrut(20));

                    yOffset += 20 + nameLabel.getPreferredSize().height; // Adjusting for label height and gap
                    
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        setLocation(650, 80);
        setTitle("Vending Machine System - Receipt");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
         jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/apuLogo.png"))); // NOI18N
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/resources/apuLogo.png"));
        Image image = logoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Resize the image
        jLabel1.setIcon(new javax.swing.ImageIcon(image)); // Set the resized image as icon
         
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel2.setText("Customer Receipt");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("Order ID");

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("Date");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setText("PAYMENT SUMMARY");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("DRINKS");

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("QUANTITY");

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("PRICE");

       // Add a placeholder JLabel for each dynamic record
        dynamicRecordsLabel = new javax.swing.JLabel();
        dynamicRecordsLabel.setLayout(new javax.swing.BoxLayout(dynamicRecordsLabel, javax.swing.BoxLayout.Y_AXIS));

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel15.setText("TOTAL (DISC)");

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(19, 195, 119));

        jButton1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton1.setBackground(new java.awt.Color(0, 0, 128)); // Restore background color on exit
        jButton1.setForeground(Color.white);
        jButton1.setBorderPainted(false); // Remove border
        jButton1.setFocusPainted(false); // Remove focus border
        
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
         // Apply hover effect
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
               jButton1.setBackground(Color.decode("#0077b6")); // Restore background color on exit
                jButton1.setForeground(Color.white);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0, 0, 128)); // Restore background color on exit
                jButton1.setForeground(Color.white);
            }
        });
        
        
        jPanel1.setPreferredSize(new java.awt.Dimension(jPanel1.getPreferredSize().width, 80)); // Set preferred height to 200

        // Create a JScrollPane and add jPanel1 to it
        JScrollPane jScrollPane = new JScrollPane(jPanel1);
        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(30, 30, 30))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(180, 180, 180)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(29, 29, 29))
                            .addComponent(jSeparator1))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(56, 56, 56)
                .addComponent(jLabel5)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>                           


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceiptGenerate().setVisible(true);
            }
        });
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Generate and save PDF on button click
        PDFGenerator.generatePDF(this, "receipt.pdf");

        // After generating the PDF, prompt the user to download it
        File pdfFile = new File("receipt.pdf");
        if (pdfFile.exists()) {
            try {
                Desktop.getDesktop().open(pdfFile);
                dispose();
                
                 // After generating the PDF, process the cart
                CartProcessor cartProcessor = new CartProcessor();
                Map<String, Integer> cartContents = cartProcessor.readCartFile();

                if (cartContents != null) {
                    cartProcessor.updateDrinkQuantities(cartContents);
                    cartProcessor.clearCartFile();
                }
                
                // Create and configure the mainFrame
                JFrame mainFrame = new JFrame("Vending Machine System");
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setSize(1200, 600);
                mainFrame.setLocation(350, 200);

                // Create and add components to the mainFrame
                VendingMachineHeader header = new VendingMachineHeader();
                VendingMachineContent content = new VendingMachineContent();

                mainFrame.add(header, BorderLayout.NORTH);
                mainFrame.add(content, BorderLayout.CENTER);

                // Make the mainFrame visible
                mainFrame.setVisible(true);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
     private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel dynamicRecordsLabel; // Placeholder for dynamic records
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration                   
}
