class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

       
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.getValue(), a.getValue()));
         
        queue.addAll(counter.entrySet());
        
        int result [] = new int[k];
        
        for (int i = 0; i < k; i++){
            result[i] = queue.poll().getKey();
        }
        return result;

    }
}
