import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class HouseDrawing extends JPanel {

    public HouseDrawing() {
        setPreferredSize(new Dimension(400, 420));
        setBackground(new Color(0x3A9EA5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int cx = getWidth() / 2;

        // === GROUND / SHADOW ===
        g2.setColor(new Color(0, 0, 0, 40));
        g2.fillOval(cx - 110, 330, 220, 20);

        // === MAIN BODY (ground floor) ===
        g2.setColor(new Color(0xF5E6C8));
        g2.fillRect(cx - 110, 220, 220, 120);

        // === SECOND FLOOR BODY ===
        g2.setColor(new Color(0xF5E6C8));
        g2.fillRect(cx - 90, 110, 180, 115);

        // === ROOF ===
        g2.setColor(new Color(0xB0B8C8));
        int[] rx = {cx - 110, cx, cx + 110};
        int[] ry = {115, 60, 115};
        g2.fillPolygon(rx, ry, 3);
        // Roof outline
        g2.setColor(new Color(0x8A93A0));
        g2.setStroke(new BasicStroke(2));
        g2.drawPolygon(rx, ry, 3);

        // === ROOF WINDOW (dormer) ===
        g2.setColor(new Color(0xD0D8E8));
        g2.fillOval(cx - 20, 70, 40, 35);
        g2.setColor(new Color(0x8A93A0));
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(cx - 20, 70, 40, 35);
        // cross in roof window
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawLine(cx, 70, cx, 105);
        g2.drawLine(cx - 20, 87, cx + 20, 87);

        // === SECOND FLOOR WINDOWS (behind railing) ===
        drawWindow(g2, cx - 65, 125, 45, 60);
        drawWindow(g2, cx + 20, 125, 45, 60);

        // === BALCONY FLOOR ===
        g2.setColor(new Color(0xD4C9A8));
        g2.fillRect(cx - 95, 215, 190, 12);
        g2.setColor(new Color(0xB0A888));
        g2.setStroke(new BasicStroke(1));
        g2.drawRect(cx - 95, 215, 190, 12);

        // === BALCONY RAILING === (on top of windows)
        g2.setColor(new Color(0x5A5A6A));
        g2.setStroke(new BasicStroke(2));
        // Top rail
        g2.drawLine(cx - 90, 180, cx + 90, 180);
        // Bottom rail
        g2.drawLine(cx - 90, 215, cx + 90, 215);
        // Vertical posts
        for (int x = cx - 90; x <= cx + 90; x += 15) {
            g2.drawLine(x, 180, x, 215);
        }

        // === GROUND FLOOR - LEFT WINDOW ===
        drawWindow(g2, cx - 95, 240, 45, 55);

        // === GROUND FLOOR - RIGHT WINDOW ===
        drawWindow(g2, cx + 50, 240, 45, 55);

        // === DOOR ===
        g2.setColor(new Color(0x6B3A2A));
        g2.fillRoundRect(cx - 22, 268, 44, 72, 5, 5);
        // Door top arch
        g2.setColor(new Color(0x6B3A2A));
        g2.fillArc(cx - 22, 258, 44, 25, 0, 180);
        // Door panel
        g2.setColor(new Color(0x7D4A38));
        g2.fillRoundRect(cx - 14, 278, 13, 25, 3, 3);
        g2.fillRoundRect(cx + 1, 278, 13, 25, 3, 3);
        // Door knob
        g2.setColor(new Color(0xD4A830));
        g2.fillOval(cx + 14, 308, 6, 6);

        // === FRONT STEP ===
        g2.setColor(new Color(0xD4C9A8));
        g2.fillRect(cx - 30, 336, 60, 8);
        g2.fillRect(cx - 25, 342, 50, 6);

        // === PLANT (right side, on the ground) ===
        drawPlant(g2, cx + 80, 348); // adjusted y to sit on ground

        // === OUTLINE on main bodies ===
        g2.setColor(new Color(0xC8B99A));
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawRect(cx - 110, 220, 220, 120);
        g2.drawRect(cx - 90, 110, 180, 115);
    }

    private void drawWindow(Graphics2D g2, int x, int y, int w, int h) {
        // Frame
        g2.setColor(new Color(0xD0C8B0));
        g2.fillRect(x, y, w, h);
        // Glass
        g2.setColor(new Color(0xA8C8D8));
        g2.fillRect(x + 3, y + 3, w - 6, h - 6);
        // Panes
        g2.setColor(new Color(0xD0C8B0));
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(x + w / 2, y + 3, x + w / 2, y + h - 3);
        g2.drawLine(x + 3, y + h / 2, x + w - 3, y + h / 2);
        // Border
        g2.setColor(new Color(0xA09070));
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawRect(x, y, w, h);
    }

    private void drawPlant(Graphics2D g2, int x, int y) {
        // Pot
        g2.setColor(new Color(0xB05030));
        int[] px = {x - 8, x + 8, x + 5, x - 5};
        int[] py = {y, y, y + 18, y + 18};
        g2.fillPolygon(px, py, 4);
        // Stem
        g2.setColor(new Color(0x3A7A30));
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(x, y, x - 5, y - 20);
        g2.drawLine(x, y, x + 3, y - 15);
        // Leaves
        g2.setColor(new Color(0x4A9A40));
        g2.fillOval(x - 16, y - 32, 18, 12);
        g2.fillOval(x - 2, y - 28, 16, 10);
        g2.fillOval(x - 10, y - 22, 14, 9);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("House");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new HouseDrawing());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}