public class thread02 implements Runnable {
    public static void main(String[] args) {
        thread02 th2=new thread02();
        Thread th=new Thread(th2);
        th.start();
        System.out.println("This is outside the thread");
    }
    public void run(){
        System.out.println("This is inside the run method");
    }
}
