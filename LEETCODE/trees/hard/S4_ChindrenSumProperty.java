package LEETCODE.trees.hard;

import LEETCODE.trees.BinaryTree;

public class S4_ChindrenSumProperty {
    private static void childerensuproperty(BinaryTree.Node root){
        if(root == null){
            return;
        }
        int child = 0;
        if(root.left != null){
            child += root.left.data;
        }
        if(root.right != null){
            child += root.right.data;
        }
        if(child > root.data){
            root.data = child;
        }else{
            if(root.left != null){
                root.left.data = child;
            }
            if(root.right != null){
                root.right.data = child;
            }
        }
        childerensuproperty(root.left);
        childerensuproperty(root.right);
        int total = 0;
        if(root.left != null){
            total += root.left.data;
        }
        if(root.right != null){
            total += root.right.data;
        }
        if(root.left != null || root.right != null){
            root.data = total;
        }
    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();

    }
}
