class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();

        for (int num : nums){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue((a,b) ->
         Integer.compare(freq.get(a),freq.get(b)));


        for (Map.Entry<Integer,Integer> entry : freq.entrySet()){

            queue.add(entry.getKey());
            if (queue.size() > k){
                queue.poll();
            }
        }
        

        int res[] = new int[k];

        for (int i = 0; i < k; i++){
            res[i] = queue.poll();
        }

        return res;
    }
}
