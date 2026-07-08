class Twitter {

    HashMap<Integer,HashSet<Integer>> userUser;
    HashMap<Integer,List<Pair>> userTweet;
    int time = 0;


    public Twitter() {
      userUser = new HashMap();
      userTweet = new HashMap();  
    }
    
    public void postTweet(int userId, int tweetId) {
        
        userTweet.computeIfAbsent(userId,k ->
         new ArrayList<Pair>()).add(new Pair(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> users = userUser.getOrDefault(userId, new HashSet<>());
        users.add(userId);
        PriorityQueue<Pair> queue = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.timestamp,a.timestamp)
        );

        for (Integer user : users){
            
            if (userTweet.containsKey(user)){
                queue.addAll(userTweet.get(user));
            }
           
        }
        List<Integer> result = new ArrayList();
        for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
            result.add(queue.poll().id);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        userUser.computeIfAbsent(followerId,k ->
         new HashSet<>()).add(followeeId); 
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userUser.containsKey(followerId)){
            userUser.get(followerId).remove(followeeId);
        }
    }

    private class Pair{
        Integer id;
        Integer timestamp;

        public Pair(Integer id, Integer timestamp){
            this.id = id;
            this.timestamp = timestamp;
        }
        
    }
}




///
// Users Map -> id , List<Integer> followeeId

//





////

