class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        for (int i = 0; i < intervals.length; i++){
            int interval [] = intervals[i];
            int n = list.size()-1;
            if (list.isEmpty() || list.get(n)[1] < interval[0]){
                list.add(interval);
            }
            else{
                list.get(n)[1] = Math.max(list.get(n)[1],interval[1]); 
            }
        }

        int res[][] = new int[list.size()][2];

        return list.toArray(new int[list.size()][2]);
    }
}
