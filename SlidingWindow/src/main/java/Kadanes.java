public class Kadanes {
//Maximum subarray problem
    public static void main(String[] args) {
        int[] arr = {-7,-4,-2,0,-8,1,-7,5,3, 10};
        System.out.println( maxSubArray(arr));
    }

    private static int maxSubArray(int[] a) {
        int localMax = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<a.length;i++){
            localMax = Math.max(localMax + a[i], a[i]);
            max = Math.max(max, localMax);
        }
        return max;
    }
}
