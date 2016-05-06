package com.hustbill;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

/**
 * Main
 *
 */
public class App {
	public static void main(String[] args) {
		
	        List<String> phoneNumbers = new ArrayList<String>();
	        phoneNumbers.add("360-553-2397");
	        phoneNumbers.add("408.441.8300");
	   
	        //Invalid phone numbers
	        phoneNumbers.add("(123) 456 7890");
	        phoneNumbers.add("555-541-1234");
	        phoneNumbers.add("12-12-111");
	        phoneNumbers.add("280 456 7890");

	        System.out.println("Validated Phone Numbers:");
	        PhoneNumberValidator validator = new PhoneNumberValidator();
	        Set<PhoneNumber> set = validator.getValidaPhoneNumber(phoneNumbers);
	        for (PhoneNumber phoneNum : set) {
	            System.out.println(phoneNum);
	        }
	        
	        //twilioLookup();
	    }

	
}
