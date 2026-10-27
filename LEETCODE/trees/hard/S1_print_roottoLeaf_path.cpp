package LEETCODE.trees.hard;


import LEETCODE.trees.BinaryTree;
import java.util.*;

public class S1_printRoottoLeadPath {
    private static boolean isleaf(BinaryTree.Node root){
        return root != null && root.left == null && root.right == null;
    }
    private static void dfs(BinaryTree.Node  root,List<List<Integer>> res, List<Integer>sub){
        if(root == null){
            return ;
        }
        
        sub.add(root.data);
        if(isleaf(root)){
            res.add(new ArrayList<>(sub));
        }else{
            dfs(root.left, res,sub);
            dfs(root.right, res,sub);
        }
        sub.remove(sub.size() - 1);
       
        
    }
    private static List<List<Integer>> printrootoPath(BinaryTree.Node root){
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {
        BinaryTree.Node  root = BinaryTree.createTree();
        printrootoPath(root);
    }
}
