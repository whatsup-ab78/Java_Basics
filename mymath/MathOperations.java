package mymath;
public class MathOperations{
        
        public int add(int a, int b){
            return a+b;
        }

        public int substract(int a,int b){
            return a-b;
        }

        public int multiply(int a,int b){
            return a*b;
        }

        public double divide(int a,int b){
            if(b==0){
                throw new ArithmeticException("Cannot divide by 0!");
            }
            else{
                return a/b;
            }
        }
}