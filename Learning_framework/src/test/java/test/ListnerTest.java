package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;

@Listeners(genericUtility.ListenerImp.class)

public class ListnerTest extends BaseClass {
	
	@Test
	public void test1() {
		System.out.println("i am just running this test");
	}

}
