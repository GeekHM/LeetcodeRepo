package mytest.utils.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

/**
 * @author whm
 * @version 2.0.0
 * @date 2022-04-10
 **/
public class ExcelDemo {
    /**
     * Excel 文件要存放的位置，假定在D盘下
     */
    public static String outputFile = "src/main/resources/test.xls";

    public static void main(String args[]) {
        try {
            //创建工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();

            //在工作簿中建一个sheet
            HSSFSheet sheet1 = workbook.createSheet("注册信息（必填）");
            HSSFSheet sheet2 = workbook.createSheet("营业信息");

            //对每一个sheet创建对应内容
            createSheets(workbook, sheet1);

            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("文件生成");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }

    public static void createSheets(HSSFWorkbook workbook, HSSFSheet sheet) {
        HSSFCellStyle headerStyle = getHeaderStyle(workbook);

        CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 4);
//        RegionUtil.setBorderBottom(BorderStyle.THIN, cellRangeAddress, sheet);//下边框
//        RegionUtil.setBorderLeft(BorderStyle.THIN, cellRangeAddress, sheet);//左边框
//        RegionUtil.setBorderRight(BorderStyle.THIN, cellRangeAddress, sheet);//右边框
//        RegionUtil.setBorderTop(BorderStyle.THIN, cellRangeAddress, sheet);//上边框
//        sheet.setDefaultColumnWidth(210 * 256);
//        sheet.setColumnWidth(0, 10 * 256);
        sheet.setDefaultColumnWidth(15);
        sheet.setDefaultRowHeightInPoints(20);
        HSSFRow row = sheet.createRow(0);
        row.setHeight((short) 1000);

        //对每一个头部都要设置该样式
        for (int i = 0; i < 5; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellType(CellType.STRING);
            cell.setCellValue("注册信息\n" + "（所有会员填写）");
            cell.setCellStyle(headerStyle);
        }
//        HSSFCell cell = row.createCell(0);
//        cell.setCellType(CellType.STRING);
//        cell.setCellValue("注册信息\n" + "（所有会员填写）");
//        cell.setCellStyle(headerStyle);

        sheet.addMergedRegion(cellRangeAddress);

    }

    /**
     * 样式
     *
     * @param wb excel
     */
    private static HSSFCellStyle getHeaderStyle(HSSFWorkbook wb) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //表头样式
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        //设置填充方案
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置自定义填充颜色
        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        //设置单元格边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        //字体
        HSSFFont font = wb.createFont();
        font.setFontName("宋体");//设置字体名称
        font.setFontHeightInPoints((short) 13);//字体大小
        font.setBold(true);
        cellStyle.setFont(font);
        cellStyle.setWrapText(true);
        return cellStyle;
    }
}
