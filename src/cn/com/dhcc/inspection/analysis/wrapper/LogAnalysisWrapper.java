package cn.com.dhcc.inspection.analysis.wrapper;

import java.util.ArrayList;
import java.util.List;

import cn.com.dhcc.inspection.analysis.impl.LogAnalysis;
import cn.com.dhcc.inspection.analysis.result.AnalysisResult;
import cn.com.dhcc.inspection.analysis.rules.AnalysisRules;
import cn.com.dhcc.inspection.analysis.rules.service.LogRulesService;

public class LogAnalysisWrapper {
	/**
	 * 根据日志路径得到结果
	 * @param logPath
	 * @return
	 */
	public static List<AnalysisResult> getResult(String logPath){
		List<AnalysisResult> listResult = new ArrayList<AnalysisResult>();
		LogRulesService service = new LogRulesService();
		List<AnalysisRules> listRules = service.getRulesByIPAndLog(logPath);

		LogAnalysis analy = new LogAnalysis();
		analy.setFileURI(logPath);
		try {
			analy.addAllRules(listRules);
			listResult.addAll(analy.doAnalysis());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listResult;
	}
}
