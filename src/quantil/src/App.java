/**
 * 
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huazhang
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DateFormat  dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		int numOfServers = 0;
		
		try {
			System.out.println("Enter a data(yyyy/MM/dd) : \n");
			String s = br.readLine();
			date = dateFormat.parse(s);
			System.out.println("Enter the number of Servers need be initialized : \n");
			numOfServers = Integer.parseInt(br.readLine());
		} catch(Exception e) {
			System.out.println("Error: " + e.toString());
			System.out.println("Please try again");
		}
		
		  System.out.println("现在的日期是 = " + date.toString()); 
		System.out.println(numOfServers);
		Server[] servers = initializeServers(numOfServers, date);
		generateLogData(servers,date);
	}

	// generate the log
	/*
	 * Please write a simulator to generate the logs for one day, say
	 * 2014-10-31, just use random numbers between 0% to 100% as CPU usage. The
	 * generator should write data to files in a directory. The timestamp is
	 * Unix time.
	 */
	public static Server[] initializeServers(int num, Date date) {
		System.out.println("initializeServers");
		Initialization serverInit = new Initialization(num, date);
		return serverInit.getServers();
	}
	
	public static void generateLogData(Server[] servers, Date date) {
		System.out.println("generateLogData");
		Generator dataGenerator = new Generator(servers, date);
		dataGenerator.generateAllData();
		
	}

}
