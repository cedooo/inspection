package cn.com.dhcc.inspection.collector;

public abstract class Collector{
	/**
	 * �ɼ�����
	 * @param config
	 * @throws Exception 
	 */
	public abstract void doCollect(CollectConfig config) throws Exception;
}
