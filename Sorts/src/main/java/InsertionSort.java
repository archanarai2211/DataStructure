public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 ,0};
        insertionSort(arr);
    }


    //Bestcase O(n)
    //worst and avg case time complexity O(n^2)
    //space complexity O(n)
    //Online provided
    public static void insertionSortImperative(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
    }


    private static void insertionSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j >0; j--){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
