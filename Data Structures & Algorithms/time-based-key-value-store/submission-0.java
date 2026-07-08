class TimeMap {

    HashMap<String, List<Pair<Integer,String>>> map = new HashMap();

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(
            timestamp,value
        ));
    }
    
    public String get(String key, int timestamp) {
        
        List<Pair<Integer,String>> values = map.getOrDefault(
            key, new ArrayList<>());
            int left = 0; int right = values.size()-1;
            String res = "";

            while (left <= right){
                int mid = (right + left)/2;
                if (values.get(mid).key <= timestamp){
                    res = values.get(mid).value;
                    left = mid +1;
                }
                else {
                    right = mid -1;
                }
            }

            return res;
    }

    private static class Pair<K,V>{
        final K key;
        final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
