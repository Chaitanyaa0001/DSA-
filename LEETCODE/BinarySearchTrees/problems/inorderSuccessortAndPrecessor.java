package LEETCODE.BinarySearchTrees.problems;

import LEETCODE.trees.BinaryTree;
import java.util.*;

public class inorderSuccessortAndPrecessor {
    private static void dfsInorder(BinaryTree.Node root,List<Integer> ans){
        if(root == null){
            return ;
        }
        dfsInorder(root.left, ans);
        ans.add(root.data);
        dfsInorder(root.right, ans);
    }
    private static List<Integer> bruteforcr(BinaryTree.Node root , int key){
        List<Integer> ans = new ArrayList<>();
        dfsInorder(root, ans);
        int[] arr = new int[ans.size()];
        int i = 0;
        for(int val : ans){
            arr[i++] = val;
        }
        int low = 0, high = arr.length - 1;
       while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (ans.get(mid) == key) {
                int pre = (mid > 0) ? ans.get(mid - 1) : -1;
                int succ = (mid < ans.size() - 1) ? ans.get(mid + 1) : -1;
            
                return Arrays.asList(pre, succ);
            }
            else if (ans.get(mid) < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return new ArrayList<>();
    }


    private static List<Integer> optimal(BinaryTree.Node root,int key){
        if(root == null){
            return new ArrayList<>();
        }
        BinaryTree.Node succ = null;
        BinaryTree.Node pre = null;
        while (root != null) {
            if(key < root.data){
                succ = root;
                root = root.left;
            }else if( key > root.data){
                pre = root;
                root = root.right;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(pre.data);
        ans.add(succ.data);
        return ans;

    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        bruteforcr(root, 0);

    }
}
