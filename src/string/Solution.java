package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

import java.util.regex.*;

public class Solution {

	static String[] animate(int speed, String init) {
		return new String[2];
	}

	public static void main(String[] args) throws IOException {
		
		res = animate(_speed, _init);

		for (int res_i = 0; res_i < res.length; res_i++) {

			bw.write(String.valueOf(res[res_i]));

			bw.newLine();

		}
	}
	
	public static void read(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		final String fileName = System.getenv("OUTPUT_PATH");

		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

		String[] res;

		int _speed;

		_speed = Integer.parseInt(in.nextLine().trim());

		String _init;

		try {

			_init = in.nextLine();

		} catch (Exception e) {

			_init = null;

		}

		res = animate(_speed, _init);

		for (int res_i = 0; res_i < res.length; res_i++) {

			bw.write(String.valueOf(res[res_i]));

			bw.newLine();

		}

		bw.close();

	}

}
