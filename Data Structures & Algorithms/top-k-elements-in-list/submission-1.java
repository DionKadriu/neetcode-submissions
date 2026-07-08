class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap(); 
        for (int i =0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
PriorityQueue<Integer> queue = new PriorityQueue((a,b)->
{return Integer.compare(map.get(b),map.get(a));});
        
        queue.addAll(map.keySet());
        int res []= new int[k];

        for (int i =0; i< k; i++){
            res[i] = queue.poll();
        }
        return res;
    
    }
}
