package LEETCODE.trees.medium;


import LEETCODE.trees.BinaryTree;

public class S10_Symmetric_BinaryTrees {
    private static  boolean dfs(BinaryTree.Node rootleft, BinaryTree.Node rootRight){
        if(rootleft == null || rootRight == null){
            return (rootleft == rootRight) ;
        }

        if(rootleft.data!= rootRight.data){
            return false;
        }
        return dfs(rootleft.left,rootRight.right)
         && dfs(rootleft.right, rootRight.left);
    }
    public static void main(String[] args) {
        BinaryTree.Node  root  = BinaryTree.createTree();
        dfs(root, root);

    }   
}
