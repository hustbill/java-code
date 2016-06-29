/*
Q2: We are building a twitter clone, but focusing on one endpoint

GET /tweets

which returns a json array tweets from users I follow ordered by timestamp. Following is a one way relationship, I could be following you, but that doesn't mean you are following me. When we say ordered by timestamp we mean the most recent tweets among all the users I follow will be on top and less recent tweets will appear below it.

For example, suppose I'm a user following @dan, @john, and @lisa then when I login I would expect to see something like:

@john - "politics is depressing" (10 seconds ago)
@john - "i can't believe trump is winning!" (20 mins ago)
@lisa - "anyone want to grab sushi tonight #hungry" (25 mins ago) 
@dan - "hello world" (35 mins ago)
@lisa - "hey" (40 mins ago)
@john - "just started watching the debate" (1 hr ago)
...
and so on

1) If I wanted to represent this in a relational database what tables would I need? What fields would they have? Don't worry too much about optimizing/scaling at this point.


2) The original API route returned all tweets, how would you update the API to provide a paginated experience? So the first fetch by the client should retrieve 100 tweets, then the next fetch should retrieve the next 100, and so on.


3) We start seeing issues with performance as our app grows to ... 100s of thousands of users. Our very simple app design is as below

Multiple Frontend Clients --> 1 JSON API Server --> 1 SQL Database Server

How would you go about debugging the performance issues and what sorts of things would you do to improve upon it?
*/
package dianmian;

public class CollectiveHealthQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
