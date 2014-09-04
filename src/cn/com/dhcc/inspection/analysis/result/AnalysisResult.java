package cn.com.dhcc.inspection.analysis.result;

import java.util.ArrayList;
import java.util.List;

public class AnalysisResult {
	private List<AnalysisResultDetails> listResultDetails = new ArrayList<AnalysisResultDetails>();
	private boolean normal = true;    //是否正常
	private String info = null;    //结果信息
	private boolean matches = false;    //是否匹配
	
	public void add(AnalysisResultDetails details){
		this.listResultDetails.add(details);
		if(listResultDetails.size()>0){
			for (AnalysisResultDetails detail : listResultDetails) {
				if(detail==null || detail.isNormal()==false){
					this.setNormal(false);
				}
			}
		}
	}
	
	public boolean isNormal() {
		return normal;
	}
	public void setNormal(boolean normal) {
		this.normal = normal;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isMatches() {
		return matches;
	}

	public void setMatches(boolean matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "AnalysisResult [listResultDetails=" + listResultDetails
				+ ", normal=" + normal + ", info=" + info + ", matches="
				+ matches + "]";
	}

	
	
}
