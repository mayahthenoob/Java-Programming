import javax.swing.JFrame;

public class DrawLinesMain {
    public static void main(String[] args) {
        DrawLines panel = new DrawLines();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(panel);
        application.setSize(250, 250);
        application.setVisible(true);
    }
}
