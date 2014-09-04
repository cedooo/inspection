package cn.com.dhcc.inspection.analysis.rules.log.factory;

import java.util.ArrayList;
import java.util.List;

import cn.com.dhcc.inspection.analysis.rules.AnalysisRules;
import cn.com.dhcc.inspection.analysis.rules.log.EqualsRules;
import cn.com.dhcc.inspection.analysis.rules.log.NumberRangeRules;

public class LogRulesFactory {
	
	/**
	 * �õ�file-nr.log�Ľ�������
	 * @return
	 */
	static public List<AnalysisRules> getFileNrLogRules(){
		List<AnalysisRules> listRules = new ArrayList<AnalysisRules>();
		NumberRangeRules rules = new NumberRangeRules();
		rules.setRegex("^(\\d+)\\s(\\d+)\\s(\\d+)$");
		try {
			rules.setRange(0, 8000);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		listRules.add(rules);
		return listRules;
	}
	
	/**
	 * �õ�df.log�Ľ�����־
	 * @return
	 */
	static public List<AnalysisRules> getDfLogRules() {
		List<AnalysisRules> listRules = new ArrayList<AnalysisRules>();
		NumberRangeRules rules = new NumberRangeRules();
		rules.setRegex(".+?(\\d+)%\\s*/.*$");
		try {
			rules.setRange(0, 80.0);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		listRules.add(rules);
		return listRules;
	}
	
	/**
	 * �õ�ifconfig.log����
	 * @return
	 */
	static public List<AnalysisRules> getIfconfigLogRules() {
		List<AnalysisRules> listRules = new ArrayList<AnalysisRules>();
		listRules.add(getIPEqualsRules("10.24.60.55"));
		return listRules;
	}
	

	/**
	 * �õ�ifconfig.log����
	 * @return
	 */
	static public List<AnalysisRules> getPingLogRules() {
		List<AnalysisRules> listRules = new ArrayList<AnalysisRules>();
		listRules.add(getPingLoseRangeRules(0,1));
		return listRules;
	}
	
	/**
	 * �õ�IP
	 * @return
	 */
	static public EqualsRules getIPEqualsRules(String ip){
		EqualsRules rules = new EqualsRules();
		rules.setRegex("\\s*inet addr:(\\d+\\.\\d+\\.\\d+\\.\\d+)\\s*(Bcast:(\\d+\\.\\d+\\.\\d+\\.\\d+))*\\s*Mask:(\\d+\\.\\d+\\.\\d+\\.\\d+)");
		rules.setEqualsVal(ip);
		return rules;
	}
	
	/**
	 * �õ�ping��ĳ����Χ
	 * @param min
	 * @param max
	 * @return
	 */
	static public NumberRangeRules getPingLoseRangeRules(double min, double max){
		NumberRangeRules rules = new NumberRangeRules();
		rules.setRegex("\\d+ packets transmitted, \\d+ received, (\\d+)% packet loss, time \\d+ms");
		try {
			rules.setRange(min, max);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return rules;
	}
	/**
	 * 
	 * @return
	 */
	static public  List<AnalysisRules> getSarLogRules(){
		List<AnalysisRules> listRules = new ArrayList<AnalysisRules>();
		listRules.add(getCPURangeRules(0,80));
		listRules.add(getCPUAvgRangeRules(0,80));
		return listRules;
	}
	/**
	 * �õ�cpu��ĳ����Χ
	 * @param min
	 * @param max
	 * @return
	 */
	static public NumberRangeRules getCPURangeRules(double min, double max){
		NumberRangeRules rules = new NumberRangeRules();
		rules.setRegex(".*all\\s*(\\d+\\.\\d+)\\s*\\s*\\d+\\.\\d+\\s*\\s*\\d+\\.\\d+\\s*\\s*\\d+\\.\\d+\\s*\\s*\\d+\\.\\d+\\s*\\s*\\d+\\.\\d+\\s*$");
		try {
			rules.setRange(min, max);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return rules;
	}
	/**
	 * �õ�cpu��ĳ����Χ
	 * @param min
	 * @param max
	 * @return
	 */
	static public NumberRangeRules getCPUAvgRangeRules(double min, double max){
		NumberRangeRules rules = new NumberRangeRules();
		rules.setRegex("^Average:\\s*all\\s*(\\d+\\.\\d+)\\s*\\s*\\d+\\.\\d+\\s*\\s*\\d+\\.\\d+\\s*\\s*\\d+\\.\\d+\\s*\\s*\\d+\\.\\d+\\s*\\s*\\d+\\.\\d+\\s*$");
		try {
			rules.setRange(min, max);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return rules;
	}
}
