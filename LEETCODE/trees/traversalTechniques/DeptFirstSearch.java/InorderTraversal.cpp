import LEETCODE.trees.BinaryTree;

public class InorderTraversal {

    public static void inorder(BinaryTree.Node root) {
        if( root == null){
            return ;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {

        BinaryTree.Node root = BinaryTree.createTree();

        inorder(root);
    }
}