package LEETCODE.BinarySearchTrees.problems;

import LEETCODE.trees.BinaryTree;

/**
 * floorBST
 */
public class floorBST {
    private static int floor(BinaryTree.Node root, int key){
       BinaryTree.Node floor = new BinaryTree.Node(-1);
        while (root != null) {
            if(root.data == key){
                floor = root;
                return floor.data;
            }else if(root.data < key){
                floor = root;
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return floor.data;
    }

    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        floor(root, 0);

    }
}