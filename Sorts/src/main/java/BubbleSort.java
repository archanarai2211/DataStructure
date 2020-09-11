public class BubbleSort {

    //O(n^2) Worst and avg complexity
    //O(n) best case complexity
    //O(n) space complexity
    //Find the largest and send it to the end
    public static void main(String[] args) {
        int[] arr = {2, 3, 1 ,6, 9, 8, 4, 5, 0};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;
        for(int i = 0; i< arr.length-1; i++){
            for(int j = 0; j< arr.length-i-1; j++){
                if(arr[j]>arr[j+1])
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        for(int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
