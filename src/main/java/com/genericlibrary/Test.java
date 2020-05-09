package com.genericlibrary;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class Test {
    public static String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
    String value = null;
    Workbook workbook = null;

    public void getExcelFile(String excelFileName, String sheetName) throws IOException {
        /*Create an object of FileInputStream class to read excel file*/
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        /*Finding the file extension by splitting file name in substring  and getting only extension name*/
        String fileExtensionName = excelFileName.substring(excelFileName.indexOf("."));
        switch (fileExtensionName) {
            case ".xlsx":
                workbook = new XSSFWorkbook(inputStream);
                break;
            case ".xls":
                workbook = new HSSFWorkbook(inputStream);
                break;
        }
        //Read sheet inside the workbook by its name
        Sheet sheet = workbook.getSheet(sheetName);
        //Find number of rows in excel file
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        //Create a loop over all the rows of excel file to read it
        for (int i = 0; i < rowCount + 1; i++) {
            Row row = sheet.getRow(i);
            //Create a loop to print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++) {
                //Print Excel data in console
                System.out.print(row.getCell(j).getStringCellValue() + "|| ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Test t=new Test();
        t.getExcelFile("TestData.xlsx","CreateAccountData");
    }
}

