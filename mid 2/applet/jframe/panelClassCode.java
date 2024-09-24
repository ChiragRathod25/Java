import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class panelClass extends JFrame implements ActionListener, ItemListener {
    JPanel jp1, jp2;
    JCheckBox jc1, jc2;
    JButton bref1;
    JButton bref2;
    JLabel jlb;
    JTextField jtf;

    panelClass(String title) {
        super(title);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jc1 = new JCheckBox("Virat");
        jc2 = new JCheckBox("Rohit");
        bref1 = new JButton("India");
        bref2 = new JButton("Sachin Tendulkar");
        jlb = new JLabel("Label calling");
        jtf = new JTextField();

        this.add(jp1);
        this.add(jp2);
        jp1.add(jc1);
        jp1.add(jc2);
        jp2.add(bref1);
        jp2.add(bref2);
        jp2.add(jlb);
        jp2.add(jtf);
        jp1.setLayout(new GridLayout(1, 2));
        jp2.setLayout(new GridLayout(1, 3));
        this.setLayout(new GridLayout(2, 1));
    }
    public void actionPerformed(ActionEvent ae){}
    public void itemStateChanged(ItemEvent ie){}

}

public class panelClassCode {
    public static void main(String[] args) {
        panelClass pc=new panelClass("Chirag's Panel");
        pc.setSize(300,400);
        pc.setVisible(true);
        pc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
