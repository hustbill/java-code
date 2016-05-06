package com.hustbill;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.twilio.sdk.TwilioRestException;

/**
1st round Validated Cell Phone Numbers:
3605532393 
2025550104 
2025550197 
2025550156 
2025550142 
2025550117 
2025550169 
Run time:  5988ms

2nd round Validated Cell Phone Numbers:  Using LRU Cache
3605532393 
2025550104 
2025550197 
2025550156 
2025550142 
2025550117 
2025550169 
Run time:  5145ms

 *
 */
public class App {
	public static void main(String[] args) throws TwilioRestException {
		
	        List<String> phoneNumbers = new ArrayList<String>();
	        phoneNumbers.add("360-553-2393");  // MOBILE
	        phoneNumbers.add("408.441.8300");  // LANDLINE
	        
	    
	        phoneNumbers.add("202-555-0142");
	        phoneNumbers.add("202-555-0104");
	        phoneNumbers.add("202-555-0197");
	        phoneNumbers.add("202-555-0156");
	        phoneNumbers.add("202-555-0117");
	        phoneNumbers.add("202-555-0169");
	        

	    
	        //Invalid phone numbers
	        phoneNumbers.add("(123) 456 7890");
	        phoneNumbers.add("555-541-1234");
	        phoneNumbers.add("12-12-111");
	        phoneNumbers.add("280 456 7890");
	        
	        List<String> phoneNumbers2 = new ArrayList<String>();
	        phoneNumbers2.add("360-553-2393");  // MOBILE
	        phoneNumbers2.add("408.441.8300");  // LANDLINE
	        
	    
	        phoneNumbers2.add("202-555-0142");
	        phoneNumbers2.add("202-555-0104");
	        phoneNumbers2.add("202-555-0197");
	        phoneNumbers2.add("202-555-0156");
	        phoneNumbers2.add("202-555-0117");
	        phoneNumbers2.add("202-555-0169");

	        System.out.println("1st round Validated Cell Phone Numbers:");
	        long startTime=System.currentTimeMillis(); 
	        
	        PhoneNumberValidator validator = new PhoneNumberValidator();
	        Set<PhoneNumber> set = validator.getValidaPhoneNumber(phoneNumbers);
	        for (PhoneNumber phoneNum : set) {
	        	long nationalNumber = phoneNum.getNationalNumber();
	            System.out.println(nationalNumber  + " " );
	        }
	        
	        long endTime=System.currentTimeMillis();

	        System.out.println("Run time:  "+(endTime-startTime)+"ms"); 
	        
	        System.out.println("\n2nd round Validated Cell Phone Numbers:");
	        startTime=System.currentTimeMillis();  
	        
	        set = validator.getValidaPhoneNumber(phoneNumbers2);
	        for (PhoneNumber phoneNum : set) {
	        	long nationalNumber = phoneNum.getNationalNumber();
	            System.out.println(nationalNumber  + " " );
	        }
	        
	        endTime=System.currentTimeMillis();  
	        System.out.println("Run time:  "+(endTime-startTime)+"ms"); 
	        
	    }	
}
