import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class mouseEventDemo extends JFrame implements MouseListener,MouseMotionListener
{
    int x,y;
    String name="Himanshu";
    int flag=0;
    int count1=0;
    int count2=0;
    mouseEventDemo(String title)
    {
        super(title);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void mouseClicked(MouseEvent me)
    {
        x=me.getX();
        y=me.getY();
        flag=1;
        repaint();
    }

    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void paint(Graphics g)
    {
        super.paint(g);
        if(flag==1)
        {
            g.drawString("(X,Y) : ("+x+","+y+")",200,300);
        }
        if(flag==2)
        {
            g.drawString(name,500,500);
        }
    }
    public void mouseMoved(MouseEvent me)
    {
        x=me.getX();
        y=me.getY();
        flag=2;
        repaint();
    }
    public void mouseDragged(MouseEvent me)
    {}
}

public class MouseEventClass
{
    public static void main(String[] args) {
        mouseEventDemo m_ref=new mouseEventDemo("Himanshu");
        m_ref.setSize(1000,1000);
        m_ref.setVisible(true);
        m_ref.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
} 
