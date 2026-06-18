package LEETCODE.trees.easy;

import LEETCODE.trees.BinaryTree;
import java.util.*;;

public class S4_SIngleStackToIMplement {
    static class pair {
        BinaryTree.Node node; 
        int value;
        pair(BinaryTree.Node node, int value){
            this.node = node;
            this.value = value;
        }
    }
    private static void allinone(BinaryTree.Node root){
        List< Integer> preorder = new ArrayList<>();
        List< Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        Stack<pair> stack = new Stack<>(); 

        stack.push(new pair(root, 1));

        while (!stack.isEmpty()) {
            pair p  = stack.peek();

            if(p.value == 1){
                preorder.add(p.node.data);
                p.value++;
                if(p.node.left != null){
                    stack.push(new pair (p.node.left,1));
                }
            }else if(p.value == 2){
                inorder.add(p.node.data);
                p.value++;
                if(p.node.right != null){
                    stack.push(new pair(p.node.right, 1));
                }
                
            }else if(p.value == 3){
                postorder.add(p.node.data);
                p.value++;
                if(p.node.right != null){
                    stack.push(new pair(p.node.right, 1));
                }
            }
        }
    }
    public static void main(String[] args) {
        allinone(null);
        
    }
}
