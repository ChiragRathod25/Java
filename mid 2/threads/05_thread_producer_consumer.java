import java.lang.*;
class myBuffer {
    volatile int info;
    volatile int flag;
    myBuffer(){
        flag=0;
    }
    synchronized void put(int value){
        try{
            if(flag==1)
                wait();
            info=value;
            flag=1;
            notify();
        }
        catch(Exception e){
            System.out.println("Production Error : "+e);
        }
    }
    synchronized void get(){
        try {
            if(flag==0)
                wait();
                System.out.println(info);
                flag=0;
                notify();
        } catch (Exception e) {
            System.out.println("Consumption Error : "+ e);
        }
    }
}
class producer extends Thread{
    String name;
    myBuffer bref;
    producer(){
        name=null;
    }
    producer(String name,myBuffer bref){
        this.bref=bref;
        this.name=name;
        start();
    }
    public void run(){
        for (int i=0;i<3;i++)
            bref.put(i*41);
    }
}

class consumer extends Thread{
    myBuffer bref;
    String name;
    consumer(){
        name=null;
    }
    consumer(String name,myBuffer bref){
        this.name=name;
        this.bref=bref;
        start();
    }
    public void run(){
        for(int i=0;i<3;i++){
            bref.get();
        }
    }
}
class myThreadMain{
    public static void main(String[] args) {
        myBuffer mb=new myBuffer();
        producer p=new producer("Programmer",mb);
        consumer c=new consumer("User",mb);
    }
}