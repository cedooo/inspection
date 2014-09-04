package test.cn.com.dhcc.inspection.analysis.log.rules;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.inspection.analysis.impl.LogAnalysis;
import cn.com.dhcc.inspection.analysis.result.AnalysisResult;
import cn.com.dhcc.inspection.analysis.rules.AnalysisRules;
import cn.com.dhcc.inspection.analysis.rules.service.LogRulesService;

public class RulesServiceImplTest {

	@Test
	public void testGetRulesByIPAndLog() {
		String[] los = {
				"insLogs/10.24.60.167/ping_inner.log",
				"insLogs/10.24.60.167/ping_outer.log", 
				"insLogs/10.24.60.167/df.log", 
				"insLogs/10.24.60.167/file-nr.log",
				"insLogs/10.24.60.167/ifconfig.log"
				};
		int ram = (int)(Math.random()*100%4);
		String logPath = los[ram];
		LogRulesService ms = new LogRulesService();
		List<AnalysisRules> listRules = ms.getRulesByIPAndLog(logPath);

		LogAnalysis analy = new LogAnalysis();
		analy.setFileURI(logPath);
		try {
			analy.addAllRules(listRules);
			System.out.println(listRules);
			List<AnalysisResult> listResult = analy.doAnalysis();
			for (AnalysisResult analysisResult : listResult) {
				System.out.println(analysisResult);
				if(!analysisResult.isNormal()){
					System.out.println("Òì³££¡£¡£¡£¡£¡£¡" );
				}
			}
			assertEquals(true, listResult!=null&&listResult.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
