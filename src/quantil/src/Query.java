import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Query {
	String query;
	String ip, cpu, logPath;
	String startDate, endDate;
	String startTime, endTime;
	String[] querySplit;

	private Set<Long> result = new HashSet<>();
	private HashMap<String, String> timeUsage = new HashMap<>();
	private List<String> usage = new LinkedList<>();
	private SortedSet<Long> timeStamp = new TreeSet<>();

	/*
	 * e.g. QUERY 192.168.1.10 1 2014-10-31 00:00 2014-10-31 00:05
	 */
	public Query(String path, String[] querySplit) throws ParseException {
		this.logPath = path;
		this.querySplit = querySplit;
		this.ip = querySplit[1];
		this.cpu = querySplit[2];
		this.startDate = querySplit[3];
		this.startTime = querySplit[4];
		this.endDate = querySplit[5];
		this.endTime = querySplit[6];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = args[0];

		while (sc.hasNextLine()) {
			String query = sc.nextLine();
			if (query.equals("EXIT")) {
				System.exit(0); // It will exit the tool
			} else {
				try {
					String[] params = query.split(" ");
					Query q = new Query(path, params);
					q.parseFile(path, q.ip, q.cpu, q.startDate + " "+  q.startTime, q.endDate + " " + q.endTime);
					q.printResult(q.ip);
					
				} catch (Exception e) {
					System.out.println("Please input valid query ");
				}
			}
		}
	}

	/*
	 * ParseFile method returns the logs of a specific sever's CPU usage which
	 * is queried
	 */
	private void parseFile(String path, String ip, String cpu, String startTime, String endTime) throws ParseException {
		System.out.println("parseFile " + "start : " + startTime + " end :"  + endTime);
		String cpuUsage;
		long start = stringToUnixDate(startTime).getTime() / 1000;
	
		long end = stringToUnixDate(endTime).getTime() /1000;
		
		try {
			FileInputStream fileReader = new FileInputStream(path + "/" + ip + ".txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
			String line = "";
			long timeSection;
			int ipCount = 0;
			int ipFalse = 0;
			while ((line = bufferedReader.readLine()) != null) {

				String str = line;
				String[] parts = str.split(" ");
				timeSection = Integer.parseInt(parts[0]);	
				
			
				cpuUsage = parts[3];
				ipCount++;
				// stores the usage and timestamp in an array
				if (line.contains(" " + ip + " ") && line.contains(" " + cpu + " ") && timeSection >= start 
						&& timeSection < end) {
					System.out.println("start = " + start + " timeSection = " +  timeSection + " end = " +  end );
					result.add(timeSection);
					timeStamp.add(timeSection);  //Stores the timestamps found corresponding to query IP
					usage.add(cpuUsage);
				} else {
					ipFalse++;  // Checks if ip found in log file and increments the counter if not found
				}
			}
			if (ipCount == ipFalse) {
				System.out.println("IP or timestampe not found in logs");
			}
			bufferedReader.close();
			fileReader.close();  
			System.out.println("ipCount : " + ipCount + "\n");
			System.out.println(timeStamp);
		} catch (Exception e) {
			System.out.println("parseFile failed");
		}
	}

	

	// convert date and time in given  yyyy-MM-dd HH:mm to unix Timestamp
	private static Date stringToUnixDate(String date) throws ParseException  {    
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date time = dateFormat.parse(date);
	
		return time;
	}
	
	
	//Converts unix timestamp tp Date and Time in format yyyy-MM-dd H:mm
		private static String unixToDate(long unix_timestamp) throws ParseException {    
			long timestamp = unix_timestamp * 1000;
			Date date = new Date(timestamp);     
			Format sdf = new SimpleDateFormat("yyyy-MM-dd H:mm");
			String formatdate;
			formatdate= sdf.format(date);
			return formatdate;
		}
		
	// print the query result on console
	public void printResult(String ip) {
		
		if (timeStamp.isEmpty()) {
			return;
		} else {
			System.out.println("CPU usage on " + ip + ":");
			Iterator <Long> it1 = timeStamp.iterator();
			Iterator <String> it2 = usage.iterator();
			int count = 0;
	
			while(it1.hasNext() && it2.hasNext()) {
				// //Timestamp and usage corresponding to the server IP and cpu id
				System.out.print("(" + it1.next() + ", " + it2.next() + "%),");
				count++;
			}
			System.out.println("\n");
			System.out.println("count : " + count + "\n");
		}
	}
	// /Users/huazhang/git/java-code/src/quantil
}
