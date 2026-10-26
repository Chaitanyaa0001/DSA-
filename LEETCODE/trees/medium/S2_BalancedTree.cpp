package LEETCODE.trees.medium;

import LEETCODE.trees.BinaryTree;

public class S2_BalancedTree {
    public static int  getHeight(BinaryTree.Node root){
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1+ Math.max(left,right);
    }

    private static boolean bruteforce(BinaryTree.Node root){
        if(root == null){
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left - right) <= 1 && bruteforce(root.left) && bruteforce(root.right) ){
            return true;
        }
        return false;
    }

    private static int optimalAppproch(BinaryTree.Node root){
        
        int left = optimalAppproch(root.left);
        int right = optimalAppproch(root.right);

        if(left == -1){
            return -1;
        }
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }   

        return 1 + Math.max(left, right);
    }

    private static boolean ans(BinaryTree.Node root){
        return optimalAppproch(root) != -1;
    }
    public static void main(String[] args) {
        BinaryTree.Node  root = BinaryTree.createTree();
        bruteforce(root);

        ans(root);
    }
}
