package cn.com.dhcc.inspection.collector.cnf;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.inspection.base.ftp.LogFileFilter;
import cn.com.dhcc.inspection.collector.CollectConfig;
import cn.com.dhcc.inspection.collector.cnf.sqlmap.InspectionCollConf;
import cn.com.dhcc.inspection.db.DBDelegate;


public class CnfFactory {
	/**
	 * µ√µΩ—≤ºÏ≈‰÷√
	 * @return
	 */
	static public List<CollectConfig> getCollectConf(){
		List<CollectConfig> listCollConf = new ArrayList<CollectConfig>();
		List<InspectionCollConf> listInspectionCollConf = null;
		SqlSession sess = DBDelegate.getSqlSessionFactory().openSession();
		try{
			listInspectionCollConf = sess.selectList("cn.com.dhcc.inspection.collector.cnf.selectAll");
		}finally{
			sess.close();
		}
		for (InspectionCollConf inspectionCollConf : listInspectionCollConf) {
			CollectConfig config = new CollectConfig();
			config.setIp(inspectionCollConf.getIp());
			config.setEncoding(inspectionCollConf.getEncoding());
			config.setLocalFile(inspectionCollConf.getLocalFile());
			config.setPasswd(inspectionCollConf.getPasswd());
			config.setUser(inspectionCollConf.getUser());
			config.setPort(inspectionCollConf.getPort());
			config.setRemoteFile(inspectionCollConf.getRemoteFile());
			
			if(inspectionCollConf.getLogFiles()!=null){
				String files = inspectionCollConf.getLogFiles();
				String fileArra[] = files.split(",");
				List<String> listFileName = new ArrayList<String>();
				for (String fileName : fileArra) {
					if(fileName.trim().length()>0){
						listFileName.add(fileName);
					}
				}
				FTPFileFilter ftpFileFilter = new LogFileFilter(listFileName);
				config.setFtpFileFilter(ftpFileFilter);
			}
			
			listCollConf.add(config);
		}
		return listCollConf;
	}
	
}
