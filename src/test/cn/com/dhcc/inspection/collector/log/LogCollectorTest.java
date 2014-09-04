package test.cn.com.dhcc.inspection.collector.log;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.inspection.collector.CollectConfig;
import cn.com.dhcc.inspection.collector.cnf.CnfFactory;
import cn.com.dhcc.inspection.collector.log.LogCollector;

public class LogCollectorTest {
	
	//@Test
	public void testDoCollect() throws Exception {
		CollectConfig config = new CollectConfig();
		config.setIp("10.24.60.167");
		config.setEncoding("GBK");
		config.setLocalFile("insLogs/10.24.60.167/");
		config.setPasswd("ftp");
		config.setUser("ftp");
		config.setPort(21);
		config.setRemoteFile("logs/");
		LogCollector logCol = new LogCollector();
		logCol.doCollect(config);
	}
	@Test
	public void testDoCollectByCnf() throws Exception {

		List<CollectConfig> listCollConf = CnfFactory.getCollectConf();
		LogCollector logCol = new LogCollector();
		for (CollectConfig config : listCollConf) {
			logCol.doCollect(config);
		}
		
	}

}
