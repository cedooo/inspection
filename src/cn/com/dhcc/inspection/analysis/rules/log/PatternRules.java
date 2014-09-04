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
/**
 * 是否存在某个关键字
 * @author CeDo
 *
 */
public class PatternRules extends LogAnalysisRules {
	private static final Logger log = Logger.getLogger(PatternRules.class.getClass());
	@Override
	public AnalysisResult check() {
		BufferedReader reader = null;
		AnalysisResult result = new AnalysisResult();
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
					result.setNormal(true);
					
					AnalysisResultDetails resultDetails = new AnalysisResultDetails();
					resultDetails.setProtoData(lineStr);
					resultDetails.setNormal(true);
					result.add(resultDetails);
					
					result.setInfo("匹配成功");
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
