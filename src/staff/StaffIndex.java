package staff;


import index.VendingMachineHeader;
import index.VendingMachineContent;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import main.VendingMachineMain;

class BorderlessButton extends Button {
    public BorderlessButton(String label) {
        super(label);
        setForeground(Color.WHITE);
        setBackground(new Color(36, 35, 86));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getLabel())) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2.drawString(getLabel(), x, y);
    }
}
public class StaffIndex extends JPanel {
    private String loggedInUsername;  // Declare the instance variable
    private JPanel contentPanel; // This panel will hold the main content
    private VendingMachineHeader header;
    private JPanel jPanel1;
    private BorderlessButton button1;
    private BorderlessButton button2;
    private BorderlessButton button3;
    private BorderlessButton button4;
    private BorderlessButton button5;
    private BorderlessButton button6;
    private JFrame staffFrame;
    
    
    

    public StaffIndex(JFrame staffFrame, String loggedInUsername) {
        this.staffFrame = staffFrame;
        this.loggedInUsername = loggedInUsername; // Assign the value
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setLayout(new BorderLayout());
        

        // Create the header
        header = new VendingMachineHeader();
        add(header, BorderLayout.NORTH);

        // Create the main content panel
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setForeground(new Color(0x1d1d36));
        contentPanel.setPreferredSize(new Dimension(1200, 600));

        jPanel1 = new JPanel();
        button1 = new BorderlessButton("Logout");
        button2 = new BorderlessButton("Shut Down");
        button3 = new BorderlessButton("Staff Management");
        button4 = new BorderlessButton("Report Generation");
        button5 = new BorderlessButton("Discount Management");
        button6 = new BorderlessButton("Profile");


        // Create an instance of VendingMachineHeader
        VendingMachineHeader header = new VendingMachineHeader();

        jPanel1.setBackground(java.awt.Color.WHITE);
        jPanel1.setForeground(new java.awt.Color(0x1d1d36));
        jPanel1.setPreferredSize(new Dimension(1200, 600)); // Adjust the preferred size as needed

        button1.setActionCommand("Shut Down");
        button1.setBackground(new java.awt.Color(36, 35, 86));
        button1.setFont(new java.awt.Font("Arial", 0, 24));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Shut Down");

        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button1.setBackground(new java.awt.Color(60, 59, 100));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1.setBackground(new java.awt.Color(36, 35, 86));
            }
        });

        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button2.setBackground(new java.awt.Color(60, 59, 100));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button2.setBackground(new java.awt.Color(36, 35, 86));
            }
        });

        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button3.setBackground(new java.awt.Color(60, 59, 100));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button3.setBackground(new java.awt.Color(36, 35, 86));
            }
        });

        button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button4.setBackground(new java.awt.Color(60, 59, 100));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button4.setBackground(new java.awt.Color(36, 35, 86));
            }
        });


        button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button5.setBackground(new java.awt.Color(60, 59, 100));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button5.setBackground(new java.awt.Color(36, 35, 86));
            }
        });

        button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button6.setBackground(new java.awt.Color(60, 59, 100));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button6.setBackground(new java.awt.Color(36, 35, 86));
            }
        });
        // Add action listener for the button1 (Shut Down) here
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });





        button2.setActionCommand("Logout");
        button2.setBackground(new java.awt.Color(36, 35, 86));
        button2.setFont(new java.awt.Font("Arial", 0, 24));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("Logout");
        // Add action listener for the button2 (Logout)
        button2.addActionListener(new ActionListener() {
            private void switchToVendingMachineInterface() {
                // Remove the current content
                removeAll();

                // Create an instance of VendingMachineHeader
                VendingMachineHeader header = new VendingMachineHeader();
                // Add the header to the panel
                add(header, BorderLayout.NORTH);

                // Create an instance of VendingMachineContent
                VendingMachineContent content = new VendingMachineContent();
                // Add the content to the panel
                add(content, BorderLayout.CENTER);

                // Validate and repaint the panel to update the changes
                revalidate();
                repaint();
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                switchToVendingMachineInterface();
                staffFrame.dispose();
                VendingMachineMain.mainFrame.setVisible(true);
            }
        });



        button3.setBackground(new java.awt.Color(36, 35, 86));
        button3.setFont(new java.awt.Font("Arial", 0, 24));
        button3.setForeground(java.awt.Color.white);
        button3.setLabel("Drinks Management");
        // Add action listener for the button3 (Staff Management) here
         button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                        // Close the current login frame
                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(StaffIndex.this);
                        currentFrame.dispose();

                       drink.ViewDrinks viewDrinks = new drink.ViewDrinks(loggedInUsername);
                       viewDrinks.setVisible(true);
            }
        });

        button4.setBackground(new java.awt.Color(36, 35, 86));
        button4.setFont(new java.awt.Font("Arial", 0, 24));
        button4.setForeground(java.awt.Color.white);
        button4.setLabel("Feedback Management");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                currentFrame.dispose();

                // Open the DiscountSet frame
               FeedbackManagement feedbackManagement = new FeedbackManagement(loggedInUsername);
                feedbackManagement.setVisible(true);
            }
        });

        button5.setBackground(new java.awt.Color(36, 35, 86));
        button5.setFont(new java.awt.Font("Arial", 0, 24));
        button5.setForeground(java.awt.Color.white);
        button5.setLabel("Order Management");
        // Add action listener for the button5 (Discount Management) here
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                currentFrame.dispose();

                // Open the DiscountSet frame
                ViewOrders viewOrders = new ViewOrders(loggedInUsername);
                viewOrders.setVisible(true);
            }
        });


        button6.setBackground(new java.awt.Color(36, 35, 86));
        button6.setFont(new java.awt.Font("Arial", 0, 24));
        button6.setForeground(java.awt.Color.white);
        button6.setLabel("Profile");
        // Add action listener for the button6 (Profile) here
       button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Close the current JFrame (AdminIndex)
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(StaffIndex.this);
                currentFrame.dispose();

               staff.ProfileUpdate staffProfileUpdate = new staff.ProfileUpdate(loggedInUsername);
                staffProfileUpdate.setVisible(true);

            }
        });



        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(108, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
        );

        setLayout(new BorderLayout()); // Set the layout to BorderLayout

        add(header, BorderLayout.NORTH);
        add(jPanel1, BorderLayout.CENTER);
    }
}
