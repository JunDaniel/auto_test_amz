package Order;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {
    public List<Address> readDataExcel(String excelFilePath) throws IOException {
        List<Address> listAddress = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = getWorkbook(inputStream, excelFilePath);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();

            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Address address = new Address();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex =  nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        address.setIDtc((String) nextCell.getStringCellValue());
                        break;
                    case 1:
                        address.setfullName((String) nextCell.getStringCellValue());
                        break;
                    case 2:
                        address.setstreetAddress((String) nextCell.getStringCellValue());
                        break;
                    case 3:
                        address.setcity((String) nextCell.getStringCellValue());
                        break;
                    case 4:
                        address.setzipCode((String) nextCell.getStringCellValue());
                        break;
                    case 5:
                        address.setphoneNumber((String) nextCell.getStringCellValue());
                        break;
                    case 6:
                        address.setcardNumber((String) nextCell.getStringCellValue());
                        break;
                    case 7:
                        address.setNameonCard((String) nextCell.getStringCellValue());
                        break;
                    case 8:
                        address.setexpirationDate((String) nextCell.getStringCellValue());
                        break;

                }
            }
            listAddress.add(address);
        }
        listAddress.remove(0);
        workbook.close();
        inputStream.close();

        return listAddress;
    }


    private Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }
}
