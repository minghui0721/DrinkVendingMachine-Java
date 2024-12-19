/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package staff;

import admin.ViewOrder;
import index.VendingMachineHeader;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import staff.StaffIndex;

/**
 *
 * @author mingh
 */
public class ViewOrders extends javax.swing.JFrame {
    
    String loggedInUsername;

    class PaddedCellRenderer extends DefaultTableCellRenderer {
    private final int topPadding;
    private final int rightPadding;
    private final int bottomPadding;
    private final int leftPadding;

    public PaddedCellRenderer(int top, int right, int bottom, int left) {
        topPadding = top;
        rightPadding = right;
        bottomPadding = bottom;
        leftPadding = left;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        if (c instanceof JLabel) {
            JLabel label = (JLabel) c;
            label.setBorder(BorderFactory.createEmptyBorder(
                    topPadding, leftPadding, bottomPadding, rightPadding));

            // Add padding to the text inside the label
            label.setText("<html><p style='padding: 50px;'>" + value + "</p></html>");
        }

        return c;
    }
}
    
    class PaddedHeaderRenderer extends DefaultTableCellRenderer {
    private final int topPadding;
    private final int rightPadding;
    private final int bottomPadding;
    private final int leftPadding;

    public PaddedHeaderRenderer(int top, int right, int bottom, int left) {
        topPadding = top;
        rightPadding = right;
        bottomPadding = bottom;
        leftPadding = left;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        label.setBorder(BorderFactory.createEmptyBorder(
                topPadding, leftPadding, bottomPadding, rightPadding));
        label.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text

        // Set the foreground color of the header text
        label.setForeground(Color.WHITE);

        return label;
    }
}
    
   class CustomHeaderRenderer extends DefaultTableCellRenderer {
    public CustomHeaderRenderer() {
        setHorizontalAlignment(JLabel.CENTER); // Center-align text
        setForeground(Color.WHITE); // Set text color
        setBackground(new Color(92, 90, 205)); // Set background color
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        label.setFont(new Font("Arial", Font.BOLD, 22)); // Set font and size

        return label;
    }
    @Override
    public Dimension getPreferredSize() {
        Dimension preferredSize = super.getPreferredSize();
        preferredSize.height = 50; // Set the preferred height to 50 pixels
        return preferredSize;
    }
    
}
   
   class CustomTableUI extends BasicTableUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        int numRows = table.getRowCount();
        int rowHeight = table.getRowHeight();

        for (int row = 0; row < numRows; row++) {
            Rectangle rowRect = table.getCellRect(row, 0, false);
            g.setColor(Color.BLACK); // Set the border color
            g.drawRect(rowRect.x, rowRect.y, table.getWidth() - 1, rowHeight);
        }
    }
}


    
    public ViewOrders(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername; // Initialize the instance variable
        initComponents();
        addHeader();  // Call the method to add the header
        
        setSize(1200, 770);
        setLocation(350,180);
        setTitle("Vending Machine System - Order History");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBackground(new java.awt.Color(92, 90, 205));
        jTable1.setFont(new java.awt.Font("Arial Black", 1, 15));
        jTable1.setRowHeight(80);
        // Get the table header
        JTableHeader tableHeader = jTable1.getTableHeader();

        // Create a custom font with Arial Bold and size 25
        Font headerFont = new Font("Arial", Font.BOLD, 35);

        // Set the custom font for the table header
        tableHeader.setFont(headerFont);
        
        
        jTable1.setUI(new CustomTableUI());

        // Define the column names
        String[] columnNames = {"Order ID", "Drink", "Quantity", "Unit Price", "Time", "Total"};

        // Create a DefaultTableModel with empty data and the specified column names
        DefaultTableModel model = new DefaultTableModel(new Object[][] {}, columnNames);
  
        // Set the model for jTable1
        jTable1.setModel(model);
        
        // Make the table uneditable
        jTable1.setDefaultEditor(Object.class, null);
        
        // Apply the custom header renderer to each column header
        for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setHeaderRenderer(new CustomHeaderRenderer());
        }

        // Set the preferred height for the header row
        jTable1.getTableHeader().setPreferredSize(new Dimension(jTable1.getTableHeader().getWidth(), 40));



        
        tableHeader.setFont(headerFont);
        
        // Create custom cell renderer for center alignment
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        // Apply custom renderer to all columns
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Apply padding to specific columns (like "Drink" and "Time")
        PaddedCellRenderer paddedRenderer = new PaddedCellRenderer(5, 50, 5, 10);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(paddedRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(paddedRenderer);

        processOrderData(model); // Populate the table with data
        
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new CustomScrollBarUI());

        jButton1.setBackground(new java.awt.Color(29, 29, 54));
        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Back");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton1FocusGained(evt);
            }
        });
        
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x5c5ADB)); // Change background color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new java.awt.Color(0x1d1d36)); // Change back to original background color when not hovering
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 55)); // NOI18N
        jLabel1.setText("Order History");

         // Instantiate the VendingMachineHeader panel
        VendingMachineHeader headerPanel = new VendingMachineHeader();

        // Create a new GroupLayout for the layout of the frame
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Add the header panel
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(515, 515, 515))
            .addGroup(layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addComponent(jLabel1)
                .addContainerGap(256, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) // Add the header panel
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>     
    
    
    private void processOrderData(DefaultTableModel model) {
        // Read and process orders from the file
        try (BufferedReader br = new BufferedReader(new FileReader("data/orders.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String orderID = parts[0];
                String time = parts[1];
//                String total = parts[2];
                String drinkOrder = parts[3];

                String[] drinkOrders = drinkOrder.split("/");
                for (String drink : drinkOrders) {
                    String[] drinkParts = drink.split(",");
                    String drinkID = drinkParts[0].replaceAll("\\[|\\]", ""); // Remove brackets
                    String drinkName = drinkParts[1];
                    String quantity = drinkParts[2];
                   // Load the price using drinkID from the data/drinks.txt file
                    String price = getPriceForDrinkID(drinkID);
                    
                    // Calculate the total by multiplying quantity with price
                    double total = Double.parseDouble(quantity) * Double.parseDouble(price);

                    // Add the data to the table
                    model.addRow(new Object[]{orderID, drinkName, quantity, price, time, total});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String getPriceForDrinkID(String drinkID) {
    try (BufferedReader br = new BufferedReader(new FileReader("data/drinks.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length >= 3 && parts[0].equals(drinkID)) {
                return parts[2]; // Assuming price is at index 2
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "N/A"; // Default value if price is not found
}

    public class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = new Color(92, 90, 205); // Set thumb color
            this.trackColor = new Color(240, 240, 240); // Set track color
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            if (thumbBounds.isEmpty() || !this.scrollbar.isEnabled()) {
                return;
            }

            int w = thumbBounds.width;
            int h = thumbBounds.height;

            g.setColor(thumbColor);
            g.fillRect(thumbBounds.x, thumbBounds.y, w, h);
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            g.setColor(trackColor);
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }
    }


    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {                                     
        dispose();
        
        JFrame staffFrame = new JFrame("Vending Machine System - Order History");
                    staffFrame.setSize(1200, 600);
                    staffFrame.setLocation(350, 250);
                    staffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    StaffIndex staffIndex = new StaffIndex(staffFrame, loggedInUsername);
                    staffFrame.getContentPane().add(staffIndex);
                    staffFrame.setVisible(true);
    }  
    
    
    private void addHeader() {
        VendingMachineHeader headerPanel = new VendingMachineHeader(); // Instantiate the header panel
        getContentPane().add(headerPanel, java.awt.BorderLayout.NORTH); // Add it to the north (top) of the frame's content pane
    }

    

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
