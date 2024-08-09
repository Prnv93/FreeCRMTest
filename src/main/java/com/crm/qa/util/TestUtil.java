package com.crm.qa.util;

/*
@author Pranav S P
@author-email Pranavsp93@gmail.com
 */

import com.crm.qa.base.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    public static String TEST_DATA_SHEETPATH="C:\\Users\\Pranav\\Documents\\Scripts\\FreeCRMTestAutomation\\src\\" +
            "main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";

    static Workbook book;
    static Sheet sheet;


    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }

    public Object[][] getTestData(String sheetname){
        FileInputStream file = null;
        try{
            file = new FileInputStream(TEST_DATA_SHEETPATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetname);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++){
            for (int k=0;k<sheet.getRow(0).getLastCellNum();k++){
                data[i][k]=sheet.getRow(i+1).getCell(k).toString();
            }
        }
        return data;
    }


}
