package admin;

import index.VendingMachineHeader;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;

public class StaffManagement extends javax.swing.JFrame {
    
    private VendingMachineHeader header;
    
    public StaffManagement() {
        initComponents();
        
        setSize(1200, 650);
        setLocation(350, 250);
        setTitle("Vending Machine System - Staff Management"); // Set the title of the frame
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        header = new VendingMachineHeader();
        
        

       jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        
        
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20)); // Set font
        jTextField1.setMargin(new java.awt.Insets(5, 10, 5, 10)); // Add padding
        jTextField1.setForeground(java.awt.Color.GRAY); // Set hint text color to gray
        
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20)); // Set font
        jPasswordField1.setMargin(new java.awt.Insets(5, 10, 5, 10)); // Add padding
        jPasswordField1.setForeground(java.awt.Color.GRAY); // Set hint text color to gray
        
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        

        jTable1.setBackground(new java.awt.Color(92, 90, 219));
        jTable1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                // Remove existing data initialization
            },
            new String [] {
                "", "Staff"
            }
        ));
        
            // Load data from 'data/staff.txt' file
            List<String> staffList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("data/staff.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("/");
                    if (parts.length > 0) {
                        staffList.add(parts[0]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Create a DefaultTableModel with the loaded data
            javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(
                new Object[staffList.size()][2], // Number of rows and columns
                new String[]{"No.", "Staff List"} // Column headers
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Make all cells uneditable
                }
            };

            for (int i = 0; i < staffList.size(); i++) {
                tableModel.setValueAt(i + 1, i, 0); // Set the "No." column (auto-numbering)
                tableModel.setValueAt(staffList.get(i), i, 1); // Set the "Staff" column
            }

            // Set the table model to jTable1
            jTable1.setModel(tableModel);
            
            // Create a custom cell renderer for center-aligned content
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            
            // Set the cell renderer to all columns in the table
                for (int columnIndex = 0; columnIndex < jTable1.getColumnCount(); columnIndex++) {
                    jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(cellRenderer);
                }
                
              // Create the JScrollPane and add the table to it
                JScrollPane jScrollPane1 = new JScrollPane(jTable1);
                jScrollPane1.getVerticalScrollBar().setUI(new CustomScrollBarUI());
                jScrollPane1.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
                
              

        // Adjust the width of the "No." column in the table header
        javax.swing.table.TableColumn noColumn = jTable1.getColumnModel().getColumn(0);
        noColumn.setPreferredWidth(1); // Set your preferred width here
        
        javax.swing.table.TableColumn usernameColumn = jTable1.getColumnModel().getColumn(1);
        usernameColumn.setPreferredWidth(300); // Set your preferred width here

        javax.swing.table.JTableHeader tableHeader = jTable1.getTableHeader();
        tableHeader.setFont(new java.awt.Font("Arial Black", java.awt.Font.PLAIN, 20)); // Set font for header text
        tableHeader.setForeground(java.awt.Color.WHITE); // Set text color to white
        tableHeader.setBackground(new java.awt.Color(29, 29, 54)); // Set background color to #1d1d36

        // Create a custom layout manager for the header
        javax.swing.table.TableCellRenderer originalRenderer = tableHeader.getDefaultRenderer();
        tableHeader.setDefaultRenderer(new javax.swing.table.TableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                                                                    boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component comp = originalRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Add intercell spacing using padding
                int spacing = 10; // Adjust spacing value as needed
                java.awt.Insets insets = new java.awt.Insets(spacing, spacing, spacing, spacing);
                if (comp instanceof javax.swing.JLabel) {
                    javax.swing.JLabel label = (javax.swing.JLabel) comp;
                    label.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    label.setIconTextGap(spacing); // Add spacing between icon and text
                    label.setBorder(new javax.swing.border.EmptyBorder(insets));
                }

                return comp;
            }
        });

        // Set the custom layout manager to the table header
        tableHeader.setLayout(new java.awt.GridLayout(1, jTable1.getColumnCount()));



        jTable1.setToolTipText("");
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setIntercellSpacing(new java.awt.Dimension(50, 0));
        jTable1.setRowHeight(50);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 40)); // NOI18N
        jLabel2.setText("Staff Management");

        jButton1.setBackground(new java.awt.Color(92, 90, 219));
        jButton1.setFont(new java.awt.Font("Arial", 0, 24));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.setFocusPainted(false); // Remove focused border
        jButton1.setBorderPainted(false); // Remove button border
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        
        jButton1.addActionListener(new ActionListener() {
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

         jButton2.setBackground(new java.awt.Color(92, 90, 219));
        jButton2.setFont(new java.awt.Font("Arial", 0, 24));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create");
        jButton2.setFocusPainted(false); // Remove focused border
        jButton2.setBorderPainted(false); // Remove button border
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String username = jTextField1.getText().trim();
            char[] password = jPasswordField1.getPassword();
            String passwordStr = new String(password).trim();
            String passwordHint = "Please enter password";

            if (username.equals("Please enter username for staff") || passwordStr.equals(passwordHint)) {
                JOptionPane.showMessageDialog(null, "Please don't leave the input fields blank !");
                return;
            }
            
            if (isUsernameExists(username)) {
                JOptionPane.showMessageDialog(null, "User already exists!");
                return;
            }

            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to create this user?",
                    "Confirm User Creation", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                String staffInfo = username + "/" + passwordStr;

                try (PrintWriter writer = new PrintWriter(new FileWriter("data/staff.txt", true))) {
                    writer.println(staffInfo);
                    JOptionPane.showMessageDialog(null, "User created successfully!");
                   
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
                    
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred while creating the user.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    });

        // Set the hint text
        String jTextField1Hint = "Please enter username for staff";

        jTextField1.setText(jTextField1Hint);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        
        // Add FocusListener to handle hint behavior
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (jTextField1.getText().equals(jTextField1Hint)) {
                    jTextField1.setText("");
                    jTextField1.setForeground(java.awt.Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (jTextField1.getText().isEmpty()) {
                    jTextField1.setForeground(java.awt.Color.GRAY);
                    jTextField1.setText(jTextField1Hint);
                }
            }
        });

        // Set the hint text
        String jPasswordField1Hint = "Please enter password";
        jPasswordField1.setText(jPasswordField1Hint);
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                char[] password = jPasswordField1.getPassword();
                if (new String(password).equals(jPasswordField1Hint)) {
                    jPasswordField1.setText("");
                    jPasswordField1.setForeground(java.awt.Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                char[] password = jPasswordField1.getPassword();
                if (password.length == 0) {
                    jPasswordField1.setForeground(java.awt.Color.GRAY);
                    jPasswordField1.setText(jPasswordField1Hint);
                }
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Password:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Username:\n");

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 78, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(50, 50, 50))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(32, 32, 32))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(50, 50, 50)  // Adjust the spacing as needed
            .addComponent(jLabel2)
            .addGap(46, 46, 46)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(55, 55, 55)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(53, 53, 53)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2))
            .addGap(103, 103, 103))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(56, 56, 56))
    );



        // ... your other component configurations ...

        pack();
    }// </editor-fold>   
    
    //design scroll bar
    public class CustomScrollBarUI extends BasicScrollBarUI {

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            Dimension zeroDim = new Dimension(0, 0);
            button.setPreferredSize(zeroDim);
            button.setMinimumSize(zeroDim);
            button.setMaximumSize(zeroDim);
            return button;
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            g.setColor(new Color(92, 90, 219)); // Set the thumb color(5c5adb)
            g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            g.setColor(new Color(205, 205, 205)); // Set the track color (#1d1d36)
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }
    }
    
    private boolean isUsernameExists(String newUsername) {
        boolean exists = false;  // Initialize a boolean variable to indicate whether the username exists or not
        try {
            // Create a BufferedReader to read the contents of the "data/admin.txt" file
            BufferedReader reader = new BufferedReader(new FileReader("data/staff.txt"));
            String line;
            // Read each line of the file
            while ((line = reader.readLine()) != null) {
                // Split the line into parts using "/" as the delimiter
                String[] parts = line.split("/");
                // Extract the username from the first part of the line
                String username = parts[0];
                // Compare the extracted username with the newUsername provided as a parameter
                if (username.equals(newUsername)) {
                    // If the extracted username matches the newUsername, set 'exists' to true and break the loop
                    exists = true;
                    break;
                }
            }
            // Close the reader after reading the file
            reader.close();
        } catch (IOException e) {
            // Handle any exceptions that might occur while reading the file
            e.printStackTrace();
        }
        // Return the 'exists' boolean variable, which indicates whether the username exists in the file
        return exists;
    }

    
                  

    private void jButtonMouseEntered(java.awt.event.MouseEvent evt) {
        javax.swing.JButton button = (javax.swing.JButton) evt.getSource();
        button.setBackground(new java.awt.Color(29, 29, 54)); // Change to #1d1d36
    }

    private void jButtonMouseExited(java.awt.event.MouseEvent evt) {
        javax.swing.JButton button = (javax.swing.JButton) evt.getSource();
        button.setBackground(new java.awt.Color(92, 90, 219));
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           



   // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;          
}
