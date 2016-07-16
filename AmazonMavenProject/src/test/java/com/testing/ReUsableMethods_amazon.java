package com.testing;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebElement;




public class ReUsableMethods_amazon{
	//	static WebDriver driver;
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;
	
	 /* Name of the method:readExcel1
	   Brief Discription: To read the contents from Excel Sheet
		Arguments: String dtTablePath,String sheetName
		Created By: Self Team
		Creatoin Date:7/6/2016
		Last Modified:7/6/2016
	*/
	
	 public static String[][] readExcel1(String dtTablePath,String sheetName) throws IOException{

			// step1 : get the xl path
				File xlFile = new File(dtTablePath);

			// step2 : Access the xl File
				FileInputStream xlDoc = new FileInputStream(xlFile);

			//step 3 : Access the workbook(poi jar file)
				HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

			//step4 : Access the sheet
				HSSFSheet sheet = wb.getSheet(sheetName);
			
			int iRowCount = sheet.getPhysicalNumberOfRows();
			int iColCount = sheet.getRow(0).getLastCellNum();

			String[][] xlData = new String[iRowCount][iColCount];
			
			for(int i=0; i<iRowCount; i++){
				for(int j = 1; j<iColCount -1; j++){
					System.out.print("Row : " + i + " Column : " + j);
					xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(" - Cell Value: " + xlData[i][j]);
				}
			}
		
			wb.close();
			return xlData;
		}

	 /* Name of the method: writingPassInExcel
	   Brief Discription: To write Pass in Excel Sheet
		Arguments: boolean obj, String dTablePath, int row, int cell
		Created By: Self Team
		Creatoin Date:7/10/2016
		Last Modified:7/10/2016
	*/

	//for "Pass"
	public static void writingPassInExcel(String tc_name,boolean obj, String dTablePath, int row, int cell) throws IOException{
		File src = new File(dTablePath);
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = wb.getSheetAt(0);
		sheet1.getRow(row).createCell(cell).setCellValue("PASS");
		
	/*	CreationHelper createHelper = wb.getCreationHelper();
		HSSFHyperlink link = (HSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_FILE);
		link.setAddress("C:/Users/KOMMURI/Documents/canvas/ReportLog/tc_name/tc_name.html");
		sheet1.getRow(row).createCell(cell).setHyperlink((org.apache.poi.ss.usermodel.Hyperlink) link);
		*/
		//sheet1.getRow(row).createCell(cell).setCellStyle(hlink_style);
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
	}
	
	
	//for "FAIL"

	/* Name of the method: writingFailInExcel
	   Brief Discription: To write Fail in Excel Sheet
		Arguments: boolean obj, String dTablePath, int row, int cell
		Created By: Self Team
		Creatoin Date:7/10/2016
		Last Modified:7/10/2016
	*/

	

	public static void writingFailInExcel(String tc_name,boolean obj, String dTablePath, int row, int cell) throws IOException{
		File src = new File(dTablePath);
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = wb.getSheetAt(0);
		//CreationHelper createHelper = wb.getCreationHelper();
		sheet1.getRow(row).createCell(cell).setCellValue("FAIL");
		
	/*	HSSFHyperlink link = (HSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_FILE);
		link.setAddress("C:/Users/KOMMURI/Documents/canvas/ReportLog/tc_name/tc_name.html");
		sheet1.getRow(row).createCell(cell).setHyperlink((org.apache.poi.ss.usermodel.Hyperlink) link);
		*/
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
	}
	
	 /* Name of the method: launch
	   Brief Discription: Checking that Application launched or not
		Arguments:String objName--> To pass application name
		Created By: Self Team
		Creatoin Date:7/11/2016
		Last Modified:7/11/2016
	*/

	public static void launch(String objName) throws IOException{
	 Update_Report("Pass", "Checking " +objName +" Application Launching", objName +" Application is Launched");
	}

	/*Name Of the method: enterText
	 * Brief Description : Enter text value to text boxes
	 * Arguments: obj-->WebElement obj, textVal-->text to be entered, objName--->actual result
	 * created by : selfTeam
	 * creation date: july1,2016
	 * last modified :july1,2016
	 */
	public static  void enterText(WebElement obj, String textVal, String objName) throws IOException{
				   if(obj.isDisplayed()){	 
					 obj.sendKeys(textVal);
					 Update_Report("Pass","checking " +objName +" is entered",objName+" is displayed");
					 	 }else{
					 		 Update_Report("Fail","checking " +objName +" is entered" ,objName+" is not displayed"); 
					 	 
					 	 }
				}
	
	/* Name of the method:elementDisplay
	   Brief Discription: Checking the element is displayed or not
		Arguments:WebElement obj, String objName
		Created By: Self Team
		Creatoin Date:7/15/2016
		Last Modified:7/15/2016
	*/
	
	 
	  public static void elementDisplay(WebElement obj, String objName) throws IOException{
	 if(obj.isDisplayed()){
	  Update_Report("Pass", "Checking "+objName+" is displayed", objName+" is displayed");
	  }else{
	  Update_Report("Fail", "Checking "+objName+" is displayed", objName+" is not displayed");
	   }
	  }
	 
	  /* Name of the method: clickElement
	   Brief Discription: select to click a button
		Arguments: String obj--> WebElement object, String ObjName ---> what action happend
		Created By: Self Team
		Creatoin Date:7/2/2016
		Last Modified:7/2/2016
	*/
	 public static void clickElement(WebElement obj1, String objName) throws IOException{
	  	if(obj1.isDisplayed()){
	  		obj1.click();
	   Update_Report("Pass","click "+objName+" button", objName+" button is clicked ");
	   }else{
	   Update_Report("Fail","click "+objName+" button", objName+" button is not clicked ");
	   }
	   }
	
	 /* Name of the method:pageVerify1
	   Brief Discription:Verifying the page
		Arguments:WebElement obj, String objName
		Created By: Self Team
		Creatoin Date:7/15/2016
		Last Modified:7/15/2016
	*/
	
	  public static void pageVerify1(WebElement obj, String objName) throws IOException{
	  if(obj.isDisplayed()){
	  Update_Report("Pass", "Verifying the page",objName+" page is displayed");
	  }else{
	  Update_Report("Fail", "Verifying the page",objName+" page is not displayed");
	  }
     }
	 

	  /* Name of the method:tabDropdownMenu
	   Brief Discription: Checking dropdown menu is displayed or not
		Arguments:WebElement obj--> to pass dropdownmenu tab name, String objName
		Created By: Self Team
		Creatoin Date:7/13/2016
		Last Modified:7/13/2016
	*/
	
	
	  public static void tabDropdownMenu(WebElement obj, String objName) throws IOException{
	  if(obj.isDisplayed()){
	  //obj.click();
	  Update_Report("Pass", "Checking " + objName + "dropdown menu is displayed", objName+ " dropdown menu is displayed");
	  }else{
	   Update_Report("Pass", "Checking " + objName + "dropdown menu is displayed", objName+ " dropdown menu is not displayed");
	  }
	
	  }
	
	  /* Name of the method:elementLink
	   Brief Discription: Checking the element is displayed or not
		Arguments:WebElement obj, String objName
		Created By: Self Team
		Creatoin Date:7/15/2016
		Last Modified:7/15/2016
	*/
	
	 
	  public static void elementLink(WebElement obj, String objName) throws IOException{
	 if(obj.isDisplayed()){
	  Update_Report("Pass", "Checking "+objName+" is displayed", objName+" is displayed");
	  }else{
	  Update_Report("Fail", "Checking "+objName+" is displayed", objName+" is not displayed");
	   }
	  }
	@Test
	public void test() throws Exception {

		startReport("AmazonMavenProject","C:/Users/KOMMURI/Documents/canvas/Report");

		Update_Report( "Pass", "Decending order sort",  "Decending order sort executing is complete.");
		
		bw.close();


	}


	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
}




