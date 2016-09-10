package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

import java.util.regex.*;

class Particle {
    int speed = 0;
    public Particle(int speed) {
        this.speed = speed;
    }
}

public class Solution {

	/*
	 * Complete the function below.
	 */

	   
	    static String[] animate(int speed, String init) {
	        List<List<Particle>> lists = new ArrayList<>();
	        List<String> res = new ArrayList<>();
	        
	        for (int i = 0; i < init.length(); i++) {
	            lists.add(new ArrayList<>());
	            char c = init.charAt(i);
	            if (c == 'R') {
	                lists.get(i).add(new Particle(speed));
	            } else if (c == 'L'){
	                lists.get(i).add(new Particle(-speed));
	            }
	        }
	        
	        while(checkRemain(lists)) {
	            res.add(convert(lists));
	            lists = nextStep(lists);
	        }
	        res.add(convert(lists));
	        String[] result = new String[res.size()];
	        int index = 0;
	        for (String s : res) {
	            result[index++] = s;
	        }
	        return result;
	    }

	    private static List<List<Particle>> nextStep(List<List<Particle>> lists) {
	       List<List<Particle>> res = new ArrayList<>();
	       for (int i = 0; i< lists.size(); i++) {
	           res.add(new ArrayList<>());
	       }
	       for (int i = 0; i < lists.size(); i++) {
	           List<Particle> list = lists.get(i);
	           for (Particle p : list) {
	               int nextPos = i + p.speed;
	               if (nextPos < 0 || nextPos >= lists.size()) {
	                   continue;
	               }
	               res.get(nextPos).add(new Particle(p.speed));
	           }
	       }
	        return res;
	    }


	    private static boolean checkRemain(List<List<Particle>> lists) {
	        for (List<Particle> list : lists) {
	            if (!list.isEmpty()) {
	                return true;
	            }
	        }
	        return false;
	    }


	    private static  String convert(List<List<Particle>> lists) {
	        StringBuilder sb = new StringBuilder();
	        for (List<Particle> list : lists) {
	            if (list.isEmpty()) 
	                sb.append('.');
	            else 
	                sb.append('X');
	        }
	        return sb.toString();
	    }


	public static void main(String[] args) throws IOException {

		// int speed = 2;
		// String init = "..R....";

		int speed = 3;
		String init = "RR..LRL";

		String[] res = animate(speed, init);

		for (int res_i = 0; res_i < res.length; res_i++) {

			System.out.println(String.valueOf(res[res_i]));

		}
	}

}
