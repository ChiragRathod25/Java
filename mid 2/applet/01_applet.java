import java.applet.*;
import java.awt.*;
class myApplet extends Applet{

    String s;
    public void init(){
        s+="Init";;
        repaint();
    }
    public void start(){
        s+="started";
    }
    public void paint(Graphics g){
        g.drawString(s,500,500);
    }
}