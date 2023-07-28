package poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var inputFile = new File("src/main/java/poi/test.xlsx");
        var dataFormatter = new DataFormatter();
        try (var wb = new XSSFWorkbook(new FileInputStream(inputFile))) {
            wb.setForceFormulaRecalculation(true);
            var sheet = wb.getSheet("Test");
            var formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
                var row = sheet.getRow(i);
                var list = new ArrayList<String>();
                for (var cell : row) {
                    list.add(format(dataFormatter, formulaEvaluator, cell));
                }
                System.out.println(String.join(", ", list));
                System.out.println("---------------------------------------");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String format(DataFormatter dataFormatter, XSSFFormulaEvaluator formulaEvaluator, Cell cell) {
        if (cell.getCellType() == CellType.FORMULA) {
            System.out.println("Formula: " + cell.getCellFormula());
            System.out.println("Cache result type: " + cell.getCachedFormulaResultType());
            if (cell.getCachedFormulaResultType() == CellType.STRING) {
                return cell.getRichStringCellValue().getString();
            } else {
                return String.valueOf(cell.getNumericCellValue());
            }
        }
        return dataFormatter.formatCellValue(cell, formulaEvaluator);
    }
}
