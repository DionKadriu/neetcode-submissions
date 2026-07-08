class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length * 2;
        int res[] = new int[len];
        int pos = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < nums.length; j++){
                res[pos++] = nums[j];
            }
        }
        return res;
    }
}