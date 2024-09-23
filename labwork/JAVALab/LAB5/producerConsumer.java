import java.lang.*;

public class producerConsumer {
    public static void main(String[] args) {
        buffer ob=new buffer();
        producer p=new producer("Himanshu",ob);
        consumer c=new consumer("Huzaifa",ob);
    }
}

class buffer
{
    int info;
    int flag;
    buffer()
    {
        flag=0;
    }

    synchronized void put(int x)
    {
        try{
            if(flag==1){
                wait();
            }
            info=x;
            flag=1;
            notify();
        }
        catch(InterruptedException ob)
        {
            System.out.println("Error occured in producing the inforamation!");
        }
    } 
    synchronized void get()
    {
        try{
            if(flag==0){
                wait();
            }
            System.out.println(info);
            flag=0;
            notify();
        }
        catch(InterruptedException ob)
        {
            System.out.println("Error occured in consuming the inforamation!");
        }
    }
}

class producer extends Thread
{
    int c=0;
    String name;
    buffer ref;

    producer()
    {
        name=null;
    }
    producer(String s,buffer ob)
    {
        ref=ob;
        name=s;
        start();
    }
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            ref.put(++c);
        }
    }
}

class consumer extends Thread
{
    String name;
    buffer ref;
    consumer(){
        name=null;
    }
    consumer(String s,buffer ob)
    {
        ref=ob;
        name=s;
        start();
    }
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            ref.get();
        }
    }
}
