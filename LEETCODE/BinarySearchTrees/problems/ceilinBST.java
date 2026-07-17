package LEETCODE.BinarySearchTrees.problems;

import LEETCODE.trees.BinaryTree;

public class ceilinBST {
    private static int ceil(BinaryTree.Node root, int key ){
        
        BinaryTree.Node ceil = new BinaryTree.Node(-1);
        while (root != null) {
            if(root.data == key){
                ceil = root;
                return ceil.data;
            }else if(root.data > key){
                ceil = root;
                root = root.left;
            }else{
                root = root.right;  
            }
        }
        return ceil.data;
    }
    
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        ceil(root, 10);
        
    }
}
