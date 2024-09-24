public class thread01 extends Thread{
    public static void main(String[] args) {
        thread01 thread=new thread01();
        thread.start();
        System.out.println("This is outside of the thread");
        System.out.println("This is outside of the thread");
        System.out.println("This is outside of the thread");
        System.out.println("This is outside of the thread");
        System.out.println("This is outside of the thread");
    }
    public void run(){
        System.out.println("This is inside the run method");
        System.out.println("This is inside the run method");
        System.out.println("This is inside the run method");
        System.out.println("This is inside the run method");
        System.out.println("This is inside the run method");
        System.out.println("This is inside the run method");
    }
}