package cn.com.dhcc.inspection;

import org.apache.log4j.Logger;

import cn.com.dhcc.inspection.schedule.InspectionSchedule;

public class Main {
	private static final Logger log	= Logger.getLogger(Main.class.getClass());
	private static InspectionSchedule insSch = null;
	public static void main(String[] args) {
		startInspection();
	}
	/**
	 * 启动巡检
	 */
	public static void startInspection(){
		insSch = new InspectionSchedule();
		new Thread(insSch).start();
		try{
			while(true){
				Thread.sleep(5*60*1000);
				if(insSch.isAlive()){
					log.info("调度线程检查：正常");
				}else{
					log.warn("调度线程检查：线程结束重启调度线程");
					new Thread(insSch).start();
				}
			}
		}catch(InterruptedException e){
			log.fatal("主线程interrupted,终止");
		}
	}
}
