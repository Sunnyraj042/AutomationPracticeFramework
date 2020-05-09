package com.genericlibrary;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFileReaderWriter {
    public static String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
    String value = null;
    Workbook workbook = null;

    public String getExcelFile(String excelFileName, String sheetName, int rowNumber, int columnNumber) throws IOException {
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
        /*Reading sheet inside the workbook by its name*/
        Cell cell = workbook.getSheet(sheetName).getRow(rowNumber).getCell(columnNumber);
        value = cell.getStringCellValue();
        return value;
    }

    public void setExcelFile(String excelFileName, String sheetName, int rowNumber, int columnNumber, String input) throws IOException {
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        String fileExtensionName = excelFileName.substring(excelFileName.indexOf("."));
        switch (fileExtensionName) {
            case ".xlsx":
                workbook = new XSSFWorkbook(inputStream);
                break;
            case ".xls":
                workbook = new HSSFWorkbook(inputStream);
                break;
        }
        workbook.getSheet(sheetName).createRow(rowNumber).createCell(columnNumber).setCellValue(input);
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        outputStream.close();
    }
}
