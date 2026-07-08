class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int freq [] = new int [26];

        for (char c : tasks){
           freq[c - 'A']++;
        }

        PriorityQueue<Integer> taskq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
        );

        for (int num : freq){
            if (num > 0){
                taskq.offer(num);
            }
        }

    int time = 0;
    Queue<int[]> idle = new LinkedList();
    while (!taskq.isEmpty() || !idle.isEmpty()){
        time++;
        if (!taskq.isEmpty()){
            int rem = taskq.poll()-1;
            if(rem > 0){
                idle.offer(new int[]{rem , n + time});
            }
        }
        
        if (!idle.isEmpty() && time == idle.peek()[1]){
            taskq.offer(idle.poll()[0]);
        }
        
    }
    return time;
    }
}




