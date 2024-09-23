import java.util.Scanner;

public class inheritance
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the dimensions : ");
        double d1=in.nextDouble();
        double d2=in.nextDouble();
        shape ob=new triangle(d1,d2);
        System.out.println("Area of triangle is "+ ob.calculateArea());

        ob=new rectangle(d1,d2);

        System.out.println("Area of rectangle is "+ ob.calculateArea());
    }
}
class shape
{
    double d1;
    double d2;
    shape()
    {
        d1 = 0;
        d2 = 0;
    }
    shape(double x, double y)
    {
        d1 = x;
        d2 = y;
    }
    double calculateArea()
    {
        return d1 * d2;
    }
}

class triangle extends shape
{
    triangle(){
        super();
    }
    triangle(double x, double y)
    {
        super(x, y);
    }
    double calculateArea()
    {
        return (0.5 * d1 * d2);
    }
}

class rectangle extends shape
{
    rectangle()
    {
        super();
    }
    rectangle(double x, double y)
    {
        super(x, y);
    }
    double calculateArea(double x, double y)
    {
        return (x * y);
    }
}