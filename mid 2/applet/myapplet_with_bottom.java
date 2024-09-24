import java.applet.*;
import java.awt.*;
import java.awt.event.*;;

public class myapplet_with_bottom  extends Applet implements ActionListener{

    int counter=0;
    String s="coutn : ";
    Button bref;
    public void init(){
        counter=37;
        bref=new Button("New Button");
        this.add(bref);
        bref.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        showStatus(s+counter++);
        
    }
}
