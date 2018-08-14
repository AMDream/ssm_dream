package com.dream.config.view;

import com.dream.service.ExcelExportService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 */
public class ExcelView extends AbstractXlsView {
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileName = null;
    private ExcelExportService es = null;
    public ExcelView(ExcelExportService es){
        this.es = es;
    }
    public ExcelView(ExcelExportService es,String viewName){
        this.setBeanName(viewName);
    }
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        if (es == null){
            throw new RuntimeException("导出服务接口不能为null！");
        }
        if (!StringUtils.isEmpty(fileName)){
            String reqCharset = request.getCharacterEncoding();
            reqCharset = reqCharset == null ? "UTF-8":reqCharset;
            fileName = new String(fileName.getBytes(reqCharset),"ISO-8859-1");
            response.setHeader("Content-disposition","attachment;filename="+fileName);
            es.makeWorkBook(map,workbook);
        }
    }
}
