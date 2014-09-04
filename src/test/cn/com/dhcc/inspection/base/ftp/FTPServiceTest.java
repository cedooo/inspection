package test.cn.com.dhcc.inspection.base.ftp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.inspection.base.ftp.FTPService;
import cn.com.dhcc.inspection.collector.CollectConfig;

public class FTPServiceTest {

	@Test
	public void testDownloadLogs() {
		String ip = "10.24.60.167";
		CollectConfig ftpConfig = new CollectConfig();
		ftpConfig.setIp(ip);
		ftpConfig.setPort(21);
		ftpConfig.setUser("ftp");
		ftpConfig.setPasswd("ftp");
		ftpConfig.setRemoteFile("logs/");
		ftpConfig.setLocalFile("insLogs/"+ ip + "/");
		ftpConfig.setEncoding("GBK");
		System.out.println(ftpConfig);
		List<String> list = FTPService.downloadLogs(ftpConfig);
		for (String string : list) {
			System.out.println("ÏÂÔØÁË£º" + string);
		}
		assertEquals(true, list!=null&&list.size()>0);
	}

}
