class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> 
        Integer.compare(map.get(b),map.get(a)));

        queue.addAll(map.keySet());

        int res[] = new int[k];
        int idx = 0;
        while (k > 0){
            res[idx++] = queue.poll(); 
            k--;
        }
        return res;
    }
}
