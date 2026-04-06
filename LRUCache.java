
//The approach is to use a doubly linked list to keep track of the order of usage of the cache entries and a hash map 
//to store the key-node pairs for O(1) access. When we access a key, we move the corresponding node to the front of the linked list 
//to mark it as most recently used. When we need to evict an entry, we remove the node at the end of the linked list, 
//which is the least recently used entry.
import java.util.*;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;

    }

    public void put(int key, int value) {

        if (map.containsKey(key))
            remove(map.get(key));
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
        if (map.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

    }
}
