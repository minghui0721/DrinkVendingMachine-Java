
package customer;

import drink.QuantityPage;
import drink.ViewCart;
import drink.ViewDrinks;
import index.VendingMachineContent;
import index.VendingMachineHeader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author mingh
 */
public class CustomerIndex extends javax.swing.JFrame {
    
     // Path to the drinks data file
    private static final String DRINKS_FILE_PATH = "data/drinks.txt";
    private VendingMachineHeader header;
    public static final int HEADER_HEIGHT = 130; // Define the header's height
    private JFrame mainFrame; // Declare the mainFrame variable
    

    public CustomerIndex() {
        initComponents();
        
        // Initialize mainFrame here
        mainFrame = this;

        setSize(1200, 1000);
        setLocation(370, 10);
        setTitle("Vending Machine System - Customer");

        loadDrinksImages();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
       header = new VendingMachineHeader();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBorder(null); // Add this line to remove the border
        jPanel1 = new javax.swing.JPanel();

        jPanel4 = new javax.swing.JPanel();
        jPanel4.setPreferredSize(new Dimension(1163, 100));
        
        jPanel2 = new javax.swing.JPanel();
        // Set the preferred width for jPanel2
        jPanel2.setBackground(new Color(92, 90, 219)); // Set your desired background color
        jPanel2.setPreferredSize(new Dimension(1200, 40)); // Adjust the width as needed
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton(); // Initialize jButton3
        
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1163, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 637, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);
        
        int paddingLeft = 20; // Set your desired left padding
        int paddingRight = 20; // Set your desired right padding
        int paddingTop = 10; // Set your desired top padding
        int paddingBottom = 10; // Set your desired bottom padding
        
        // Create a new JButton for the "HELP" button
        JButton helpButton = new JButton("HELP");
        helpButton.setBackground(new java.awt.Color(0x5c5adb));
        helpButton.setFont(new java.awt.Font("Arial", 0, 24));
        helpButton.setForeground(new java.awt.Color(255, 255, 255));
        helpButton.setBorder(null);
        helpButton.setFocusPainted(false);
        helpButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(paddingTop, paddingLeft, paddingBottom, paddingRight));
        // Set cursor type to indicate that the button is clickable
        helpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        helpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpButton.setBackground(new java.awt.Color(0x1D1D35));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpButton.setBackground(new java.awt.Color(0x5c5adb));
            }
        });

        // Add an ActionListener to the "HELP" button
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                // Open a new instance of the ViewCart frame
                HelpOptions helpOptions = new HelpOptions();
                helpOptions.setVisible(true);
            }
        });
        
        
        
        
        jButton3.setBackground(new java.awt.Color(92, 90, 219));
        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DONE");
        jButton3.setBorder(null);
        jButton3.setFocusPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3.setBackground(new java.awt.Color(0x1D1D35));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3.setBackground(new java.awt.Color(0x5c5adb));
            }
        });
        
        jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
 

                // Open a new instance of the ViewCart frame
                ViewCart viewCart = new ViewCart();
                viewCart.setVisible(true);

                // Close the current frame
                dispose();

        }
    });

        
        // Create a new JButton for the "Back" button
        JButton backButton = new JButton("BACK");
        backButton.setBackground(new java.awt.Color(0x5c5adb));
        backButton.setFont(new java.awt.Font("Arial", 0, 24));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setBorder(null);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new java.awt.Color(0x1D1D35));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new java.awt.Color(0x5c5adb));
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                dispose();
                
                
                // Delete all records from the 'data/cart.txt' file
                try (PrintWriter writer = new PrintWriter("data/cart.txt")) {
                    // Write an empty string to the file
                    writer.print("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    // Handle the exception appropriately
                }

                // Create a new instance of the 'index' frame
                JFrame indexFrame = new JFrame();
                indexFrame.setSize(1200, 600);
                indexFrame.setLocation(350,200);
                indexFrame.setTitle("Vending Machine System - Customer");

                // Create and add the VendingMachineHeader to the top of the frame
                VendingMachineHeader header = new VendingMachineHeader();
                indexFrame.add(header, BorderLayout.NORTH);

                // Create and add the VendingMachineContent to the center of the frame
                VendingMachineContent content = new VendingMachineContent();
                indexFrame.add(content, BorderLayout.CENTER);

                // Set the default close operation for the frame
                indexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Make the frame visible
                indexFrame.setVisible(true);
            }
        });



        // Create a new JPanel for the buttonsPanel and backButtonPanel
        JPanel controlsPanel = new JPanel(new BorderLayout());
        controlsPanel.setBackground(new java.awt.Color(92, 90, 219));


        // Create a new JPanel for the buttonsPanel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 20)); // Add gap between buttons
        
        // Set preferred size (width and height) for the buttons
        int buttonWidth = 130; // Set your desired button width
        int buttonHeight = 50; // Set your desired button height
        backButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        jButton3.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        helpButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        jPanel2.setBackground(new java.awt.Color(2, 2, 64));
 

        
        
        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        double total = calculateTotalFromCart();
        jLabel6.setText("Total: RM " + total);
        


        jButton2.setBackground(new java.awt.Color(2, 2, 64));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setBorder(null);
        jButton2.setFocusPainted(false);
        jButton2.setText("YOUR CART ");
        // Add padding to jButton2

        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(paddingTop, paddingLeft, paddingBottom, paddingRight));
        // Set cursor type to indicate that the button is clickable
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Add hover effect by changing background color
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(new java.awt.Color(0, 0, 128)); // Change to the color you want on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(new java.awt.Color(2, 2, 64)); // Change back to the original color
            }
        });
        
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                dispose();

                // Open a new instance of the ViewCart frame
                ViewCart viewCart = new ViewCart();
                viewCart.setVisible(true);
            }
        });

        
       // Set up GroupLayout for jPanel2
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(80, 80, 80))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        
        
        // Create a new JPanel for the backButtonPanel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 20));

        // Add the "Back" button to the left side of the backButtonPanel
        backButtonPanel.add(backButton);

        // Create a space-filling component to push the "DONE" button to the right
        Component horizontalGlue = Box.createHorizontalGlue();
        backButtonPanel.add(horizontalGlue);
        
        // Create a new JPanel for the doneButtonPanel
        JPanel doneButtonPanel = new JPanel(new GridBagLayout());

        // Set up GridBagConstraints for the DONE button
        GridBagConstraints gbcDoneButton = new GridBagConstraints();
        gbcDoneButton.gridx = 2;
        gbcDoneButton.gridy = 0;
        gbcDoneButton.anchor = GridBagConstraints.CENTER;

        doneButtonPanel.add(helpButton, gbcDoneButton);
        doneButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40)); // Add right margin
        
        


        // Add the "DONE" button to the right side of the backButtonPanel
        buttonsPanel.add(jButton3);
        
        
        
        
        
        



        // Create a new JPanel for jPanel4nel
        JPanel jPanel4 = new JPanel();

        // Set the layout for jPanel4
        jPanel4.setLayout(new BorderLayout());
        jPanel4.add(buttonsPanel, BorderLayout.EAST);
        jPanel4.add(doneButtonPanel, BorderLayout.CENTER);
        jPanel4.add(backButtonPanel, BorderLayout.WEST);


        // Create a JSplitPane to hold the header and jScrollPane1
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, header, jScrollPane1);
        splitPane.setDividerSize(0); // Hide the divider
        splitPane.setResizeWeight(0); // Make the header not resizable

        // Set the horizontal divider location to maximize the jScrollPane1 width
       splitPane.setDividerLocation(HEADER_HEIGHT);


       // Set up the layout of the main content
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(splitPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Add jPanel2
                )
                .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(splitPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) // Set preferred height to 20 for jPanel2
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()
                )
        );

        pack();

        }
    
    // Method to calculate the total from the "data/cart.txt" file
    private double calculateTotalFromCart() {
        double total = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader("data/cart.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 4) {
                    double lineTotal = Double.parseDouble(parts[3]); // Assuming total is at index 3
                    total += lineTotal;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return total;
    }

     public void openViewDrinksFrame(String loggedInUsername) {
            ViewDrinks viewDrinksFrame = new ViewDrinks(loggedInUsername);
            viewDrinksFrame.setVisible(true);
        }


    private void loadDrinksImages() {
       try (BufferedReader reader = new BufferedReader(new FileReader(DRINKS_FILE_PATH))) {
           String line;
           int row = 0;
           int col = 0;

           while ((line = reader.readLine()) != null) {
               String[] parts = line.split("\\|"); // Escape the pipe character
               if (parts.length >= 5) {
                   String drinkId = parts[0]; // Drink ID (portion 1)
                   String imagePath = parts[4]; // Assuming image path is at index 4
                   ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
                   Image image = imageIcon.getImage();
                   Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

                   JLabel label = new JLabel(new ImageIcon(scaledImage));
                   int labelWidth = label.getPreferredSize().width;
                   int labelHeight = label.getPreferredSize().height;
                   
                    // Create a JButton for the drink ID
                    JButton drinkButton = new JButton(drinkId);
                    drinkButton.setFont(new Font("Arial", Font.PLAIN, 15));
                    drinkButton.setForeground(Color.WHITE);
                    drinkButton.setBorderPainted(false);
                    drinkButton.setFocusPainted(false);
                    Color customBackgroundColor = new Color(0x5c5adb);
                    drinkButton.setBackground(customBackgroundColor);
                    
                    // Inside your loadDrinksImages() method where you're creating drink buttons
                    drinkButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String selectedDrinkId = drinkId;
                            String[] drinkInfo = retrieveDrinkInfo(selectedDrinkId); // Retrieve drink info using drinkID

                            if (drinkInfo != null) {
                                String selectedDrinkName = drinkInfo[0];
                                double unitPrice = Double.parseDouble(drinkInfo[1]);
                                 int availableQuantity = Integer.parseInt(drinkInfo[2]);

                                 if (availableQuantity > 0) {
                                    QuantityPage quantityPage = new QuantityPage();
                                     quantityPage.setDrinkInfo(selectedDrinkId, selectedDrinkName, unitPrice, availableQuantity); // Set drinkId, drinkName, unitPrice, and availableQuantity
                                    quantityPage.setVisible(true);
                                } else {
                                    // Display an error message or take appropriate action
                                    JOptionPane.showMessageDialog(null, "This drink is out of stock !", "Out of Stock", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                // Handle the case where drink info is not found
                                // Display an error message or take appropriate action
                            }
                        }
                    });





                   // Calculate x and y positions with gaps
                   int gap = 100;
                   int xOffset = (jScrollPane1.getViewport().getWidth() - (4 * 150 + 3 * gap)) / 2; // Center the row
                   int x = xOffset + col * (150 + gap) + (125 - labelWidth) / 2;

                   int y;
                   if (row == 0) {
                       y = 20 + 50; // Add 50 vertical spacing for the first row
                   } else {
                       y = 20 + 50 + row * (220 + gap); 
                   }
                   
               
                    
                    int buttonX = x + (labelWidth - drinkButton.getPreferredSize().width) / 2;
                    // Adjust the buttonY to move the button lower
                    int buttonY = y + labelHeight - 30; // Adjust the value as needed
                    
                    drinkButton.setBounds(buttonX, buttonY, drinkButton.getPreferredSize().width, drinkButton.getPreferredSize().height);

                    // Inside your loadDrinksImages() method where you're creating drink buttons
                   


                   jPanel1.add(drinkButton, new Integer(1)); // Add the button with a higher layer
                   label.setBounds(x, y, 150, 150);
                   jPanel1.add(label);

                   // Create a label for the drink name and id
                    String capitalizedDrinkName = parts[1].substring(0, 1).toUpperCase() + parts[1].substring(1).toLowerCase();
                    JLabel nameLabel = new JLabel(capitalizedDrinkName + " (" + drinkId + ")");

                   JLabel priceLabel = new JLabel("Price: RM" + parts[2]); // Price (portion 3)
                   JLabel quantityLabel = new JLabel("Quantity: " + parts[3]); // Quantity (portion 4)
                   
                   nameLabel.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font to Arial, size 20
                  Color customColor = new Color(0x1D1D36); // Create a Color object with the custom color
                    nameLabel.setForeground(customColor); // Set font color of nameLabel to custom color

                    priceLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font to Arial, size 20
                    priceLabel.setForeground(Color.BLACK); // Set font color to white
                    quantityLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font to Arial, size 20
                    quantityLabel.setForeground(Color.BLACK); // Set font color to white

                   int labelCenterX = x + labelWidth / 2;
                   int nameLabelY = y + labelHeight + 20;
                   int priceLabelY = nameLabelY + nameLabel.getPreferredSize().height + 20; // Added padding here
                   int quantityLabelY = priceLabelY + priceLabel.getPreferredSize().height + 10;

                   nameLabel.setBounds(labelCenterX - nameLabel.getPreferredSize().width / 2, nameLabelY,
                                       nameLabel.getPreferredSize().width, nameLabel.getPreferredSize().height);
                   priceLabel.setBounds(labelCenterX - priceLabel.getPreferredSize().width / 2, priceLabelY,
                                        priceLabel.getPreferredSize().width, priceLabel.getPreferredSize().height);
                   quantityLabel.setBounds(labelCenterX - quantityLabel.getPreferredSize().width / 2, quantityLabelY,
                                           quantityLabel.getPreferredSize().width, quantityLabel.getPreferredSize().height);
                   

                   jPanel1.add(nameLabel);
                   jPanel1.add(priceLabel);
                   jPanel1.add(quantityLabel);

                   col++;
                   if (col >= 4) {
                       col = 0;
                       row++;
                   }
               }
           }
           
            JScrollBar verticalScrollBar = jScrollPane1.getVerticalScrollBar();
            verticalScrollBar.setUI(new CustomScrollBarUI()); // Set custom UI for the vertical scrollbar

           // Set the preferred size of jPanel1 to accommodate all the added labels
           jPanel1.setPreferredSize(new Dimension(1000, (row + 2) * (300 + 100)));
           
           // Set the preferred size of jScrollPane1
            int scrollPaneHeight = 500; // Set your desired height here
            jScrollPane1.setPreferredSize(new Dimension(jScrollPane1.getPreferredSize().width, scrollPaneHeight));

               // Refresh the jScrollPane1 view
           jScrollPane1.setViewportView(jPanel1);

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    
   private String[] retrieveDrinkInfo(String drinkId) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/drinks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 4 && parts[0].equals(drinkId)) {
                    String drinkName = parts[1]; // Drink name (portion 2)
                    double unitPrice = Double.parseDouble(parts[2]); // Unit price (portion 3)
                    int quantity = Integer.parseInt(parts[3]); // Quantity (portion 4)
                    return new String[] { drinkName, String.valueOf(unitPrice), String.valueOf(quantity) };
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if not found
    }



    
    private void deleteDrinkRecord(String drinkId) {
        List<String> lines = new ArrayList<>();

        // Read all lines from the file and exclude the line with the matching drinkId
        try (BufferedReader reader = new BufferedReader(new FileReader(DRINKS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 1 && !parts[0].equals(drinkId)) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the updated lines back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DRINKS_FILE_PATH))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void refreshUI() {
        // Clear jPanel1 and reload drinks
        jPanel1.removeAll();
        loadDrinksImages();
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    
    public void closeFrame() {
        this.dispose();
    }

    
    public class CustomScrollBarUI extends BasicScrollBarUI {
       
        private final Color thumbColor = new Color(0x1D1D36); // Set the color of the thumb

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
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
        
        @Override
       protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
           g.setColor(thumbColor);
           g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
       }

       @Override
       protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
           g.setColor(c.getBackground()); // Use the background color of the component for the track
           g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
       }
    }
    
    public static void main(String[] args) {
        // Replace "username" with the actual logged-in username
        String loggedInUsername = "username";

        // Create an instance of ViewDrinks
        CustomerIndex customerIndexFrame = new CustomerIndex();

        // Set the default close operation for the frame
        customerIndexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        customerIndexFrame.setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
