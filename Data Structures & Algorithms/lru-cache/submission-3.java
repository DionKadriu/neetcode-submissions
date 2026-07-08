class LRUCache {

    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        head.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node != null){
            remove(node);
            add(node);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null){
            Node newNode = new Node(key,value);
            if (cache.size() >= capacity){
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            cache.put(key,newNode);
            add(newNode);
        }
        else{
            remove(node);
            node.value = value;
            add(node);
        }
    }

    public void add(Node n){
        Node headNext = head.next;
        n.next = headNext;
        headNext.prev = n;
        head.next = n;
        n.prev = head;
    }
    public void remove(Node n){
        Node previous = n.prev;
        Node next = n.next;
        previous.next = next;
        next.prev = previous;
    }

    private class Node{

        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }
}
