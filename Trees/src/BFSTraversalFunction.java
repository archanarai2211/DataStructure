//Time Complexity: O(n^2) in worst case.
public class BFSTraversalFunction {

    // Root of the Binary Tree
    BSTNode root;

    /* function to print level order traversal of tree*/
    void printLevelOrder() {
        int h = height(root);
        for (int i = 0; i < h; i++) {
            printGivenLevel(root, i);
        }
    }

    /* Compute the "height" of a tree -- the number of
   nodes along the longest path from the root node
   down to the farthest leaf node.*/
    int height(BSTNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            return Math.max(lheight, rheight)+1;
        }
    }


    /* Print nodes at the given level */
    void printGivenLevel (BSTNode root ,int level)
    {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        else if (level > 0)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    public static void main(String args[])
    {
        BFSTraversalFunction tree = new BFSTraversalFunction();
        tree.root= new BSTNode(1);
        tree.root.left= new BSTNode(2);
        tree.root.right= new BSTNode(3);
        tree.root.left.left= new BSTNode(4);
        tree.root.left.right= new BSTNode(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
    }
}
