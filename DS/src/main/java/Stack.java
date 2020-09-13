public class Stack {

    private int arr[];
    private  int top;
    private int capacity;

    Stack(int c){
        this.capacity = c;
        arr = new int[c];
        top = -1;
    }

    public void push(int v){
        if(top == capacity-1){
            throw new RuntimeException("Capacity exhausted");
        }
        arr[++top] = v;
    }
    public int pop(){
        if(top == -1){
            throw new RuntimeException("Stack Empty");
        }
        return arr[top--];
    }

}
