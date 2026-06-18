package LEETCODE.trees.easy;

import java.util.*;

import LEETCODE.trees.BinaryTree;

// int this we can use 2 stack and 1 stack 
public class PostorderIteration {
    private static List<Integer> postorderSINGLE(BinaryTree.Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<BinaryTree.Node> stack1 = new Stack<>();
        Stack<BinaryTree.Node> stack2= new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            BinaryTree.Node node = stack1.pop();
            stack2.push(node);

            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack1.push(node.right);
            }
        }
        while (stack1.isEmpty()) {
            stack1.pop();
        }
        
        return ans;
    }
    public static void main(String[] args) {

        BinaryTree.Node root = BinaryTree.createTree();

    }
}
