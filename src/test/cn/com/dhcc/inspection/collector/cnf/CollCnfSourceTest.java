package test.cn.com.dhcc.inspection.collector.cnf;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.inspection.collector.CollectConfig;
import cn.com.dhcc.inspection.collector.cnf.CnfFactory;

public class CollCnfSourceTest {

	@Test
	public void testGetConf() {
		List<CollectConfig> listCollConf = CnfFactory.getCollectConf();
		for (CollectConfig inspectionCollConf : listCollConf) {
			System.out.println(inspectionCollConf);
		}
		assertEquals(true, listCollConf!=null);
	}

}
