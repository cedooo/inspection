package cn.com.dhcc.inspection.analysis;

import java.util.ArrayList;
import java.util.List;

import cn.com.dhcc.inspection.analysis.result.AnalysisResult;
import cn.com.dhcc.inspection.analysis.rules.AnalysisRules;

public abstract class Analysis {
	
	protected List<AnalysisRules> listRules = new ArrayList<AnalysisRules>();     //解析规则集合
	
	public List<AnalysisRules> getListRules() {
		return listRules;
	}
	/**
	 * 添加规则
	 * @param rule
	 * @throws Exception
	 */
	public abstract void addRules(AnalysisRules rule) throws Exception;
	/**
	 * 添加规则
	 * @param list规则集合
	 * @throws Exception
	 */
	public void addAllRules(List<AnalysisRules> list) throws Exception{
		for (AnalysisRules analysisRules : list) {
			this.addRules(analysisRules);
		}
	}

	/**
	 * 得到解析结果
	 * @return
	 */
	public abstract List<AnalysisResult> doAnalysis() throws Exception;
	
}
