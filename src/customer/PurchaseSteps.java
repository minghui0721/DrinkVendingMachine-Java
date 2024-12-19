package customer;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;

public class PurchaseSteps extends javax.swing.JFrame {

    public PurchaseSteps() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);
        setTitle("Purchase Steps");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(240, 240, 240));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24));
        jLabel1.setForeground(new Color(29, 29, 54));
        jLabel1.setText("Purchase Steps");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 16));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("1. Click on the drink button you want to purchase and select the quantity.\n\n2. Make the payment using the provided payment methods.\n\n3. Collect your item from our vending machine.");
        jTextArea1.setWrapStyleWord(true);
        // Add padding to the inside of the jTextArea
        int topPadding = 10;
        int leftPadding = 10;
        int bottomPadding = 10;
        int rightPadding = 10;
        jTextArea1.setBorder(BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding));
        jTextArea1.setBackground(new Color(210, 210, 210));
        jScrollPane1.setViewportView(jTextArea1);

        backButton.setFont(new java.awt.Font("Arial", 1, 18)); // Set your preferred font
        backButton.setText("Back");
        backButton.setBackground(new Color(29, 29, 54));
        backButton.setForeground(Color.white);
        backButton.setBorder(null);
        backButton.setFocusPainted(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(45, 45, 80));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(29, 29, 54));
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose(); // Close the current frame when the Back button is clicked
        
        // Open a new instance of the ViewCart frame
               CustomerIndex customerIndex = new CustomerIndex();
               customerIndex.setVisible(true);
    }

  

    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
}
