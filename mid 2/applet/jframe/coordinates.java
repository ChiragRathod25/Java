import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class coordinates {
    public static void main(String[] args) {
        myCoordinates mc=new myCoordinates("Chirag's coordinating system");
        mc.setVisible(true);
        mc.setSize(300,400);
        mc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}

class myCoordinates extends JFrame implements MouseListener ,MouseMotionListener{
    int x;
    int y;
    int flag=0;
    myCoordinates(String title){
        super(title);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    public void paint(Graphics g){
        super.paint(g);
        if(flag==1)
            g.drawString("I'm here, catch me if you can",x,y);
        else 
            g.drawString("X : "+x+"Y: "+y, x, y);
    }
    public void mousePressed(MouseEvent me){
        x=me.getX();
        y=me.getY();
        flag=0;
        repaint();
    }

    public void mouseReleased(MouseEvent me){}
    public void mouseClicked(MouseEvent me){
       
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void mouseMoved(MouseEvent me){
        x=me.getX();
        y=me.getY();
        x=x-30;
        y=y-40;
        flag=1;
        repaint();
    }
    public void mouseDragged(MouseEvent me){}

}