class Twitter {
    private int timeStamp = 0;

    private class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Queue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Pehle khud ke tweets heap mein daalo
        if (tweetMap.containsKey(userId)) {
            maxHeap.addAll(tweetMap.get(userId));
        }

        // User jin-jin ko follow karta hai, unke tweets bhi Heap mein daalo
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followees) {
            if (tweetMap.containsKey(followeeId)) {
                maxHeap.addAll(tweetMap.get(followeeId));
            }
        }
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            res.add(maxHeap.poll().id);
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        // Apne aap ko follow karne ki zaroorat nahi
        if (followerId == followeeId)
            return;

        followMap.putIfAbsent(followerId, new HashSet<>());
        // FollowerId ke Set mein followeeId add karo
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            // followerId ke Set se followeeId remove karo
            followMap.get(followerId).remove(followeeId);
        }
    }
}
