package cn.com.dhcc.inspection.analysis.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.dhcc.inspection.analysis.Analysis;
import cn.com.dhcc.inspection.analysis.result.AnalysisResult;
import cn.com.dhcc.inspection.analysis.rules.AnalysisRules;
import cn.com.dhcc.inspection.analysis.rules.log.LogAnalysisRules;
/**
 * 日志解析
 * @author CeDo
 *
 */
public class LogAnalysis extends Analysis{
	private String fileURI = null;
	
	public String getFileURI() {
		return fileURI;
	}

	public void setFileURI(String fileURI) {
		this.fileURI = fileURI;
	}

	@Override
	public List<AnalysisResult> doAnalysis() throws Exception{
		if(fileURI!=null && fileURI.trim().length()>0){
			List<AnalysisResult> listResult = new ArrayList<AnalysisResult>();
			for(AnalysisRules rule : listRules){
				LogAnalysisRules logRule = (LogAnalysisRules)rule;
				logRule.setLogPath(fileURI);
				listResult.add(logRule.check());
			}
			return listResult;
		}else{
			throw new Exception("未设置日志路径,或者日志路径为空");
		}
	}

	@Override
	public void addRules(AnalysisRules rule) throws Exception {
		if(rule instanceof LogAnalysisRules){
			this.listRules.add(rule);
		}else{
			throw new Exception("不支持的规则");
		}
	}
	
}
