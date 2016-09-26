

import java.util.Random;
import java.util.Date;
import java.io.FileWriter;

public class Generator {
	private Server[] servers;
	private long startTime;

	public Generator(Server[] servers,  Date date) {
		this.servers = servers;
		this.startTime = date.getTime() / 1000L;
	}
	
	public void generateAllData() {
		System.out.println("content");
		for (int i = 0; i < servers.length; i++) {
			generateDataPerServer(servers[i]);
		}
	}
	
	public void generateDataPerServer(Server server) {
		String content = generateDailyData(server);

		writeIntoFile(content, server);
	}
	
	private String generateDailyData(Server server) {
		String logPerServer = "";
		Random rand = new Random();
		for (int i = 0; i < 86400; i += 60) {
			logPerServer += (startTime + i) + " " + server.getIp()
				+ " 0 " + rand.nextInt(101) + "\n";
			logPerServer += (startTime + i) + " " + server.getIp()
			+ " 1 " + rand.nextInt(101) + "\n";
		}
		System.out.println(server.getIp() + "'s Data is genrating");
		return logPerServer;
	}
	
	private void  writeIntoFile(String content, Server server) {
		try {
			String path = server.getLogPath(); 
			FileWriter fw = new FileWriter(path, true);
			fw.write(content);
			fw.flush();
			fw.close();
		} catch(Exception e) {
			System.out.println(e.toString());
			return;
		}
	}

}
