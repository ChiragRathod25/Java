import java.util.Scanner;

public class book {
    public static void main(String[] args)
    {
        Scanner in= new Scanner(System.in);
        System.out.print("Enter the numbers of book : ");
        int n=in.nextInt();

        stock [] arr=new stock[n];
        System.out.println("Enter the title,auther,price and stock");
        for(int i=0;i<n;i++)
        {
            String t=in.nextLine();
            String a=in.nextLine();
            in.nextLine();
            double p=in.nextDouble();
            in.nextLine();
            int s=in.nextInt();
            arr[i]=new stock(t,a,p,s);
        }
        System.out.println("Enter the title of book : ");

    }
}

class bookStore{
    String author;
    String title;
    double price;

    bookStore()
    {
        author=null;
        title=null;
        price=0;
    }

    bookStore(String s1,String s2,double x)
    {
        author=s1;
        title=s2;
        price=x;
    }

    void display()
    {
            System.out.println("Title : "+title+"\nAuther : "+author+"\nPrice : "+price);
    }
}

class stock extends bookStore
{
    int stock;


    stock(){
        super();
    }
    stock(String s1, String s2, double x, int s)
    {
        super(s1,s2,x);
        stock=s;
    }

    void displayStock()
    {
        display();
        System.out.println("Available Stock : "+stock);
    }

    void issueBook()
    {
        if(stock==0){
            System.out.println("stock is not available!");
            return;
        }
        stock--;
        System.out.println("Book issued successfully!");
    }

    void returnBook()
    {
        System.out.println("Returned Successfully!");
        stock++;
    }
}
