class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer,Integer> freq = new HashMap<>();

        for (int i = 0; i< nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0) + 1);
          
        }
        for (int i = 0; i < bucket.length;i++){
              bucket[i] = new ArrayList();
        }

        for (Map.Entry<Integer,Integer> entry : freq.entrySet()){   
            bucket[entry.getValue()].add(entry.getKey());
        }

        int res[] = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && idx < k; i-- ){
            if (!bucket[i].isEmpty()){
                for (int num : bucket[i]){
                    res[idx++] = num;
                    } 
               }
        }   
        return res;

    }
}
