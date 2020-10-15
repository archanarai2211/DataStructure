public class MaxSumSubArray {


    public static void main(String[] args) {
        int[] a = {2,5,8,-1,4,-9,6,9};
        System.out.println(findMaxSumSubArray(a, 3));
    }

    public static int findMaxSumSubArray(int[] a, int k){
        int max = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i =0; i< a.length; i++){
            currSum+= a[i];
            if(i >= k-1){
                max = Math.max(currSum, max);
                currSum-= a[i-(k-1)];
            }
        }
        return max;
    }
}
