package LEETCODE.trees.easy;

import java.util.*;

import LEETCODE.trees.BinaryTree;

// int this we can use 2 stack and 1 stack 
public class S2_PostorderIteration {
    // ITERATIVE POSTORDER 
    private static List<Integer> postorderDOUBLE(BinaryTree.Node root){
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

    private static List<Integer> postorderSINGLE(BinaryTree.Node root) {

    List<Integer> list = new ArrayList<>();
    Stack<BinaryTree.Node> stack = new Stack<>();

    BinaryTree.Node curr = root;

    while (curr != null || !stack.isEmpty()) {

        if (curr != null) {

            stack.push(curr);
            curr = curr.left;

        } else {

            BinaryTree.Node temp = stack.peek().right;

            if (temp == null) {

                temp = stack.pop();
                list.add(temp.data);

                while (!stack.isEmpty()
                        && stack.peek().right == temp) {

                    temp = stack.pop();
                    list.add(temp.data);
                }

            } else {

                curr = temp;
            }
        }
    }

    return list;
}
    public static void main(String[] args) {

        BinaryTree.Node root = BinaryTree.createTree();
        postorderDOUBLE(root);
        postorderSINGLE(root);

    }
}
