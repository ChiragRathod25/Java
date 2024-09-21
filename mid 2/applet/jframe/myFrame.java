import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class myFrame  extends JFrame {  
        myFrame(String title){
            super(title);
        }
}
class myFrameMain {
    public static void main(String[] args) {
        myFrame mf=new myFrame("Chirag");
        mf.setSize(300,400);
        mf.setVisible(true);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
