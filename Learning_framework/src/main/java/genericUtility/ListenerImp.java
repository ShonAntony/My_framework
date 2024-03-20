package genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("------------------------------the test script has passed---------------------");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		/*
		 * System.out.
		 * println("------------------------------the test script has failed---------------------"
		 * );
		 * 
		 * String method = result.getMethod().getMethodName(); try { String failedScript
		 * = WebDriverUtility.takeSS(BaseClass.sdriver, method); } catch (Exception e) {
		 * e.printStackTrace(); } ITestListener.super.onTestFailure(result);
		 */
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);
	}

	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
