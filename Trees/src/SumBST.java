public class SumBST {


    public BSTNode mergeTrees(BSTNode t1, BSTNode t2) {

        return merge(t1, t2);

    }
    public BSTNode merge(BSTNode t1, BSTNode t2) {

        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        Integer t = t1.data + t2.data;
        BSTNode node = new BSTNode(t);
        node.left = merge(t1.left, t2.left);
        node.right = merge(t1.right, t2.right);
        return node;
    }
}
