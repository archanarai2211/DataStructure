public class Factorial {

    static int factorial(int accumilator, int n){
        if(n==1)
            return accumilator;
        return factorial(accumilator*n, n-1);
    }

    public static int factorial(int n){
        return factorial(1, n);
    }

    public static void main(String[] args) {
        System.out.println(factorial(6));
    }
}
