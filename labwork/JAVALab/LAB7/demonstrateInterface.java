public class demonstrateInterface {
    public static void main(String[] args) {
        tempInterface t_ref=new rectangle(2,4);
        tempInterface t_ref1=new triangle(2, 6);
        System.out.println("Area of triangle is "+t_ref.cal());
        System.out.println("Area of rectangle is "+t_ref1.cal());
    }
}

class triangle implements tempInterface
{
    double d1;
    double d2;
    triangle(){
        d1=0;
        d2=0;
    }
    triangle(double a, double b)
    {
        d1=a;
        d2=b;
    }

    public double cal()
    {
        return (0.5*d1*d2);
    }
    // public void display()
    // {
    //     System.out.println("Base : "+d1+" Height : "+d2);
    // }
}

class rectangle implements tempInterface
{
    double d1;
    double d2;

    rectangle()
    {
        d1=0;
        d2=0;
    }
    rectangle(double a, double b)
    {
        d1=a;
        d2=b;
    }
    public double cal()
    {
        return (d1*d2);
    }
    // public void display()
    // {
    //     System.out.println("Base : "+d1+" Height : "+d2);
    // }
}
