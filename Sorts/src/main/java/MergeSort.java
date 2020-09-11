public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1 ,6, 9, 8, 4, 5, 0};
        sort(arr, 0, arr.length-1);
        for(int i=0; i< arr.length ;i++){
            System.out.println(arr[i]);
        }
    }

//Time complexity O(nlogn)
    //Space complexity O(n)

    private static void sort(int[] arr, int s, int l) {
        if(s<l) {
            //divide
            int m = (s + l) / 2;
            sort(arr, s, m);
            sort(arr, m + 1, l);

            //merge and sort
            merge(arr, s, m, l);
        }
    }

    //0 2, 3 4=>0 1, 2,2=>00,11

    private static void merge(int[] arr, int s, int m, int l) {
        //calculate the size for two arrays
        int l1 = m-s+1;
        int l2 = l-m;
        //create two temporary arrays
        int L[] = new int [l1];
        int R[] = new int [l2];

        for(int i=0;i<l1; i++){
            L[i]=arr[s+i];
        }for(int i=0;i<l2; i++){
            R[i]=arr[i+m+1];
        }
        //start merging with sorting
        int i=0;
        int j=0;
        int k=s;
        while(i<l1 && j <l2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        //Add remaining elements
        while(i<l1){
            arr[k]=L[i];
            k++;
            i++;
        }
        while(j<l2){
            arr[k]=R[j];
            k++;
            j++;
        }
    }
}
