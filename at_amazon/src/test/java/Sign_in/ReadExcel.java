package Sign_in;

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
    /*private Object getCellValue(Cell cell) {
    switch (cell.getCellType()) {
    case STRING:
        return cell.getStringCellValue();

    case BOOLEAN:
        return cell.getBooleanCellValue();

    case NUMERIC:
        return cell.getNumericCellValue();
    default:
        break;
    }
    return null;
}
*/
    public List<User> readDataExcel(String excelFilePath) throws IOException {
        List<User> listUsers = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = getWorkbook(inputStream, excelFilePath);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();

            Iterator<Cell> cellIterator = nextRow.cellIterator();
            User user = new User();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex =  nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        user.setIDtc((String) nextCell.getStringCellValue());
                        break;
                    case 1:
                        user.setUsername((String) nextCell.getStringCellValue());
                        break;
                    case 2:
                        user.setPassword((String) nextCell.getStringCellValue());
                        break;
                    case 3:
                        user.setMessage((String) nextCell.getStringCellValue());
                        break;
                }
            }
            listUsers.add(user);
        }
        listUsers.remove(0);
        workbook.close();
        inputStream.close();

        return listUsers;
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
