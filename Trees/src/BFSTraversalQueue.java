import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(n) where n is number of nodes in the binary tree
//Space Complexity: O(n) where n is number of nodes in the binary tree
public class BFSTraversalQueue {

    // Root of the Binary Tree
    BSTNode root;

    /* function to print level order traversal of tree*/
    void printLevelOrder() {
        Queue<BSTNode> queue = new LinkedList<BSTNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            BSTNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        BFSTraversalQueue tree_level = new BFSTraversalQueue();
        tree_level.root = new BSTNode(1);
        tree_level.root.left = new BSTNode(2);
        tree_level.root.right = new BSTNode(3);
        tree_level.root.left.left = new BSTNode(4);
        tree_level.root.left.right = new BSTNode(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}
