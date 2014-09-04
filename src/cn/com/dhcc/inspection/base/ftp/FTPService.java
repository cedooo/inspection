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
	 * �ɼ�log�ļ�
	 * @return ���سɹ�����־�ļ�����
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
				log.info("��¼ʧ��:" + ftpConfig);
			}
		} catch(NoRouteToHostException e){
			log.info("Զ���������ɴ����ǽ�赲��·��down");
		}  catch (ConnectException connE){
			log.info("����ftp��ʱ");
		} catch (SocketException e) {
			log.info("��¼FTP�쳣");
		} catch(UnknownHostException  e){
			log.info("�������ɴ�");
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				ftpDelegate.logout();
			} catch (IOException e) {
				log.debug("ftp �˳�ʱ���ִ���");
			}
		}
		return listFileName;
	}
}
