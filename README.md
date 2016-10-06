Java concept and coding questions
=================================


##Version history
Init   Date: July 5, 2014   
Update Date: March 25, 2015  
Update Date: May 20, 2016
Update Date: June 16, 2016 for design twitter 

## Java Data format 

### Stream

### Real-time data analysis
Using Tableau, Grafana and IndexDB

### Design Twitter

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:  

**postTweet(userId, tweetId)**: Compose a new tweet.  
**getNewsFeed(userId)**: Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.  

**follow(followerId, followeeId)**: Follower follows a followee.  
**unfollow(followerId, followeeId)**: Follower unfollows a followee.  

#### Example:  ####

```java
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
```

### Feedback  

If you find a issue or more optimial solution,  feel free to email me.  

Thanks, Hua :-)  

Email: billyzhang2010@gmail.com 
