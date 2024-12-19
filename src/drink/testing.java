package drink;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testing extends javax.swing.JFrame {

    // Path to the drinks data file
    private static final String DRINKS_FILE_PATH = "data/drinks.txt";

    private JPanel imagePanel;

    public testing() {
        initComponents();

        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Image Viewer");

        displayImages();
    }

    private void initComponents() {
        imagePanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(imagePanel);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void displayImages() {
        List<String> imagePaths = getImagePaths();

        int imageWidth = 150; // Set the desired width
        int imageHeight = 150; // Set the desired height

        for (String imagePath : imagePaths) {
            System.out.println("Loading image: " + imagePath);

            // Debugging: Print resource URL
            System.out.println("Resource URL: " + getClass().getResource(imagePath));

            ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));

            if (imageIcon.getImageLoadStatus() == MediaTracker.ERRORED) {
                System.out.println("Error loading image: " + imagePath);
            } else {
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

                JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
                imageLabel.setToolTipText("Image Path: " + imagePath);
                imagePanel.add(imageLabel);
            }
        }
    }


    private List<String> getImagePaths() {
        List<String> imagePaths = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DRINKS_FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // Escape the pipe character
                if (parts.length >= 5) {
                    String imagePath = parts[4]; // Get the image path from the text file
                    imagePaths.add(imagePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imagePaths;
    }



    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new testing().setVisible(true));
    }
}
