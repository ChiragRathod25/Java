import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class myApplet extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello, Applet!", 20, 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Applet Converted to JFrame");
        myApplet appletPanel = new myApplet();
        frame.add(appletPanel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
