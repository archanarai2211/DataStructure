public class Test {

    public static void main(String[] args) {
        int[] arr = {5,7,9,1,4,2,8,0};
        sort(arr, 0, arr.length-1);
        System.out.println(arr);

    }
    public static void quickSort( int[] arr, int s, int e) {
        if(e>s){
            int m = s+e/2;
            sort(arr, s, m);
            sort(arr, m+1, e);
            merge(arr, s,m ,e);

        }

      public static void merge(int[] arr, int s, int m, int e){
          int l1 = m-s+1;
          int l2 = e-m;

          for(int i = 0;i<l1;i++){
              ll[i] = arr[i];
          }

            for(int i = 0;i<l2;i++){
                lr[i] = arr[i];
            }
            int i =0;
            int j = 0;
            int k = s;
            while(i<l1 &&j<l2){
                if(ll[i]<lr[j]){
                    arr[k] = ll[i];
                    i++;
                    j++;
                }else{

                }
            }
        }
    }

}

