class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = 0;
        for (int pile : piles){
            max = Math.max(pile, max);
        }

        int l = 1;
        int r = max;

        while (l <= r){
            int mid = l + (r - l) / 2;

            if (correctHours(piles,h,mid)){
                max = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return max;

    }
    public boolean correctHours(int piles[], int h, int num){
        long hours = 0;
        for (int pile : piles){
             hours += Math.ceil((double) pile /num);
        }
        return hours <= h;
    }
}


