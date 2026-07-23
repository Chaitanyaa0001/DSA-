package LEETCODE.BinarySearchTrees.problems;

import java.util.*;
import LEETCODE.trees.BinaryTree;

public class RecoverBST {

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
 

    static int index = 0;
    private static void inorder(BinaryTree.Node root,List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }
    private static void  bruteforce(BinaryTree.Node root){
        List<Integer> list  = new ArrayList<>();
        inorder(root,list);
        // now we have to traverse inorder again 
        Collections.sort(list);
        index = 0;
        putAtcorrectPosition(root, list);
    }
    private static void  putAtcorrectPosition(BinaryTree.Node root, List<Integer> list){
        if(root == null){
            return;
        }
        putAtcorrectPosition(root.left, list);
        if(list.get(index)  != root.data){
            root.data = list.get(index);
        }
        index++;
        putAtcorrectPosition(root.right, list);
        
    }
    // ------------------------------------------------------------------------------------------------------------

    // now optimal approch 
   static TreeNode prev ;
   static TreeNode  first;
   static TreeNode middle ;
   static TreeNode last;

    private static void inorderOptimal(TreeNode root){
        if(root == null){
            return;
        }
        inorderOptimal(root.left);

        if(prev != null  && (prev.val > root.val)){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorderOptimal(root.right);
    }
    
    private static void optimaApproch(TreeNode root){
        prev = first = middle = last = null;
      
        inorderOptimal(root);

        // case 1 mera 
        // agar mera adjacent elemets nhi hai or 2 violation hai 
        if(first != null && last != null){
            int temp = first.val;
            first = last;
            last.val = temp;
        }else if(first != null && middle != null){
            // or agar mera adjacent ele,ents hai or violation hai toh 
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }

    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        bruteforce(root);

    }
}
