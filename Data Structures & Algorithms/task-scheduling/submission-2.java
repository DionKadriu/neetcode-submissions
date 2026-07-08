class Solution {
    public int leastInterval(char[] tasks, int n) {
         Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : map.values()) {
            queue.offer(val);
        }
        int time = 0;
        Queue<Task> coolOff = new LinkedList<>();
        while (!queue.isEmpty() || !coolOff.isEmpty()){

            
            if (!queue.isEmpty()) {
                
                int remaining = queue.poll() - 1;
                time++;

                if (remaining > 0) {
                    coolOff.offer(new Task(remaining, time + n));
                }
            }
            else{
                time = coolOff.peek().time;
            }
            if (!coolOff.isEmpty() && coolOff.peek().time == time){
                queue.add(coolOff.poll().remaining);
            }
        }

        return time;
    }

    private static class Task{
        int remaining;
        int time;
        public Task(int rem, int time){
            this.remaining = rem;
            this.time = time;
        }
    }
}
