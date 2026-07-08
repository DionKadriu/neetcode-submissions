class Solution {
    public int[] getConcatenation(int[] nums) {
        int res [] = new int[nums.length * 2];
        int pos = 0;
        int index = 0;
        boolean did = false;
        while (index < nums.length){
            res[pos++] = nums[index++];
            if(index == nums.length && !did){
                did = true;
                index = 0;
            }
        }
        return res;
    }
}