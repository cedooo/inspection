package cn.com.dhcc.inspection.schedule;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class InspectionSchedule implements Runnable {
	private static final Logger log	= Logger.getLogger(InspectionSchedule.class.getClass());
	private boolean alive = false;
	@Override
	public void run() {
		Scheduler scheduler = null;
		ScheduleListener listener = new ScheduleListener();
		try{
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.getListenerManager().addSchedulerListener(listener);
			scheduler.start();
			this.alive = true;
			try{
				while(true){
					Thread.sleep(5*60*1000);
					
				}
			}catch(InterruptedException e){
				log.fatal("�����̳߳���interrupted����ֹ");
			} 
		} catch (SchedulerException e) {
			log.fatal("���ȳ�������ʱ�����쳣���޷�������");
		} finally{
			if(scheduler!=null){
				try {
					scheduler.shutdown();
				} catch (SchedulerException e) {
	 				e.printStackTrace();
				}
			}
		}
		this.alive = false;
		log.fatal("�ɼ������߳̽���");
		
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
