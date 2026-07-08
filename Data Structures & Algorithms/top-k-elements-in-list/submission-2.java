class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();

        PriorityQueue<Map.Entry<Integer,Integer>> queue =
         new PriorityQueue<>((a,b) ->  Integer.compare(
            b.getValue(),a.getValue()
         ));

        for (int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        queue.addAll(map.entrySet());

        int res []= new int[k];
        k--;
        while (k>=0){
            res[k--] = queue.poll().getKey();
        }

        return res;
    }
}
