import java.lang.*;
import java.util.*;
import java.util.Scanner;

public class producerConsumerM {
    public static void main(String[] args) {
        buffer ob=new buffer();
        Scanner in= new Scanner(System.in); 
        int n=2;
        producer[] p=new producer[n];
        consumer[] c=new consumer[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter "+(i+1)+" Producer name : ");
            String name=in.nextLine();
            producer t=new producer(name,ob);
            p[i]=t;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter "+(i+1)+" Consumer name : ");
            String name=in.nextLine();
            consumer t=new consumer(name,ob);
            c[i]=t;
        }
        for(int i=0;i<n;i++)
        {
            p[i].start();
        }
        for(int i=0;i<n;i++)
        {
            c[i].start();
        }
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

    synchronized void put(int x,String pName)
    {
        try{
            while(flag==1){
                wait();
            }
            info=x;
            System.out.println("Item produce by "+pName);
            System.out.println();
            flag=1;
            notifyAll();
        }
        catch(InterruptedException ob)
        {
            System.out.println("Error occured in producing the inforamation!");
        }
    } 
    synchronized void get(String cName)
    {
        try{
            while(flag==0){
                wait();
            }
            System.out.print("Item consumed by "+cName+" ");
            System.out.println(info);
            System.out.println();
            flag=0;
            notifyAll();
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
    }
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            ref.put(++c,name);
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
    }
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            ref.get(name);
        }
    }
}
