package cn.com.dhcc.inspection.analysis.result;

public class AnalysisResultDetails {
	private String protoData = null;    //ԭʼ����
	private String info = null;    //���˵��
	private String note = null;    //��ע
	private boolean normal = false;    //�Ƿ�����
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
