package index;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VendingMachineHeader extends JPanel {

    public VendingMachineHeader() {
        setBackground(Color.decode("#1d1d36"));
        setLayout(new BorderLayout());

        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(padding);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/resources/apuLogo.png"));
        int width = 100;
        int height = 100;
        Image image = logoIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        ImageIcon resizedIcon = new ImageIcon(image);
        JLabel logoLabel = new JLabel(resizedIcon);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 10));

        JLabel titleLabel = new JLabel("Drinks Vending Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        centerPanel.setBackground(Color.decode("#1d1d36"));
        centerPanel.add(logoLabel);
        centerPanel.add(titleLabel);

        add(centerPanel, BorderLayout.CENTER);

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");

        JLabel dateLabel = new JLabel(dateFormat.format(now));
        dateLabel.setForeground(Color.WHITE);
        Font currentDateFont = dateLabel.getFont();
        dateLabel.setFont(new Font(currentDateFont.getName(), currentDateFont.getStyle(), 18));
        dateLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 15));

        JLabel timeLabel = new JLabel(timeFormat.format(now));
        timeLabel.setForeground(Color.WHITE);
        Font currentTimeFont = timeLabel.getFont();
        timeLabel.setFont(new Font(currentTimeFont.getName(), currentTimeFont.getStyle(), 18));
        timeLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JLabel dayLabel = new JLabel(dayFormat.format(now));
        dayLabel.setForeground(Color.WHITE);
        Font currentDayFont = dayLabel.getFont();
        dayLabel.setFont(new Font(currentDayFont.getName(), currentDayFont.getStyle(), 18));
        dayLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 15));

        JPanel dateTimePanel = new JPanel();
        dateTimePanel.setLayout(new BoxLayout(dateTimePanel, BoxLayout.LINE_AXIS));
        dateTimePanel.setBackground(Color.decode("#1d1d36"));
        dateTimePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));

        dateTimePanel.add(dayLabel);
        dateTimePanel.add(dateLabel);
        dateTimePanel.add(timeLabel);

        add(dateTimePanel, BorderLayout.LINE_END);
    }
}
