import java.lang.*;
class myThread extends Thread{
    myThread(){

    }
    myThread(String name){
        super(name);
    }
    @Override
    public void run() {
        int i=10;
        while(i--!=0)
            System.out.println("Ha ha i'm running " + this.getId()) ;
            System.out.println("Ha ha i'm running " + this.getName()) ;
    }
}
class myThreadMain {
    public static void main(String[] args) {
        myThread th1=new myThread("First Thread");
        myThread th2=new myThread();
        System.out.println("Before starting of thread execution");
        th1.start();
        try {
            
            th1.join(); //=> waits for this thread to end, after completion of it program continues
            th2.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        th2.start();
        
        Thread th=Thread.currentThread(); // =>  returns the current running thread 
        // try {
        //     th.sleep(6000);
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
        System.out.println(th.getName());
        System.out.println(th.getId());
        

    }
}