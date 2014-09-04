package cn.com.dhcc.inspection.analysis.rules.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.dhcc.inspection.analysis.rules.AnalysisRules;
import cn.com.dhcc.inspection.analysis.rules.log.factory.LogRulesFactory;

public class LogRulesService {

	public List<AnalysisRules> getRulesByIPAndLog(String logPath) {
		if( logPath==null){
			return null;
		}else{
			List<AnalysisRules> listRules = new ArrayList<AnalysisRules>();
			if(logPath.endsWith("df.log")){
				listRules.addAll(LogRulesFactory.getDfLogRules());
			}else if(logPath.endsWith("ifconfig.log")){
				listRules.addAll(LogRulesFactory.getIfconfigLogRules());
			}else if(logPath.endsWith("file-nr.log")){
				listRules.addAll(LogRulesFactory.getFileNrLogRules());
			}else if(logPath.endsWith("ping_inner.log") || logPath.endsWith("ping_outer.log")){
				listRules.addAll(LogRulesFactory.getPingLogRules());
			}else if(logPath.endsWith("sar.log")){
				listRules.addAll(LogRulesFactory.getSarLogRules());
			}
			return listRules;
		}
	}

}
