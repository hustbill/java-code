1. 第一题
You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces, brackets, and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses validator.
Let's say:

'(', '{', '[' are called "openers."
')', '}', ']' are called "closers."

Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.

Examples:

"{ [ ] ( ) }" should return True
"{ [ ( ] ) }" should return False
"{ [ }" should return False
"{a''**bc}" should return True


public boolean checkValid(String s) {
    static final Map<Character, Character> map  = 
        new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };
        
      // pre-operate 
    // remove abc from {abc}
    for (char c : s) {
        if ( Character.isLetterOrDigit(c)) {
            ....
        }
        
    }    
    // s from  orig to {} 
    // s.subString(... )
    // regular express
    // only remain six:  () {} and []
    Stack<Character> st = new Stack<>();
    
    for (char c : s.toCharArray()) {
        if (map.containsKey(c) {
            st.push(c); // push "openers"
        } else if (st.isEmpty() || map.get(st.pop()) != c) {
            return false;
        }
    }
    return st.isEmpty();
}





## 第二题
We are building a twitter clone, but focusing on one endpoint

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