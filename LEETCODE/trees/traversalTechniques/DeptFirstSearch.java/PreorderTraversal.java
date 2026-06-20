import LEETCODE.trees.BinaryTree;

public class PreorderTraversal {
    private static void inorder(BinaryTree.Node root){

        if(root ==  null){
            return;
        }
        System.out.println(root.data);
        inorder(root.left);
        inorder(root.right);
    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        inorder(root);

    }
}
