package LEETCODE.LinkedList.hardofLL;

import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S3_Swap_Nodes_Leetcode {

    private  static Node  reverse(Node head){
        Node temp = head;Node prev = null;
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return temp;
    }

    public Node swapPairs(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node t1 = head;
        Node prev = null;
        while(t1 != null){
            Node t2 = t1.next;
            if(t2 == null){
                prev.next = t1;
                break;
            }
            Node nextNode = t2.next;
            t2.next = null;
            reverse(t1);
            if(t1 == head){
                head = t2;
            }else{
                prev.next = t2;
            }

            prev = t1;
            t1 = nextNode;
        }
        return head;

    }
    public static void main(String[] args) {
        
    }
}
