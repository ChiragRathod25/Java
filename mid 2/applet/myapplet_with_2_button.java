import java.applet.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;;

public class myapplet_with_2_button  extends Applet implements ActionListener{

    int counter1=0;
    int counter2=0;
    String s="coutn : ";
    Button bref1;
    Button bref2;
    public void init(){
        counter1=37;
        counter2=41;
        
        bref1=new Button("Btn 1");
        bref2=new Button("Btn 2");

        this.add(bref1);
        this.add(bref2);
        bref1.addActionListener(this);
        bref2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        Button temp=(Button)(ae.getSource());
        if(temp==bref1){
            counter1++;
        }
        else 
            counter2++;
        showStatus("counter 1 : "+ counter1+"   counter 2 : "+counter2);
        
    }
}
