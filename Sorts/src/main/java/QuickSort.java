public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1 ,6, 9, 8, 4, 5, 0};
        quickSort(arr, 0, arr.length-1);
        for(int i=0; i< arr.length ;i++){
            System.out.print(arr[i]);
        }
    }

    //Worst time performance O(n^2)
    //Avg and best O(nlogn)
    //Space performance O(n)
    private static void quickSort(int[] arr, int s, int l) {
        if(s<l) {
            int pi = partition(arr, s, l);
            quickSort(arr, s, pi - 1);  // Before pi
            quickSort(arr, pi + 1, l); // After pi
        }
    }

    private static int partition(int[] arr, int s, int l) {
        //last element is pivot
        int pivot = arr[l];

        //starting index will be incremented before use
        int i = s-1;

        //swapping everything smaller than pivot to left
        for(int j=s; j< l; j++){
            if(arr[j]<pivot){
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swapping and fixing pivot
        int temp = arr[i+1];
        arr[i+1] = arr[l];
        arr[l] = temp;
        return i+1;
    }
}
