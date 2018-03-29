package person.hwj.Test.ucenter;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserToSql {

    public static void main(String[] args) throws Exception {
        // 1.得到Excel常用对象
        FileInputStream inputStream = new FileInputStream(new File(FileInfo.pathString));
        Workbook workbook = new XSSFWorkbook(inputStream);
        // 读取工作表
        Sheet sheet = workbook.getSheetAt(2);
        // 总行数
        int trLength = sheet.getLastRowNum();
        // 4.得到Excel工作表的行
        Row row = sheet.getRow(0);
        // 总列数
        int tdLength = row.getLastCellNum();
        System.out.println(tdLength);
        // 5.得到Excel工作表指定行的单元格
        Cell cell = row.getCell((short) 1);
        // 6.得到单元格样式
        CellStyle cellStyle = cell.getCellStyle();
        List<UserEntity> users = new ArrayList<UserEntity>();
        for (int i = 1; i <= trLength; i++) {
            UserEntity userEntity = new UserEntity();
            // 得到Excel工作表的行
            Row row1 = sheet.getRow(i);
            for (int j = 0; j < tdLength; j++) {
                // 得到Excel工作表指定行的单元格
                Cell cell1 = row1.getCell(j);
                // 获得每一列中的值
                // System.out.print(cell1.getStringCellValue() + "\t\t\t");
                String value = cell1.getStringCellValue();
                switch (j) {
                    case 0: {
                        userEntity.setNewJobNumber(value);
                        break;
                    }
                    case 1: {
                        userEntity.setFullName(value);
                        break;
                    }
                    case 2: {
                        userEntity.setDepartmentId(Integer.valueOf(value));
                        break;
                    }
                    case 3: {
                        userEntity.setPositionId(Integer.valueOf(value));
                        break;
                    }
                    case 4: {
                        if (value.equals("男")) {
                            userEntity.setGender(1);
                        } else {
                            userEntity.setGender(2);
                        }
                        break;
                    }
                    case 5: {
                        userEntity.setPhoneNum(value);
                        break;
                    }
                    case 6: {
                        userEntity.setEmail(value);
                        break;
                    }
                    case 7: {
                        break;
                    }
                    case 8: {
                        userEntity.setWorkplace(value);
                        break;
                    }
                    default:
                        break;
                }
            }
            // System.out.println();
            users.add(userEntity);
        }

        for (UserEntity userEntity : users) {
            System.out
                    .println("INSERT  INTO `user`(`new_job_number`,`old_job_number`,`full_name`,`user_name`,`password`,`department_id`,`position_id`,`gender`,`phone_num`,"
                            + " `id_card`,`email`,`workplace`,`entry_time`,`remarks`,`resignation_time`,`job_sequence`,`sales_stars`,`job_status`,`account_status`,`create_by`,`is_delete`)");
            System.out.println("VALUES('" + userEntity.getNewJobNumber() + "','','"
                    + userEntity.getFullName() + "','" + userEntity.getNewJobNumber()
                    + "','e10adc3949ba59abbe56e057f20f883e','" + userEntity.getDepartmentId()
                    + "','" + userEntity.getPositionId() + "','" + userEntity.getGender() + "','"
                    + userEntity.getPhoneNum() + "','','" + userEntity.getEmail() + "','"
                    + userEntity.getWorkplace()
                    + "','2000-01-01 00:00:00','','2000-01-01 00:00:00','',1,1,1,1,0);");
        }
    }
}
