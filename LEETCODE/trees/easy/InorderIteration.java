package LEETCODE.trees.easy;

import java.util.ArrayList;
import java.util.*;

import LEETCODE.trees.BinaryTree;

public class InorderIteration {

    private static List<Integer> inorder(BinaryTree.Node root){
        List<Integer> ans  = new ArrayList<>();
        Stack<BinaryTree.Node> stack = new Stack<>();
        
        if(root == null){
            return ans;
        }

        BinaryTree.Node  node = root;
    // left root right 
        while (true) {
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                ans.add(node.data);
                node = node.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
        BinaryTree.Node root  = BinaryTree.createTree();
    }

}
