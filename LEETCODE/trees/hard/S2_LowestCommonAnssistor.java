package LEETCODE.trees.hard;

import LEETCODE.trees.BinaryTree;
import java.util.*;

public class S2_LowestCommonAnssistor {
    private static boolean findPath(BinaryTree.Node root,BinaryTree.Node target,List<Integer> path) {

        if (root == null) {
            return false;
        }

        path.add(root.data);

        // Target found
        if (root == target) {
            return true;
        }

        // Search left subtree agar mera fun ne true return krdiya to  true 
        if (findPath(root.left, target, path)) {
            return true;
        }

        // Search right subtree
        if (findPath(root.right, target, path)) {
            return true;
        }
        // Backtrack
        path.remove(path.size() - 1);
        return false;
    }

    // Brute Force LCA
    private static int bruteForce(BinaryTree.Node root,BinaryTree.Node p, BinaryTree.Node q) {

        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        findPath(root, p, path1);
        findPath(root, q, path2);

        int i = 0;

        while (i < path1.size() &&i < path2.size() &&path1.get(i).equals(path2.get(i))) {
            i++;
        }

        return path1.get(i - 1);
    }

    private static BinaryTree.Node optimal(BinaryTree.Node root,  BinaryTree.Node p, BinaryTree.Node q){
        if(root == null  && p == null &&  q == null){
            return root;
        }
        BinaryTree.Node left = optimal(root.left, p, q);
        BinaryTree.Node right = optimal(root.right, p, q);

        if(left == null){
            return right;
        }else if(right == null){
            return right;
        }else{
            return root;
        }
    }

    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        bruteForce(root, root, root);

    }
}
