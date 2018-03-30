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

public class DepartmentToSql {

    public static void main(String[] args) throws Exception {
        // 1.得到Excel常用对象
        FileInputStream inputStream = new FileInputStream(new File(FileInfo.pathString));
        Workbook workbook = new XSSFWorkbook(inputStream);
        // 读取工作表
        Sheet sheet = workbook.getSheetAt(0);
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
        List<DepartmentEntity> departmentEntities = new ArrayList<DepartmentEntity>();
        for (int i = 1; i <= trLength; i++) {
            DepartmentEntity department = new DepartmentEntity();
            // 得到Excel工作表的行
            Row row1 = sheet.getRow(i);
            for (int j = 0; j < tdLength; j++) {
                // 得到Excel工作表指定行的单元格
                Cell cell1 = row1.getCell(j);
                // 获得每一列中的值
                // System.out.print(cell1.getStringCellValue() + "\t\t\t");
                switch (j) {
                    case 0: {
                        // double value = cell1.getNumericCellValue();
                        department.setId(Integer.valueOf(cell1.getStringCellValue()));
                        department.setDepartmentCode(cell1.getStringCellValue());
                        break;
                    }
                    case 1: {
                        // department.setEffectiveDate("2000-01-01 00:00:00");
                        break;
                    }
                    case 2: {
                        String value = cell1.getStringCellValue();
                        department.setDepartmentName(value);
                        break;
                    }
                    case 3: {
                        String value = cell1.getStringCellValue();
                        department.setDepartmentAbbreviation(value);
                        break;
                    }
                    case 4: {
                        department.setDepartmentStatus1(1);
                        department.setDepartmentStatus2(1);
                        break;
                    }
                    case 5: {
                        String value = cell1.getStringCellValue();
                        department.setParentId(value);
                        break;
                    }
                    default:
                        break;
                }
            }
            // System.out.println();
            departmentEntities.add(department);
        }

        for (DepartmentEntity department : departmentEntities) {
            System.out
                    .println("INSERT INTO `department`( `id`,`department_code`,`effective_date`,`department_name`,`department_abbreviation`,`department_status1`,`department_status2`,`parent_id`,`first_principal`,`secondary_principal`,`three_principal`,`remarks`, `create_by`) ");
            System.out.println("VALUES(" + department.getId() + ",'"
                    + department.getDepartmentCode() + "','2000-01-01 00:00:00','"
                    + department.getDepartmentName() + "','"
                    + department.getDepartmentAbbreviation() + "',1,1,'" + department.getParentId()
                    + "','','','','',1);");
        }
    }
}
