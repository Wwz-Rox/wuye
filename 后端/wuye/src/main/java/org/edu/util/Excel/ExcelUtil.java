package org.edu.util.Excel;

import org.edu.util.Excel.BaseVo;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
/*import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;
import net.sf.jxls.transformer.XLSTransformer;*/
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtil<T extends BaseVo> {

    /**
     * 从excel中读入数据到List<T>中
     * 
     * @param xmlTemplate
     *            读入用xml模板流
     * @param inputXLS
     *            读入的excel数据流
     * @param beans
     *            读入的到的list
     * @param beansName
     *            List的名字，对应模板中定义的items
     * @return excel读入的状态
     * @throws Exception
     */
   /* public XLSReadStatus readFromExcel(InputStream xmlTemplate, InputStream inputXLS, List<T> beans, String beansName)
            throws Exception {
        XLSReader mainReader = ReaderBuilder.buildFromXML(xmlTemplate);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(beansName, beans);
        XLSReadStatus status = mainReader.read(inputXLS, map);
        return status;
    }*/

    /**
     * 取得excel读取的数据行
     * 
     * @param inputXLS
     *            excel输入流
     * @param describeLine
     *            excel说明文字所占的行数
     * @return excel预读取的数据行
     * @throws IOException
     */
    public int getExcelDataMaxRowNum(InputStream inputXLS, int describeLine) throws IOException {
        HSSFWorkbook hssfbook = new HSSFWorkbook(inputXLS);
        return hssfbook.getSheetAt(0).getLastRowNum() - describeLine;
    }

    /**
     * 导入数据到excel文件
     * 
     * @param templateFilePath
     *            模板路径
     * @param beanName
     *            导入的bean是实体
     * @param destFilePath
     *            要写入的文件
     * @throws ParsePropertyException
     * @throws InvalidFormatException
     * @throws IOException
     */
    /*public void writeToExcelFile(String templateFilePath, String beanName, T bean, String destFilePath)
            throws ParsePropertyException, InvalidFormatException, IOException {
        Map<String, T> beans = new HashMap<String, T>();
        beans.put(beanName, bean);
        XLSTransformer transformer = new XLSTransformer();
        transformer.transformXLS(templateFilePath, beans, destFilePath);
    }*/
    
    
    
    
    
    /**
     * 导入数据到excel文件
     * 
     * @param templateFilePath
     *            模板路径
     * @param destFilePath
     *            要写入的文件
     * @throws ParsePropertyException
     * @throws InvalidFormatException
     * @throws IOException
     */
    public void mergeSheetToExcel(List<String> templateFilePath, String destFilePath)
            throws BiffException, IOException, WriteException {
        WritableWorkbook newWb = jxl.Workbook.createWorkbook(new File(destFilePath));
        for (int i = 0; i < templateFilePath.size(); i++) {
            InputStream is = new FileInputStream(templateFilePath.get(i));
            jxl.Workbook wb = jxl.Workbook.getWorkbook(is);
            newWb.importSheet("sheet" + i, i, wb.getSheet(0));
            is.close();
            wb.close();
        }
        for (int i = 0; i < templateFilePath.size(); i++) {
            WritableSheet sheet=newWb.getSheet(i);
            sheet.setColumnView(1,25);  
            sheet.setColumnView(4,25);  
        }
        newWb.write();
        newWb.close();
    }
    

    /**
     * 导入数据到excel文件
     * 
     * @param templateFilePath
     *            模板路径
     * @param beanName
     *            导入的bean是实体
     * @param destFilePath
     *            要写入的文件
     * @throws ParsePropertyException
     * @throws InvalidFormatException
     * @throws IOException
     */
   /* public void writeListToExcelFile(String templateFilePath, String beanName, List<T> bean, String destFilePath)
            throws ParsePropertyException, InvalidFormatException, IOException {
        Map<String, List<T>> beans = new HashMap<String, List<T>>();
        beans.put(beanName, bean);
        XLSTransformer transformer = new XLSTransformer();
        transformer.transformXLS(templateFilePath, beans, destFilePath);
    }

    public Workbook writeToExcel(InputStream template, T bean, String beanName) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(beanName, bean);

        XLSTransformer transformer = new XLSTransformer();
        Workbook wb = transformer.transformXLS(template, map);

        return wb;
    }

    public Workbook writeToExcel(InputStream template, List<T> beanList, String beanListName) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(beanListName, beanList);

        XLSTransformer transformer = new XLSTransformer();
        Workbook wb = transformer.transformXLS(template, map);

        return wb;
    }*/

}
