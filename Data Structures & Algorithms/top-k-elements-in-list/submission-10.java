class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums){
            counter.put(num, counter.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        pq.addAll(counter.entrySet());

        int res[] = new int[k];

        for (int i = 0; i < k && !pq.isEmpty(); i++){
            res[i] = pq.poll().getKey();
        }

        return res;
    }
}
