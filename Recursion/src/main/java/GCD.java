public class GCD {



    public static void main(String[] args) {
        System.out.println(gcd(9,6));
        System.out.println(gcdItr(3,7));
    }

    private static int gcdItr(int num1   , int num2) {

        while(num2 != 0){
            int temp = num2;
            num2 = num1%num2;
            num1 = temp;

        }
        return num1;
    }

    private static int gcd(int num1  , int num2) {
        if(num2 == 0)
            return num1;
        return gcd(num2, num1 % num2);
    }
}
