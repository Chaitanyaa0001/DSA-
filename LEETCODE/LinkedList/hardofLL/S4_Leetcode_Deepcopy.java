package LEETCODE.LinkedList.hardofLL;

import java.util.HashMap;

public class S4_Leetcode_Deepcopy {
    static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
    public  static Node  copyRandomList(Node head) {
        if(head == null){
            return head;
        }
      Node temp = head;
      HashMap<Node,Node> map = new HashMap<>();

      while(temp != null){
        map.put(temp,new Node(temp.val));
        temp = temp.next;
      }

      temp = head;
      while(temp != null){
        Node copy = map.get(temp);
        copy.next = map.get(temp.next);
        copy.random = map.get(temp.random);
        temp = temp.next;
      }
      return map.get(head);
    }

    private static  Node optimal(Node head){
        return head
    }
    public static void main(String[] args) {
        
    }
}
