import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UserFormUI extends JFrame {

    public UserFormUI() {
        setTitle("Java Form Recreation");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Exterior Blue Border Panel
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(0, 162, 232));
        outerPanel.setLayout(null); // manual positioning
        add(outerPanel);

        // --- TOP TAB (Icon Panel) ---
        JPanel tabHeader = new JPanel();
        tabHeader.setBounds(20, 5, 100, 35);
        tabHeader.setLayout(new BorderLayout());
        tabHeader.setOpaque(false); // remove background

        try {
            ImageIcon topIcon = new ImageIcon("icon.jpg");
            Image img = topIcon.getImage();

            // Custom panel to draw image fully filling tab
            JPanel iconPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                }
            };
            iconPanel.setOpaque(false); // transparent background
            tabHeader.add(iconPanel, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println("Tab icon not found.");
        }

        outerPanel.add(tabHeader);

        // 2. Interior White Content Panel
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.WHITE);
        innerPanel.setLayout(null);
        innerPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 2));
        innerPanel.setBounds(20, 40, 645, 400);
        outerPanel.add(innerPanel);

        // --- FORM FIELDS ---
        Color inputColor = new Color(25, 100, 140);

        createField(innerPanel, "First Name", 60, inputColor);
        createField(innerPanel, "Last Name", 110, inputColor);
        createField(innerPanel, "Age", 160, inputColor);

        // --- PERSON IMAGE (Right Box, Full Fill) ---
        try {
            ImageIcon personIcon = new ImageIcon("person.png");
            Image img = personIcon.getImage();

            // Custom panel to draw image fully filling the area
            JPanel picBox = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                }
            };
            picBox.setBounds(460, 57, 140, 140);
            picBox.setOpaque(false);
            picBox.setBorder(BorderFactory.createLineBorder(new Color(64, 128, 192)));
            innerPanel.add(picBox);
        } catch (Exception e) {
            JLabel fallback = new JLabel("Image Not Found", SwingConstants.CENTER);
            fallback.setBounds(460, 57, 140, 140);
            fallback.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            innerPanel.add(fallback);
        }

        // --- BUTTONS ---
        addButton(innerPanel, "UP", 40, 260, 80, 40);
        addButton(innerPanel, "Down", 40, 310, 80, 40);
        addButton(innerPanel, "Enter", 180, 290, 120, 45);
        addButton(innerPanel, "Cancel", 320, 290, 120, 45);
        addButton(innerPanel, "Undo", 460, 290, 120, 45);
    }

    private void createField(JPanel p, String labelText, int y, Color bg) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setBounds(80, y, 100, 30);
        p.add(label);

        JTextField field = new JTextField();
        field.setBounds(190, y, 240, 35);
        field.setBackground(bg);
        field.setForeground(Color.WHITE);
        field.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        p.add(field);
    }

    private void addButton(JPanel p, String text, int x, int y, int w, int h) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, w, h);
        btn.setBackground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(new RoundedBorder(15, new Color(0, 100, 0)));
        p.add(btn);
    }

    static class RoundedBorder implements Border {
        private int radius;
        private Color color;

        RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
        }

        @Override
        public boolean isBorderOpaque() { return true; }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(color);
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserFormUI().setVisible(true));
    }
}