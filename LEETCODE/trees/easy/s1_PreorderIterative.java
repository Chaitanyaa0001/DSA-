package LEETCODE.trees.easy;
import java.util.*;

import LEETCODE.trees.BinaryTree;

// in this we will use iterative not recurssion  
// in this we will use stack   

public class s1_PreorderIterative {
    private static List<Integer> preorder(BinaryTree.Node root){

        // root  left right 
        Stack<BinaryTree.Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            
            BinaryTree.Node curr = stack.pop();
            list.add(curr.data);

            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
            
        }
        return list;
    }
    public static void main(String[] args) {

        preorder(null);
    }
}
