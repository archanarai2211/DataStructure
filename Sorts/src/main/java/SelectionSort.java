public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1 ,6, 9, 8, 4, 5, 0};
        selectionSort(arr);
    }
    //Time complexity O(n^2)
    //Space complexity O(n)
    private static void selectionSort(int[] arr) {
        int minIndex = 0;
        int temp = 0;
        for(int i = 0; i< arr.length-1;i++ ){
            for(int j = i+1; j< arr.length;j++ ){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        for(int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
