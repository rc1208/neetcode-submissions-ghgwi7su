class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;
    int timestamp;
    public Twitter() {
        followMap = new HashMap();
        tweetMap = new HashMap();
        timestamp=0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        Set<Integer> following;
        if (tweetMap.containsKey(userId)) {
            List<Tweet> tweets = tweetMap.get(userId);
            tweets.add(new Tweet(tweetId, timestamp));
        } else {
            List<Tweet> tweets = new ArrayList();
            tweets.add(new Tweet(tweetId, timestamp));
            tweetMap.put(userId, tweets);
        }

        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.ts, b.ts));

        // fetch userId's tweets first
        if (tweetMap.containsKey(userId)) {
            
            List<Tweet> ownTweets = tweetMap.get(userId);
            for (int j=0; j< ownTweets.size(); j++) {
                Tweet tweet = ownTweets.get(j);
                pq.add(tweet);

                if (pq.size() > 10) pq.poll();
            }
        }
        
        
        
        if (followMap.containsKey(userId)) {
            Set<Integer> following = followMap.get(userId);
            for (Integer followingPerson: following) {
            // System.out.println("following: " + following);

            // QUICK FIX: Skip if the followee is the user themselves to prevent duplication
            if (followingPerson == userId) {
                continue;
            }
            if (tweetMap.containsKey(followingPerson)) {
                List<Tweet> tweets = tweetMap.get(followingPerson);
                for (int j=0; j< tweets.size(); j++) {
                    Tweet tweet = tweets.get(j);
                    pq.add(tweet);

                    if (pq.size() > 10) pq.poll();
                }
            }  
          }
        }
        

        List<Integer> ans = new ArrayList();

        while(!pq.isEmpty()) {
            Tweet poppedTweet = pq.poll();
            ans.add(poppedTweet.tweetId);
        }

        Collections.reverse(ans);

        return ans;


    }
    
    public void follow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            Set<Integer> following = followMap.get(followerId);
            following.add(followeeId);
        } else {
            Set<Integer> following = new HashSet();
            following.add(followeeId);
            followMap.put(followerId, following);
        }

        // System.out.println("followeeId " + followeeId);
        // System.out.println("followerId " + followMap.get());
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            Set<Integer> following = followMap.get(followerId);
            following.remove(followeeId);
        } 

        return;
    }
}

class Tweet {
    int tweetId;
    int ts;

    public Tweet(int tweetId, int ts) {
        this.tweetId = tweetId;
        this.ts = ts;
    }
}


/*
followMap
userID -> [list of followers]

top10Map
userId -> [heap with tweets ordered by tweetId]

tweetMap
userId -> [list of tweets by user]


getNewsFeed(userId)

1. given userId, fetch followers
2. For each followers, go thru their list of tweets
3. keep pushing to minHeap. If at any point, minHeap.size() > 10, pop()




*/
