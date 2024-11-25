class myBuffer {
    int[] info;
    boolean[] flag;
    int s;

    myBuffer(int size) {
        s = size;
        info = new int[s];
        flag = new boolean[s];
        for (int i = 0; i < s; i++)
            flag[i] = false;
    }

    // Producer puts the value in the buffer
    synchronized void put(int value, int pId, int index) {
        try {
            while (flag[index]) {  // Wait until the buffer slot is free
                wait();
            }
            info[index] = value;  // Put the produced value in the buffer
            flag[index] = true;  // Mark the slot as occupied
            System.out.println("Information " + info[index] + " produced by " + pId + " for consumer at index " + index);
            notifyAll();  // Notify waiting consumers
        } catch (Exception e) {
            System.out.println("Production Error: " + e);
        }
    }

    // Consumer retrieves the value from the buffer
    synchronized void get(int cId, int index) {
        try {
            while (!flag[index]) {  // Wait until there is something to consume
                wait();
            }
            System.out.println(info[index]);  // Consume the value
            flag[index] = false;  // Mark the slot as free
            System.out.println("Information " + info[index] + " consumed by consumer " + cId + " from index " + index);
            notifyAll();  // Notify waiting producers
        } catch (Exception e) {
            System.out.println("Consumption Error: " + e);
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

    // Each producer produces 3 values and puts them in different buffer slots
    public void run() {
        for (int i = 0; i < bref.s; i++) {
            bref.put(i * 41, pId, i);  // Map producer index to buffer index
        }
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

    // Each consumer consumes values from the buffer at its assigned slot
    public void run() {
        for (int i = 0; i < bref.s; i++) {
            bref.get(cId, i);  // Each consumer consumes from a specific buffer index
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

      

        // Wait for all threads to finish
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
