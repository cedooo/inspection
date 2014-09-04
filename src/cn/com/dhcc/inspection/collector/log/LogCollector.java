package cn.com.dhcc.inspection.collector.log;

import java.util.List;

import cn.com.dhcc.inspection.analysis.result.AnalysisResult;
import cn.com.dhcc.inspection.analysis.wrapper.LogAnalysisWrapper;
import cn.com.dhcc.inspection.base.ftp.FTPService;
import cn.com.dhcc.inspection.collector.Collector;
import cn.com.dhcc.inspection.collector.CollectConfig;

public class LogCollector extends Collector {

	
	private CollectConfig inspectionConfig = null;
	@Override
	public void doCollect(CollectConfig config) throws Exception {
		boolean configValid = config!=null;
		if(!configValid){
			throw new Exception("����Ϊ��");
		}
		
		List<String> list = FTPService.downloadLogs(config);
		
		for (String string : list) {
			String logPath = config.getLocalFile() + string;
			//TODO ��������
			List<AnalysisResult> listResult = LogAnalysisWrapper.getResult(logPath);
			for (AnalysisResult analysisResult : listResult) {
				System.out.println(analysisResult);
			}
		}
	}
	
	/**
	 * ��ձ��زɼ�����־�ļ�
	 * @return ��ճɹ�����true�����򷵻�false
	 */
	public boolean clearLogFile(){
		return false;
	}

	public CollectConfig getInspectionConfig() {
		return inspectionConfig;
	}

	public void setInspectionConfig(CollectConfig inspectionConfig) {
		this.inspectionConfig = inspectionConfig;
	}
	

}
