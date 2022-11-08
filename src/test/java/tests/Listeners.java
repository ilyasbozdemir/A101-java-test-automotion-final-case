package tests;

import logger.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        Log.info("onStart: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("onFinish" + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info(result.getMethod().getMethodName() + " Started.");
        Log.info("Description: " + result.getMethod().getDescription());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("Skip of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getMethod().getMethodName() + " Passed.");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        Log.fail("Failed with timeout because of - " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.fail("Failed because of - " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.fail("Failure of test cases and its details are : " + result.getName());
    }
}
