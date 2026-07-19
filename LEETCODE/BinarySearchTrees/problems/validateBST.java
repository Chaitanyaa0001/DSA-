package LEETCODE.BinarySearchTrees.problems;

import LEETCODE.trees.BinaryTree;

public class validateBST {
    private static boolean dfs(BinaryTree.Node root, long low, long  high){
        if(root == null){
            return true;
        }
        if(root.data <= low || root.data >= high){
            return false;
        }
        //  ab left k liye mera parent = high m jayaga 
        //  ab right k liye 
        return dfs(root.left,low,root.data) && dfs(root.right,root.data,high);
    }

    
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        dfs(root,Long.MIN_VALUE,Long.MAX_VALUE) ;
    }
}
