package fan.junit.test;

import org.junit.Test;

import fan.utils.PageUtil;

public class PageTest {
	
	@Test
	public void test()
	{
		System.out.println(PageUtil.pack(15, 151, 1));
	}
}
