package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ExcelUtils {

    public static List<LinkedHashMap<String, String>> readFromExcel(String filePath) throws IOException {
        List<LinkedHashMap<String, String>> dataFromExcel = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new File(filePath));
        Sheet sheet = workbook.getSheet("data");

        DataFormatter formatter = new DataFormatter();
        //get Number of Rows
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
        List<String> keys = new ArrayList<>();
        LinkedHashMap<String, String> mapData;
        for (int i = 0; i < numberOfRows; i++) {
            mapData = new LinkedHashMap<>();
            if (i == 0) {
                for (int j = 0; j < numberOfColumns; j++) {
                    String data = formatter.formatCellValue(sheet.getRow(0).getCell(j));
                    keys.add(data);
                }
            } else {
                for (int j = 0; j < numberOfColumns; j++) {
                    String data = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    mapData.put(keys.get(j), data);
                }
                dataFromExcel.add(mapData);
            }
        }

        return dataFromExcel;
    }

    public static List<LinkedHashMap<String, String>> readDataFromExcel(String fileName) throws IOException {
        List<LinkedHashMap<String, String>> dataMap = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(new File(fileName));
        Sheet sheet = workbook.getSheet("data");
        DataFormatter formatter = new DataFormatter();
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        List<String> keys = new ArrayList<>();
        LinkedHashMap<String, String> mapData;
        for (int i = 0; i < numberOfRows; i++) {
            mapData=new LinkedHashMap<>();
            if (i == 0) {
                for (int j = 0; j < numberOfColumns; j++) {
                    String data = formatter.formatCellValue(sheet.getRow(0).getCell(j));
                    keys.add(data);
                }
            }
            else{
                for (int j = 0; j < numberOfColumns; j++) {
                    String data = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    mapData.put(keys.get(j),data);
                }
                dataMap.add(mapData);
            }
        }
        return dataMap;
    }
}
