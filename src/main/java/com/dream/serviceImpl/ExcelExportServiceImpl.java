package com.dream.serviceImpl;

import com.dream.pojo.Role;
import com.dream.service.ExcelExportService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class ExcelExportServiceImpl implements ExcelExportService {
    @Override
    public void makeWorkBook(Map<String, Object> model, Workbook wb) {
        List<Role> roles = (List<Role>) model.get("roleList");
        Sheet sheet = wb.createSheet();
        Row title = sheet.createRow(0);
        title.createCell(0).setCellValue("编号");
        title.createCell(1).setCellValue("姓名");
        title.createCell(2).setCellValue("备注");
        for (int i = 0; i < roles.size(); i++) {
            Role role = roles.get(i);
            int rowIdx = i + 1;
            Row row = sheet.createRow(rowIdx);
            row.createCell(0).setCellValue(role.getId());
            row.createCell(1).setCellValue(role.getRoleName());
            row.createCell(2).setCellValue(role.getNote());
        }
    }
}
