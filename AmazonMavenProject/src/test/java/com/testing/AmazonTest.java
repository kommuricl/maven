package com.testing;

import java.io.IOException;
import java.lang.reflect.Method;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AmazonTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AmazonTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AmazonTest.class );
    }
    
    public void test_amazone() throws IOException
    {
		boolean result = false;
		String runNoRun;
		// C:\Users\KOMMURI\Documents\canvas\TestData\scriptExecutionController.xls
		String[][] recData = AutoScripts_amazon.readExcel1(
						"c:/Users/KOMMURI/Documents/canvas/SeleniumTest/AmazonScriptExeController.xls",
						"sheet1");

		String automationScript;
		for (int i = 1; i < recData.length; i++) {

			int a = i;

			automationScript = recData[i][2];
			try {
				runNoRun = recData[i][1];
				if (runNoRun.equalsIgnoreCase("Y")) {

					Method ts = AutoScripts_amazon.class.getMethod(automationScript);
					ts.invoke(ts);

					result = true;
					if (result == true) {
						ReUsableMethods_amazon.writingPassInExcel(
										automationScript,
										result,
										"c:/Users/KOMMURI/Documents/canvas/SeleniumTest/AmazonScriptExeController.xls",
										a, 3);
						if (i == 9) {
							Exception e = new Exception("My Own Exception");
							throw (e);
						}
					}
				}
			} catch (Exception e) {
				ReUsableMethods_amazon.writingFailInExcel(
								automationScript,
								result,
								"c:/Users/KOMMURI/Documents/canvas/SeleniumTest/AmazonScriptExeController.xls",
								a, 3);

			}
		}
    }    

}


	

