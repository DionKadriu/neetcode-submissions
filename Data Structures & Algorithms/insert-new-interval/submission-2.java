class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<>();
        int len = intervals.length;
        int pos = 0;
        while (pos < len && intervals[pos][1] < newInterval[0]){
            list.add(intervals[pos]);
            pos++;
        }

        while (pos < len && intervals[pos][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[pos][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[pos][1],newInterval[1]);
            pos++;
        }
        list.add(newInterval);
        while (pos < len){
            list.add(intervals[pos]);
            pos++;
        }

        return list.toArray(new int[list.size()][2]);
    }
}
