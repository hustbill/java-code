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


public class PhoneNumberTest {
    public static void main(String[] args) {

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("360-553-2397");
        phoneNumbers.add("408.441.8300");
   
        //Invalid phone numbers
        phoneNumbers.add("(123) 456 7890");
        phoneNumbers.add("555-541-1234");
        phoneNumbers.add("12-12-111");
        phoneNumbers.add("280 456 7890");

        System.out.println("Validated Phone Numbers:");
        Set<PhoneNumber> set = getValidaPhoneNumber(phoneNumbers);
        for (PhoneNumber phoneNum : set) {
            System.out.println(phoneNum);
        }
    }

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
}