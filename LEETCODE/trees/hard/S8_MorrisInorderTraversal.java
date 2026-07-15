package LEETCODE.trees.hard;


import LEETCODE.trees.BinaryTree;
import java.util.*;

public class S8_MorrisInorderTraversal {
    private static List<Integer>  morrisTraversal(BinaryTree.Node root){
        BinaryTree.Node curr = root;
        List<Integer> inorder = new ArrayList<>();
        while (curr != null) {
            if(curr.left == null){
                inorder.add(curr.data);
                curr = curr.right;
            }else{
                BinaryTree.Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null){
                    inorder.add(curr.data);
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        morrisTraversal(root);
    }   
}
