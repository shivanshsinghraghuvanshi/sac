package com.ilab.safety.sac.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class twitterTester {
	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		twitter.getNewsFeed(1);
		twitter.follow(1, 2);
		twitter.postTweet(2, 6);
		twitter.getNewsFeed(1);
		twitter.unfollow(1, 2);
		twitter.getNewsFeed(1);
	}
}

class Twitter {

	/** Initialize your data structure here. */
	Map<Integer, User> userMap;

	public Twitter() {
		userMap = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!userMap.containsKey(userId)) {
			User user = new User();
			user.tweetList.add(tweetId);
			userMap.put(userId, user);
		} else {
			User user = userMap.get(userId);
			user.tweetList.add(tweetId);
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		User user = userMap.get(userId);
		if (user.tweetList.size() > 10) {
			return user.tweetList.subList(user.tweetList.size() - 10, user.tweetList.size() - 1);
		} else if (user.tweetList.size() <= 10 && user.tweetList.size() != 0) {
			return user.tweetList;
		} else {
			return null;
		}
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (!userMap.containsKey(followeeId)) {
			User user = new User();
			user.followersList.add(followerId);
			userMap.put(followeeId, user);
		} else {
			User user = userMap.get(followeeId);
			user.tweetList.add(followerId);
		}
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (userMap.containsKey(followeeId)) {
			User user = userMap.get(followeeId);
			if (user.followersList.contains(followerId)) {
				user.followersList.remove(Integer.valueOf(followerId));
			}
		}
	}
}

class User {
	public List<Integer> followersList;
	public List<Integer> tweetList;

	public User() {
		followersList = new LinkedList<Integer>();
		tweetList = new ArrayList<Integer>();
	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
