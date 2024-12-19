package customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Feedback extends javax.swing.JFrame {

    public Feedback() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(0x5c5acd));
        setSize(700, 450);
        setLocationRelativeTo(null);
        setTitle("Vending Machine System - Feedback");
    }

    private void initComponents() {
        jTextArea1 = new JTextArea();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 18));
        jTextArea1.setMargin(new Insets(10, 10, 10, 10)); // Adding padding
         jTextArea1.setToolTipText("Enter your feedback to us !:");
        JScrollPane scrollPane = new JScrollPane(jTextArea1);

        jButton1.setFont(new java.awt.Font("Arial", 1, 20));
        jButton1.setBackground(new java.awt.Color(0x1d1d16));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.setBorder(null);
        jButton1.setFocusPainted(false);
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new Dimension(150, jButton1.getPreferredSize().height));
        jButton1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x1D1D35));
            }

            public void mouseExited(MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x1d1d16));
            }
        });
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x5c5acb));
                jButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x1d1d16));
                jButton1.setBorder(null); // Remove the border
            }
        });
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String feedback = jTextArea1.getText().trim(); // Trim any leading/trailing spaces

                if (feedback.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your feedback before submitting.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit this feedback?", "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        // Save feedback to the text file
                        try {
                            java.util.Date date = new java.util.Date();
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String formattedDate = sdf.format(date);

                            java.io.FileWriter fw = new java.io.FileWriter("data/feedback.txt", true);
                            fw.write(formattedDate + "|" + feedback + System.lineSeparator());
                            fw.close();

                            JOptionPane.showMessageDialog(null, "Feedback submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            dispose(); // Close the current frame after successful submission
                            // Open a new instance of the ViewCart frame
                            CustomerIndex customerIndex = new CustomerIndex();
                            customerIndex.setVisible(true);
                        } catch (java.io.IOException e) {
                            JOptionPane.showMessageDialog(null, "Error saving feedback.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });



        jButton2.setFont(new java.awt.Font("Arial", 1, 20));
        jButton2.setBackground(new java.awt.Color(0x1d1d16));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.setBorder(null);
        jButton2.setFocusPainted(false);
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton2.setPreferredSize(new Dimension(150, jButton2.getPreferredSize().height));
        jButton2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jButton2.setBackground(new java.awt.Color(0x1D1D35));
                jButton2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            public void mouseExited(MouseEvent evt) {
                jButton2.setBackground(new java.awt.Color(0x1d1d16));
                jButton2.setBorder(null); // Remove the border
            }
        });
        
         jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton2ActionPerformed(evt);
            }
        });
         
         jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
               jButton2.setBackground(new java.awt.Color(0x5c5acb));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
              jButton2.setBackground(new java.awt.Color(0x1d1d16));
            }
        });
        

           JLabel titleLabel = new JLabel("Feedback");
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 35));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center-align the label

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPane))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addContainerGap(40, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }
    
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            dispose(); // Close the current frame when jButton2 is clicked

            // Open a new instance of the CustomerIndex frame
            CustomerIndex customerIndex = new CustomerIndex();
            customerIndex.setVisible(true);
        }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Feedback().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextArea jTextArea1;
}
