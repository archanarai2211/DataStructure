public class Queue {
    int[] arr =new int [1000];
    int capacity;
    int first;
    int last;

    Queue(int capacity){
        arr = new int [capacity];
        this.capacity = capacity;
        first = -1;
        last = -1;
    }

    void enqueue(int n){
        if(last == capacity-1){
            throw new IllegalStateException("Queue is full");
        }else if(first == -1 && last == -1){
            first++; last ++;
            arr[last] = n;
        }else{
            arr[++last] = n;
        }
    }

    int dequeue(){

        if(first == -1 && last == -1){
            throw new IllegalStateException("Queue is empty");
        }else if(first == last){
            int n  = arr[first];
            first = -1;
            last = -1;
            return n;
        }else{
            int n  = arr[first];
            first ++;
            return n;
        }

    }
    boolean contains(int n){
        if(first == -1 && last == -1){
            throw new IllegalStateException("Queue is empty");
        }
        for(int i = first; i<= last; i++){
            if(arr[i]==n){
                return true;
            }
        }
        return false;
    }
    int access(int position){
        if((first == -1 && last == -1) || position>last){
            throw new IllegalStateException("Queue is empty");
        }
        for(int i = first; i<= last; i++){
            if(i==position){
                return arr[i];
            }
        }
        throw new IllegalStateException("element not found");
    }
}
