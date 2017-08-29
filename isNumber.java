/**
 Wepay coding questions:
 8/29/2017 9:30 am - 10:30 am
 * Returns true if the provided String is a number, or false if it is not
 *
 * 1 => true
 * b => false
 * 1-1=> false ?
 * 001 => true
 * 6000000000000000 => true
 * We are handling positive integers.
 *  -1 => true
 * 0.12 =>true
 * 1/2 => false
 * s1 => false
 * .1 => true
 * .1. => false
 * -1-1 => false
 *
 **/
public boolean isNumber(String input) {
    // Implementation here
   boolean dotflag = false;

    // check the minus sign
   if (!Character.isDigit(input.charAt(0)) && intput.charAt(0) != '-'')  {
       return false;
   }

   for (char c : input.substring(1).toCharArray()) {
       if (!Character.isDigit(c)) {
           if (c == '.' && !dotflag) { // check the . position
               dotflag = true;
               continue;
           }
       }
      return false;
   }
   return true;
}
