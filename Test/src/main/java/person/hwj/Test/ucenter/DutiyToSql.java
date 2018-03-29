package person.hwj.Test.ucenter;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DutiyToSql {

    public static void main(String[] args) throws Exception {
        // 1.得到Excel常用对象
        FileInputStream inputStream = new FileInputStream(new File(FileInfo.pathString));
        Workbook workbook = new XSSFWorkbook(inputStream);
        // 读取工作表
        Sheet sheet = workbook.getSheetAt(1);
        // 总行数
        int trLength = sheet.getLastRowNum();
        // 4.得到Excel工作表的行
        Row row = sheet.getRow(0);
        // 总列数
        int tdLength = row.getLastCellNum();
        // 5.得到Excel工作表指定行的单元格
        // Cell cell = row.getCell((short) 1);
        // 6.得到单元格样式
        // CellStyle cellStyle = cell.getCellStyle();
        List<DutiesEntity> duties = new ArrayList<DutiesEntity>();
        for (int i = 1; i <= trLength; i++) {
            DutiesEntity duty = new DutiesEntity();
            // 得到Excel工作表的行
            Row row1 = sheet.getRow(i);
            for (int j = 0; j < tdLength; j++) {
                // 得到Excel工作表指定行的单元格
                Cell cell1 = row1.getCell(j);
                // 获得每一列中的值
                System.out.print(cell1.getStringCellValue() + "\t\t\t");
                String value = cell1.getStringCellValue();
                switch (j) {
                    case 0: {
                        duty.setGroupId(value);
                        break;
                    }
                    case 1: {
                        duty.setId(Integer.valueOf(value));
                        duty.setJobCode(value);
                        break;
                    }
                    case 2: {
                        duty.setDutiesStatus((byte) 1);
                        break;
                    }
                    case 3: {
                        duty.setJobTitle(value);
                        break;
                    }
                    case 4: {
                        duty.setJobShortTitle(value);
                        break;
                    }
                    default:
                        break;
                }
            }
            System.out.println();
            duties.add(duty);
        }

        for (DutiesEntity duty : duties) {
            System.out
                    .println("INSERT INTO `duties` (`id`,`group_id`,`job_code`,`job_title`,`job_short_title`,`job_sequence`, `duties_status`,`create_by`)");
            System.out.println("VALUES(" + duty.getId() + ",'" + duty.getGroupId() + "','"
                    + duty.getJobCode() + "','" + duty.getJobTitle() + "','"
                    + duty.getJobShortTitle() + "','',1,1);");
        }
    }
}
