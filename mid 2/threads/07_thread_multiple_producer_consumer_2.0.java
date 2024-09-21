class myBuffer {
    int[] info;
    boolean[] flag;
    int s;

    

    myBuffer(int size) {
        s = size;
        info = new int[s];
        flag = new boolean[s];
        for (int i = 0; i < s; i++)
            flag[0] = false;
    }

    synchronized void put(int value, int pId, int cId) {
        try {
            while (flag[cId] == true) {
                wait();
            }
            info[cId] = value;
            flag[cId] = true;
            System.out.println("Information " + info[cId] + " produced by " + pId + " for consumer " + cId);
            notifyAll();
        } catch (Exception e) {
            System.out.println("Production Error : " + e);
        }
    }

    synchronized void get(int cId) {
        try {
            while (flag[cId] == false)
                wait();
            System.out.println(info[cId]);
            flag[cId] = false;
            System.out.println("Information " + info[cId] + " consumed by " + cId);
            notifyAll();
        } catch (Exception e) {
            System.out.println("Consumption Error : " + e);
        }
    }
}

class producer implements Runnable {
    int pId;
    myBuffer bref;
    Thread thref;

    producer() {
        pId = 0;
    }

    producer(myBuffer bref, int pId) {
        this.bref = bref;
        this.pId = pId;
        this.thref = new Thread(this);
        thref.start();
    }

    public void run() {
        for (int i = 0; i < 3; i++)
            bref.put(i * 41, pId, i);
    }
}

class consumer implements Runnable {
    myBuffer bref;
    int cId;
    Thread thref;

    consumer() {
        cId = 0;
    }

    consumer(myBuffer bref, int cId) {
        this.cId = cId;
        this.bref = bref;
        thref = new Thread(this);
        thref.start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            bref.get(i);
        }
    }
}

class myThreadMain {
    public static void main(String[] args) {
        myBuffer mb = new myBuffer(5);
        int n = 5;
        producer[] p = new producer[n];
        consumer[] c = new consumer[n];
        int pId = 0;
        int cId = 0;
        for (int i = 0; i < n; i++) {
            p[i] = new producer(mb, pId++);
            c[i] = new consumer(mb, cId++);
        }
        for (int i = 0; i < n; i++) {
            try {
                p[i].thref.join();
                c[i].thref.join();
            } catch (Exception e) {
                System.out.println("Error in join :" + e);
            }
        }
    }
}