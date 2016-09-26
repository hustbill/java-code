
import java.util.*;
import java.io.File;


public class Initialization {
	private Server[] servers;
	private Set<String>  ipSet;
	private File logPath;
	
	public Initialization(int num, Date date ) {
		servers  = new Server[num];
		ipSet = new HashSet<String>();
		logPath = new File("serverLog_" + date.getTime()/1000L);
		logPath.mkdir();
		serversGenerator();
	}
	
	public Server[] getServers() {
		return servers;
	}
	
	private void serversGenerator() {
		System.out.println("serversGenerator");
		Random rand = new Random();
		File file;
		for (int i = 0; i < servers.length; i++) {
			String ip = "";
		
			do {
				ip = (rand.nextInt(256)) + "." + (rand.nextInt(256)) +"." 
						+ (rand.nextInt(256)) + "." + (rand.nextInt(256));
			} while (!ipSet.add(ip));
			servers[i] = new Server(ip);
			file = new File(logPath, ip + ".txt");
			try {
				file.createNewFile();
				servers[i].setLogPath(file.getPath());
			} catch (Exception e) {
				System.out.println(e.toString());
				return;
			}
		}
	}
}
