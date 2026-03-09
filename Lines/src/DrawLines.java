import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawLines extends JPanel{
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int num = 20;

        for(int n = 1; n < num; n++) {
            g.drawLine(0, height * n/num, width*n/num, height);
        }
    }
}
