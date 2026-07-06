package LEETCODE.trees.medium;

import LEETCODE.trees.BinaryTree;
import java.util.*;

public class S5_BoundaryTraversal {

    private static boolean isleaf(BinaryTree.Node root){
        return root != null &&  root.left == null &&  root.right == null;
    }
    private static void leftboundry(BinaryTree.Node root, List<Integer> res){

        // leftbounary  
        BinaryTree.Node  curr = root.left;
        while (curr != null) {
            // agar mera ye false hai to ye mera leaf node nhi hai 
            if(!isleaf(curr)){
                res.add(curr.data);
            }
            if(curr.left != null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }

    private static  void rightmostboundary(BinaryTree.Node root,List<Integer> res){
        Stack<Integer> stack = new Stack<>();
        BinaryTree.Node curr = root.right;

        while (curr != null) {
            if(!isleaf(curr)){
                stack.push(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }
    private static void leafnodes(BinaryTree.Node root,List<Integer> res){
        if(isleaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null){
            leafnodes(root.left, res);
        }
        if(root.right != null){
            leafnodes(root.right, res);
        }
    }

    private static List<Integer> boundary(BinaryTree.Node root){
        List<Integer>  ans = new ArrayList<>();
        if(root == null)
            return ans;
        if(!isleaf(root)){
            ans.add(root.data);
        } 

        leftboundry(root, ans);
        leafnodes(root, ans);
        rightmostboundary(root, ans);
        return ans;
    }
    public static void main(String[] args) {
        BinaryTree.Node  root = BinaryTree.createTree();
        boundary(root);

    }
}
