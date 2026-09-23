class LRUCache {
    
    Map<Integer, Node> map;
    int max;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        max = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) return -1;
        remove(n);
        add(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
            return;
        }
        if (map.size() >= max) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        add(newNode);
    }

    // insert right after head (most recently used)
    private void add(Node n) {
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
    }

    // unlink node from anywhere in the list
    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
