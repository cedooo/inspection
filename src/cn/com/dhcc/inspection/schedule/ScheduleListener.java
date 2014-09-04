package cn.com.dhcc.inspection.schedule;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

public class ScheduleListener implements SchedulerListener {
	private Logger log = Logger.getLogger(ScheduleListener.class);

	@Override
	public void jobAdded(JobDetail arg0) {
		

	}

	@Override
	public void jobDeleted(JobKey arg0) {
		

	}

	@Override
	public void jobPaused(JobKey arg0) {
		

	}

	@Override
	public void jobResumed(JobKey arg0) {
		

	}

	@Override
	public void jobScheduled(Trigger arg0) {
		

	}

	@Override
	public void jobUnscheduled(TriggerKey arg0) {
		

	}

	@Override
	public void jobsPaused(String arg0) {
		

	}

	@Override
	public void jobsResumed(String arg0) {
		

	}

	@Override
	public void schedulerError(String arg0, SchedulerException arg1) {
		

	}

	@Override
	public void schedulerInStandbyMode() {
		

	}

	@Override
	public void schedulerShutdown() {
		log.fatal("调度线程停止");
	}

	@Override
	public void schedulerShuttingdown() {
		

	}

	@Override
	public void schedulerStarted() {
		log.info("调度线程启动成功");
	}

	@Override
	public void schedulerStarting() {
		log.info("调度线程正在启动");

	}

	@Override
	public void schedulingDataCleared() {
		

	}

	@Override
	public void triggerFinalized(Trigger arg0) {
		

	}

	@Override
	public void triggerPaused(TriggerKey arg0) {
		

	}

	@Override
	public void triggerResumed(TriggerKey arg0) {
		

	}

	@Override
	public void triggersPaused(String arg0) {
		

	}

	@Override
	public void triggersResumed(String arg0) {
		

	}

}
