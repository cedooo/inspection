package cn.com.dhcc.inspection;

import java.util.List;

import org.apache.log4j.Logger;

import cn.com.dhcc.inspection.collector.CollectConfig;
import cn.com.dhcc.inspection.collector.cnf.CnfFactory;
import cn.com.dhcc.inspection.collector.log.LogCollector;

public class DoIt {
	private static Logger log = Logger.getLogger(DoIt.class.getClass());
	
	public static void main(String[] args) {
		List<CollectConfig> listCollConf = CnfFactory.getCollectConf();
		LogCollector logCol = new LogCollector();
		for (CollectConfig config : listCollConf) {
			try {
				log.info("ִ�мƻ�: " + config);
				logCol.doCollect(config);
			} catch (Exception e) {
				log.warn("�����쳣");
			}
		}
		
	}
}
