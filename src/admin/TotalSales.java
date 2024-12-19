/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author mingh
 */
public class TotalSales extends javax.swing.JFrame {

    /**
     * Creates new form Popular
     */
    public TotalSales() {
        initComponents();

        setLocation(515,200);
        this.getContentPane().setBackground(new java.awt.Color(92, 90, 189));
        setTitle("Vending Machine System - Total Sales"); // Set the title of the frame

        double totalSales = calculateTotalSales();
        jLabel2.setText(String.format("Total Sales Amount: RM %.2f", totalSales));

        setCurrentMonth();

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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel1.setForeground(Color.white);
        jLabel1.setText("Total Sales (RM)");

        // Create and configure the back button
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setFocusPainted(false); // Remove the auto-focused border
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame (PopularDrink)
                dispose();

                // Create and configure the frame for the previous page (e.g., ReportGeneration)
                JFrame previousFrame = new ReportGeneration(); // Replace with the actual class name
                previousFrame.setVisible(true);
            }
        });

        jLabel2.setText("jLabel3");
        jLabel2.setForeground(new Color(0xea4335)); // Set the text color to #ea4335
        jLabel2.setFont(new Font("Arial Black", Font.PLAIN, 36));

        jLabel3.setText("jLabel3");
        jLabel3.setForeground(new Color(0xea4335)); // Set the text color to #ea4335
        jLabel3.setFont(new Font("Arial Black", Font.PLAIN, 36));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(189, 189, 189)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(365, 365, 365)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel1)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel2)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel3)
                                .addGap(60, 60, 60)
                                .addComponent(jButton1)
                                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>  

    private void setCurrentMonth() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy"); // Format the month like "August 2023"
        String formattedMonth = currentDate.format(formatter);
        jLabel3.setText("Current Month: " + formattedMonth);
    }

    private double calculateTotalSales() {
        double totalSales = 0.0;

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader reader = new BufferedReader(new FileReader("data/orders.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] orders = line.split("\\|");
                if (orders.length >= 3)
                {
                    String dateTimeString = orders[1];
                    LocalDateTime orderDateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter);
                    LocalDate orderDate = orderDateTime.toLocalDate();

                    if (orderDate.getYear() == currentDate.getYear() && orderDate.getMonth() == currentDate.getMonth())
                    {
                        double orderAmount = Double.parseDouble(orders[2]);
                        totalSales += orderAmount;
                    }
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return totalSales;
    }

    private String findMostPopularDrink(Map<String, Integer> drinkQuantityMap) {
        String mostPopularDrinkID = null;
        int maxQuantity = 0;

        for (Map.Entry<String, Integer> entry : drinkQuantityMap.entrySet())
        {
            if (entry.getValue() > maxQuantity)
            {
                maxQuantity = entry.getValue();
                mostPopularDrinkID = entry.getKey();
            }
        }

        return mostPopularDrinkID;
    }

    private void setPopularDrinkDetails(String drinkID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/drinks.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split("\\|");
                if (parts.length >= 3 && parts[0].equals(drinkID))
                {
                    String drinkName = parts[1];
                    String iconPath = parts[4]; // Assuming index 3 contains the icon path

                    jLabel3.setText(drinkName);
                    // Load the image from the iconPath
                    ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));

                    // Get the original image from the ImageIcon
                    Image originalImage = icon.getImage();

                    // Scale the image to 100x100 pixels
                    Image scaledImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

                    // Create a new ImageIcon with the scaled image
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    // Set the scaled icon on jLabel2
                    jLabel2.setIcon(scaledIcon);

                    System.out.println(iconPath);
                    break;
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(Popular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Popular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Popular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Popular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TotalSales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jButton1; // Declare the button as a class member
}
// End of variables declaration                   

