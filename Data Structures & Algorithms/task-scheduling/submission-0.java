class Solution {
    public int leastInterval(char[] tasks, int n) {

    PriorityQueue<Integer> taskq = new PriorityQueue<>(
       (a,b ) -> Integer.compare(b,a)
    );
    int freq[] = new int[26];

    for (char c : tasks){
        freq[c - 'A']++;
    }
    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0) {
            taskq.offer(freq[i]);
        }
    }
    Queue<int[]> idle = new LinkedList();
    int cpu = 0;

    while (!taskq.isEmpty() || !idle.isEmpty()){
        cpu++;
        if (!taskq.isEmpty()){
            int rem = taskq.poll()-1;

            if (rem > 0){
                idle.add(new int[]{rem,cpu + n});
            }
        }
        if (!idle.isEmpty() && idle.peek()[1]==cpu){
            taskq.offer(idle.poll()[0]);
        }
    }
    return cpu;

    }
}

class Pair{

char c;
int count;

Pair(char c , int count){
    this.c = c;
    this.count = count;
}

}
