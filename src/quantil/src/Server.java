public class Server {
	private int cpu1;
	private int cpu2;
	private String ip;
	private String logPath;
	
	public Server(String ip) {
		this.ip = ip;
	}
	
	public Server (String ip, int cpu1, int cpu2) {
		this.ip = ip;
		this.cpu1 = cpu1;
		this.cpu2 = cpu2;
	}
	
	public String getIp () {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getCPU1() {
		return cpu1;
	}
	
	public int getCPU2() {
		return cpu2;
	}
	
	public void setCPU(int cpu1, int cpu2) {
		this.cpu1 = cpu1;
		this.cpu2 = cpu2;
	}
	
	public void setLogPath(String path) {
		this.logPath = path;
	}
	
	public String getLogPath() {
		return logPath;
	}
}
