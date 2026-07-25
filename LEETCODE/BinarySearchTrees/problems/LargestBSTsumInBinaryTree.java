package LEETCODE.BinarySearchTrees.problems;

import LEETCODE.trees.BinaryTree;

public class LargestBSTsumInBinaryTree {
    
    // bruteforce 
    static int ans = 0;
    private static boolean validate(BinaryTree.Node root, long min, long max){
        if(root == null){
            return true ;
        }
        if(min >= root.data &&  root.data >= max ){
            return false;
        }
        return validate(root.left, min, root.data) && validate(root.right, root.data, max);
    }
    private static void bruetforce(BinaryTree.Node root){

        if(root == null){
            return;
        }
        if(validate(root,Long.MAX_VALUE, ans)){
            ans = Math.max(ans, sum(root));
        }
        bruetforce(root.left);
        bruetforce(root.right);
    }
    private static int  sum(BinaryTree.Node root){
      if(root == null){
            return 0 ;
        }
        int left =   sum(root.left);
        int right =  sum(root.right);
        return root.data + left + right;
    }
    // ---------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------
    // optimal 
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static  class Pair{
        int sum;
        long largest; // largest 
        long smallest; // smallest 

        Pair(int sum, long largest ,long smallest){
            this.sum = sum;
            this.largest = largest;
            this.smallest = smallest;
        }
    }
    static  int maxsum = 0;
    private static  Pair postorder(TreeNode root){
        if(root == null){
            return new Pair(0,Long.MIN_VALUE,Long.MAX_VALUE);
        }

        Pair left  =  postorder(root.left);
        Pair right = postorder(root.right);
        // ab agar mera bst hai 
        if(left.largest < root.val && root.val < right.smallest){    

            int currsum = root.val + left.sum + right.sum;
            maxsum = Math.max(currsum,maxsum);

            return new Pair(currsum, Math.max(root.val,right.largest) , Math.min(root.val,left.smallest));
        }
        //  or ab agar mera  BST nhi hai koi 
        return new Pair(0,Long.MAX_VALUE,Long.MIN_VALUE);

    }
    public static  int maxSumBST(TreeNode root) {
        maxsum = 0;
        postorder(root);
        return maxsum;
    }

    public static void main(String[] args) {

        BinaryTree.Node root = BinaryTree.createTree();
        bruetforce(root);
        maxSumBST(null);
       

    }
}
