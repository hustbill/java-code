
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class LogParser {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = "input_1.txt";
		if (args.length > 0) {
			filename = args[0];
		}

		String answer = parseFile(filename);
		System.out.println(answer);
	}

	static String parseFile(String filename) throws FileNotFoundException, IOException {
		/*
		 * Don't modify this function
		 */
		BufferedReader input = new BufferedReader(new FileReader(filename));
		List<String> allLines = new ArrayList<String>();
		String line;
		while ((line = input.readLine()) != null) {
			allLines.add(line);
		}
		input.close();

		return parseLines(allLines.toArray(new String[allLines.size()]));
	}

	static String parseLines(String[] lines) {
		/*
		 *
		 * Your code goes here
		 *
		 */
		Stack<Date> connectStack = new Stack<Date>();
		Stack<Date> stack = new Stack<Date>();

		int total = 0, connect = 0;
		for (String line : lines) {
			String[] parts = line.split("::");
			String timeStamp = parts[0].trim();
			Date date = new Date();
			DateFormat sdf = new SimpleDateFormat("(MM/dd/yyyy-HH:mm:ss)");

			try {
				date = sdf.parse(timeStamp);
				String key = parts[1].trim();

				if (key.equals("CONNECTED")) {
					connectStack.push(date);
				} else {
					if (key.equals("DISCONNECTED")) {
						Date top = connectStack.pop();
						connect += minutesDiff(top, date);
					}
				}
				if ( connectStack.size() > 0 &&  key.equals("SHUTDOWN")) {
					Date top = connectStack.pop();
					connect += minutesDiff(top, date);
				}

				if (key.equals("START")) {
					stack.push(date);
				} else {
					if (key.equals("SHUTDOWN")) {
						Date top = stack.pop();
						total += minutesDiff(top, date);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		float percentage = (float) connect / total * 100;
		return String.valueOf((int) percentage) + "%";
	}

	public static int minutesDiff(Date earlierDate, Date laterDate) {
		if (earlierDate == null || laterDate == null)
			return 0;

		return (int) ((laterDate.getTime() / 60000) - (earlierDate.getTime() / 60000));
	}
}