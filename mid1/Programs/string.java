class string{
    public static void main(String[] args) {
        String s="chirag";
        
        String s1="Himanshu";
        // s.equals(s1); => false
        
        String s2=s;
        // s.equals(s2) => true 
        
        String s3="chirag";
        // System.out.println(s3);
        // s.equals(s3); //=> true
        // System.out.println(s==s3); //=>true
        
        String s4=new String("chirag");
        // s.equals(s4); => true 
        
        String s5=new String("chirag");
        // s5.equals(s4); => true
        
        if(s5.equals(s4)){
            System.out.println("Both are equal");
        }
        else {
                System.out.println("not equal");
            }
           
            
        //s3==s => true
        //s4==s5 =>false
        // s4==s3 => false
        // s4==s => false
        if(s==s3){
            System.out.println("boolean true returns");
        }
        else{
            System.out.println("boolean false returns");
        }


    }
}