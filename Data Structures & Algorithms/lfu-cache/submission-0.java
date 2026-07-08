class LFUCache {

    Map<Integer, Node> nodes = new HashMap<>();
    Map<Integer, DDList> freq = new HashMap<>();
    int minFreq = 0;
    int size = 0;
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node n = nodes.get(key);
        if (n == null) return -1;
        touch(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        Node n = nodes.get(key);
        if (n != null){
            n.value = value;
            touch(n);
            return;
        }
        if (capacity == size){
            DDList oldDDL = freq.get(minFreq);
            Node removed = oldDDL.removeLast();
            nodes.remove(removed.key);
            size--;
        }
        
        Node newNode = new Node(key,value);
        nodes.put(key,newNode);
        freq.computeIfAbsent(1, k -> new DDList()).add(newNode);
        minFreq = 1;
        size++;
    }

    public void touch(Node n){
        DDList oldDDL = freq.get(n.freq);
        oldDDL.remove(n);
        if (n.freq == minFreq && oldDDL.size == 0){
            minFreq++;
        }
        n.freq++;
        freq.computeIfAbsent(n.freq, k -> new DDList()).add(n);
    }


    private static class Node{
        int key;
        int value;
        int freq = 1;
        Node next;
        Node prev;

        Node(int k , int v){
            this.key = k;
            this.value = v;
        }
    }
    private static class DDList{

        Node head;
        Node tail;
        int size;

        DDList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        public void add(Node n){
             Node first = head.next;
            n.next = first;
            n.prev = head;
            head.next = n;
            first.prev = n;   // or: n.next.prev = n;
            size++;
        }
        public void remove(Node n){
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = n.prev = null;
            size--;
        }
        public Node removeLast(){
            Node n = tail.prev;
            remove(n);
            return n;
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */