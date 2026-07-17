package LEETCODE.BinarySearchTrees.problems;

import LEETCODE.trees.BinaryTree;

public class SearchInBST {
    private static BinaryTree.Node search(BinaryTree.Node root, int target){
        if(root == null){
            return null;
        }
        if(target == root.data){
            return root;
        }
        if(target < root.data){
            search(root.left, target);
        }else{
            search(root.right, target);
        }
        return root;
    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        search(root, 0);

    }
}
