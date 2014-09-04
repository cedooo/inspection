package cn.com.dhcc.inspection.collector;

public abstract class Collector{
	/**
	 * 采集数据
	 * @param config
	 * @throws Exception 
	 */
	public abstract void doCollect(CollectConfig config) throws Exception;
}
