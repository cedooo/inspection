package test.cn.com.dhcc.inspection.db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.com.dhcc.inspection.db.DBDelegate;

public class DBDelegateTest {

	@Test
	public void testGetSqlSessionFactory() {
		SqlSession sess = DBDelegate.getSqlSessionFactory().openSession();
		sess.close();
		assertEquals(true, sess!=null);
	}

}
