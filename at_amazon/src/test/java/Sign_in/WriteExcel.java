package Sign_in;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WriteExcel {
    public void exportData(List<HashMap<String, Object>> ResultExport, String excelFilePath) {
        List<String> headers = Arrays.asList("IDtc", "username", "password", "message", "result");
        int currentRowNumber = 0;
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet spreadsheet = workbook.createSheet(" Test Report ");
            Row header = spreadsheet.createRow(currentRowNumber);
            for (int i = 0; i < headers.size(); i++) {
                Cell headerCell = header.createCell(i);
                headerCell.setCellValue(headers.get(i));
            }
            for (int i = 0; i < ResultExport.size(); i++) {
                HashMap<String, Object> row = ResultExport.get(i);

                currentRowNumber++;
                Row sheetRow = spreadsheet.createRow(currentRowNumber);

                for (int j = 0; j < headers.size(); j++) {
                    Cell cell = sheetRow.createCell(j);

                    String currentColumnName = headers.get(j);
                    if (row.containsKey(currentColumnName)) {
                        cell.setCellValue(row.get(currentColumnName).toString());
                    }
                }
                try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                    workbook.write(outputStream);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void writeData(ArrayList<String> arrResult, String excelFilePath) {
        List<String> headers = Arrays.asList("IDtc", "username", "password", "message", "result");
        int currentRowNumber = 0;
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet spreadsheet = workbook.createSheet(" Test Report ");
            Row header = spreadsheet.createRow(currentRowNumber);
            for (int i = 0; i < headers.size(); i++) {
                Cell headerCell = header.createCell(i);
                headerCell.setCellValue(headers.get(i));
            }

            int idxRow = 1;
            for (int k=0; k< arrResult.size(); k++) {
                Row sheetRow = spreadsheet.createRow(idxRow);
                String[] data = arrResult.get(k).split(";");
                String IDtc = data[0];
                String username = data[1];
                String password = data[2];
                String message = data[3];
                String status = data[4];
                Cell cell0 = sheetRow.createCell(0);
                Cell cell1 = sheetRow.createCell(1);
                Cell cell2 = sheetRow.createCell(2);
                Cell cell3 = sheetRow.createCell(3);
                Cell cell4 = sheetRow.createCell(4);
                cell0.setCellValue(IDtc);
                cell1.setCellValue(username);
                cell2.setCellValue(password);
                cell3.setCellValue(message);
                cell4.setCellValue(status);
                idxRow ++;
            }

            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
