package LEETCODE.LinkedList.doubleLinkedlist;

public class ArrayintoDll {
    static class Node {
        int data;
        Node next;
        Node back;
        Node(int data, Node next, Node back){
            this.data = data;
            this.next = next;
            this.back = back;
        }
        Node(int data){
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }
    public static Node arraytodll (int [] arr){
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i = 1; i < n;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next =  temp;
            prev = prev.next;
        }
        return head;
    }

    public static void printal(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        int[] arr ={2,3,4,5,6};

        Node head = arraytodll(arr);
        printal(head);
       
    }
}
