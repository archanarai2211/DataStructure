public class DFSTraversal {


        //action to add node to the new copy tree
        //tree clone===> preOrderTraversal
        //    Pre-order=> Node=>left=>left...=>node>right=>node>right...=>right...
    public void preOrderTraversal( BSTNode root){
        action(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // inOder=> Left+>node=>right        sorting
    public void inOrderTraversal( BSTNode root){
        inOrderTraversal(root.left);
        action(root);
        inOrderTraversal(root.right);
    }

    //postOrder=>left+>right=>node action                    node deletion
    public void postOrderTraversal( BSTNode root){
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        action(root);
    }

    private void action(BSTNode root) {
        System.out.println(root.data);
    }
}
