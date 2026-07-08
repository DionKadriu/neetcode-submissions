class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet();
        for (int num:nums){
            set.add(num);
        }
        int currNum = 0;
        int longest = 0;

        for (int num : nums){

            currNum = num;
      
            if (!set.contains(num - 1)){
                      int count = 0;
                while (set.contains(currNum)){
                    currNum++;
                    count++;
                }
                longest = Math.max(longest, count);
            }

   
         
        }
        return longest;
    }
}
