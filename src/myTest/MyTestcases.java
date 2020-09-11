package myTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTestcases {
	
	
   // this is written @test level
	@Test
	public void test1() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(false, true);
	}

//	@Test(retryAnalyzer=analyzer.RetryAnalyzer.class)
//	public void test3() {
//		Assert.assertEquals(false, true);
//	}
//	
//	@Test
//	public void test4() {
//		Assert.assertEquals(false, true);
//	}
//	
//	@Test
//	public void test5() {
//		Assert.assertEquals(true, true);
//	}
}
