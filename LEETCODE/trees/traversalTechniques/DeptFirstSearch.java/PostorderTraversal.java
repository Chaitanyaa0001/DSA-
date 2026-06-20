import LEETCODE.trees.BinaryTree;

public class PostorderTraversal {
    private static void postorder(BinaryTree.Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        BinaryTree.Node  root = BinaryTree.createTree();
        postorder(root);
    }
}
