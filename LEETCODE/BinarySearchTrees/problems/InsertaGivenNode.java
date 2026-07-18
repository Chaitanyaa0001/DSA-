package LEETCODE.BinarySearchTrees.problems;

import LEETCODE.trees.BinaryTree;

// You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

// Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
public class InsertaGivenNode {
    private static BinaryTree.Node insertnode(BinaryTree.Node root, int t){
        if(root == null){
            return null;
        }
        BinaryTree.Node curr = root;
        while(curr != null){
            if(t < curr.data){
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    BinaryTree.Node newnode = new BinaryTree.Node(t);
                    curr.left = newnode;
                    break;
                }
            }else{
                if(curr.right != null){
                    curr = curr.right;
                }else{
                    BinaryTree.Node newnode = new BinaryTree.Node(t);
                    curr.right = newnode;
                    break;
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        int t  = 5;
        insertnode(root, t);

    }
}
