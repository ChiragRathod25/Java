class thirdClass{
    public static void main(String[] args) {
        int i=0;
        boolean label=true;

        // here into the if statement 
        // if(i) {} => raise error //because it expect true or false, not an integer or string values
        
        if(label)
            System.out.println("Condition satisfied");
        else 
            System.out.println("Not satisfied");

    }
}