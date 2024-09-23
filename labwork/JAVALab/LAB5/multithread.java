import java.lang.*;
public class multithread
{
    public static void main(String[] args)
    {
        childThread th1=new childThread("Th1");
        childThread th2=new childThread("Th2");
        childThread th3=new childThread("Th3");
        try{
            th1.join();
            th2.join();
            th3.join();
        }
        catch(InterruptedException ob)
        {
            System.out.println(" join thrown exception!");
        }
        for(int i=0;i<4;i++)
        {
            try{
                System.out.println(i+" main Thread");
                Thread.sleep(1);
            }
            catch(InterruptedException ob)
            {
                System.out.println(" Main thrown exception!");
            }
        }
        System.out.println("main ter");
    }
}

class childThread extends Thread{
    String name;
    childThread(){
        name=null;
    }
    childThread(String s)
    {
        super(s);
        name=s;
        start();
    }

    public void run()
    {
        for(int i=0;i<3;i++)
        {
            try{
                System.out.println(" "+i+" "+name);
                Thread.sleep(1000);
            }
            catch(InterruptedException ob)
            {
                System.out.println(name+" thrown exception!");
            }
        }
    }

}