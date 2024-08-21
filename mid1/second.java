class base{
    int a;
    base(int a){
        this.a=a;
    }
}
class child extends base{
    int b;
    child(int a,int b){
        super(a);
        this.b=b;
    }
}
class subchild extends child{
    int c;
    subchild(int a,int b,int c){
        super(a,b);
        this.c=c;
    }
}
class secondMain{
    public static void main(String [] args){
        //base b=new base(10);
        // System.out.println(b.a);
        base newclass=new child(12,456);
        System.out.println(newclass.a);
        //System.out.println(newclass.b); -> here i can't access any variables from the child
        child children=new child(13,43);
        System.out.println(children.a);
        System.out.println(children.b);

        // child children2=new base(32); --> base can't be converted to the child
        // System.out.println(children2.a);
        
    }
}