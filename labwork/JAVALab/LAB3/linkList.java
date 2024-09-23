class node
{
    int info;
    node next;

    node(){
        next=null;
        info=0;
    }
    node (int x)
    {
        info=x;
    }

    void append(int x)
    {
        node  t=new node(x);
        node temp=this;
        while(temp.next != null)
        {
            temp=temp.next;
        }
        temp.next=t;
    }

    void display()
    {
        node temp=this;
        do
        {
            System.out.print(temp.info+" ");
            temp=temp.next;
        }while(temp!=null);
        System.out.println();
    }

    node del(int x)
    {
        node temp1=this;
        node temp2=this;
        if(temp1.info==x){
            return temp1.next;
        }
        while(temp1.next!=null && x!=temp1.info)
        {
            temp2=temp1;
            temp1=temp1.next;
        }
        if(temp1.next == null && temp1.info !=x){
            System.out.println("Node not found!");
            return this;
        }else if(temp1.next == null && temp1.info ==x ){
            temp2.next=null;
        }else{
            temp2.next=temp1.next;
        }
        return this;
    }
}

public class linkList
{
    public static void main(String[] args)
    {
        node head=new node(29);
        head.append(18);
        head.append(37);
        head=head.del(29);
        head.display();
    }
}