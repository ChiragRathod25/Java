class myBuffer {
    volatile int info;
    volatile int flag;
    myBuffer(){
        flag=0;
    }
    synchronized void put(int value,String name){
        try{
            while(flag==1)
                wait();
            info=value;
            flag=1;
            System.out.println("Information "+info+" produced by "+ name);
            notifyAll();
        }
        catch(Exception e){
            System.out.println("Production Error : "+e);
        }
    }
    synchronized void get(String name){
        try {
            while(flag==0)
                wait();
                System.out.println(info);
                flag=0;
                System.out.println("Information "+info+" consumed by "+ name);
                notifyAll();
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
            bref.put(i*41,name);
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
            bref.get(name);
        }
    }
}
class myThreadMain{
    public static void main(String[] args) {
        myBuffer mb=new myBuffer();

        producer p0=new producer("Programmer0",mb);
        consumer c0=new consumer("User0",mb);
        producer p1=new producer("Programmer1",mb);
        consumer c1=new consumer("User1",mb);
        producer p2=new producer("Programmer2",mb);
        consumer c2=new consumer("User2",mb);
        producer p3=new producer("Programmer3",mb);
        consumer c3=new consumer("User3",mb);
    }
}