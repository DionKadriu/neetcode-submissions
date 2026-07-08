class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r){
            int mh = (l + r)/2;
            long totalTime = 0;
            for (int p : piles){
                totalTime += Math.ceil((double) p / mh);
            }

            if (totalTime <= h){
                res = mh;
                r = mh-1;
            }
            else{
                l = mh +1;
            }
        }
        return res;
    }
}
