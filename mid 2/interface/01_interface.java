class demoInterface {
    public static void main(String[] args) {
        shape s1 = new triangle(3, 4);
        shape s2 = new square(4, 5);

        System.out.println(s1.area());
        System.out.println(s2.area());
        
        // s1.triangleAreaDisplay();  // => here it can't call methods of triangle class, because it is a reference of shape interface which is refering to the triagle object
    }
}

class triangle implements shape {
    double d1;
    double d2;

    triangle() {
        d1 = 0;
        d2 = 0;
    }   
    void triangleAreaDisplay(){
        intro();
        System.out.println("My display is "+area());
    }

    triangle(double d1, double d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public void intro() {
        System.out.println("Hii , I'm triangle class and i implemented shape interface");
    }

    public double area() {
        // finalVar=37;// => gives error, because we are trying to modify interface variable
        // int finalVar=37;// => gives error, it;s a local variable of area() method
        System.out.println("Final variable of Interface : " + finalVar);
        intro();
        return (d1 * d2) / 2;
    }
}

class square implements shape {
    double d1;
    double d2;

    square() {
        d1 = 0;
        d2 = 0;
    }

    square(double d1, double d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    public double area() {
        System.out.println("Final variable of Interface : " + finalVar);
        intro();
        return (d1) * d2;
    }
}

interface shape {
    int finalVar = 41;

    double area();

    default void intro() {
        System.out.println("Hii , I'm shape interface");
    }
}