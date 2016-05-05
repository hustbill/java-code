#NimbleRx technical challenge

##Q1 - JDK Implementation of Phone Number service
###Problem Statement
You are given a large collection of phone numbers (100K) to process. The phone numbers are US phone numbers. From these phone numbers, you will need to:

1) Determine if the phone number is a valid phone number (i.e. 555-541-1234 is not a valid phone number).

[Hua] use libphonenumber, Google’s open source phone number handling library, to properly format possible phone numbers for a given region, using length and prefix.


2) You will need to determine if the phone number is a cell phone.
[Hua] Use Twilio REST API Lookup

3) You will need to process this very quickly (another 100K phone numbers will come your way).
[Hua] Use multithread to validate the number,  also call Twilio REST API parallel

4) You will need to return a collection of phone number that are verified cell phone numbers.

5) You should think about how expensive it is to call Twilio and avoid it as much as possible until you are sure that you need to call Twilio (optimize before you call Twilio).

[Hua]  Use caching, so that for those duplicate numbers we validate using our caching. 
or using ElasticSearch. We will index and store the validated phone number into our ElasticSearch. 


6) The code must be written in Java.


###API Definition:
1) You can define a phone number class with the variables you feel are appropriate.

2) Assuming you name your class PhoneNumber, the API would look like public Set<PhoneNumber> getValidPhoneNumber(final Collection<String> phoneNumbers);


###Hints:
1) You should use as many features of JDK 6, 7, 8 as possible, it will make your life simple.
2) You should break this problem into smaller problems. There is a library for you to get information about a phone number including if it's valid. To figure out the type of phone number (i.e.), you'll need a service like Twilio. You're not expected to run 100K phone numbers against Twilio, I will know if the code works or not by looking at your implementation.

 
 
