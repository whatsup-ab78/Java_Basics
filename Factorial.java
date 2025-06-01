class Factorial{
    public static void main(String[]args){
        int num=Integer.parseInt(args[0]);
        int fact=1;
        System.out.println("The Factorial of "+num+" is");
        for(int i=0;i<num;i++){
            System.out.print(i+1);
            if(i<num-1)
                System.out.print("x");
            fact*=(i+1);
        }
        System.out.println();
        System.out.println("Which is equal to:"+fact);
    }
}