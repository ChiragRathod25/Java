class myThread extends Thread{
    myThread(String name){
        super.setName(name);
    }
    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println("I'm going to sleep " + this.threadId()+ " " + this.getName());
            try {
                Thread.sleep(1000);
                System.out.println("Me Jaag Gaya " + this.threadId());
            } catch (InterruptedException e) {
                System.out.println(e);   
            }
        }
       
    }
}
class myThreadMain {
    public static void main(String[] args) {
        myThread th1=new myThread("Chirag");
        myThread th2=new myThread("Himanshuuu");
        myThread th3=new myThread("Chai");
        th1.start();
        th2.start();
        try {
            th2.join();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        th3.start();

    }
}