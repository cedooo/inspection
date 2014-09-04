package cn.com.dhcc.inspection.analysis.rules.log;

import cn.com.dhcc.inspection.analysis.rules.AnalysisRules;


public abstract class LogAnalysisRules extends AnalysisRules{
	private String regex = null;
	private int groupCount = 1;
	private String logPath = null;
	
	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}

	public int getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
	}

	
	
}
