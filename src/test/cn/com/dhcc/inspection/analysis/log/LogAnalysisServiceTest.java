package test.cn.com.dhcc.inspection.analysis.log;

import org.junit.Test;

import cn.com.dhcc.inspection.analysis.wrapper.LogAnalysisWrapper;

public class LogAnalysisServiceTest {

	@Test
	public void testGetResult() {
		String ip = "10.24.60.167";
		String[] los = {
				"insLogs/" + ip + "/ping_inner.log",
				"insLogs/" + ip + "/ping_outer.log", 
				"insLogs/" + ip + "/df.log", 
				"insLogs/" + ip + "/file-nr.log",
				"insLogs/" + ip + "/ifconfig.log"
				};
		int ram = (int)(Math.random()*100%4);
		System.out.println(LogAnalysisWrapper.getResult(los[ram]));
	}

}
