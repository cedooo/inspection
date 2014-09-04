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
 * �Ƚ���ֵ�����Ƿ��ڷ�Χ֮��
 * <p>
 * ������ʽ�� Ĭ�� ƥ�����ֵ ��������ʽ��<b>��һ��</b>ƥ��group,������ǣ���Ҫͨ��setIndexOfChecked(int)��������ƥ���groupλ��
 * </p>
 * @author CeDo
 *
 */
public class NumberRangeRules extends LogAnalysisRules {
	private static final Logger log = Logger.getLogger(NumberRangeRules.class.getClass());
	
	private double[] range = new double[2];
	
	public void setRange(double bottom, double top) throws Exception{
		if(top-bottom>=1e-6){
			this.range[0] = bottom;
			this.range[1] = top;
		}else{
			throw new Exception("��Χ����bottom Ӧ��С�ڻ���� top");
		}
	}

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
					result.setInfo("ƥ��ɹ�");
					String val = matcher.group(this.getGroupCount());
					Double d = Double.parseDouble(val);
					boolean inRange = d.compareTo(range[0])>=0
							&& d.compareTo(range[1])<=0;
					AnalysisResultDetails resultDetails = new AnalysisResultDetails();
					if(inRange){
						resultDetails.setProtoData(lineStr);
						resultDetails.setInfo(d + " ��ָ����Χ["  + range[0] + ", " + range[1] +  "]��");
						resultDetails.setNormal(true);
					}else{
						resultDetails.setProtoData(lineStr);
						resultDetails.setInfo(d + " ����ָ����Χ["  + range[0] + ", " + range[1] +  "]��");
						resultDetails.setNormal(false);
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
