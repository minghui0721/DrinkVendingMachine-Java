package admin;

import index.VendingMachineHeader;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;


public class ProfileUpdate extends javax.swing.JFrame{
     
    private VendingMachineHeader header;
    private static final Color HINT_TEXT_COLOR = new Color(0x5c5adb); // Set hint text color to #5c5adb

    
// Update the padding values as needed
    private static final int INPUT_PADDING_TOP = 5;
    private static final int INPUT_PADDING_LEFT = 10;
    private static final int INPUT_PADDING_BOTTOM = 5;
    private static final int INPUT_PADDING_RIGHT = 10;

    public ProfileUpdate() {
        initComponents();
        setSize(1200, 600);
        setLocation(350,250);
        setTitle("Vending Machine System - Admin Profile"); // Set the title of the frame
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        header = new VendingMachineHeader();
        
        // Read the username from admin.txt and set it as the hint for jTextField1
       String username = readUsernameFromFile("data/admin.txt");
    if (username != null && !username.isEmpty()) {
        jTextField1 = new javax.swing.JTextField(username);
        setHint(jTextField1, username);
    } else {
        jTextField1 = new javax.swing.JTextField();
        setHint(jTextField1, "Username");
    }
   
    

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField(username);
        setPadding(jTextField1); // Set padding for jTextField1

        jPasswordField1 = new javax.swing.JPasswordField();
        setHint(jPasswordField1, "password");
        setPadding(jPasswordField1); // Set padding for jPasswordField1

        jPasswordField2 = new javax.swing.JPasswordField();
        setHint(jPasswordField2, "password");
        setPadding(jPasswordField2); // Set padding for jPasswordField2

        jPasswordField3 = new javax.swing.JPasswordField();
        setHint(jPasswordField3, "password");
        setPadding(jPasswordField3); // Set padding for jPasswordField3
        
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Profile Update");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Current Password:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("New Password:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Confirm New Password:");

        jTextField1.setForeground(new Color(0x5c5adb)); // Set text color to #5c5adb
        jTextField1.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size for input field
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        
        
        jPasswordField1.setText("password");
        jPasswordField1.setMaximumSize(new java.awt.Dimension(267, 100));
        jPasswordField1.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size for input field
        jPasswordField1.setMinimumSize(new java.awt.Dimension(267, 60));
        jPasswordField1.setForeground(new Color(0x5c5adb)); // Set text color to #5c5adb
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jPasswordField2.setText("password");
        jPasswordField2.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size for input field
        jPasswordField2.setMaximumSize(new java.awt.Dimension(267, 100));
        jPasswordField2.setMinimumSize(new java.awt.Dimension(267, 60));
        jPasswordField2.setForeground(new Color(0x5c5adb)); // Set text color to #5c5adb
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });

        jPasswordField3.setText("password");
        jPasswordField3.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size for input field
        jPasswordField3.setMaximumSize(new java.awt.Dimension(267, 100));
        jPasswordField3.setMinimumSize(new java.awt.Dimension(267, 60));
        jPasswordField3.setForeground(new Color(0x5c5adb)); // Set text color to #5c5adb
        jPasswordField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField3ActionPerformed(evt);
            }
        });
        
        jButton1.setBackground(new java.awt.Color(0x5C5ADB));
        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save");
        jButton1.setFocusPainted(false); // Remove focused border
        
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x1D1D36)); // Change background color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x5C5ADB)); // Change back to original background color when not hovering
            }
        });
        
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = jTextField1.getText();
                String currentUsername = readUsernameFromFile("data/admin.txt");

                String enteredPassword = new String(jPasswordField1.getPassword());
                String storedPassword = readUserDataFromFile("data/admin.txt")[1];


                
                String newPassword = new String(jPasswordField2.getPassword());
                String confirmPassword = new String(jPasswordField3.getPassword());
                
                boolean usernameChanged = !newUsername.isEmpty() && !newUsername.equals(currentUsername);
                boolean passwordChanged = (!enteredPassword.isEmpty() && !enteredPassword.equals("password")) ||
                        (!newPassword.isEmpty() && !newPassword.equals("password")) ||
                        (!confirmPassword.isEmpty() && !confirmPassword.equals("password"));

                
                if (!usernameChanged && !passwordChanged) {
                    JOptionPane.showMessageDialog(
                            ProfileUpdate.this,
                            "No changes were made to the profile.",
                            "No Changes",
                            JOptionPane.INFORMATION_MESSAGE
                            
                    );
                            
                      dispose(); // Close the ProfileUpdate framedispose(); // Close the ProfileUpdate frame


                            // Create and configure the frame for AdminIndex
                            JFrame adminFrame = new JFrame("Vending Machine System - Admin Dashboard");
                            adminFrame.setSize(1200, 600);
                            adminFrame.setLocation(350, 200);
                            adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            AdminIndex adminIndex = new AdminIndex(adminFrame);
                            adminFrame.getContentPane().add(adminIndex);
                            adminFrame.setVisible(true);       
                    return;
                }
                
                  if (!enteredPassword.equals(storedPassword)) {
                        JOptionPane.showMessageDialog(
                            ProfileUpdate.this, 
                            "Please enter correct current password !", 
                            "Invalid Password", 
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                boolean passwordsMatch = newPassword.equals(confirmPassword);
                if (!passwordsMatch) {
                    JOptionPane.showMessageDialog(
                            ProfileUpdate.this,
                            "New passwords do not match!",
                            "Password Mismatch",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                
                boolean passwordChanged2 = (!newPassword.isEmpty() && !newPassword.equals("password")) ||
                (!confirmPassword.isEmpty() && !confirmPassword.equals("password"));
                
               if (passwordChanged2 || usernameChanged) {
                    // Show a confirmation dialog
                    int response = JOptionPane.showConfirmDialog(
                            ProfileUpdate.this, // Parent component
                            "Do you really want to update your profile?", // Message
                            "Confirmation", // Dialog title
                            JOptionPane.YES_NO_OPTION // Option type
                    );

                    // Check the user's response
                    if (response == JOptionPane.YES_OPTION) {
                       
                        if (usernameChanged) {
                            // Update the admin username in the file
                            updateUsernameInFile("data/admin.txt", newUsername);
                            JOptionPane.showMessageDialog(
                                ProfileUpdate.this,
                                "Successfully updated username.",
                                "Username Updated",
                                JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                        
                         if (passwordChanged) {
                            if (newPassword.equals(storedPassword)) {
                                JOptionPane.showMessageDialog(
                                    ProfileUpdate.this,
                                    "Nothing has changed because the new password is the same as the old one !",
                                    "Password Unchanged",
                                    JOptionPane.INFORMATION_MESSAGE
                                );
                            } else if (passwordsMatch) {
                                // Update the admin password in the file
                                updatePasswordInFile("data/admin.txt", newPassword);
                                JOptionPane.showMessageDialog(
                                    ProfileUpdate.this,
                                    "Successfully updated password !",
                                    "Password Updated",
                                    JOptionPane.INFORMATION_MESSAGE
                                );
                            }
                        }


                        // Close the current frame (ProfileUpdate)
                        dispose();

                        // Create and configure the frame for AdminIndex
                        JFrame adminFrame = new JFrame("Vending Machine System - Admin Dashboard");
                        adminFrame.setSize(1200, 600);
                        adminFrame.setLocation(350, 250);
                        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                          // Create an instance of AdminIndex
                       AdminIndex adminIndex = new AdminIndex(adminFrame);

                        adminFrame.getContentPane().add(adminIndex);
                        adminFrame.setVisible(true);


                    }
                } else {
                    // Username hasn't changed, show a message
                    JOptionPane.showMessageDialog(
                            ProfileUpdate.this, // Parent component
                            "No changes were made to the username.", // Message
                            "No Changes", // Dialog title
                            JOptionPane.INFORMATION_MESSAGE // Message type
                    );

                    dispose(); // Close the ProfileUpdate framedispose(); // Close the ProfileUpdate frame


                        // Create and configure the frame for AdminIndex
                        JFrame adminFrame = new JFrame("Vending Machine System - Admin Dashboard");
                        adminFrame.setSize(1200, 600);
                        adminFrame.setLocation(350, 250);
                        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        AdminIndex adminIndex = new AdminIndex(adminFrame);
                        adminFrame.getContentPane().add(adminIndex);
                        adminFrame.setVisible(true);
                }
            }
        });


        jButton2.setBackground(new java.awt.Color(0x5C5ADB));
        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.setFocusPainted(false); // Remove focused border
        
        
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(new java.awt.Color(0x1D1D36)); // Change background color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(new java.awt.Color(0x5C5ADB)); // Change back to original background color when not hovering
            }
        });
        
       jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame (ProfileUpdate)
                dispose();

           
                // Create and configure the frame for AdminIndex
                JFrame adminFrame = new JFrame("Vending Machine System - Admin Dashboard");
                adminFrame.setSize(1200, 600);
                adminFrame.setLocation(350, 250);
                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // Create an instance of AdminIndex
                AdminIndex adminIndex = new AdminIndex(adminFrame);
                adminFrame.getContentPane().add(adminIndex);
                adminFrame.setVisible(true);
            }
        });


         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Add the header panel
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(20, 20, 20)
                                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53)
                                    .addComponent(jLabel5)
                                    .addGap(20, 20, 20)
                                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53)
                                    .addComponent(jLabel3)
                                    .addGap(77, 77, 77)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 95, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) // Add the header panel
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(376, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>
    
    
    private void updatePasswordInFile(String filename, String newPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Read all lines from the file
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // Update the second line with the new password
            if (lines.size() >= 2) {
                lines.set(1, newPassword);
            }

            // Write the modified content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    //update username
    private void updateUsernameInFile(String filename, String newUsername) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Read all lines from the file
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // Update the first line with the new username
            if (!lines.isEmpty()) {
                lines.set(0, newUsername);
            }

            // Write the modified content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}




    
    
    private void setPadding(JTextField field) {
        field.setMargin(new Insets(INPUT_PADDING_TOP, INPUT_PADDING_LEFT, INPUT_PADDING_BOTTOM, INPUT_PADDING_RIGHT));
    }

   private String readUsernameFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
   
   private String[] readUserDataFromFile(String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String[] userData = new String[2];
        userData[0] = reader.readLine(); // Read username
        userData[1] = reader.readLine(); // Read password
        return userData;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}



    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jPasswordField3ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }   
    
    private void setHint(JTextField field, String hint) {
        field.setForeground(new ColorUIResource(HINT_TEXT_COLOR));
        field.setText(hint);

        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText() != null && field.getText().equals(hint)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
                // If the field is a JPasswordField, clear the text
                if (field instanceof javax.swing.JPasswordField) {
                    ((javax.swing.JPasswordField) field).setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(new ColorUIResource(HINT_TEXT_COLOR));
                    field.setText(hint);
                }
            }
        });
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration       
}
