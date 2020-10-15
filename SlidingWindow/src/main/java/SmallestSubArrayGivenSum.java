public class SmallestSubArrayGivenSum {


    //Minimum value
    //Maximum value
    //Longest value
    //Shortest value
    //ßK-sized value

        public static void main(String[] args) {
            int[] a = {2, 5, 9, -1, 4, -9, 6, 8};
            System.out.println(findSmallestSubArrayGivenSum(8, a));
        }

        public static int findSmallestSubArrayGivenSum(int sum, int[] a){
        int minWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int currentWindowSum = 0;

        for(int windowEnd =0; windowEnd< a.length; windowEnd++){
                currentWindowSum += a[windowEnd];

            while(currentWindowSum >= sum){
                minWindowSize = Math.min(minWindowSize, windowEnd-windowStart+1);
                currentWindowSum-= a[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;

    }

}
