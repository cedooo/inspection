package cn.com.dhcc.inspection.base.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.log4j.Logger;

import cn.com.dhcc.inspection.collector.CollectConfig;

public class FTPDelegate {
	private static Logger log = Logger.getLogger(FTPService.class.getClass());
	static final private int TIME_OUT = 30*1000;
	private static final int MAX_FILE_SIZE = 20*1024*1024;    //文件最大：20M
	private CollectConfig ftpConfig = null;
	private FTPClient ftpClient = new FTPClient();
	
	public CollectConfig getFtpConfig() {
		return ftpConfig;
	}
	public void setFtpConfig(CollectConfig ftpConfig) {
		this.ftpConfig = ftpConfig;
	}
	/**
	 * 登入
	 * @param ip IP 地址
	 * @param port 端口
	 * @param user 用户名
	 * @param passwd 密码
	 * @throws IOException 
	 * @throws SocketException 
	 */
	public boolean login() throws SocketException, IOException{
		ftpClient.setDataTimeout(TIME_OUT);
		ftpClient.connect(ftpConfig.getIp(), ftpConfig.getPort());
		ftpClient.setControlEncoding(ftpConfig.getEncoding());
		ftpClient.login(ftpConfig.getUser(), ftpConfig.getPasswd());
		log.debug("ftp replyString " + ftpClient.getReplyString());
		return ftpClient.getReplyCode()==230;
	}
	/**
	 * 登出
	 * @throws IOException 
	 */
	public void logout() throws IOException{
		if(ftpClient!=null && ftpClient.isConnected()){
			this.ftpClient.disconnect();
		}
	}
	/**
	 * 下载文件
	 * @param filter 过滤器
	 * @return
	 */
	public List<String> downloadFile(FTPFileFilter filter){
		List<String> listFileName = new ArrayList<String>();
		try {
			OutputStream output = null;
			ftpClient.enterLocalPassiveMode();
			FTPFile[] ftpFiles = null;
			if(filter!=null){
				ftpFiles = ftpClient.listFiles(ftpConfig.getRemoteFile(), filter);
			}else{
				//ftpFiles = ftpClient.listFiles(ftpConfig.getRemoteFile());
				return listFileName;
			}
			for (FTPFile ftpFile : ftpFiles) {
				if(ftpFile.isFile() && ftpFile.getSize() < MAX_FILE_SIZE){
					try{
						String lcaDir = ftpConfig.getLocalFile() + ftpFile.getName();
						File file = new File(ftpConfig.getLocalFile() );
						if(!file.exists() && !file.isDirectory()){
							file.mkdirs();
						}
						output = new FileOutputStream(lcaDir);
						boolean retrieve = ftpClient.retrieveFile(ftpConfig.getRemoteFile() + ftpFile.getName(), output);
						if(retrieve){
							log.info("下载" + ftpFile.getName() + "成功");
							listFileName.add(ftpFile.getName());
						}else{
							log.info("下载" + ftpFile.getName() + "失败");
						}
					}finally{
						if(output!=null){
							output.close();
						}
					}
				}else {
					continue;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listFileName;
	}
	
}
