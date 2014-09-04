package cn.com.dhcc.inspection.analysis.result;

public class AnalysisResultDetails {
	private String protoData = null;    //原始数据
	private String info = null;    //结果说明
	private String note = null;    //备注
	private boolean normal = false;    //是否正常
	public String getProtoData() {
		return protoData;
	}
	public void setProtoData(String protoData) {
		this.protoData = protoData;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isNormal() {
		return normal;
	}
	public void setNormal(boolean normal) {
		this.normal = normal;
	}
	@Override
	public String toString() {
		return "AnalysisResultDetails [protoData=" + protoData + ", info="
				+ info + ", note=" + note + ", normal=" + normal + "]";
	}
	
}
