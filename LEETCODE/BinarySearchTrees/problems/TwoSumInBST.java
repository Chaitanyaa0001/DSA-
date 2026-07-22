package LEETCODE.BinarySearchTrees.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import LEETCODE.trees.BinaryTree;

public class TwoSumInBST {

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
   
    public static  class BSTiterator {
       Stack<TreeNode> st = new Stack<>();
       boolean isCheck = true;

        public BSTiterator(TreeNode root,boolean reverse){
           isCheck = reverse;
           pushAll(root,isCheck);
        }
        public void  pushAll(TreeNode node, boolean isCheck){
           // next vala follow krna hai 
           if(isCheck){
               while(node != null){
                   st.push(node);
                   node = node.left;
               }
           }else{
               while(node != null){
                   st.push(node);
                   node = node.right;
                }
            }
        }
       public int  next(){
            TreeNode curr = st.pop();
            if(isCheck){ /// true to next   
               pushAll(curr.right,isCheck);
            }else{
               // agar false hai toh 
               pushAll(curr.left,isCheck);
            }
            return curr.val;
        }
        public boolean hasNext(){
           return !st.isEmpty();
        }
    }


    public static  boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        BSTiterator l = new BSTiterator(root,true);
        BSTiterator r = new BSTiterator(root,false);

        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k){
                return true;
            }else if(i + j < k){
                i = l.next();
            }else{
                j = r.next();
            }
        }
        return false;
    }

// ---------------------------------------------------------------------------------

    public static  void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public  static boolean bruteforce(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            int sum = list.get(left) + list.get(right);

            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        
        bruteforce(null, 0);
        findTarget(null, 0);
    }
}
