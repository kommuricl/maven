package com.testing;

import java.lang.reflect.Method;



public class ExeEngine_amazon extends ReUsableMethods_amazon{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		String runNoRun;
		//                                                C:\Users\KOMMURI\Documents\canvas\TestData\scriptExecutionController.xls
		String[][] recData = AutoScripts_amazon.readExcel1("c:/Users/KOMMURI/Documents/canvas/SeleniumTest/AmazonScriptExeController.xls", "sheet1");
				
		String automationScript ;
		for(int i=1; i < recData.length; i++){
			
			int a =i;
			
			automationScript = recData[i][2];
			try{
			runNoRun = recData[i][1];
			if(runNoRun.equalsIgnoreCase("Y")){
				
			Method ts = AutoScripts_amazon.class.getMethod(automationScript);
		      ts.invoke(ts);
			
				  result = true;
		    if(result == true){
		    	  writingPassInExcel(automationScript,result, "c:/Users/KOMMURI/Documents/canvas/SeleniumTest/AmazonScriptExeController.xls", a, 3);
		      if(i==9){
		    	  Exception e = new Exception("My Own Exception");
		    	  throw(e);
		         }
		         }
			  }
			}catch(Exception e){
				writingFailInExcel(automationScript, result, "c:/Users/KOMMURI/Documents/canvas/SeleniumTest/AmazonScriptExeController.xls", a, 3);
		     
			}
			}
		    
		    
		    /*{
		    	
		    	*/ 
	    }
		     
/*java reflexion method or Reflexion API
 * Method testscript = Automationscripts.class.getMethod("testcase methodName");
 * testscript.invoke(testscript);
 */
	
	
	}
	

