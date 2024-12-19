package index;
import admin.AdminLoginPage;
import customer.CustomerIndex;
import main.VendingMachineMain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import staff.StaffLoginPage;



public class VendingMachineContent extends JPanel {

    public VendingMachineContent() {
        setLayout(new BorderLayout());

        // Style for the buttons
        Color buttonColor = Color.decode("#5c5adb");
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Dimension buttonSize = new Dimension(120, 40);

        // Define default and hover colors
        Color defaultColor = buttonColor;
        Color hoverColor = Color.decode("#1d1d36");

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.PAGE_AXIS));
        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0)); // Add top padding

        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 50));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 20, 0)); // Add bottom padding
        titlePanel.add(welcomeLabel);

        JLabel startLabel = new JLabel("Start Purchasing Here");
        startLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        startLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0)); // Add bottom padding
        titlePanel.add(startLabel);

        JButton browseButton = createStyledButton("Browse", buttonFont, buttonColor, buttonSize);
        browseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        browseButton.setMaximumSize(buttonSize);
        setupHoverEffect(browseButton, defaultColor, hoverColor);
        titlePanel.add(browseButton);
        
// Adding an ActionListener to the browseButton
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                Frame frame = (Frame) SwingUtilities.getWindowAncestor(browseButton);
                frame.dispose();

                new CustomerIndex().setVisible(true);
            }
        });

        add(titlePanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 35, 25));

        JButton adminButton = createStyledButton("Admin", buttonFont, buttonColor, buttonSize);
        setupHoverEffect(adminButton, defaultColor, hoverColor);

        // Add an ActionListener to adminButton
        // Add an ActionListener to adminButton
        // Add an ActionListener to adminButton
        adminButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the current content panel from the main frame
                  Frame frame = (Frame) SwingUtilities.getWindowAncestor(adminButton);
                    frame.dispose();

                    // Create a new JFrame
                    JFrame adminFrame = new JFrame("Vending Machine System - Admin Login Page");
                    adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    adminFrame.setSize(1200, 600);
                    adminFrame.setLocation(350, 250);

                    // Create an instance of AdminLoginPage
                    AdminLoginPage adminLoginPage = new AdminLoginPage();

                    // Add the AdminLoginPage to the adminFrame
                    adminFrame.add(adminLoginPage, BorderLayout.CENTER);

                    // Make the adminFrame visible
                    adminFrame.setVisible(true);
                }
        });
        buttonPanel.add(adminButton);

        JButton staffButton = createStyledButton("Staff", buttonFont, buttonColor, buttonSize);
        setupHoverEffect(staffButton, defaultColor, hoverColor);
        
        staffButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the current content panel from the main frame
                       Frame frame = (Frame) SwingUtilities.getWindowAncestor(staffButton);
                    frame.dispose();

                    // Create a new JFrame
                    JFrame staffFrame = new JFrame("Vending Machine System - Staff Login Page");
                    staffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   staffFrame.setSize(1200, 600);
                    staffFrame.setLocation(350, 250);

                    // Create an instance of AdminLoginPage
                    StaffLoginPage staffLoginPage = new StaffLoginPage();

                    // Add the AdminLoginPage to the adminFrame
                    staffFrame.add(staffLoginPage, BorderLayout.CENTER);

                    // Make the adminFrame visible
                    staffFrame.setVisible(true);
                }
        });
        
        buttonPanel.add(staffButton);

        add(buttonPanel, BorderLayout.SOUTH);
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
}
