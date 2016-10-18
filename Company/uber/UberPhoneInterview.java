/*

UberPhoneInterview.java
Date: April 26, 2016 11:00 am - 12:00pm

Q1. Implement a rate limiter   attribute/decoration/annotation on top of an API endpoint. 
caps to N requests per minute with a rolling window (implement from scratch / test / compiling + working code) 
  // -user login to system (remember login)
  // -for one min - record count in table , if > 35 disable user 
  // - 2 database (one for read , other for write)
  // - if you scale the system, you can use a cache (redis)
  
  Ref: http://stackoverflow.com/questions/8775079/how-to-rate-limit-an-api
https://www.glassdoor.com/Interview/Q2-Implement-a-rate-limiter-attribute-decoration-annotation-on-top-of-an-API-endpoint-caps-to-N-requests-per-minute-with-QTN_1075051.htm
 [Answer]

 use a queue+ Choose time granularity ... on incoming request try to consume balance... dequeue , replenish balance + enqueue new values.
 OR enqueue a time for incoming request while queue 1 minute ago.

 Interview Candidate on Aug 5, 2015
  
  
Q2.  Coin counting problem:
    //  Given a unlimited number of coins of a certain denomination (i.e - 1, 3, 5, 10 25), print out all the ways that you can count up to a number n.
     
    //  For example: n = 7
    //  1, 1, 5
    //  3, 1, 1, 1, 1


Failed!


*/    
    
    public class AProgram {
        private static boolean ready;
        private static int number;
        private static class ReaderThread extends Thread {
            public void run() {
                while (!ready)
                    Thread.yield();
                System.out.println(number++);
            }
        }
        public static void main(String[] args) {
            new ReaderThread().start();
            number = 10;
            ready = true;
        }
    }
    
    /*10
    11
    12
    13
    14
    15
    16
    17
    
    10
    10
    10
    10
    10
    10*/
    
    
    // Implement rate-limiting tweet feature
    // -user login to system (remember login)
    // -for one min - record count in table , if > 35 disable user 
    // - 2 database (one for read , other for write)
    // - if you scale the system, you can use a cache (redis)
    
    // message passing (latency, overhead), if a machine goes down.
    
    //  1 master  n workers 
    //  count i for each worker,  1 master it has total count.
     
     
    //  Coin counting problem:
    //  Given a unlimited number of coins of a certain denomination (i.e - 1, 3, 5, 10 25), print out all the ways that you can count up to a number n.
     
    //  For example: n = 7
    //  1, 1, 5
    //  3, 1, 1, 1, 1, etc:
     
     // List<List<Integer>> result 
     // input size : 
     public class Solution {
         
        // int[] arr = {1, 3, 5, 10, 25};
         public List<List<Integer>> findComb(int[] arr, int n) {
             List<List<Integer>> res = new ArrayList<List<Integer>>();
             Arrays.sort(arr);
             helper(res, new ArrayList<Integer>(), arr, n, 0);
             
             return res;
         }
         
         public void helper( List<List<Integer>> res, List<Integer> cur, int[] arr, int target, int start) {
             if (target > 0)  {
                 for (int i = start;  i < arr.length && target >= arr[i]; i++) {
                     cur.add(arr[i]);
                     helper(res, cur, arr, target - arr[i], i);
                     cur.remove(cur.size() - 1);
                 }
             } else if (target == 0) {
                 res.add(new ArrayList<Integer>(cur));
             }
         }
     }
     
