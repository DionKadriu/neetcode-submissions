class Solution {
    public int maxArea(int[] heights) {
        
        int i = 0;
        int j = heights.length - 1;
        int max = 0;
        while (i < j){
            int ma = Math.min(heights[i],heights[j]) * (j - i);
            max = Math.max(ma,max);

            if (heights[i] < heights[j]) {
                i++;
                }
            else{
                j--;
            }
        }
        System.gc();
        return max;
    }
}
