class Solution {
    public int longestConsecutive(int[] nums) {
    
    int max = 0;
    Set<Integer> set = new HashSet();
    int res = 0;
    
    for (int num : nums){
        set.add(num);
    }

    for(int num : nums){

    int curr = num;
    max = 0;

    while (set.contains(curr)){
        curr++; 
        max++;
    }
    

    res = Math.max(res,max);
    }
    return res;
    }
}
