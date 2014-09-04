package cn.com.dhcc.inspection.collector.cnf.sqlmap;

public class InspectionCollConf {
	private String id = null;
	private String ip = null;
	private int port = -1;
	private String user = null;
	private String passwd = null;
	private String localFile = null;
	private String remoteFile = null;
	private String encoding = null;
	private String logFiles = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getLocalFile() {
		return localFile;
	}
	public void setLocalFile(String localFile) {
		this.localFile = localFile;
	}
	public String getRemoteFile() {
		return remoteFile;
	}
	public void setRemoteFile(String remoteFile) {
		this.remoteFile = remoteFile;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getLogFiles() {
		return logFiles;
	}
	public void setLogFiles(String logFiles) {
		this.logFiles = logFiles;
	}
	@Override
	public String toString() {
		return "InspectionCollConf [id=" + id + ", ip=" + ip + ", port=" + port
				+ ", user=" + user + ", passwd=" + passwd + ", localFile="
				+ localFile + ", remoteFile=" + remoteFile + ", encoding="
				+ encoding + "]";
	}
	
	
}
