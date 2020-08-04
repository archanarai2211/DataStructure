public class Traversal {

    public void preOrderTraversal( BSTNode root){
        action(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal( BSTNode root){
        preOrderTraversal(root.left);
        action(root);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal( BSTNode root){
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        action(root);
    }

    private void action(BSTNode root) {
        System.out.println(root.data);
    }
}
