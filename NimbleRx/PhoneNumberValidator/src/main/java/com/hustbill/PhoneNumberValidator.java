/*
 * Phone Number Validator
 * 
 * Steps: 
 * 		1.Determine if the phone number is a valid phone number using Google's libphonenumber 
 * 		2.Determine if the phone number is a cell phone by Call Twilio Lookup API 
 * 
 * Date: 2016/05/05
 * 
 */
package com.hustbill;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.twilio.sdk.LookupsClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.lookups.PhoneNumber.Type;

public class PhoneNumberValidator {
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC180c23689eab0b992235e6d14a1efd91";
	public static final String AUTH_TOKEN = "7b290425b3a0d209bcbd74be314574ea";

	/*
	 * Get the type of a phone : Landline or Mobile by Twilio Lookup API. 
	 * 
	 * Twilio Lookup is a simple REST API with a ton of utility. Twilio
	 * https://www.twilio.com/lookup determine whether a phone is a landline or
	 * can receive text messages, and even discover information about the
	 * carrier associated with that phone number.
	 */
	public static String twilioLookup(PhoneNumber number) throws TwilioRestException {
		String strNum = String.valueOf(number.getNationalNumber());

		LookupsClient client = new LookupsClient(ACCOUNT_SID, AUTH_TOKEN);
		com.twilio.sdk.resource.instance.lookups.PhoneNumber phoneNumber = client.getPhoneNumber(strNum, true);

		return phoneNumber.getType().toString();
	}

	/* Determine if the phone number is a valid phone number using Google's libphonenumber
	 * 
	 * Google's common Java, C++ and JavaScript library for
	 * parsing, formatting, and validating international phone numbers.
	 */
	public static Set<PhoneNumber> getValidaPhoneNumber(final Collection<String> phoneNumbers) {
		Set<PhoneNumber> result = new HashSet<PhoneNumber>();
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		LRUCache cache = new LRUCache(1000);

		for (String usaNumberStr : phoneNumbers) {
			try {
				PhoneNumber usaNumberProto = phoneUtil.parse(usaNumberStr, "US");
				boolean isValid = phoneUtil.isValidNumber(usaNumberProto);
			
				if (isValid) {
					long key =  usaNumberProto.getNationalNumber();
					if (cache.get(key) != -1) {
						if (cache.get(key) == 1) {  // 1 - MOBILE
							result.add(usaNumberProto);
						}
					} else {
						if (twilioLookup(usaNumberProto) == "MOBILE") {
							result.add(usaNumberProto);
							cache.set(key, 1);
						} else {
							cache.set(key, 0);  // 0 - LANDLINE
						}
					}
				}				
			} catch (Exception e) {
				System.err.println("NumberParseException was thrown: " + e.toString());
			}
		}
		return result;
	}

}

/*
 * Ref: 1. https://github.com/googlei18n/libphonenumber Google's common Java,
 * C++ and JavaScript library for parsing, formatting, and validating
 * international phone numbers.
 * 
 * 2. https://www.twilio.com/docs/quickstart/php/lookups 3.
 * https://www.twilio.com/docs/api/lookups 4.
 * https://www.twilio.com/blog/2016/02/how-to-verify-phone-numbers-in-python-
 * with-the-twilio-lookup-api.html
 * 
 * curl -XGET
 * https://lookups.twilio.com/v1/PhoneNumbers/+13605532393/?Type=caller-name \
 * -u 'AC180c23689eab0b992235e6d14a1efd91:7b290425b3a0d209bcbd74be314574ea'
 * 
 * curl -XGET
 * https://lookups.twilio.com/v1/PhoneNumbers/+15108675309/?Type=carrier&Type=
 * caller-name \ -u
 * 'AC180c23689eab0b992235e6d14a1efd91:7b290425b3a0d209bcbd74be314574ea'
 * 
 * curl -XGET
 * https://lookups.twilio.com/v1/PhoneNumbers/+13605532393/?Type=carrier&Type=
 * caller-name \ -u
 * 'AC180c23689eab0b992235e6d14a1efd91:7b290425b3a0d209bcbd74be314574ea'
 */