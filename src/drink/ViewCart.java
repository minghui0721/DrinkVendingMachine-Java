package drink;

import customer.CustomerIndex;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ViewCart extends JFrame {
    private JPanel mainPanel;
    private double totalPrice = 0.0; // To store the total price
    private JLabel titleLabel; // Declare the titleLabel here
    private Map<String, Drink> drinksMap; // Declare drinksMap as a class-level variable

    public ViewCart() {
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#5c5acd")); // Set the background color of the content pane


        // Create a title label
        JLabel titleLabel = new JLabel("Your Cart");
        titleLabel.setForeground(Color.WHITE); // Set the text color to white
        titleLabel.setFont(new Font("Arial Black", Font.BOLD, 48)); // Adjust font and size if needed
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        int topSpacing = 40;
        int bottomSpacing = 30;
        titleLabel.setBorder(BorderFactory.createEmptyBorder(topSpacing, 0, bottomSpacing, 0));
        add(titleLabel, BorderLayout.NORTH);

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode("#5c5acd")); // Set the background color

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/cart.txt"));
            String line;
            Map<String, Drink> drinksMap = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String drinkID = parts[0];
                String drinkName = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                double price = Double.parseDouble(parts[3]);

                if (drinksMap.containsKey(drinkID)) {
                    Drink existingDrink = drinksMap.get(drinkID);
                    existingDrink.addQuantity(quantity);
                    existingDrink.addPrice(price);
                } else {
                    Drink newDrink = new Drink(drinkID, drinkName, quantity, price);
                    drinksMap.put(drinkID, newDrink);
                }
            }

            reader.close();

            int gridy = 0;
            for (Drink drink : drinksMap.values()) {
                
                
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = gridy;
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing

                JPanel panel = createDrinkPanel(drink, drinksMap);

                mainPanel.add(panel, gbc);
                
                gridy++;
                
                calculateTotalPrice(drinksMap); // Calculate the total price using the class-level drinksMap
                updateTitleLabel(); // Update the title label with the total amount
            }
            
             // Create a scroll pane with vertical scrollbar always shown
            JScrollPane scrollPane = new JScrollPane(mainPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            
            // Customize the vertical scrollbar appearance
            JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
            verticalScrollBar.setPreferredSize(new Dimension(20, 0)); // Set the width of the scrollbar
            verticalScrollBar.setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = Color.decode("#1d1d36"); // Set thumb color
                    this.trackColor = Color.white; // Set track color
                }
            });

            // Set the fixed preferred size of the scroll pane (adjust the width as needed)
        scrollPane.setPreferredSize(new Dimension(800, 500)); // Set the desired width and height
        scrollPane.setBorder(null); // Remove the border
        

        // Create a panel to hold the scroll pane and the "Back" button
        JPanel contentPanel = new JPanel(new BorderLayout()); 
        

        // Add the scroll pane to the content panel
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        add(contentPanel);
        
        // Create and configure the "Payment" button
        JButton paymentButton = new JButton("Pay");
        Font buttonFont = new Font("Arial", Font.PLAIN, 24);
        paymentButton.setFont(buttonFont);
        paymentButton.setPreferredSize(new Dimension(150, 40)); // Set width and height
        paymentButton.setBackground(Color.decode("#1d1d36")); // Set background color
        paymentButton.setForeground(Color.WHITE); // Set text color
        paymentButton.setBorderPainted(false); // Remove border
        paymentButton.setFocusPainted(false); // Remove focus border
        paymentButton.setContentAreaFilled(false); // Make content area transparent
        paymentButton.setOpaque(true); // Make the button opaque
        
        paymentButton.addActionListener(e -> {
    if (drinksMap.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a drink first !", "Empty Cart", JOptionPane.WARNING_MESSAGE);
        dispose();
          CustomerIndex customerIndex = new CustomerIndex(); // Create a new instance of CustomerIndex
            customerIndex.setVisible(true); // Show the CustomerIndex frame
        
         
    } else {
        int choice = JOptionPane.showConfirmDialog(
            this,
            "Do you want to proceed with the payment?",
            "Payment Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            saveOrderToFile(drinksMap);
            payment.PaymentPage paymentPage = new payment.PaymentPage();
            paymentPage.setVisible(true);
            dispose();
        }
    }
});

        // Apply hover effect
        paymentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentButton.setBackground(Color.decode("#dedaf4")); // Change background color on hover
                paymentButton.setForeground(Color.black);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentButton.setBackground(Color.decode("#1d1d36")); // Restore background color on exit
                 paymentButton.setForeground(Color.white);
            }
        });



        // Create and configure the "Back" button
       JButton backButton = new JButton("Back");
       // Set the font for the "Back" button
        backButton.setFont(buttonFont);
        backButton.setPreferredSize(new Dimension(150, 40)); // Set width and height
        backButton.setBackground(Color.decode("#1d1d36")); // Set background color
        backButton.setForeground(Color.WHITE); // Set text color
        backButton.setBorderPainted(false); // Remove border
        backButton.setFocusPainted(false); // Remove focus border
        backButton.setContentAreaFilled(false); // Make content area transparent
        backButton.setOpaque(true); // Make the button opaque

        // Apply hover effect
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(Color.decode("#dedaf4")); // Change background color on hover
                backButton.setForeground(Color.black);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(Color.decode("#1d1d36")); // Restore background color on exit
                 backButton.setForeground(Color.white);
            }
        });

        // Apply padding to the inside of the button
        int buttonPadding = 30; // Set the desired padding
        backButton.setBorder(BorderFactory.createEmptyBorder(buttonPadding, buttonPadding, buttonPadding, buttonPadding));

        backButton.addActionListener(e -> {
            dispose(); // Close the current window
            CustomerIndex customerIndex = new CustomerIndex(); // Create a new instance of CustomerIndex
            customerIndex.setVisible(true); // Show the CustomerIndex frame
        });


        // Create a container panel for the button
        JPanel buttonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        buttonContainer.setBackground(Color.decode("#5c5acd"));
        int buttonMargin = 25; // Set the desired margin
        buttonContainer.setBorder(BorderFactory.createEmptyBorder(buttonMargin, 0, buttonMargin, 20));

        // Add the "pay" & "Back" button to the container panel
        buttonContainer.add(paymentButton);
        buttonContainer.add(backButton);

        // Add the container panel to the content panel
        contentPanel.add(buttonContainer, BorderLayout.SOUTH);

        // Add the content panel to the main JFrame
        add(contentPanel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        setSize(1200, 680); // Adjusted initial size
        setLocation(370, 10);
        setTitle("Vending Machine System - Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void saveOrderToFile(Map<String, Drink> drinksMap) {
        try {
            Path directoryPath = Paths.get("data");
            Path filePath = directoryPath.resolve("temporary_cart.txt");

            // Create the directory if it doesn't exist
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            List<String> lines = new ArrayList<>();
            for (Drink drink : drinksMap.values()) {
                String line = drink.getDrinkID() + "|" + drink.getDrinkName() + "|" + drink.getTotalQuantity() + "|" + drink.getTotalPrice();
                lines.add(line);
            }

            Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.WRITE);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    
    private void calculateTotalPrice(Map<String, Drink> drinksMap) {
        totalPrice = 0; // Reset the total price before recalculating
        for (Drink drink : drinksMap.values()) {
            totalPrice += drink.getTotalPrice();
        }
    }

    
    private void updateTitleLabel() {
        JLabel titleLabel = new JLabel("Your Cart - Total Amount: RM" + String.format("%.2f", totalPrice));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial Black", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        int topSpacing = 40;
        int bottomSpacing = 30;
        titleLabel.setBorder(BorderFactory.createEmptyBorder(topSpacing, 0, bottomSpacing, 0));
        add(titleLabel, BorderLayout.NORTH);
    }

private JPanel createDrinkPanel(Drink drink, Map<String, Drink> drinksMap) {
    JPanel panel = new JPanel();
     panel.setBackground(Color.decode("#1d1d36")); // Set the background color of the main panel
    panel.setPreferredSize(new Dimension(620, 120)); // Set panel size
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20)); // Add padding
    panel.setLayout(new BorderLayout());
   
    JPanel imagePanel = new JPanel();
    
    // Inside the createDrinkPanel method
    String drinkID = drink.getDrinkID();
    String imageUrl = ""; // Initialize the imageUrl

    try {
        BufferedReader reader = new BufferedReader(new FileReader("data/drinks.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length >= 5 && parts[0].equals(drinkID)) {
                // Assuming the fifth portion contains the image URL
                imageUrl = parts[4];
                break; // No need to continue searching
            }
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Load the image from the retrieved URL
    ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageUrl));
    Image image = imageIcon.getImage();
    Image scaledImage = image.getScaledInstance(100, 150, Image.SCALE_SMOOTH);

    // Create a JLabel and set the scaled image as its icon
    JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
    int labelWidth = imageLabel.getPreferredSize().width;
    int labelHeight = imageLabel.getPreferredSize().height;

    // Add the JLabel to the imagePanel
    imagePanel.add(imageLabel);

   // Load icons from the resources directory
    Icon editIcon = new ImageIcon(getClass().getResource("/resources/edit.png"));
    Icon deleteIcon = new ImageIcon(getClass().getResource("/resources/delete.png"));

    // Scale the icons to 50x50
    Image scaledEditImage = ((ImageIcon) editIcon).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    Image scaledDeleteImage = ((ImageIcon) deleteIcon).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

    // Create scaled icons
    Icon scaledEditIcon = new ImageIcon(scaledEditImage);
    Icon scaledDeleteIcon = new ImageIcon(scaledDeleteImage);
    
    

    // Create a panel for the edit and delete controls
    JPanel editDeletePanel = new JPanel(new BorderLayout());
    editDeletePanel.setBorder(new EmptyBorder(10, 10, 10, 30)); // Add padding
    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    
    Font arialFont = new Font("Arial", Font.BOLD, 25); // Create Arial font with size 25

    JLabel nameLabel = new JLabel(drink.getDrinkName());
    nameLabel.setForeground(Color.WHITE);
    nameLabel.setFont(arialFont); // Set the font


    Font textFieldFont = new Font("Arial", Font.PLAIN, 14);

    JTextField quantityTextField = new JTextField("Quantity: " + drink.getTotalQuantity(), 10);
    quantityTextField.setEditable(false); // Make the text field non-editable
    quantityTextField.setFont(textFieldFont); // Set the font

    JTextField priceTextField = new JTextField("Price: " + drink.getTotalPrice(), 10);
    priceTextField.setEditable(false); // Make the text field non-editable
    priceTextField.setFont(textFieldFont); // Set the font

    
    // Set the preferred height for the text fields
    quantityTextField.setPreferredSize(new Dimension(quantityTextField.getPreferredSize().width, 30));
    priceTextField.setPreferredSize(new Dimension(priceTextField.getPreferredSize().width, 30));
    
    JButton editButton = new JButton(scaledEditIcon); // Set scaled edit icon
    editButton.setFocusPainted(false); // Remove focused border
    JButton deleteButton = new JButton(scaledDeleteIcon); // Set scaled delete icon
    deleteButton.setFocusPainted(false); // Remove focused border
    
   deleteButton.addActionListener(e -> {
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this item?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            deleteDrinkRecord(drink.getDrinkID()); // Delete the record
            mainPanel.remove(panel); // Remove the panel from the mainPanel
            mainPanel.revalidate(); // Refresh the layout
            mainPanel.repaint(); // Repaint the panel
            
            dispose();
            
            ViewCart viewDrinks = new ViewCart();
                       viewDrinks.setVisible(true);
        }
    });
   
    editButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create and show the QuantityCart frame here
            QuantityCart quantityCart = new QuantityCart(drink, drinksMap, ViewCart.this);
            quantityCart.setVisible(true);
        }
    });


    
    // Set cursor effect to hand cursor
    editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
      // Set text color of the buttons to white
    editButton.setForeground(Color.WHITE);
    deleteButton.setForeground(Color.WHITE);

    
    editButton.setPreferredSize(new Dimension(50, 50)); // Set preferred size
    deleteButton.setPreferredSize(new Dimension(50, 50)); // Set preferred size
    editButton.setBorderPainted(false); // Remove border
    editButton.setContentAreaFilled(false); // Remove background
    deleteButton.setBorderPainted(false); // Remove border
    deleteButton.setContentAreaFilled(false); // Remove background
    
    
    topPanel.add(nameLabel);
    topPanel.add(editButton);
    topPanel.add(deleteButton);

    bottomPanel.add(quantityTextField);
    bottomPanel.add(priceTextField);

    editDeletePanel.add(topPanel, BorderLayout.NORTH);
    editDeletePanel.add(bottomPanel, BorderLayout.CENTER);

    // Create a panel for the image and edit/delete controls
    JPanel imageEditDeletePanel = new JPanel(new BorderLayout());
    
    // Create a sub-panel for the image and position it on the left
    JPanel imageSubPanel = new JPanel(new BorderLayout());
    imageSubPanel.add(imagePanel, BorderLayout.WEST);
    imageEditDeletePanel.add(imageSubPanel, BorderLayout.WEST);
    
    // Create a sub-panel for the edit/delete controls and position it in the center
    JPanel editDeleteSubPanel = new JPanel(new BorderLayout());
    editDeleteSubPanel.add(editDeletePanel, BorderLayout.CENTER);
    imageEditDeletePanel.add(editDeleteSubPanel, BorderLayout.CENTER);
    
    // Create a panel for the edit and delete buttons and position it on the right
    JPanel buttonPanel = new JPanel(new BorderLayout());
    buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding
    buttonPanel.add(editButton, BorderLayout.EAST);
    buttonPanel.add(deleteButton, BorderLayout.WEST);
    imageEditDeletePanel.add(buttonPanel, BorderLayout.EAST);
    
    // Set the preferred sizes for the panels
    imagePanel.setPreferredSize(new Dimension(150, imagePanel.getPreferredSize().height));
    editDeletePanel.setPreferredSize(new Dimension(300, editDeletePanel.getPreferredSize().height));
    buttonPanel.setPreferredSize(new Dimension(150, buttonPanel.getPreferredSize().height));

    panel.add(imageEditDeletePanel, BorderLayout.CENTER); // Position image, editDeletePanel, and buttonPanel
    
    // Set the background color of sub-panels
    imagePanel.setBackground(Color.decode("#1d1d36")); 
    editDeletePanel.setBackground(Color.decode("#1d1d36")); 
    topPanel.setBackground(Color.decode("#1d1d36"));
    bottomPanel.setBackground(Color.decode("#1d1d36"));
    buttonPanel.setBackground(Color.decode("#1d1d36"));

    return panel;
}

private void deleteDrinkRecord(String drinkID) {
    try {
        Path filePath = Paths.get("data/cart.txt");
        List<String> lines = Files.readAllLines(filePath);
        List<String> updatedLines = new ArrayList<>();


        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length >= 1 && !parts[0].equals(drinkID)) {
                updatedLines.add(line);
            }
        }

        Files.write(Paths.get("data/cart.txt"), updatedLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public Map<String, Drink> getDrinksMap() {
            return drinksMap;
        }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(ViewCart::new);
    }
}

class Drink {
    private String drinkID;
    private String drinkName;
    private int totalQuantity;
    private double totalPrice;

    public Drink(String drinkID, String drinkName, int quantity, double price) {
        this.drinkID = drinkID;
        this.drinkName = drinkName;
        this.totalQuantity = quantity;
        this.totalPrice = price;
    }

    public void addQuantity(int quantity) {
        totalQuantity += quantity;
    }

    public void addPrice(double price) {
        totalPrice += price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
    public String getDrinkID() {
        return drinkID;
    }
}
