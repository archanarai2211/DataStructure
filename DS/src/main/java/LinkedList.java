import java.util.NoSuchElementException;

public class LinkedList {

    Node start;
    Node next;
    int nodeCount;

    LinkedList(){
        this.start = null;
        this.next=null;
        this.nodeCount = 0;
    }

    void add(Node node){
        if(start == null){
            this.start = node;
            this.next=node;
        }else {
            next.setNextNode(node);
            next = next.getNextNode();
        }
        nodeCount++;
    }
    int size(){
        return nodeCount;
    }

    Node remove(){
        if(start == null){
            throw new IllegalStateException("List is empty");
        }else{
            Node firstNode = start;
            start = start.next;
            nodeCount--;
            return firstNode;
        }
    }

    void insert(Node node, int position){
        if(size() < position){
           throw new IllegalStateException("List is smaller that the position");
        }
        if(position == 1){
            node.setNextNode(start);
            start = node;
            nodeCount++;
            return;
        }
        Node currentNode = start;

        for(int i=2; i<position && currentNode != null; i++){
            currentNode = currentNode.getNextNode();
        }

        Node nextNode = currentNode.getNextNode();
        node.setNextNode(nextNode);
        currentNode.setNextNode(node);
        
        nodeCount++;
    }

    int removeAt(int position){
        if(start == null || size() < position){
            throw new IllegalStateException("List is smaller that the position");
        }
        if(position == 1){
            int val = start.getNodeVal();
            start = start.getNextNode();
            nodeCount--;
            return val;
        }
        Node currentNode = start;
        Node previous = start;
        for(int i=1; i<position && currentNode != null; i++){
            previous = currentNode;
            currentNode = currentNode.getNextNode();
        }

        int val = currentNode.getNodeVal();
        previous.setNextNode(currentNode.getNextNode());

        nodeCount--;
        return val;
    }

    int get(int pos){
        if(start == null || size() < pos){
            throw new IllegalStateException("List is smaller that the position");
        }
        Node current = start;
        for(int i =1; i<size() && current!= null; i++){
            if(i==pos){
                return current.getNodeVal();
            }
            current = current.getNextNode();
        }
        throw new NoSuchElementException("Element not found");
    }

    int find(int item){

        if(start == null ){
            throw new IllegalStateException("List is smaller that the position");
        }
        Node current = start;
        for(int i =1; i<size() && current!= null; i++){
            if(item==current.getNodeVal()){
                return i;
            }
            current = current.getNextNode();
        }
        throw new NoSuchElementException("Element not found");

    }

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer();
        Node current = start;
        System.out.println("size: "+size());
        for(int i =0; i<size() && current!=null ; i++){
            str.append(current.getNodeVal()+" ,");
            current = current.getNextNode();
        }
        return str.toString();
    }

    public static class Node{
        int val;
        Node next;

        Node(int val){
            this.val=val;
        }

        void setNextNode(Node node){
            this.next = node;
        }

        void setNodeVal(int val){
            this.val = val;
        }

        int getNodeVal(){
            return this.val;
        }

        Node getNextNode(){
            return this.next;
        }
    }
}
