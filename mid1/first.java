import java.lang.Math;
class first{

    public static void main(String args[]) {
        for (int i=0;i<args.length;i++){
            System.out.println(args[i]);       
        }
        System.out.println(1+2);       
        System.out.println("HI"+12+2);       
        System.out.println("HI");       
        System.out.println(1+2+"HI");  
        int number=Integer.parseInt("123");
        // int number=Integer.parseInt("12.3"); => throws an Error 
        System.out.println(number);  
        System.out.println(Math.sqrt(-5));  
    }
}