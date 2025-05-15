class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(){}

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int cache_size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache_size = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int ans = node.val;
            remove(node);
            Node new_node = new Node(key, ans);
            add(new_node);
            map.put(key, new_node);
            return ans;

        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            Node new_node = new Node(key, value);
            add(new_node);
            map.put(key, new_node);
        }
        else {
            if (map.size() == cache_size) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node new_node = new Node(key, value);
            add(new_node);
            map.put(key, new_node);
        }
    }

    void remove(Node node) {
        Node node_next = node.next;
        Node node_prev = node.prev;

        node_next.prev = node_prev;
        node_prev.next = node_next;
    }

    void add(Node node) {
        Node first_node = head.next;
        head.next = node;
        node.next = first_node;
        node.prev = head;
        first_node.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */