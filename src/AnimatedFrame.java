import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatedFrame extends JFrame {
    private float opacity = 0.1f; // Initial opacity
    private final int DELAY = 50; // milliseconds

    public AnimatedFrame() {
        setTitle("Slow Display Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Removes the frame decorations for a cleaner effect
        setOpacity(opacity); // Set initial opacity

        Timer timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gradually increase the opacity until it reaches 1
                opacity += 0.1f;
                if (opacity >= 1.0f) {
                    opacity = 1.0f; // Ensure opacity doesn't exceed 1
                    ((Timer) e.getSource()).stop(); // Stop the timer once opacity is 1
                }
                setOpacity(opacity);
            }
        });

        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AnimatedFrame().setVisible(true);
            }
        });
    }
}
