public class myComplex
{
    public static void main(String [] args)
    {
        complex ob1=new complex(5,2);
        complex ob2=new complex(5,2);
        complex ob3=ob1.addComplex(ob2);
        ob3.display();
    }
}
class complex
{
    int r;
    int i;

    public complex()
    {
        r=0;
        i=0;
    }
    public complex(int a , int b)
    {
        r=a;
        i=b;
    }

    public complex addComplex(complex ob)
    {
        complex ob1=new complex();
        ob1.r=r+ob.r;
        ob1.i=i+ob.i;
        return ob1;
    } public void display()
    {
        System.out.println(r + " + "+i+"i");
    }
}

