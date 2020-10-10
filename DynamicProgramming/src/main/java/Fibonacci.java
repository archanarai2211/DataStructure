import java.util.HashMap;

public class Fibonacci {

    public static HashMap<Integer, Integer> dp = new HashMap<>();

    //Use dynamic programming when there are overlapping subproblems
    //          f(4)
    //      f(3)     f(2)
    //  f(2)    f(1)f(1)  f(0)====>Overlapping f(2) calculated twice
    public static void main(String[] args) {
        System.out.println(fibonacci(100));
        dp.put(0,0);
        dp.put(1,1);
        System.out.println(fibonacciDP(100));
    }

    private static int fibonacciDP(int n) {
        if(dp.get(n)!=null)
            return dp.get(n);
        dp.put(n-1, fibonacciDP(n-1));
        dp.put(n-2, fibonacciDP(n-2));
        int result = fibonacciDP(n-1)+fibonacciDP(n-2);
        dp.put(n, result);
        return result;
    }

    private static int fibonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
