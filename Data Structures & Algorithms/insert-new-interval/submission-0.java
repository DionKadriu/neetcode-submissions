class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int len = intervals.length;
        int pos = 0;
        List<int[]> res = new ArrayList();
        
        while (pos < len && newInterval[0] > intervals[pos][1]){
            res.add(intervals[pos]);
            pos++;
        }

        while (pos < len &&  newInterval[1] >= intervals[pos][0]){
            newInterval[0] = Math.min(newInterval[0],intervals[pos][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[pos][1]);
            pos++;
        }
        res.add(newInterval);

        while (pos < len){
            res.add(intervals[pos]);
            pos++;
        }

        int r [][] = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++){
            r[i] = res.get(i);
        }
    
        return r;
    }
}
