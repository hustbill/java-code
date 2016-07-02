package microsoftOTS;

import java.util.*;

public class RearrangeLetters {

	public static void main(String[] args) {
		RearrangeLetters csr = new RearrangeLetters();
		//String[] inputs = { "aaabc", "aa", "aadfggggg", "aacccccccccdf", "aaaaaabbcc" , "$$aaa&&&bbcc", "aabbbccddee", "$$aaa&&bbcc"};
		String[] inputs = { "aadfggg"};

		for (String input : inputs)
			System.out.println(csr.rearrange(input.toCharArray()));
		
	}

	static boolean rearrange(char[] ar) {

        if (ar.length < 2) return true;

        int s = 0; // source;

        char last = ar[s++];
        int t = 1; // destination - first char already there

        char postponed = '?'; // buffer is empty it this value is ignored
        int nPostponed = 0;

        while (s < ar.length || nPostponed > 0) {

            // is character in postponed buffer ?
            if (nPostponed > 0 && postponed != last) {
                // Remove from postponed buffer
                ar[t++] = postponed;
                --nPostponed;
                last = postponed;
            } else {
                if ( ! (s < ar.length) ) {
                    // no more to take from
                    return false;
                }
                char c = ar[s++];
                if (c != last) {
                    ar[t++] = c;
                    last = c;
                } else {
                    // so it must equals postponed if the later is not empty
                    // Add to postponed buffer
                    ++nPostponed;
                    postponed = c;
                }
            }
        }

        return true;
    }

}
