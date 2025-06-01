import mymath.MathOperations;

public class MathTest{

    public static void main(String[]args){
        MathOperations math=new MathOperations();
        System.out.println("Enter two numbers:");
        int num1=Integer.parseInt(args[0]);
        int num2=Integer.parseInt(args[1]);  
        System.out.println("After Addition:"+math.add(num1,num2));
        System.out.println("After Substraction:"+math.substract(num1,num2));
        System.out.println("After Multiplication:"+math.multiply(num1,num2));
        System.out.println("After Division:"+math.divide(num1,num2));
    }

}