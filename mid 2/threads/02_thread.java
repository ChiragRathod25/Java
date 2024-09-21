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
        System.out.println(th1.getName());
        th1.setName("U see bhai");
        th2.setName("This is not your attitude");
        System.out.println(th1.getName());
        try{
            
            th1.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(th2.getName());


    }
}