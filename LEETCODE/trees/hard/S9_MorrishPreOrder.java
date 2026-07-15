package LEETCODE.trees.hard;

import java.util.ArrayList;
import java.util.List;

import LEETCODE.trees.BinaryTree;

public class S9_MorrishPreOrder {
    private static List<Integer> preorder(BinaryTree.Node root){
        BinaryTree.Node curr = root;
        List<Integer> preorder = new ArrayList<>();
        while (curr != null) {
            if(curr.left == null){
                preorder.add(curr.data);
                curr = curr.right;
            }else{
                BinaryTree.Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null){
                    preorder.add(curr.data);
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        preorder(root);

    }
}
