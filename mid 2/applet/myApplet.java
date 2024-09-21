import java.applet.*;
import java.awt.*;

public class myApplet extends Applet {
    String s = "";  

    public void init() {
        s += "Init";
        repaint();
    }

    public void start() {
        s += " started";
    }

    public void paint(Graphics g) {
        g.drawString(s, 50, 50);  
    }
    public void destroy(){}
    public void stop(){}
}
