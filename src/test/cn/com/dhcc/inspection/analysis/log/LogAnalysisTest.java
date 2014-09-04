package test.cn.com.dhcc.inspection.analysis.log;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.inspection.analysis.impl.LogAnalysis;
import cn.com.dhcc.inspection.analysis.result.AnalysisResult;
import cn.com.dhcc.inspection.analysis.rules.log.factory.LogRulesFactory;

public class LogAnalysisTest {

	@Test
	public void testDoAnalysis() {
		LogAnalysis analy = new LogAnalysis();
		String[] los = {"insLogs/10.24.60.167/ping_inner.log",
				"insLogs/10.24.60.167/ping_outer.log", 
				"insLogs/10.24.60.167/df.log", 
				"insLogs/10.24.60.167/file-nr.log"
				,"insLogs/10.24.60.167/ifconfig.log"};
		//int ram = (int)(Math.random()*100%4);
		analy.setFileURI(los[4]);
		
		/*//±Ì¥Ô Ω∆•≈‰
		PatternRules rule = new PatternRules();
		rule.setRegex("\\d+ packets transmitted, \\d+ received, \\d+% packet loss, time \\d+ms");
		try {
			analy.addRules(rule);
		} catch (Exception e1) {
			e1.printStackTrace();
		}*/
		
		
		try {
			analy.addAllRules(LogRulesFactory.getFileNrLogRules());
			analy.addAllRules(LogRulesFactory.getDfLogRules());
			analy.addAllRules(LogRulesFactory.getIfconfigLogRules());
			analy.addRules(LogRulesFactory.getIPEqualsRules("10.24.60.55"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		
		
		
		try {
			List<AnalysisResult> listResult = analy.doAnalysis();
			for (AnalysisResult analysisResult : listResult) {
				System.out.println(analysisResult);
			}
			assertEquals(true, listResult!=null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
