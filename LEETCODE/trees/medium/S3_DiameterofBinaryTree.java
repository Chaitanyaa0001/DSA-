package LEETCODE.trees.medium;

import LEETCODE.trees.BinaryTree;

public class S3_DiameterofBinaryTree {
    // diameter of binary tree is  longest path between 2 noded  path does not to excedd via rot 
   static int maxi = 0;

    public static int  getHeight(BinaryTree.Node root){
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1+ Math.max(left,right);
    }
    private static int bruteforce(BinaryTree.Node root){
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        maxi = Math.max(maxi,left + right);

        bruteforce(root.left);
        bruteforce(root.right);
        return 1+ Math.max(left, right);
        // time : O(n square )
    }

    private static int optimalAppproch(BinaryTree.Node root, int maxi){
        if(root == null){
            return 0;
        }
        int left = optimalAppproch(root.left, maxi);
        int right = optimalAppproch(root, maxi);

        maxi = Math.max(maxi,left +  right);

        return 1 + Math.max(left, right);
    }
    public static void main(String[] args) {
        BinaryTree.Node  root = BinaryTree.createTree();
        bruteforce(root);
        optimalAppproch(root, maxi);

    }
}
