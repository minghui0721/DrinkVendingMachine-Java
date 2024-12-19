package main;

import index.VendingMachineContent;
import index.VendingMachineHeader;
import javax.swing.*;
import java.awt.*;

public class VendingMachineMain {
    // Static reference to the main frame
    public static JFrame mainFrame;

    public static void main(String[] args) {
        //This is the main container for your entire application.
        mainFrame = new JFrame("Vending Machine System");
        //This line sets the default close operation for the window. When you click the close button (X) of the window, it will close the window and terminate the application.
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200, 600);
       mainFrame.setLocation(350,250);

        //creating an instance of the VendingMachineHeader class
        VendingMachineHeader header = new VendingMachineHeader();
        //This line adds the header (which is an instance of VendingMachineHeader) to the frame (the main window).
   mainFrame.add(header, BorderLayout.NORTH);

        //creating an instance of the VendingMachineContent class
        VendingMachineContent content = new VendingMachineContent();
      mainFrame.add(content,BorderLayout.CENTER);
      

        //set the frame visible
     mainFrame.setVisible(true);
    }
}
