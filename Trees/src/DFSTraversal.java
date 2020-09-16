public class DFSTraversal {

    public void preOrderTraversal( BSTNode root){
        action(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal( BSTNode root){
        inOrderTraversal(root.left);
        action(root);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal( BSTNode root){
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        action(root);
    }

    private void action(BSTNode root) {
        System.out.println(root.data);
    }
}
