package com.hustbill;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.twilio.sdk.TwilioRestException;

/**
 * Main
 *
 */
public class App {
	public static void main(String[] args) throws TwilioRestException {
		
	        List<String> phoneNumbers = new ArrayList<String>();
	        phoneNumbers.add("360-553-2393");  // MOBILE
	        phoneNumbers.add("408.441.8300");  // LANDLINE
	   
	        //Invalid phone numbers
	        phoneNumbers.add("(123) 456 7890");
	        phoneNumbers.add("555-541-1234");
	        phoneNumbers.add("12-12-111");
	        phoneNumbers.add("280 456 7890");

	        System.out.println("Validated Cell Phone Numbers:");
	        
	        PhoneNumberValidator validator = new PhoneNumberValidator();
	        Set<PhoneNumber> set = validator.getValidaPhoneNumber(phoneNumbers);
	        for (PhoneNumber phoneNum : set) {
	        	long nationalNumber = phoneNum.getNationalNumber();
	            System.out.println(nationalNumber  + " " );
	        }	        
	    }	
}
