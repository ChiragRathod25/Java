import java.util.Scanner;
class stack
{
    int top;
    int []a;
    int size;
    public stack()
    {
        top=-1;
    }
    public stack(int s)
    {
        size=s;
        top=-1;
        a=new int[s];
    }
    public void push(int x)
    {
        if(top==-1)
        {
            a[++top]=x;
        }else{
            try{
                 if(top==size) throw new Exception();
                 else{
                     top++;
                     a[top]=x;
                 }
            }
            catch(Exception e)
            {
                System.out.println("Stack Overflow!");
            }
        }
    }

    public int getTop()throws Exception
    {
        try{
            if(top==-1) throw new Exception();
            else return a[top];
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    public void pop()
    {
        try{
            if(top==-1) throw new Exception();
            else{
                top--;
            }
        }
        catch(Exception e)
        {
            System.out.println("UnderFlow!");
        }
        
    }
    public void display()
    {
        for(int i=0;i<=top;i++)
        {
            System.out.println(a[i]+" ");
        }
    }

}


public class stackArgu
{
    public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    System.out.print("Enter the size of Stack : ");
    int s=in.nextInt();
    stack st=new stack(s);
    for(int i=0;i<args.length;i++)
    {
        if(args[i].equals("pop")){
            st.pop();
        }else if(args[i].equals("push"))
        {
            i++;
            st.push(Integer.parseInt(args[i]));
        }
    }
    try{
        System.out.println(st.getTop());
    }
    catch(Exception e)
    {
        System.out.println("UnderFlow");
    } 
    st.display();
    }
}