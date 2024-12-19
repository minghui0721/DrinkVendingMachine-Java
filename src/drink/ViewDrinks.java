
package drink;

import index.VendingMachineHeader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle;
import javax.swing.plaf.basic.BasicScrollBarUI;
import staff.StaffIndex;

/**
 *
 * @author mingh
 */
public class ViewDrinks extends javax.swing.JFrame {
    
     // Path to the drinks data file
    private static final String DRINKS_FILE_PATH = "data/drinks.txt";
    private VendingMachineHeader header;
    public static final int HEADER_HEIGHT = 130; // Define the header's height
    private static String loggedInUsername; // Declare as static field

    public ViewDrinks(String loggedInUsername) {
        initComponents();
        
        this.loggedInUsername = loggedInUsername; // Store the loggedInUsername
        
        setSize(1200, 900);
        setLocation(370, 50);
        setTitle("Vending Machine System - Drinks Management");

        loadDrinksImages();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        header = new VendingMachineHeader();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new java.awt.Color(0x5C5ADB)); // Set background color of jPanel1 to #5c5adb

        jPanel4 = new javax.swing.JPanel();
        jPanel4.setPreferredSize(new Dimension(1163, 100)); // Adjust the height as needed
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("jLabel4");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(92, 90, 219));

        jScrollPane1.setBackground(new java.awt.Color(92, 90, 219));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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
        
        

        jButton1.setBackground(new java.awt.Color(0x5c5adb));
        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(null);
        jButton1.setFocusPainted(false);
        jButton1.setText("Add");
        
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                // Create and display a new instance of AddDrinks frame
                new AddDrinks(loggedInUsername).setVisible(true);
            }
        });

        
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x1D1D35));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x5c5adb));
            }
        });

        jButton3.setBackground(new java.awt.Color(0x5c5adb));
        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
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

        jButton3.setText("Modify");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                // Create and display a new instance of AddDrinks frame
                new ModifyDrinks(loggedInUsername).setVisible(true);
            }
        });
        
        

        jButton4.setBackground(new java.awt.Color(0x5c5adb));
        jButton4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setBorder(null);
        jButton4.setFocusPainted(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4.setBackground(new java.awt.Color(0x1D1D35));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4.setBackground(new java.awt.Color(0x5c5adb));
            }
        });
        jButton4.setText("Delete");
        jButton4.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
            // Close the current frame
            closeFrame();

            // Open a new instance of DeleteDrinks frame
            openDeleteDrinksFrame(loggedInUsername);
        }
    });
        
        // Create a new JButton for the "Back" button
        JButton backButton = new JButton("Back");
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

                // Create and configure the frame for StaffIndex
                JFrame staffFrame = new JFrame("Vending Machine System - Staff Dashboard");
                staffFrame.setSize(1200, 600);
                staffFrame.setLocation(350, 200);
                staffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create an instance of StaffIndex
                StaffIndex staffIndex = new StaffIndex(staffFrame, loggedInUsername);
                staffFrame.getContentPane().add(staffIndex);

                // Make the new frame visible
                staffFrame.setVisible(true);
            }
        });


        // Create a new JPanel for the buttonsPanel and backButtonPanel
        JPanel controlsPanel = new JPanel(new BorderLayout());
        controlsPanel.setBackground(new java.awt.Color(92, 90, 219));


        // Create a new JPanel for the buttonsPanel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); // Add gap between buttons
        
        // Set preferred size (width and height) for the buttons
        int buttonWidth = 130; // Set your desired button width
        int buttonHeight = 50; // Set your desired button height
        jButton1.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        jButton3.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        jButton4.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        backButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));


        // Add the button panels to the buttonsPanel
        buttonsPanel.add(jButton1);
        buttonsPanel.add(jButton3);
        buttonsPanel.add(jButton4);

        // Create a new JPanel for the backButtonPanel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));

        // Add the "Back" button to the backButtonPanel
        backButtonPanel.add(backButton);

        // Create a new JPanel for jPanel4
        JPanel jPanel4 = new JPanel();

        // Set the layout for jPanel4
        jPanel4.setLayout(new BorderLayout());
        jPanel4.add(buttonsPanel, BorderLayout.WEST);
        jPanel4.add(backButtonPanel, BorderLayout.EAST);

         // Create a JSplitPane to hold the header and jScrollPane1
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, header, jScrollPane1);
        splitPane.setDividerSize(0); // Hide the divider
        splitPane.setResizeWeight(0); // Make the header not resizable

    // Set up the layout of the main content
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE) // Set the width of the split pane
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()
                )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(splitPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Set the height of the split pane
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGap(50) // Add a vertical gap here to move the buttons lower
                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
        );
        

        pack();
    }


    // Method to open the DeleteDrinks frame
    public void openDeleteDrinksFrame(String loggedInUsername) {
        DeleteDrinks deleteDrinksFrame = new DeleteDrinks(loggedInUsername);
        deleteDrinksFrame.setVisible(true);
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
                    priceLabel.setForeground(Color.WHITE); // Set font color to white
                    quantityLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font to Arial, size 20
                    quantityLabel.setForeground(Color.WHITE); // Set font color to white
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
           jPanel1.setPreferredSize(new Dimension(1000, (row + 2) * (200 + 100)));
           
           // Set the preferred size of jScrollPane1
            int scrollPaneHeight = 500; // Set your desired height here
            jScrollPane1.setPreferredSize(new Dimension(jScrollPane1.getPreferredSize().width, scrollPaneHeight));

               // Refresh the jScrollPane1 view
           jScrollPane1.setViewportView(jPanel1);

       } catch (IOException e) {
           e.printStackTrace();
       }
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
        ViewDrinks viewDrinksFrame = new ViewDrinks(loggedInUsername);

        // Set the default close operation for the frame
        viewDrinksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        viewDrinksFrame.setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
