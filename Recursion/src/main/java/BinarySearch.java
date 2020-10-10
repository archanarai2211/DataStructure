public class BinarySearch {

    public  static int binarySearch(int[] arr, int n, int s, int l) {
        if (s > l) {
            return -1;
        } else {
            int m = (s + l) / 2;
            if (arr[m] == n) {
                return m;
            } else if (arr[m] > n) {
                return binarySearch(arr, n, s, m - 1);
            } else {
                return binarySearch(arr, n, m + 1, l);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(a, 4, 0, 10));
    }
}
