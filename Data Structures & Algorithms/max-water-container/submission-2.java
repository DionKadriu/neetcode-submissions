class Solution {
    public int maxArea(int[] heights) {
    int n = heights.length;

    int i = 0;
    int j = n - 1;
    int res = 0;

    while (i < j){

        int height = Math.min(heights[i],heights[j]);
        System.out.print("h "+height);
        System.out.print("index "+(j-i));
        System.out.println();
        int area = height * (j-i);
        

        res = Math.max(area,res);

        if (heights[j] > heights[i]){
            i++;
        }
        else{
            j--;
        }

    }    
    return res;
    }
}
