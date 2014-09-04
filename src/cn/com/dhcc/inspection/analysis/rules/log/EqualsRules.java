package cn.com.dhcc.inspection.analysis.rules.log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import cn.com.dhcc.inspection.analysis.result.AnalysisResult;
import cn.com.dhcc.inspection.analysis.result.AnalysisResultDetails;

public class EqualsRules extends LogAnalysisRules  {
	private static final Logger log = Logger.getLogger(NumberRangeRules.class.getClass());

	private String equalsVal = null;
	
	public String getEqualsVal() {
		return equalsVal;
	}

	public void setEqualsVal(String equalsVal) {
		this.equalsVal = equalsVal;
	}

	@Override
	public AnalysisResult check() {
		BufferedReader reader = null;
		AnalysisResult result = new AnalysisResult();
		if(this.equalsVal==null) return result;
		try {
			FileInputStream fileInStream = new FileInputStream(this.getLogPath());
			reader = new BufferedReader(new InputStreamReader(fileInStream));

			String lineStr = null;
			Pattern pattern = Pattern.compile(this.getRegex());
			
			while((lineStr=reader.readLine())!=null){
				Matcher matcher = pattern.matcher(lineStr);
				log.debug(matcher.matches() + "::" + lineStr);
				if(matcher.matches()){
					result.setMatches(true);
					result.setInfo("匹配成功");
					String val = matcher.group(this.getGroupCount());
					AnalysisResultDetails resultDetails = new AnalysisResultDetails();
					resultDetails.setProtoData(val);
					if(this.getEqualsVal().equals(val)){
						resultDetails.setNormal(true);
						resultDetails.setInfo(val + "与指定值" + this.getEqualsVal() + "一致");
					}else{
						resultDetails.setNormal(false);
						resultDetails.setInfo(val + "与指定值" + this.getEqualsVal() + "不一致");
					}
					
					result.add(resultDetails);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{
				if(reader !=null){
					reader.close();
				}
			}catch(IOException e){
				
			}
		}
		return result;
	}

}
