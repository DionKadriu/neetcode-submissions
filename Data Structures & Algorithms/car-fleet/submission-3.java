class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        Track[] tracks = new Track[len];

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < len; i++){
            tracks[i] = new Track((double)position[i],(double)speed[i]);
        }

        Arrays.sort(tracks, (a,b) -> Double.compare(b.pos, a.pos));

        for (Track track : tracks){
            
            double time = (target - track.pos) / track.spd;

            if (stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }

        }

        return stack.size();
        
    }

    private class Track{
        double pos;
        double spd;

        public Track(double pos, double spd){
            this.pos = pos;
            this.spd = spd;
        }
    }
}
