public class BinaryTree {

    private Node root;

    int size;

    public BinaryTree() {
    }

    public int getSize() {
        return size;
    }

    public void add(int val){
        Node node = new Node(val);
        if(root == null){
            root = node;
            size++;
        }else{
            insert(root, node);
        }

    }

    public boolean delete(int val){
       boolean deleted = false;
       if(root == null)
            return false;
       Node currentNode = getNode(val);
       if(currentNode!=null){
           if(currentNode.getRight()==null && currentNode.getLeft()==null){
               unlink(currentNode, null);
               deleted = true;
           }else if(currentNode.getRight()!=null && currentNode.getLeft()==null){
               unlink(currentNode, currentNode.getRight());
           }else if(currentNode.getRight()==null && currentNode.getLeft()!=null){
               unlink(currentNode, currentNode.getLeft());
           }else{
                Node child = currentNode.getLeft();
                while(child.getLeft()!=null && child.getRight()!=null){
                    child = child.getRight();
                }
                child.getParent().setRight(null);
                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());
                unlink(currentNode, child);
                deleted = true;
           }
       }
       if(deleted)
           size--;       return deleted;
    }

    private void unlink(Node currentNode, Node newNode){
        if(currentNode == this.root){
            newNode.setLeft(root.getLeft());
            newNode.setRight(root.getRight());
            this.root = newNode;
        }else if(currentNode.getParent().getRight() == currentNode){
            currentNode.getParent().setRight(newNode);
        }else{
            currentNode.getParent().setLeft(newNode);
        }
    }

    public boolean contains(int val){
        return getNode(val) != null;
    }

    private Node getNode(int val){
        Node currentNode = this.root;
        while(currentNode != null){
            if(currentNode.getVal() == val){
                return currentNode;
            }else if(currentNode.getVal() > val){
                currentNode = currentNode.getRight();
            }else{
                currentNode = currentNode.getLeft();
            }
        }
        return null;
    }

    public void insert(Node parent, Node child){
        if(child.val< parent.val){
            if(parent.getLeft() == null){
                parent.setLeft(child);
                child.setParent(child);
                size++;
            }else{
                insert(parent.left, child);
            }

        }else if(child.val> parent.val){
            if(parent.getRight() == null){
                parent.setRight(child);
                child.setParent(child);
                size++;
            }else{
                insert(parent.right, child);
            }
        }

        //equal case is left upto the reader
    }

    private class Node{
        Node left;
        Node right;
        Node parent;
        int val;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
