class myThread extends Thread{
    @Override
    public void run() {
        // while(true)

            System.out.println("Ha ha i'm running " + this.threadId()) ;
    }
}
class myThreadMain {
    public static void main(String[] args) {
        myThread th1=new myThread();
        myThread th2=new myThread();
        System.out.println("Before starting of thread execution");
        // th1.start();
        try {
            
            th1.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        // th2.start();
        
        Thread th=Thread.currentThread(); // =>  returns the current running thread 
        System.out.println(th.getName());
        System.out.println(th.threadId());
        

    }
}