package drink;

import index.VendingMachineHeader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import javax.swing.JLabel;


public class AddDrinks extends javax.swing.JFrame {

    private VendingMachineHeader header;
    private static final Color HINT_TEXT_COLOR = new Color(0x5c5adb);
    private String filePath; // Declare it as a member variable
    private String fileName; // Declare it as a member variable
    private File selectedFile;
    private static String loggedInUsername; // Declare as a class-level variable
    private JLabel selectedFileNameLabel;




    public AddDrinks(String loggedInUsername) {
    this.loggedInUsername = loggedInUsername; // Store the loggedInUsername
        initComponents();
        header = new VendingMachineHeader();
        setLayout(new BorderLayout());
        add(header, BorderLayout.NORTH); // Add the header to the top
        setSize(1050, 720); // Set the frame size
        setLocation(440, 130); // Set the frame location
        setTitle("Vending Machine System - Add Drinks"); // Set the title of the frame
        

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ViewDrinks viewDrinksFrame = new ViewDrinks(loggedInUsername);

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        // Inside the initComponents method, after initializing button1
        selectedFileNameLabel = new JLabel("No file selected");
        selectedFileNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        selectedFileNameLabel.setPreferredSize(new Dimension(200, 20)); // Set preferred width
        add(selectedFileNameLabel);
        
        jTextField1 = new javax.swing.JTextField();
        int textFieldWidth = 400; // Set the desired width for the text fields
        int textFieldHeight = 40; // Set the desired height for the text fields
        int padding = 10; // Set the desired padding value
        
        jTextField1.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        addPadding(jTextField1, padding);
        jTextField1.setFont(new Font("Arial", Font.PLAIN, 15)); // Set font
        

        jTextField2 = new javax.swing.JTextField();
        jTextField2.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        addPadding(jTextField2, padding);
        jTextField2.setFont(new Font("Arial", Font.PLAIN, 15)); // Set font

        jTextField3 = new javax.swing.JTextField();
        jTextField3.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        addPadding(jTextField3, padding);
        jTextField3.setFont(new Font("Arial", Font.PLAIN, 15)); // Set font
        
        
        setHint(jTextField1, "Please enter the name of the drink");
        setHint(jTextField2, "Please enter the quantity");
        setHint(jTextField3, "Please enter the unit price (RM)");

        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 55)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Drinks");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Drinks Name:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Quantity:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Price (RM):");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Drinks Icon:");

  

        button1 = new JButton("File");
        button1.setBackground(new java.awt.Color(0x5c5adb));
        button1.setFont(new java.awt.Font("Arial", 0, 22));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setFocusPainted(false); // Remove focus border
        button1.setBorderPainted(false); // Remove border
        
        // Add mouse listener for hover effect
        button1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button1.setBackground(new Color(0x393191)); // Change background color on hover
            }

            public void mouseExited(MouseEvent evt) {
                button1.setBackground(new Color(0x5c5adb)); // Restore original background color when mouse exits
            }
        });
        
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chooseFile();
            }
        });
        
 

        button2 = new JButton("Add");
        button2.setBackground(new java.awt.Color(0x1d1d36));
        button2.setFont(new java.awt.Font("Arial", 0, 24));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setFocusPainted(false); // Remove focus border
        button2.setBorderPainted(false); // Remove border
        // Add mouse listener for hover effect
        button2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button2.setBackground(new Color(0x393191)); // Change background color on hover
            }

            public void mouseExited(MouseEvent evt) {
                button2.setBackground(new Color(0x1d1d36)); // Restore original background color when mouse exits
            }
        });

        button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            
            
            // Check if any of the input fields are empty
            boolean isNameEmpty = jTextField1.getText().isEmpty() || jTextField1.getText().equals("Please enter the name of the drink");
            boolean isQuantityEmpty = jTextField2.getText().isEmpty() || jTextField2.getText().equals("Please enter the quantity");
            boolean isPriceEmpty = jTextField3.getText().isEmpty() || jTextField3.getText().equals("Please enter the unit price (RM)");
            boolean isFileEmpty = filePath == null || filePath.isEmpty();

            int emptyFieldCount = 0;
            if (isNameEmpty) emptyFieldCount++;
            if (isQuantityEmpty) emptyFieldCount++;
            if (isPriceEmpty) emptyFieldCount++;
            if (isFileEmpty) emptyFieldCount++;

            if (emptyFieldCount > 1) {
                JOptionPane.showMessageDialog(AddDrinks.this, "Please don't leave the inputs blank !", "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // Don't proceed if more than one field is empty
            }

            String errorMessage = "";
            if (isNameEmpty) {
                errorMessage += "Please enter the name of the drink !\n";
            }

            if (isQuantityEmpty) {
                errorMessage += "Please enter the quantity you want to add, Minimum 1 - Maximum 10 !\n";
            }

            if (isPriceEmpty) {
                errorMessage += "Please enter the unit price (RM)!\n";
            }

            if (isFileEmpty) {
                errorMessage += "Please upload the image for the drink !\n";
            }

            if (!errorMessage.isEmpty()) {
                JOptionPane.showMessageDialog(AddDrinks.this, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // Don't proceed if any field is empty

            }
            
             // Check if the input fields are valid
            if (!validateInputs()) {
                return; // Validation failed, don't proceed
            }

            // Convert drinkName to lowercase
            String drinkName = jTextField1.getText().toLowerCase();
            if (drinkExists(drinkName)) {
                JOptionPane.showMessageDialog(AddDrinks.this, "Can't add. Drink already exists !");
                return;
            }
            
            // Display a confirmation dialog
            int confirmResult = JOptionPane.showConfirmDialog(
                AddDrinks.this,
                "Are you sure you want to add this drink?",
                "Confirm Add Drink",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmResult == JOptionPane.YES_OPTION) {
                // Get lastDrinkID and generate newDrinkID
                String lastDrinkID = getLastDrinkID();
                String newDrinkID = generateNewDrinkID(lastDrinkID);

                // Get the value from jTextField3 and format it to two decimal places
                double price = Double.parseDouble(jTextField3.getText());
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                String formattedPrice = decimalFormat.format(price);

                // Prepare the record to insert into the file
                String newRecord = newDrinkID + "|" + drinkName + "|" +
                                   formattedPrice + "|" + jTextField2.getText() + "|" +
                                   filePath;

               // Save the selected file to the "resources" folder
                if (fileName != null && !fileName.isEmpty()) {
                    File resourcesFolder = new File("src/resources");
                    if (!resourcesFolder.exists()) {
                        resourcesFolder.mkdir(); // Create the "resources" folder if it doesn't exist
                    }


                    File destinationFile = new File(resourcesFolder, fileName);
                    if (!destinationFile.exists()) {
                        try {
                            Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(AddDrinks.this, "Error saving file to resources folder.");
                            return; // Exit the method if file saving failed
                        }
                    }
    }

                if (insertRecord(newRecord)) {
                    int confirmContinue = JOptionPane.showConfirmDialog(
                        AddDrinks.this,
                        "Drink added successfully! Do you want to continue adding drinks?",
                        "Add Another Drink",
                        JOptionPane.YES_NO_OPTION
                    );

                    if (confirmContinue == JOptionPane.YES_OPTION) {
                        clearInputs(); // Clear the input fields
                        filePath = null; // Reset the filePath
                        fileName = null; // Reset the fileName
                        selectedFileNameLabel.setText("No file selected");
                    } else {
                        // Close the AddDrinks frame
                        dispose();   

                        // Open the ViewDrinks frame
                        openViewDrinksFrame(loggedInUsername);

         
                    }
                } else {
                    JOptionPane.showMessageDialog(AddDrinks.this, "Failed to add drinks !");
                }
            }
        }
    });


        button3 = new JButton("Back");
        button3.setBackground(new java.awt.Color(0x1d1d36));
        button3.setFont(new java.awt.Font("Arial", 0, 24));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setFocusPainted(false); // Remove focus border
        button3.setBorderPainted(false); // Remove border
        // Add mouse listener for hover effect
        button3.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button3.setBackground(new Color(0x393191)); // Change background color on hover
            }

            public void mouseExited(MouseEvent evt) {
                button3.setBackground(new Color(0x1d1d36)); // Restore original background color when mouse exits
            }
        });
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                 openViewDrinksFrame(loggedInUsername);
            }
        });
        
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(44, 44, 44))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(37, 37, 37)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(selectedFileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addContainerGap(290, Short.MAX_VALUE))
);
layout.setVerticalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addGap(147, 147, 147)
        .addComponent(jLabel1)
        .addGap(31, 31, 31)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel2)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(45, 45, 45)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel3)
            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectedFileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
);


        pack();
    }// </editor-fold>    
    
    public void openViewDrinksFrame(String loggedInUsername) {
        ViewDrinks viewDrinksFrame = new ViewDrinks(loggedInUsername);
        viewDrinksFrame.setVisible(true);
    }

    
    // Validate input fields
    private boolean validateInputs() {
        String drinkName = jTextField1.getText().trim();
        String quantityStr = jTextField2.getText().trim();
        String priceStr = jTextField3.getText().trim();
        
        // Validate jTextField1 (Drink Name)
        if (!isValidDrinkName(drinkName)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid drink name !");
            return false;
        }

        // Validate jTextField2 (Quantity)
        if (!isInteger(quantityStr)) {
            JOptionPane.showMessageDialog(this, "Please only enter integer for quantity !");
            return false;
        }
        int quantity = Integer.parseInt(quantityStr);
        if (quantity < 1) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for quantity !");
            return false;
        }
        if (quantity > 10) {
            JOptionPane.showMessageDialog(this, "Maximum of 10 units of drinks !");
            return false;
        }

        // Validate jTextField3 (Price)
        if (!isNumber(priceStr)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid unit price !");
            return false;
        }
        float price = Float.parseFloat(priceStr);
        if (price <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid unit price !");
            return false;
        }

        return true; // All validations passed
    }
    
    private boolean isValidDrinkName(String name) {
        if (name.isEmpty()) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasLetter || (hasDigit && name.matches(".*\\D.*"));
    }





    
    // Check if a drink already exists
    private boolean drinkExists(String drinkName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/drinks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 2 && parts[1].equalsIgnoreCase(drinkName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get the last drink ID from the file
    private String getLastDrinkID() {
        String lastDrinkID = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/drinks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 1) {
                    lastDrinkID = parts[0];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastDrinkID;
    }

    // Generate a new drink ID based on the lastDrinkID
    private String generateNewDrinkID(String lastDrinkID) {
        if (lastDrinkID == null || lastDrinkID.isEmpty()) {
            return "D001"; // If no previous ID found, start with D001
        }
        int num = Integer.parseInt(lastDrinkID.substring(1)) + 1;
        return String.format("D%03d", num); // Format to "D001", "D002", ...
    }


    // Insert the record into the file
    private boolean insertRecord(String newRecord) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/drinks.txt", true))) {
            writer.write(newRecord);
            writer.newLine();
            return true; // Successfully inserted
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Insertion failed
        }
    }

     // Clear input fields
    private void clearInputs() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
    }

    // Utility method to check if a string is an integer
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Utility method to check if a string is a number (integer or float)
    private boolean isNumber(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private void setHint(JTextField field, String hint) {
        field.setForeground(new ColorUIResource(HINT_TEXT_COLOR));
        field.setText(hint);

        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(hint)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
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

    
    
   private void chooseFile() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        selectedFile = fileChooser.getSelectedFile(); // Assign to class-level variable
        fileName = selectedFile.getName(); // Get the file name
        filePath = "/resources/" + fileName; // Update the member variable filePath
        System.out.println("Selected file path: " + filePath);
        selectedFileNameLabel.setText("Selected file: " + fileName); // Update label
    }
}

    private void addPadding(JTextField textField, int padding) {
        Border paddingBorder = BorderFactory.createEmptyBorder(padding, padding, padding, padding);
        Border compoundBorder = BorderFactory.createCompoundBorder(
            textField.getBorder(), // Existing border
            paddingBorder // Inner padding border
        );
        textField.setBorder(compoundBorder);
    }

     

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // Your look and feel setting code
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDrinks(loggedInUsername).setVisible(true);
            }
        });
    }
    
        private JButton button1;
        private JButton button2;
        private JButton button3;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPopupMenu jPopupMenu1;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        private javax.swing.JTextField jTextField3;
}
