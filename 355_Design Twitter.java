
public class Twitter {
public int timestamp=0;
public Map<Integer, User> mapUser;
//sigle linkedlist
public class Tweet{
    public int time;
    public int tweetid;
    public Tweet next;
    
    public Tweet(int tweetid){
        this.tweetid = tweetid;
        time = timestamp++;
        next = null;
    }
}


public class User{
    public int userid;
    public Set<Integer> followed;
    public Tweet tweethead;
    
    public User(int userid){
        this.userid = userid;
        followed = new HashSet<>();
        followed.add(userid);
        tweethead = null;
    }

    
    public void follow(int userid){
        followed.add(userid);
    }
    
    public void unfollow(int userid){
        followed.remove(userid);
    }
    
    public void postTweet(int tweetid){
        Tweet newtweet = new Tweet(tweetid);
        newtweet.next = tweethead;
        tweethead = newtweet;
    }
    
}
    /** Initialize your data structure here. */
    public Twitter() {
        mapUser = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!mapUser.containsKey(userId)){
            User temp = new User(userId);
            mapUser.put(userId, temp);
        }
        mapUser.get(userId).postTweet(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if(!mapUser.containsKey(userId)){
            return result;
        }
        
        Set<Integer> followeeId = mapUser.get(userId).followed;
        //maxHeap
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(new Comparator<Tweet>(){
            @Override
            public int compare(Tweet t1, Tweet t2){
                return t2.time - t1.time;
            }
        });
        
        for(int uid : followeeId){
            Tweet t = mapUser.get(uid).tweethead;
            if(t != null){
                pq.add(t);
            }
        }
        
        int count = 0;
        while(!pq.isEmpty() && count < 10){
            Tweet t = pq.poll();
            result.add(t.tweetid);
            count++;
            if(t.next != null){
                pq.add(t.next);
            }
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!mapUser.containsKey(followerId)){
            User temp = new User(followerId);
            mapUser.put(followerId, temp);
        }
        if(!mapUser.containsKey(followeeId)){
            User temp = new User(followeeId);
            mapUser.put(followeeId, temp);
        }
        mapUser.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!mapUser.containsKey(followerId) || followerId == followeeId){
            return;
        }
        mapUser.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
