import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class btnApplet extends Applet implements ActionListener{
    int count1;
    int count2;
    String s="Button Implementation";
    Button b_ref1;
    Button b_ref2;
    public void init()
    {
        count1=0;
        count2=0;
        repaint();
        b_ref1=new Button("Button 1");
        b_ref2=new Button("Button 2");
        this.add(b_ref1);
        this.add(b_ref2);
        b_ref1.addActionListener(this);
        b_ref2.addActionListener(this);
        
    }
    public void paint(Graphics g)
    {
        g.drawString(s,237,50);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Button type=(Button)(ae.getSource());
        if(type==b_ref1)
        {
            ++count1;
        }else{
            count2++;
        }
        
        showStatus("Button1 : "+count1+"        Button2 : "+count2);
    }
}
