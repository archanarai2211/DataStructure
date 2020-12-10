public class Kadanes {
//Maximum subarray problem
    public static void main(String[] args) {
        int[] arr = {-7,-4,-2,0,-8,1,-7,5,3, 10};
        System.out.println( maxSubArray(arr));
    }

    private static int maxSubArray(int[] a) {
       int size = a.length; 
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0; 
  
        for (int i = 0; i < size; i++) 
        { 
            max_ending_here = max_ending_here + a[i]; 
            if (max_so_far < max_ending_here) 
                max_so_far = max_ending_here; 
            if (max_ending_here < 0) 
                max_ending_here = 0; 
        } 
        return max_so_far; 
    }
}
