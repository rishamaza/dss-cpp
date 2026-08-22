class LRUCache {

    class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        void jodo(Node naklihead) {
            this.next = naklihead.next;
            this.prev = naklihead;
            naklihead.next.prev = this;
            naklihead.next = this;
        }

        void hatao() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.hatao();    
            node.jodo(head);  
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value; 
            node.hatao();
            node.jodo(head);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                lru.hatao();
                map.remove(lru.key);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            node.jodo(head);
        }
    }
}