import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class myFrame_with_Btn extends JFrame implements ActionListener{
    int count1=37;
    int count2=29;
    JButton bref1;
    JButton bref2;
    myFrame_with_Btn(String title){
        super(title);
        bref1=new JButton("Btn 1");
        bref2=new JButton("Btn 2");
        this.add(bref1);
        this.add(bref2);
        bref1.addActionListener(this);
        bref2.addActionListener(this);
        this.setLayout(new FlowLayout());
    }
    public void paint(Graphics g){
            g.drawString("count 1 : "+count1+"  count 2 : "+count2,100,count2);
    }
    public void actionPerformed(ActionEvent ae){
        JButton temp=(JButton)(ae.getSource());
        if(temp==bref1)
            count1++;
        else 
            count2++;
        
        repaint();
    }

}

public class myFrame_with_Btn_main{
    public static void main(String[] args) {
        myFrame_with_Btn mfb=new myFrame_with_Btn("chirag with buttons");
        mfb.setSize(300,400);
        mfb.setVisible(true);
        mfb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}