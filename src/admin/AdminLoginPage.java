    package admin;

import index.VendingMachineContent;
    import index.VendingMachineHeader;
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.FocusEvent;
    import java.awt.event.FocusListener;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
    import javax.swing.border.Border;
    import javax.swing.border.EmptyBorder;
    import javax.swing.border.LineBorder;
    import javax.swing.plaf.ColorUIResource;
    import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import main.VendingMachineMain;


    

    public class AdminLoginPage extends JPanel {

        private static final Color HINT_TEXT_COLOR = new Color(0x5c5adb);
        private static final String USERNAME_HINT = "Please enter your username";
        private static final String PASSWORD_HINT = "Please enter your password";

        private static final Color BUTTON_COLOR = Color.decode("#5c5adb");
        private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 16);
        private static final Dimension BUTTON_SIZE = new Dimension(120, 40);
        
        private VendingMachineHeader vendingMachineHeader;
        private VendingMachineContent vendingMachineContent;

        public AdminLoginPage() {
            setLayout(new BorderLayout());
            vendingMachineHeader = new VendingMachineHeader();
            vendingMachineContent = new VendingMachineContent();
            

            // Create and add the header panel
            VendingMachineHeader header = new VendingMachineHeader();
            add(header, BorderLayout.NORTH);

            // Create and add the content panel
            JPanel contentPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout for vertical centering


            // Title
            JLabel titleLabel = new JLabel("Admin Login");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 70));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0)); // Adjust the top border
           contentPanel.add(titleLabel, createGBC(0, 0, 2, 1, GridBagConstraints.CENTER, new Insets(0, 0, 0, -240)));


           // Create rounded border
            Border roundedBorder = BorderFactory.createCompoundBorder(
                    new LineBorder(Color.GRAY, 1), // Outer border
                    new EmptyBorder(0, 20, 0, 10) // Inner padding
            );

           // Username label and input field
            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50)); // Add left padding to the label
            usernameLabel.setFont(new Font("Arial", Font.PLAIN, 25)); // Adjust the font size
            JTextField usernameField = new JTextField(20);
             setHint(usernameField, USERNAME_HINT);
            usernameField.setPreferredSize(new Dimension(300, 40)); // Adjust the height
            usernameField.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size for input field
            usernameField.setBorder(roundedBorder); // Apply rounded border
           usernameField.setForeground(new Color(0x5c5adb)); // Set text color to #5c5adb


            JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            usernamePanel.add(usernameLabel);
            usernamePanel.add(usernameField);
            usernamePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Adjust the bottom border
            contentPanel.add(usernamePanel, createGBC(0, 1, 2, 1, GridBagConstraints.CENTER, new Insets(0, 0, 50, -250)));

           // Password label and input field
            // Password label and input field
            JLabel passwordLabel = new JLabel("Password: ");
            passwordLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50)); // Add left padding to the label
            passwordLabel.setFont(new Font("Arial", Font.PLAIN, 25)); // Adjust the font size
            JPasswordField passwordField = new JPasswordField(20);
            setHint(passwordField, PASSWORD_HINT);
            passwordField.setPreferredSize(new Dimension(300, 40)); // Adjust the height
            passwordField.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size for input field
            passwordField.setBorder(roundedBorder); // Apply rounded border
            passwordField.setForeground(new Color(0x5c5adb)); // Set text color to #5c5adb


            JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordField);
           contentPanel.add(passwordPanel, createGBC(0, 2, 2, 1, GridBagConstraints.CENTER, new Insets(0, 0, 50, -250))); // Add the insets parameter

            // Create styled buttons
            JButton loginButton = createStyledButton("Login", BUTTON_FONT, BUTTON_COLOR, BUTTON_SIZE);
            JButton backButton = createStyledButton("Back", BUTTON_FONT, BUTTON_COLOR, BUTTON_SIZE);
            
             createAdminFileIfNotExist(); // Ensure the admin file exists
              
              
           backButton.addActionListener(e -> {
                remove(getComponent(1)); // Remove the current content panel
                add(vendingMachineContent, BorderLayout.CENTER); // Add the header panel
                revalidate(); // Revalidate the layout
                repaint(); // Repaint the UI
            });
           
           loginButton.addActionListener(e -> {
                String enteredUsername = usernameField.getText();
                char[] enteredPassword = passwordField.getPassword();
                
                String usernamePlaceholder = USERNAME_HINT;
                String passwordPlaceholder = PASSWORD_HINT;

               if (enteredUsername.equals(usernamePlaceholder) || enteredPassword.length == 0) {
                    JOptionPane.showMessageDialog(this, "Please do not leave the fields blank !", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else if (isValidAdmin(enteredUsername, enteredPassword)) {
                    JOptionPane.showMessageDialog(this, enteredUsername + " has successfully logged in !" , "Success", JOptionPane.INFORMATION_MESSAGE);
                     // Close the current login frame
                        Frame frame = (Frame) SwingUtilities.getWindowAncestor(loginButton);
                        frame.dispose();
                
                 // Create and configure the frame for AdminIndex
                JFrame adminFrame = new JFrame("Vending Machine System - Admin Dashboard");
                adminFrame.setSize(1200, 600);
                adminFrame.setLocation(350, 250);
                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminFrame.setVisible(true);

                // Create an instance of AdminIndex and pass adminFrame to the constructor
                AdminIndex adminIndex = new AdminIndex(adminFrame);

                adminFrame.getContentPane().add(adminIndex, BorderLayout.CENTER);

                } else {
                    JOptionPane.showMessageDialog(this, "Username and Password are incorrect !", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            });




            // Setup hover effect for buttons
            setupHoverEffect(loginButton, BUTTON_COLOR, Color.decode("#1d1d36")); // Using defaultColor and hoverColor from VendingMachineContent class
            setupHoverEffect(backButton, BUTTON_COLOR, Color.decode("#1d1d36")); // Using defaultColor and hoverColor from VendingMachineContent class

            // Add buttons to contentPanel with adjusted insets
            // Add buttons to contentPanel with adjusted insets for left and right spacing
            contentPanel.add(loginButton, createGBC(1, 3, 1, 1, GridBagConstraints.LINE_START, new Insets(5, 100, 5, -5))); // Adjusted insets
            contentPanel.add(backButton, createGBC(2, 3, 1, 1, GridBagConstraints.LINE_START, new Insets(5, 0, 5, 150))); // Adjusted insets





            add(contentPanel, BorderLayout.CENTER);
        }
        
        private void createAdminFileIfNotExist() {
            Path filePath = Paths.get("data/admin.txt");
            try {
                if (!Files.exists(filePath)) {
                    Files.createFile(filePath);
                    Files.write(filePath, "admin@gmail.com\nadmin123".getBytes());
                }

            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception here, e.g., show an error message
            }
        }





        private JButton createStyledButton(String text, Font font, Color bgColor, Dimension size) {
            JButton button = new JButton(text);
            button.setFont(font);
            button.setBackground(bgColor);
            button.setForeground(Color.WHITE);
            button.setPreferredSize(size);
            button.setFocusPainted(false);
            button.setBorder(null);
            return button;
        }
        
        private boolean isValidAdmin(String username, char[] password) {
            try (BufferedReader reader = new BufferedReader(new FileReader("data/admin.txt"))) {
                String adminUsername = reader.readLine();
                String adminPassword = reader.readLine();

                // Compare the entered username and password with admin credentials
                return adminUsername != null && adminPassword != null &&
                       adminUsername.equals(username) && new String(password).equals(adminPassword);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }


        private void setupHoverEffect(JButton button, Color defaultColor, Color hoverColor) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setBackground(hoverColor);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setBackground(defaultColor);
                }
            });
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

        private GridBagConstraints createGBC(int gridx, int gridy, int gridwidth, int gridheight, int anchor, Insets insets) {
           GridBagConstraints gbc = new GridBagConstraints();
           gbc.gridx = gridx;
           gbc.gridy = gridy;
           gbc.gridwidth = gridwidth;
           gbc.gridheight = gridheight;
           gbc.anchor = anchor;
           gbc.insets = insets;
           return gbc;
       }


    }
