package com.exuviance.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 *	Author : Vaibhav Nagvekar
 *	Date : 14 Oct 2022
 **/

public class CustomListener extends BaseClass implements ITestListener {

	Action action= new Action();

	public void onTestStart(ITestResult result) {
		test = exprep.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is : " + result.getName());
			exprep.flush();
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Failed Test case is : "+result.getName(), ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Test Case Failed : "+result.getThrowable(), ExtentColor.RED));

			String imgPath = action.screenShot(BaseClass.driver, result.getName());
			test.addScreenCaptureFromPath(imgPath);
			exprep.flush();
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is : " + result.getName());
			exprep.flush();
		}
	}

	public void onFinish(ITestContext context) {
		if (exprep != null) {
			exprep.flush();
		}
	}
}
