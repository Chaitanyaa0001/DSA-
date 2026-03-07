package LEETCODE.LinkedList.mediumquesofLL;

import java.util.HashMap;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S12_Leetcode_InterSectionOFLinkedList {
    private static Node brute(Node head1, Node head2){
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp1 = head1;
        while(temp1 != null){
            map.put(temp1,1);
            temp1 = temp1.next;
        }
        temp1 = head2;
        while(temp1 != null){
            if(map.containsKey(temp1)){
                return temp1;
            }
            temp1 = temp1.next;
        }
        return null;
    }
    private static Node helpercollisonPoint(Node heada, Node headb, int d){
        while (d != 0) {
            d--;
            headb = headb.next;
        }
        while (heada != null && headb != null) {
            if(heada == headb){
                return heada;
            }
            heada = heada.next;
            headb = headb.next;
        }
        return null;  
    }
    private static Node betterApproch(Node headA, Node headB){
        Node t1 = headA , t2 = headB; 
        int n1 = 0, n2 = 0;
        while (t1 != null) {
            n1++;
            t1 = t1.next;
        }
        while (t2 != null) {
            n2++;
            t2 = t2.next;
        }
        if(n1 < n2){
            // smaller, bigger, distance 
            return helpercollisonPoint(headA, headB, n2 - n1);
        }else{
            return helpercollisonPoint(headB, headA,  n1 - n2);
        }
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Node Head = LinkedListUtil.arrayToLinkedList(arr);

    }
}