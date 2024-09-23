import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class panelClass {
    public static void main(String[] args) {
        panelDemo p_ref=new panelDemo("Himanshu");
        p_ref.setSize(1000,1000);
        p_ref.setVisible(true);
        p_ref.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class panelDemo extends JFrame implements ActionListener,ItemListener
{
    JCheckBox cb1,cb2;
    JLabel lb;
    JPanel p1,p2;
    JTextField jtf;
    JButton btn1,btn2;
    String s=" ";
    panelDemo(String title)
    {
        super(title);
        cb1=new JCheckBox("First");
        cb2=new JCheckBox("Second");
        lb=new JLabel("Name");
        p1=new JPanel();
        p2=new JPanel();
        jtf=new JTextField();
        btn1=new JButton("Btn1");
        btn2=new JButton("Btn2");
        add(p1);
        add(p2);
        p1.add(cb1);
        p1.add(cb2);
        p2.add(lb);
        p2.add(jtf);
        p2.add(btn1);
        p2.add(btn2);
        p1.setLayout(new GridLayout(1,2));
        p2.setLayout(new GridLayout(1,4));
        this.setLayout(new GridLayout(2,1));
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        jtf.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {

    }
    public void itemStateChanged(ItemEvent ie)
    {

    }
}
