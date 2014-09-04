package cn.com.dhcc.inspection.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.com.dhcc.inspection.collector.CollectConfig;
import cn.com.dhcc.inspection.collector.cnf.CnfFactory;
import cn.com.dhcc.inspection.collector.log.LogCollector;

public class CollectJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		List<CollectConfig> listCollConf = CnfFactory.getCollectConf();
		LogCollector logCol = new LogCollector();
		try {
			for (CollectConfig config : listCollConf) {
					logCol.doCollect(config);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
