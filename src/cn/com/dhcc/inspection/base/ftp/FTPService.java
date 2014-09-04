package cn.com.dhcc.inspection.base.ftp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.dhcc.inspection.collector.CollectConfig;

public class FTPService {
	private static Logger log = Logger.getLogger(FTPService.class.getClass());
	/**
	 * 采集log文件
	 * @return 下载成功的日志文件名称
	 */
	static public List<String> downloadLogs(CollectConfig ftpConfig){
		
		FTPDelegate ftpDelegate = new FTPDelegate();	
		
		ftpDelegate.setFtpConfig(ftpConfig);
		
		List<String> listFileName = new ArrayList<String>();
		try {
			boolean loginSuccess = ftpDelegate.login();
			if(loginSuccess){
				listFileName.addAll(ftpDelegate.downloadFile(ftpConfig.getFtpFileFilter()));
			}else{
				log.info("登录失败:" + ftpConfig);
			}
		} catch(NoRouteToHostException e){
			log.info("远程主机不可达：防火墙阻挡或路由down");
		}  catch (ConnectException connE){
			log.info("连接ftp超时");
		} catch (SocketException e) {
			log.info("登录FTP异常");
		} catch(UnknownHostException  e){
			log.info("主机不可达");
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				ftpDelegate.logout();
			} catch (IOException e) {
				log.debug("ftp 退出时出现错误");
			}
		}
		return listFileName;
	}
}
