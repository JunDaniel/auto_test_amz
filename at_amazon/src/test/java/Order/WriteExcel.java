package Order;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteExcel {
    public void writeResultTestOrder(ArrayList<String> arrResult, String excelFilePath) {
        List<String> headers = Arrays.asList("IDtc", "Full name", "Stresst Address", "City", "Zip Code", "Phone Number", "Message", "Results");
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
                String fullName = data[1];
                String streetAddress = data[2];
                String city = data[3];
                String zipCode = data[4];
                String phoneNumber = data[5];
                String message = data[6];
                String status = data[7];
                Cell cell0 = sheetRow.createCell(0);
                Cell cell1 = sheetRow.createCell(1);
                Cell cell2 = sheetRow.createCell(2);
                Cell cell3 = sheetRow.createCell(3);
                Cell cell4 = sheetRow.createCell(4);
                Cell cell5 = sheetRow.createCell(5);
                Cell cell6 = sheetRow.createCell(6);
                Cell cell7 = sheetRow.createCell(7);
                cell0.setCellValue(IDtc);
                cell1.setCellValue(fullName);
                cell2.setCellValue(streetAddress);
                cell3.setCellValue(city);
                cell4.setCellValue(zipCode);
                cell5.setCellValue(phoneNumber);
                cell6.setCellValue(message);
                cell7.setCellValue(status);
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
