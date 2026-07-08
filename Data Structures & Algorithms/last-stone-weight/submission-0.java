class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> queue = new PriorityQueue<>(
        (a,b) -> Integer.compare(b,a)
       );

        for (int stone : stones){
            queue.offer(stone);
        }

        int i = queue.size()-1;

        while (queue.size() > 1){
            int x = queue.poll();
            int y = queue.poll();

            if (x == y){
                continue;
            }
            else{
                queue.offer(Math.abs(x-y));
            }
        }
        return queue.size()==0? 0 : queue.poll();
    }
}


//**


