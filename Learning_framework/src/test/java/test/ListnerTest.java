package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.FileUtility;

@Listeners(genericUtility.ListenerImp.class)

public class ListnerTest extends BaseClass {
	
	@Test
	public void test1() throws Exception {
		System.out.println("i am just running this test");
		FileUtility fLib = new FileUtility();
		String s = fLib.getValueFromPropertyFile("url");
		System.out.println(s);
	}

}
