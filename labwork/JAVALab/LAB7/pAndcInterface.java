import java.lang.*;
import java.util.Scanner;
import java.*;

public class pAndcInterface {
    public static void main(String[] args) {
        buffer ob = new buffer(4);
        Scanner in = new Scanner(System.in);
        int n = 2;
        producer[] p=new producer[n];
        consumer[] c=new consumer[n];
        int p_id=0;
        int c_id=0;
        for (int i = 0; i < n; i++) {
            producer t = new producer(ob,p_id++);
            p[i] = t;
            consumer t1 = new consumer(ob,c_id++);
            c[i] = t1;
        }
        for (int i = 0; i < n; i++) {
            try{
                p[i].th_ref.join();
                c[i].th_ref.join();
            }
            catch(InterruptedException eOb)
            {
                System.out.println("Error in join");
            }

        }
    }
}

class buffer {
    int[] info;
    boolean[] flag;
    int s;

    buffer() {
        s = 0;
    }

    buffer(int size) {
        s = size;
        info = new int[s];
        flag = new boolean[s];
        for (int i = 0; i < s; i++) {
            flag[i] = false;
        }
    }

    synchronized void put(int cId, int x, int pId) {
        try {
            while (flag[cId] == true) {
                wait();
            }
            info[cId] = x;
            System.out.println("Item produce by producer " + pId + " for the consumer " + cId);
            flag[cId] = true;
            notifyAll();
        } catch (InterruptedException ob) {
            System.out.println("Error occured while producing the item");
        }
    }

    synchronized void get(int cId) {
        try {
            while (flag[cId] == false) {
                wait();
            }
            System.out.println("item "+info[cId] + " consumed by consumer " + cId);
            flag[cId] = false;
            notifyAll();
        } catch (InterruptedException ob) {
            System.out.println("Error occured while consuming the item");
        }
    }
}

class producer implements Runnable {
    int p_id;
    buffer b_ref;
    Thread th_ref;

    producer() {
        p_id = 0;
    }

    producer(buffer ob, int x) {
        b_ref = ob;
        th_ref = new Thread(this);
        p_id = x;
        th_ref.start();
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            b_ref.put(i, i + 1, p_id);
        }
    }
}

class consumer implements Runnable {
    int c_id;
    buffer b_ref;
    Thread th_ref;

    consumer() {
        c_id = -1;
    }

    consumer(buffer ob, int x) {
        b_ref = ob;
        th_ref = new Thread(this);
        c_id = x;
        th_ref.start();
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            b_ref.get(c_id);
        }
    }
}
