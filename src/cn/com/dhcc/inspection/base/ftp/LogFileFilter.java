package cn.com.dhcc.inspection.base.ftp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;

public class LogFileFilter implements FTPFileFilter{

	private List<String> listFiles = new ArrayList<String>();
	public LogFileFilter(List<String> listFiles){
		if(listFiles!=null){
			this.listFiles.addAll(listFiles);
		}
	}
	@Override
	public boolean accept(FTPFile file) {
		if(file.isFile()){
			for (String name : listFiles) {
				if(file.getName().equals(name)){
					return true;
				}else{
					continue;
				}
			}
		}
		return false;
	}

}
