class complex{
    int i;
    int j;
    complex(){
        this.i=0;
        this.j=0;
    }
    complex(int i,int j){
        this.i=i;
        this.j=j;
    }
    complex addComplex(complex c1){
        return new complex(this.i+c1.i,this.j+c1.j);
    }
    void display(){
        System.out.println("i : "+i + " J: "+ j);
    }
}
class complex_main{
    public static void main(String[] args) {
        complex c1=new complex(3,45);
        complex c2=new complex(65,23);
        complex result;
        result=c1.addComplex((c2));
        c1.display();
        c2.display();
        result.display();
    }
}