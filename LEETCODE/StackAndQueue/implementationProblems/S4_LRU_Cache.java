package LEETCODE.StackAndQueue.implementationProblems;

import java.util.HashMap;

public class S4_LRU_Cache {

    static class Node {
        // data of array 
        int key;
        int value;
        // pointers 
        Node next;
        Node prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    class LRUCache {

        int capacity;
        HashMap<Integer, Node> map;
        Node head = new Node(-1,-1); 
        Node tail = new Node(-1,-1); 

        void insert(Node temp){

        }

        void delete(Node temp){

        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }
            Node node = map.get(key);
            delete(node);
            insert(node);
            return node.value;
        }

        public void put(int key, int value) {
        
        }

    }
    public static void main(String[] args) {
        // we neeed to initialize lru capacity to a positive interger capacity 
        //  1- get function     return value of the key if key exist otherwise return 1 
        // 2- Update the value of the key if the key exists. Otherwise, 
        // add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
        //  evict the least recently used key.
    }
}
