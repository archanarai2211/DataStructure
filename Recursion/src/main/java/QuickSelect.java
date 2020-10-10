public class QuickSelect {

    public static void main(String[] args) {
        int[] arr = {4,2,9,6,8,5,1};
        quickSelect(2, arr);//find second highest
    }

    public static void quickSelect(int k, int[] arr){
        System.out.println(select(arr, 0, arr.length-1, k-1));
    }

    private static int select(int[] arr, int s, int l, int k) {
        if(s<l){
            int p = partition(arr, s, l);
            if(p>k){
                select(arr, s, p-1, k);
            }else if(p<k){
                select(arr, p+1, l, k);
            }
        }
        return arr[k];
    }

    private static int partition(int[] arr, int s, int l) {
        int pivot = arr[l];

        int i = s-1;
        for(int j = s; j<l; j++){
            if(arr[j]>pivot){//left side greater
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        int temp = arr[i+1];
        arr[i+1] = arr[l];
        arr[l] = temp;
        return i+1;
    }
}
