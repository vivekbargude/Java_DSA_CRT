class Recursion{
    public static void main(String[] args){
        System.out.println(fibonacci(4));
        System.out.println(factorial(4));
        System.out.println(sumOfN(4));
        
    }
    public static int fibonacci(int num){
        if(num==0 || num==1)
        return num;

        return fibonacci(num-1)+fibonacci(num-2);
    }

    public static int factorial(int n){
        if(n==1)
        return 1;

        return n*factorial(n-1);
    }

    public static int sumOfN(int n){
        if(n==1)
        return 1;

        return n+sumOfN(n-1);
    }

    
}