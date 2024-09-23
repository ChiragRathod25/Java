import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class simpleApplet extends Applet {
    String s="";
    public void init()
    {
        s+="In init     ";
        repaint();
    }
    public void start()
    {
        s+="        started";
        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawString(s,100,100);
        System.out.println();
    }

}
