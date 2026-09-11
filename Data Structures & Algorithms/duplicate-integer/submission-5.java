class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> holder = new HashSet<>();

        for (int num : nums){
            if (!holder.add(num))
            {
                return true;
            }
        }
        return false;
    }
}