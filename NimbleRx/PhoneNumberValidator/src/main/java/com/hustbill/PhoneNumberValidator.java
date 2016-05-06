package com.hustbill;

/*
Desc: Phone Number Validator
Date: 2016/05/04
Complie & Run:
javac -cp "./lib/libphonenumber-7.3.2.jar" PhoneNumberTest.java
java -cp  ".:./lib/libphonenumber-7.3.2.jar"  PhoneNumberTest
*/
import java.util.*;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.ShortNumberInfo;


public class PhoneNumberValidator {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC180c23689eab0b992235e6d14a1efd91";
    public static final String AUTH_TOKEN = "7b290425b3a0d209bcbd74be314574ea";
      
        

    public static Set<PhoneNumber> getValidaPhoneNumber(final Collection<String> phoneNumbers) {
        Set<PhoneNumber> result = new HashSet<PhoneNumber>();
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

        for(String usaNumberStr : phoneNumbers) {
            try {
                PhoneNumber usaNumberProto = phoneUtil.parse(usaNumberStr, "US");
                boolean isValid = phoneUtil.isValidNumber(usaNumberProto);
                if (isValid) {
                    result.add(usaNumberProto);
                }
            } catch (Exception e) {
                System.err.println("NumberParseException was thrown: " + e.toString());
            }
        }
        return result;
    }
    /*
        Twilio Lookup is a simple REST API with a ton of utility. 
        Twilio https://www.twilio.com/lookup
        You can use Lookup to check whether a number exists, 
        format international numbers to local standards, 
        determine whether a phone is a landline or can receive text messages, 
        and even discover information about the carrier associated with that phone number.
    */
   /* public static void twilioLookup() throws TwilioRestException, UnsupportedEncodingException {
        LookupsClient client = new LookupsClient(ACCOUNT_SID, AUTH_TOKEN);

        String nationalNumber = URLEncoder.encode("(510) 867-5309", "UTF-8")
            .replaceAll("\\+", "%20");
        PhoneNumber number = client.getPhoneNumber(nationalNumber, "US", true);

        System.out.println(number.getType());
        System.out.println(number.getCarrierName());
    }
       */
}

/*
    Ref: 
    1. 
    1. https://www.twilio.com/docs/api/lookups
    2. https://www.twilio.com/blog/2016/02/how-to-verify-phone-numbers-in-python-with-the-twilio-lookup-api.html

curl -XGET https://lookups.twilio.com/v1/PhoneNumbers/+13605532393/?Type=caller-name \
-u 'AC180c23689eab0b992235e6d14a1efd91:7b290425b3a0d209bcbd74be314574ea'

 curl -XGET https://lookups.twilio.com/v1/PhoneNumbers/+15108675309/?Type=carrier&Type=caller-name \
-u 'AC180c23689eab0b992235e6d14a1efd91:7b290425b3a0d209bcbd74be314574ea'

 curl -XGET https://lookups.twilio.com/v1/PhoneNumbers/+13605532393/?Type=carrier&Type=caller-name \
-u 'AC180c23689eab0b992235e6d14a1efd91:7b290425b3a0d209bcbd74be314574ea'
*/