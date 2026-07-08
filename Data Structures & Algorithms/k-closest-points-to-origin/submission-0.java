class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
            (a,b)-> Integer.compare(euclidean(a[0],a[1]),
            euclidean(b[0],b[1])
            ));


            for (int [] point : points){
                queue.offer(point);
            }

            int res[][]= new int[k][k];

            for (int i = 0; i< k;i++){
                res[i] = queue.poll();
            }
            return res;


    }

    public int euclidean(int x, int y){

        return (int) (Math.pow(x,2) + Math.pow(y,2));
    }
}
