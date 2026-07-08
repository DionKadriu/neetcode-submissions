class LRUCache {
    
    int capacity;
    Map <Integer, Node>cache ;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        cache = new HashMap<>(); 
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if (cache.containsKey(key)){

            Node n = cache.get(key);
            n.value = value;
            cache.put(key,n);
            remove(n);
            add(n);
            
        }
        else{
            Node newNode = new Node(key,value);
            if(cache.size() >= capacity){
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            cache.put(key,newNode);
            add(newNode);
        }

    }

    public void add(Node node){
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public void remove(Node node){
        Node previous = node.prev;
        Node next = node.next;
        previous.next = next;
        next.prev = previous;
    }

    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
