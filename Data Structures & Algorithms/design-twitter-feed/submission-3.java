class Twitter {

 private static int timestamp = 0;

    private Map<Integer, List<Tweet>> tweetsMap;
    private Map<Integer, Set<Integer>> followersMap;

    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        tweetsMap = new HashMap<>();
        followersMap = new HashMap<>();
    }

    // Post a new tweet
    public void postTweet(int userId, int tweetId) {
        tweetsMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new Tweet(tweetId, timestamp++));
    }

    // Get the 10 most recent tweets in the user's news feed
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add the user's own tweets
        if (tweetsMap.containsKey(userId)) {
            for (Tweet tweet : tweetsMap.get(userId)) {
                maxHeap.offer(tweet);
            }
        }

        // Add the tweets from followees
        if (followersMap.containsKey(userId)) {
            for (int followeeId : followersMap.get(userId)) {
                if (tweetsMap.containsKey(followeeId)) {
                    for (Tweet tweet : tweetsMap.get(followeeId)) {
                        maxHeap.offer(tweet);
                    }
                }
            }
        }

        // Get the top 10 tweets
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll().id);
            count++;
        }

        return result;
    }

    // Follow a user
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) { // Can't follow self
            followersMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }
    }

    // Unfollow a user
    public void unfollow(int followerId, int followeeId) {
        if (followersMap.containsKey(followerId)) {
            followersMap.get(followerId).remove(followeeId);
        }
    }
}
