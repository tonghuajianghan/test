package com.wondersgroup.core.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author SHI
 * @POI工具类
 */
public class POIUtil {
    /**
     * 从Excel文件获取工作表对象
     * 
     * @param file
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     * @throws Throwable
     */
    public static Workbook read(File file) throws InvalidFormatException, IOException {
        return WorkbookFactory.create(file);
    }

    /**
     * 根据页索引获取指定工作表中的标签页对象
     * 
     * @param wb
     * @param idx
     * @return
     */
    public static Sheet read(Workbook wb, int idx) {
        return wb.getSheetAt(idx - 1);
    }

    /**
     * 根据行索引获取指定标签页中的行对象
     * 
     * @param st
     * @param idx
     * @return
     */
    public static Row read(Sheet st, int idx) {
        Row rw = st.getRow(idx - 1);
        return rw == null ? st.createRow(idx - 1) : rw;
    }

    /**
     * 根据页、行索引获取指定工作表中的行对象
     * 
     * @param wb
     * @param sidx
     * @param ridx
     * @return
     */
    public static Row read(Workbook wb, int sidx, int ridx) {
        return POIUtil.read(POIUtil.read(wb, sidx), ridx);
    }

    /**
     * 根据列索引获取指定行中的单元格对象
     * 
     * @param rw
     * @param idx
     * @return
     */
    public static Cell read(Row rw, int idx) {
        Cell cl = rw.getCell(idx - 1);
        return cl == null ? rw.createCell(idx - 1) : cl;
    }

    /**
     * 根据行、列索引获取指定标签页中的单元格对象
     * 
     * @param st
     * @param ridx
     * @param cidx
     * @return
     */
    public static Cell read(Sheet st, int ridx, int cidx) {
        return POIUtil.read(POIUtil.read(st, ridx), cidx);
    }

    /**
     * 根据页、行、列索引获取指定工作表中的单元格对象
     * 
     * @param wb
     * @param sidx
     * @param ridx
     * @param cidx
     * @return
     */
    public static Cell read(Workbook wb, int sidx, int ridx, int cidx) {
        return POIUtil.read(POIUtil.read(POIUtil.read(wb, sidx), ridx), cidx);
    }

    /**
     * 强制从单元格获取String类型数据
     * 
     * @param cl
     * @return
     */
    public static String readString(Cell cl) {
        // 如果单元格为空，直接返回null值
        if (cl.getCellType() == Cell.CELL_TYPE_BLANK) {
            return null;
        }

        cl.setCellType(Cell.CELL_TYPE_STRING);
        return cl.getStringCellValue();
    }

    /**
     * 强制从单元格获取String类型数据，并去除前后空格
     * 
     * @param cl
     * @return
     */
    public static String readTrimmedString(Cell cl) {
        return StringUtils.trimToEmpty(POIUtil.readString(cl));
    }

    /**
     * 强制从单元格获取Double类型数据
     * 
     * @param cl
     * @return
     */
    public static Double readDouble(Cell cl) {
        // 如果单元格为空，直接返回null值
        if (cl.getCellType() == Cell.CELL_TYPE_BLANK) {
            return null;
        }

        cl.setCellType(Cell.CELL_TYPE_NUMERIC);
        return cl.getNumericCellValue();
    }

    /**
     * 强制从单元格获取Integer类型数据
     * 
     * @param cl
     * @return
     */
    public static Integer readInteger(Cell cl) {
        String v = POIUtil.readTrimmedString(cl);
        return StringUtils.isBlank(v) ? null : Integer.valueOf(v);
    }

    /**
     * 强制从单元格获取BigDecimal类型数据
     * 
     * @param cl
     * @return
     */
    public static BigDecimal readBigDecimal(Cell cl) {
        Double v = POIUtil.readDouble(cl);

        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(false);

        return v == null ? null : new BigDecimal(df.format(v));
    }
}
