package leetcode.medium;

/**
 * 
Design a simplified version of Twitter where users can post tweets, 
follow/unfollow another user and is able to see the 10 most recent tweets in 
the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's 
news feed. Each item in the news feed must be posted by users who the user 
followed or by the user herself. Tweets must be ordered from most recent to
least recent.

follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 *
Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);

 */

import java.util.*;
public class Twitter {
    /** Initialize your data structure here. */
	Map<Integer, List<Integer>> map;
    public Twitter() {
        List<Integer> list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(map.containsKey(userId)) {
        	map.get(userId).add(tweetId);
        }
        else {
        	List<Integer> list = new ArrayList<>();
        	list.add(tweetId);
        	map.put(userId, list); 
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        return map.get(userId);
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if(!map.containsKey(followerId)) {
    		List<Integer> list = new ArrayList<>();
        	map.put(followerId, list);
    	}
    	if(!map.containsKey(followeeId)) {
    		List<Integer> list = new ArrayList<>();
        	map.put(followeeId, list);
    	}
        map.get(followerId).addAll(map.get(followeeId));
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        map.get(followerId).removeAll(map.get(followeeId));
    }
    
    public static void main(String[] args) {
    	
    	Twitter twitter = new Twitter();

    	// User 1 posts a new tweet (id = 5).
    	twitter.postTweet(1, 5);

    	// User 1's news feed should return a list with 1 tweet id -> [5].
    	twitter.getNewsFeed(1);

    	// User 1 follows user 2.
    	twitter.follow(1, 2);

    	// User 2 posts a new tweet (id = 6).
    	twitter.postTweet(2, 6);

    	// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
    	// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    	twitter.getNewsFeed(1);

    	// User 1 unfollows user 2.
    	twitter.unfollow(1, 2);

    	// User 1's news feed should return a list with 1 tweet id -> [5],
    	// since user 1 is no longer following user 2.
    	twitter.getNewsFeed(1);
    	 
    }
}
