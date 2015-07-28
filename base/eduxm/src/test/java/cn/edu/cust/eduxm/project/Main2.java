package cn.edu.cust.eduxm.project;
//注意文档中的学历学位，成果形式，民族等等，必须与.json文件里面的内容相同，否则对象属性会为空
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.edu.cust.eduxm.DataSourceFactory4Test;
import cn.edu.cust.eduxm.project.converter.CodeConverter;
import cn.edu.cust.eduxm.project.converter.Converter;
import cn.edu.cust.eduxm.project.converter.DateConverter;
import cn.edu.cust.eduxm.project.converter.IntConverter;
import cn.edu.cust.eduxm.project.dao.AchievementBeforeDAO;
import cn.edu.cust.eduxm.project.dao.MemberDAO;
import cn.edu.cust.eduxm.project.dao.PrincipalDAO;
import cn.edu.cust.eduxm.project.dao.PrincipalProjectDAO;
import cn.edu.cust.eduxm.project.dao.ProjectDAO;
import cn.edu.cust.eduxm.project.domain.AchievementBefore;
import cn.edu.cust.eduxm.project.domain.Member;
import cn.edu.cust.eduxm.project.domain.Principal;
import cn.edu.cust.eduxm.project.domain.PrincipalProject;
import cn.edu.cust.eduxm.project.domain.Project;
import cn.edu.cust.util.db.JdbcTool;

public class Main2 {
	public static String[][] tts = new String[][] {
			{ "课题名称", "\\s*课\\s*题\\s*名\\s*称\\s*：\\s*.*\\s*" },
			{ "成果形式", "\\s*成\\s*果\\s*形\\s*式\\s*：\\s*.*\\s*" },
			{ "计划完成时间", "\\s*计\\s*划\\s*完\\s*成\\s*时\\s*间\\s*：\\s*.*\\s*" },
			{ "项目负责人", "\\s*项\\s*目\\s*负\\s*责\\s*人\\s*：\\s*.*\\s*" },
			{ "负责人职称", "\\s*负\\s*责\\s*人\\s*职\\s*称\\s*：\\s*.*\\s*" },
			{ "负责人联系电话", "\\s*负\\s*责\\s*人\\s*联\\s*系\\s*电\\s*话\\s*：\\s*.*\\s*" },
			{ "负责人所在单位", "\\s*负\\s*责\\s*人\\s*所\\s*在\\s*单\\s*位\\s*：\\s*.*\\s*" },
			{ "申报项目类别", "\\s*申\\s*报\\s*项\\s*目\\s*类\\s*别\\s*：\\s*.*\\s*" },
			{ "填表时间", "\\s*填\\s*表\\s*时\\s*间\\s*：\\s*.*\\s*" }, };

	// 项目信息数组
	private static Object[][] projectFields = new Object[][] {
			{ "课题名称", "setXmmc", String.class, null },// 由于word文档读出来的事课题名称。实际就是项目名称
			{ "成果形式", "setCgxs", String.class, new CodeConverter("成果形式") },
			{ "计划完成时间", "setJhwcsj", Date.class, new DateConverter() },
			{ "申报项目类别", "setXmlb", String.class, null },
			{ "填表时间", "setTbsj", Date.class, new DateConverter() } };
	// 负责人信息数组
	private static Object[][] principalFields = new Object[][] {
			{ "负责人姓名", "setFzrxm", String.class, null },
			{ "性别", "setXb", String.class, null },
			{ "民族", "setMz", String.class, new CodeConverter("民族") },
			{ "出生年月", "setCsny", Date.class, new DateConverter() },
			{ "行政职务", "setXzzw", String.class, null },
			{ "业务职务", "setYwzw", String.class, null },
			{ "研究专长", "setYjzc", String.class, null },
			{ "最后学历", "setZhxl", String.class, new CodeConverter("学历") },
			{ "最后学位", "setZhxw", String.class, null },
			{ "担任导师", "setDrds", String.class, null },
			{ "工作单位", "setGzdw", String.class, null },
			{ "联系电话", "setLxdh", String.class, null },
			{ "通讯地址", "setTxdz", String.class, null },
			{ "邮编", "setYb", String.class, null },
			{ "是否同时承担其他科研项目的研究", "setSfdrqtxm", String.class, null } };
	// 主要参加人员信息数组
	private static Object[][] memberFields = new Object[][] {
			{ "姓名", "setXm", String.class, null },
			{ "性别", "setXb", String.class, null },
			{ "出生年月", "setCsny", Date.class, new DateConverter() },
			{ "专业职务", "setZyzw", String.class, null },
			{ "研究专长", "setYjzc", String.class, null },
			{ "学历学位", "setXlxw", String.class, new CodeConverter("学历") },
			{ "单位", "setDw", String.class, null } };
	// 负责人正在担任的研究项目数组
	private static Object[][] PrincipalProjectFields = new Object[][] {
			{ "项目名称", "setXmmc", String.class, null },
			{ "项目类别", "setXmlb", String.class, null },
			{ "开始时间", "setKssj", Date.class, new DateConverter() },
			{ "结束时间", "setJssj", Date.class, new DateConverter() },
			{ "批准单位", "setPzdw", String.class, null },
			{ "资助金额（万）", "setZzje", String.class, null } };
	// 负责人和课题成员近期与本课题有关的研究成果数组
	private static Object[][] AchievementBeforeFields = new Object[][] {
			{ "成果名称", "setCgmc", String.class, null },
			{ "成果作者", "setCgzz", String.class, null },
			{ "成果形式", "setCgxs", String.class, new CodeConverter("成果形式") },
			{ "发表刊物或出版单位", "setFbkw", String.class, null },
			{ "发表或出版时间", "setFbsj", Date.class, new DateConverter() } };

	private static void setValue(Object[][] fields, Object obj, String title,
			String value) {
		for (int i = 0; i < fields.length; i++) {
			Object[] field = fields[i];
			if (field[0].equals(title)) {
				try {
					Method m = obj.getClass().getMethod(field[1].toString(),
							(Class<?>) field[2]);
					if (field[3] != null) {
						m.invoke(obj, ((Converter) field[3]).convert(value));
					} else {
						m.invoke(obj, value);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				return;
			}
		}
	}

	public static void main(String[] args) {
//		String path = "D:/ceshi/FileOne.doc";
		String path = "D:/ceshi/FileThree.docx";
		process(path);
	}

	/**
	 * 负责整个流程控制
	 * 
	 * @param path
	 */
	private static void process(final String path) {

		
		DataSource ds = DataSourceFactory4Test.getDataSource();
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		JdbcTool.setJdbcTemplate(jt);
		
		TransactionTemplate tt = new TransactionTemplate();
		tt.setTransactionManager(new DataSourceTransactionManager(ds));
		JdbcTool.setTransactionTemplate(tt);
		
		tt.execute(new TransactionCallback<Object>(){

			@Override
			public Object doInTransaction(TransactionStatus arg0) {
				try {
					Project p = new Project();
					Principal pri = new Principal();
					List<Object> members = new ArrayList<Object>();
					List<Object> pps = new ArrayList<Object>();
					List<Object> abs = new ArrayList<Object>();
					ProjectDAO pdao = new ProjectDAO();
					PrincipalDAO pridao = new PrincipalDAO();
					MemberDAO mdao = new MemberDAO();
					PrincipalProjectDAO ppdao = new PrincipalProjectDAO();
					AchievementBeforeDAO abdao = new AchievementBeforeDAO();
					
					if (path.endsWith(".doc")) {
						FileInputStream in = new FileInputStream(path);
						POIFSFileSystem pfs = new POIFSFileSystem(in);
						HWPFDocument hwpf = new HWPFDocument(pfs);
						// 调用extractPage1函数
						p = extractPage1(hwpf);
						Range range = hwpf.getRange();
						TableIterator it = new TableIterator(range);
						// 跳过第一个表格从第二个表格开始访问
						List<Table> ts = new ArrayList<Table>();
						while (it.hasNext()) {
							Table tb = (Table) it.next();
							ts.add(tb);
						}
						// 调用extractTable1获得第一个表格信息
						pri = extractTable1(ts.get(1));
							members = extractTable(ts.get(2), Member.class, memberFields);
							pps = extractTable(ts.get(3), PrincipalProject.class, PrincipalProjectFields);
							abs = extractTable(ts.get(4), AchievementBefore.class, AchievementBeforeFields);
					} else {
						FileInputStream in = new FileInputStream(path);
						XWPFDocument doc = new XWPFDocument(in);
						// 运用XWPFWordExtractor类对象可获得全文本
						XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
						// 返回包含页眉或页脚的文本段
						List<XWPFParagraph> paras = doc.getParagraphs();
						// 调用extractPa1方法获得指定信息
						p = extractPage1X(paras);
						List<XWPFTable> tables = doc.getTables();
						// 调用extractTable1方法获得第一个表格的信息
						pri = extractTable1X(tables.get(1));
						//此处不可用for循环
							members = extractTableX(tables.get(2), Member.class, memberFields);
							pps = extractTableX(tables.get(3), PrincipalProject.class, PrincipalProjectFields);
							abs = extractTableX(tables.get(4), AchievementBefore.class, AchievementBeforeFields);
					}
					//插入项目信息到数据库
					p.setZt("a19");
					pdao.insert(p);
					//插入项目负责人信息到数据库
					pri.setId(p.getXm_id());//改为用项目表的id值作为负责人表的id，，，即两者id相同来达到一对一的关联
					pridao.insert(pri);//他没有外键
					//插入项目成员信息到数据库
					// 插入项目成员信息到数据库
					for (int i = 0; i < members.size(); i++) {
						Member m = (Member) members.get(i);
						//因为无法准确确定表格中空行，所以此处需过滤掉属性为空的对象
						if(m.getXm()!=null){
							m.setXm_id(p.getXm_id());
							mdao.insert(m);
						}
					}
					// 插入项目负责人正在担任的项目信息到数据库
					for (int i = 0; i < pps.size(); i++) {
						PrincipalProject pp = (PrincipalProject) pps.get(i);
						if(pp.getXmmc()!=null){
							pp.setXmid(p.getXm_id());
							ppdao.insert(pp);
						}
					}
					// 插入负责人和课题成员近期与本课题有关的研究成果信息到数据库
					for (int i = 0; i < abs.size(); i++) {
						AchievementBefore ab = (AchievementBefore) abs.get(i);
						if(ab.getCgmc()!=null){
							ab.setXmid(p.getXm_id());
							abdao.insert(ab);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		});

	}

	/**
	 * 获取页面特定信息
	 * 
	 * @param hwpf
	 */
	private static Project extractPage1(HWPFDocument hwpf) {
		Project proj = new Project();
		WordExtractor extractor = null;
		try {
			extractor = new WordExtractor(hwpf);
			String[] fileData = extractor.getParagraphText();
			for (int i = 0; i < fileData.length; i++) {
				for (int k = 0; k < tts.length; k++) {
					if (Pattern.compile(tts[k][1]).matcher(fileData[i])
							.matches()) {
						// 需要将字符串中的空格去除
						String line = fileData[i].replaceAll("\\s",
								"");
						String value = line.substring(line.indexOf("：") + 1,
								line.length());
						setValue(projectFields, proj, tts[k][0], value);
					}
				}
			}
			extractor.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return proj;
	}

	/**
	 * 获取页面特定信息
	 * 
	 * @param xwpf
	 */
	private static Project extractPage1X(List<XWPFParagraph> paras) {
		Project p = new Project();
		for (XWPFParagraph para : paras) {
			String text = para.getText();
			for (int k = 0; k < tts.length; k++) {
				if (Pattern.compile(tts[k][1]).matcher(text).matches()) {
					// 需要将字符串中的空格去除
					text = text.substring(text.indexOf("：") + 1, text.length())
							.replaceAll("\\s", "");
					setValue(projectFields, p, tts[k][0], text);
				}
			}
		}
		return p;
	}

	/**
	 * 获取第一个表格
	 * 
	 * @param
	 */
	private static Principal extractTable1(Table tb) {
		Principal p = new Principal();
		String title = null;
		String value = null;
		System.out.println("表1");
		for (int i = 0; i < tb.numRows(); i++) {
			TableRow tr = tb.getRow(i);
			for (int j = 0; j < tr.numCells(); j++) {
				TableCell td = tr.getCell(j);
				for (int k = 0; k < td.numParagraphs(); k++) {
					Paragraph para = td.getParagraph(k);
					String s = para.text();
					s = s.substring(0, s.length() - 1).replaceAll(
							"\\s", "");
					if (j % 2 == 0) {
						title = s;
					} else {
						value = s;
					}
					if (title != null && value != null) {
						setValue(principalFields, p, title, value);
						title = null;
						value = null;
					}

				}
			}
		}
		return p;
	}

	/**
	 * 获取第一个表格docx
	 * 
	 * @param tb
	 */
	private static Principal extractTable1X(XWPFTable tb) {
		Principal p = new Principal();
		String title = null;
		String value = null;
		System.out.println("表1");
		List<XWPFTableRow> rows = tb.getRows();
		for (int i = 0; i < rows.size(); i++) {
			XWPFTableRow row = rows.get(i);
			List<XWPFTableCell> cells = row.getTableCells();
			int j = 0;
			for (XWPFTableCell cell : cells) {
				j++;
				String s = cell.getText().replaceAll("\\s", "");
				if (j % 2 == 0) {
					value = s;
				} else {
					title = s;
				}
				if (title != null && value != null) {
					setValue(principalFields, p, title, value);
					title = null;
					value = null;
				}
			}

		}
		return p;
	}

	/**
	 * 获取剩余的三个表格
	 * 
	 * @param index
	 * 
	 * @param t
	 */
	private static List<Object> extractTable(Table tb, Class<?> clazz, Object[][] fields) {
		List<Object> all = new ArrayList<Object>();

		// 由于文档中表格的格式问题，所以用list来存储title
		List<String> titles = new ArrayList<String>();
		for (int i = 0; i < tb.numRows(); i++) {
			Object obj = null;
			try{
				obj = clazz.newInstance();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			TableRow tr = tb.getRow(i);
			for (int j = 0; j < tr.numCells(); j++) {

				TableCell td = tr.getCell(j);
				String value = "";
				for (int m = 0; m < td.numParagraphs(); m++) {
					Paragraph para = td.getParagraph(m);
					String s = para.text();
					Pattern p = Pattern.compile("\\s");
					Matcher mt = p.matcher(s);
					s = mt.replaceAll("").replace("", "");
					value += s;

					if (i == 0) {
						if ((m == 0 && td.numParagraphs() == 1)
								|| (m != 0 && td.numParagraphs() > 1 && m == td
										.numParagraphs() - 1)) {
							titles.add(value);
						}
					} else if (!value.equals("")) {
						if (titles.get(j).equals("起止时间")) {
							String stime = value.substring(0,
									value.indexOf("-"));
							setValue(fields, obj, "开始时间",
									stime);
							String etime = value.substring(
									value.indexOf("-") + 1, value.length());
							setValue(fields, obj, "结束时间",
									etime);
						} else {
							setValue(fields, obj,
									titles.get(j), value);
						}
					}

				}
			}
			all.add(obj);
		}
		return all;
	}

	private static List<Object> extractTableX(XWPFTable tb, Class<?> clazz, Object[][] fields) {
		List<Object> all = new ArrayList<Object>();	
		// 由于文档中表格的格式问题，所以用list来存储title
		List<String> titles = new ArrayList<String>();
		List<XWPFTableRow> rows = tb.getRows();
		for (int i = 0; i < rows.size(); i++) {
			Object obj = null;
			try{
				obj = clazz.newInstance();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			XWPFTableRow row = rows.get(i);
			List<XWPFTableCell> cells = row.getTableCells();
			for (int j = 0; j < cells.size(); j++) {
				XWPFTableCell cell = cells.get(j);
				String value = cell.getText().replaceAll("\\s", "");

				if (i == 0) {
					titles.add(value);
				}  else if (!value.equals("")) {
					if (titles.get(j).equals("起止时间")) {
						String stime = value.substring(0,
								value.indexOf("-"));
						setValue(fields, obj, "开始时间",
								stime);
						String etime = value.substring(
								value.indexOf("-") + 1, value.length());
						setValue(fields, obj, "结束时间",
								etime);
					} else {
						setValue(fields, obj,
								titles.get(j), value);
					}
				}
			}
			all.add(obj);
		}
		return all;
	}
}