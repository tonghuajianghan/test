package cn.edu.cust.eduxm.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


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

import cn.edu.cust.codelib.CodeLib;
import cn.edu.cust.eduxm.project.converter.CodeConverter;
import cn.edu.cust.eduxm.project.converter.Converter;
import cn.edu.cust.eduxm.project.converter.DateConverter;
import cn.edu.cust.eduxm.project.converter.IntConverter;
import cn.edu.cust.eduxm.project.domain.AchievementBefore;
import cn.edu.cust.eduxm.project.domain.Member;
import cn.edu.cust.eduxm.project.domain.Principal;
import cn.edu.cust.eduxm.project.domain.PrincipalProject;
import cn.edu.cust.eduxm.project.domain.Project;

public class GetInfo {
	public Principal principal = new Principal();
	public Project project = new Project();
	public Member member = new Member();
	public List<Member> members = new ArrayList<Member>();
	public AchievementBefore ab = new AchievementBefore();
	public List<AchievementBefore> achievementbefore = new ArrayList<AchievementBefore>();
	public PrincipalProject pp = new PrincipalProject();
	public List<PrincipalProject> principalproject = new ArrayList<PrincipalProject>();
	
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
	//项目信息数组
	private static Object[][] projectFields = new Object[][]{
		{"项目名称","setXmmc",String.class,null},
		{"成果形式","setCgxs",CodeConverter.class,new CodeConverter("cgxs.json")},
		{"计划完成时间","setJhwcsj",Date.class,new DateConverter()},
		{"申报项目类别","setXmlb",CodeConverter.class,new CodeConverter("sbxmlb.json")},
		{"填表时间","setTbsj",Date.class,new DateConverter()}
	};
	//负责人信息数组
	private static Object[][] principalFields = new Object[][]{
		{"负责人姓名","setFzrxm",String.class,null},
		{"性别","setXb",String.class,null},
		{"民族","setMz",CodeConverter.class,new CodeConverter("mz.json")},
		{"出生年月","setCsny",DateConverter.class,new DateConverter()},
		{"行政职务","setXzzw",String.class,null},
		{"业务职务","setYwzw",String.class,null},
		{"研究专长","setYjzc",String.class,null},
		{"最后学历","setZhxl",CodeConverter.class,new CodeConverter("xl.json")},
		{"最后学位","setZhxw",String.class,null},
		{"担任导师","setDrds",String.class,null},
		{"工作单位","setGzdw",String.class,null},
		{"联系电话","setLxdh",String.class,null},
		{"通讯地址","setTxdz",String.class,null},
		{"邮编","setYb",String.class,null},
		{"是否同时承担其他科研项目的研究","setSfdrqtxm",String.class,null}
	};
	//主要参加人员信息数组
	private static Object[][] memberFields = new Object[][]{
		{"姓名","setXm",String.class,null},
		{"性别","setXb",String.class,null},
		{"出生年月","setCsny",Date.class,new DateConverter()},
		{"专业职务","setZyzw",String.class,null},
		{"研究专长","setYjzc",String.class,null},
		{"学历学位","setXlxw",CodeConverter.class,new CodeConverter("xl.json")},
		{"单位","setDw",String.class,null}
	};
	//负责人正在担任的研究项目数组
	private static Object[][] PrincipalProjectFields = new Object[][]{
		{"项目名称","setXmmc",String.class,null},
		{"项目类别","setXmlb",String.class,null},
		{"起止时间","setQzsj",Date.class,new DateConverter()},
		{"批准单位","setPzdw",String.class,null},
		{"资助金额（万）","setZzje",IntConverter.class,new IntConverter()}
	};
	//负责人和课题成员近期与本课题有关的研究成果数组
	private static Object[][] AchievementBeforeFields = new Object[][]{
		{"成果名称","setCgmc",String.class,null},
		{"成果作者","setCgzz",String.class,null},
		{"成果形式","setCgxs",CodeConverter.class,new CodeConverter("cgxs.json")},
		{"发表刊物或出版单位","setFbkw",String.class,null},
		{"发表或出版时间","setFbsj",DateConverter.class,new DateConverter()}
	};
	
	private void setValue(Object[][] fields, Object obj, String title, String value){
		for (int i = 0; i < fields.length; i++) {
			Object[] field = fields[i];
			if(field[0].equals("title")){
				try{
					Method m = obj.getClass().getMethod(field[1].toString(), (Class<?>)field[2]);
					if(field[3] != null){
						m.invoke(obj, ((Converter)field[3]).convert(value));
					}else{
						m.invoke(obj, value);
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
				return;
			}
		}
	}

	/*
	 * public static void main(String[] args) { String path = "E:/FileOne.doc";
	 * //String path = "E:/EclipseWorkspace/FileThr.docx"; process(path); }
	 */
	private HWPFDocument useDoc(String path) {
		FileInputStream in;
		POIFSFileSystem pfs;
		HWPFDocument hwpf = null;
		try {
			in = new FileInputStream(path);
			pfs = new POIFSFileSystem(in);
			hwpf = new HWPFDocument(pfs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hwpf;
	}

	private XWPFDocument useDocx(String path) {
		FileInputStream in = null;
		XWPFDocument doc = null;
		try {
			in = new FileInputStream(path);
			doc = new XWPFDocument(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 运用XWPFWordExtractor类对象可获得全文本
		XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
		// 返回包含页眉或页脚的文本段
		return doc;
	}

	/**
	 * 获得project的对象
	 * 
	 * @param path
	 * @return
	 */
	public Project getProjectInfo(String path) {
		if (path.endsWith(".doc")) {
			HWPFDocument hwpf = this.useDoc(path);
			// 调用extractPage1函数
			extractPage1(hwpf);
		} else {

			XWPFDocument doc = useDocx(path);
			// 返回包含页眉或页脚的文本段
			List<XWPFParagraph> paras = doc.getParagraphs();
			// 调用extractPa1方法获得指定信息
			extractPage1X(paras);
		}
		return project;
	}

	private List<Table> getTableDoc(String path) {
		HWPFDocument hwpf = this.useDoc(path);
		Range range = hwpf.getRange();
		TableIterator it = new TableIterator(range);
		// 跳过第一个表格从第二个表格开始访问
		List<Table> ts = new ArrayList<Table>();
		while (it.hasNext()) {
			Table tb = (Table) it.next();
			ts.add(tb);
		}
		return ts;
	}

	/**
	 * 获得负责人信息表的对象
	 * 
	 * @param path
	 * @return
	 */
	public Principal getPrincipalInfo(String path) {
		if (path.endsWith(".doc")) {
			// 调用extractTable1获得第一个表格信息
			List<Table> ts = getTableDoc(path);
			if (ts != null && ts.size() > 1) {
				extractTable1(ts.get(1));
			}
		} else {
			XWPFDocument doc = useDocx(path);
			List<XWPFTable> tables = doc.getTables();
			// 调用extractTable1方法获得第一个表格的信息
			if (tables != null && tables.size() > 1) {
				extractTable1X(tables.get(1));
			}
		}
		return principal;
	}

	/**
	 * 获得成员
	 * 
	 * @param path
	 * @return
	 */
	public List<Member> getMemberInfo(String path) {
		List<Member> members = null;
		if (path.endsWith(".doc")) {
			List<Table> ts = getTableDoc(path);
			if (ts != null && ts.size() > 2) {
				members = (List<Member>) extractTable(ts.get(2), 2);
			}
		} else {
			XWPFDocument doc = useDocx(path);
			List<XWPFTable> tables = doc.getTables();
			// 调用extractTable1方法获得第一个表格的信息
			if (tables != null && tables.size() > 2) {
				members = (List<Member>) extractTableX(tables.get(2), 2);
			}
		}
		return members;
	}

	public List<PrincipalProject> getPrincipalProjectInfo(String path) {
		List<PrincipalProject> principalPorjects = null;
		if (path.endsWith(".doc")) {
			List<Table> ts = getTableDoc(path);
			if (ts != null && ts.size() > 3) {
				principalPorjects = (List<PrincipalProject>) extractTable(
						ts.get(3), 3);
			}
		} else {
			XWPFDocument doc = useDocx(path);
			List<XWPFTable> tables = doc.getTables();
			// 调用extractTable1方法获得第一个表格的信息
			if (tables != null && tables.size() > 2) {
				principalPorjects = (List<PrincipalProject>) extractTableX(
						tables.get(3), 3);
			}
		}
		return principalPorjects;
	}

	public List<AchievementBefore> getAchievementBeforeInfo(String path) {
		List<AchievementBefore> achievementBefores = null;
		if (path.endsWith(".doc")) {
			List<Table> ts = getTableDoc(path);
			if (ts != null && ts.size() > 4) {
				achievementBefores = (List<AchievementBefore>) extractTable(
						ts.get(4), 4);
			}
		} else {
			XWPFDocument doc = useDocx(path);
			List<XWPFTable> tables = doc.getTables();
			// 调用extractTable1方法获得第一个表格的信息
			if (tables != null && tables.size() > 2) {
				achievementBefores = (List<AchievementBefore>) extractTableX(
						tables.get(4), 4);
			}
		}
		return achievementBefores;
	}

	/**
	 * 负责整个流程控制
	 * 
	 * @param path
	 */
	public void process(String path) {
		try {
			if (path.endsWith(".doc")) {
				FileInputStream in = new FileInputStream(path);
				POIFSFileSystem pfs = new POIFSFileSystem(in);
				HWPFDocument hwpf = new HWPFDocument(pfs);
				// 调用extractPage1函数
				extractPage1(hwpf);
				Range range = hwpf.getRange();
				TableIterator it = new TableIterator(range);
				// 跳过第一个表格从第二个表格开始访问
				List<Table> ts = new ArrayList<Table>();
				while (it.hasNext()) {
					Table tb = (Table) it.next();
					ts.add(tb);
				}
				// 调用extractTable1获得第一个表格信息
				extractTable1(ts.get(1));
				// for循环调用extractTable获得二三四表格的信息
				for (int i = 2; i <= 4; i++) {
					System.out.println("表" + i);
					// extractTable(ts.get(i));
				}
			} else {
				FileInputStream in = new FileInputStream(path);
				XWPFDocument doc = new XWPFDocument(in);
				// 运用XWPFWordExtractor类对象可获得全文本
				// XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
				// 返回包含页眉或页脚的文本段
				List<XWPFParagraph> paras = doc.getParagraphs();
				// 调用extractPa1方法获得指定信息
				extractPage1X(paras);
				List<XWPFTable> tables = doc.getTables();
				// 调用extractTable1方法获得第一个表格的信息
				extractTable1X(tables.get(1));
				// for循环调用extractTable获得二三四表格的信息
				// extractTablesX(tables);
				for (int i = 2; i <= 4; i++) {
					System.out.println("表" + i);
					// extractTableX(tables.get(i));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取页面特定信息 即封页的信息
	 * 
	 * @param hwpf
	 */
	private void extractPage1(HWPFDocument hwpf) {
		WordExtractor extractor = null;
		try {
			extractor = new WordExtractor(hwpf);
			String[] fileData = extractor.getParagraphText();
			for (int i = 0; i < fileData.length; i++) {
				for (int k = 0; k < tts.length; k++) {
					if (Pattern.compile(tts[k][1]).matcher(fileData[i])
							.matches()) {
						// 需要将字符串中的空格去除
						fileData[i] = fileData[i].substring(
								fileData[i].indexOf("：") + 1,
								fileData[i].length()).replace(" ", "").replaceAll("\\s*|\t|\r|\n", "");
						// System.out.print(tts[k][0] + ":---" + fileData[i]);
						finiProject(tts[k][0], fileData[i]);
					}
				}
			}
		} catch (Exception exep) {
		}
	}

	/**
	 * 获取页面特定信息 即封页的信息 docx格式
	 * 
	 * @param xwpf
	 */
	private void extractPage1X(List<XWPFParagraph> paras) {
		for (XWPFParagraph para : paras) {
			String text = para.getText();
			for (int k = 0; k < tts.length; k++) {
				if (Pattern.compile(tts[k][1]).matcher(text).matches()) {
					// 需要将字符串中的空格去除
					text = text.substring(text.indexOf("：") + 1, text.length())
							.replaceAll("\\s*|\t|\r|\n", "");
					System.out.println(tts[k][0] + ":" + text);
					finiProject(tts[k][0], text);
				}
			}
		}
	}

	/**
	 * 获取第一个表格
	 * 
	 * @param
	 */
	private void extractTable1(Table tb) {
		System.out.println("表1");
		String name = "";
		String value = "";
		for (int i = 0; i < tb.numRows(); i++) {
			TableRow tr = tb.getRow(i);

			for (int j = 0; j < tr.numCells(); j++) {
				TableCell td = tr.getCell(j);

				for (int k = 0; k < td.numParagraphs(); k++) {
					Paragraph para = td.getParagraph(k);
					String s = para.text();
					s = s.substring(0, s.length() - 1).replaceAll("\\s*|\t|\r|\n", "");
					if (j % 2 == 0) {
						name += s;
						System.out.print(s + "\t");
					} else {
						value += s;
						System.out.print(s + "\t");
						// System.out.println();
					}
					System.out.print("循环了" + k + "次----");
				}
				System.out.println("第几个单元格：" + j);
				if (name != "" && value != "") {
					finiPrincipal(name, value);
					name = "";
					value = "";
				}
			}

		}
	}

	/**
	 * 获取剩余的三个表格 docx格式
	 * 
	 * @param t
	 */
	private void extractTable1X(XWPFTable tb) {
		System.out.println("表1");
		String name = "";
		String value = "";
		List<XWPFTableRow> rows = tb.getRows();
		for (int i = 0; i < rows.size(); i++) {
			// i代表第几行
			XWPFTableRow row = rows.get(i);
			List<XWPFTableCell> cells = row.getTableCells();
			int j = 0;
			for (XWPFTableCell cell : cells) {
				j++;
				String s = cell.getText().replaceAll("\\s*|\t|\r|\n", "");
				if (j % 2 == 0) {
					value += s;
					System.out.println(s);
				} else {
					name += s;
					System.out.print(s + "\t");
				}
				if (name != "" && value != "") {
					finiPrincipal(name, value);
					name = "";
					value = "";
				}
			}

		}
	}

	/**
	 * 获取剩余的三个表格doc文档
	 * 
	 * @param t
	 */
	private List<?> extractTable(Table tb, int index) {
		List<Member> members = new ArrayList<Member>();
		List<PrincipalProject> principalPorjects = new ArrayList<PrincipalProject>();
		List<AchievementBefore> achievementBefores = new ArrayList<AchievementBefore>();
		for (int i = 1; i < tb.numRows(); i++) {
			if (index == 2) {
				member = new Member();
			}
			if (index == 3) {
				pp = new PrincipalProject();
			}
			if (index == 4) {
				ab = new AchievementBefore();
			}
			TableRow tr = tb.getRow(i);
			for (int j = 0; j < tr.numCells(); j++) {
				System.out.println(j + "++++++++++++++++++================");
				TableCell td = tr.getCell(j);
				StringBuffer temp = new StringBuffer();
				for (int m = 0; m < td.numParagraphs(); m++) {
					// 这个for循环是看下一个td中有没有换行
					Paragraph para = td.getParagraph(m);
					String s = para.text();
					s.replaceAll("\\s*|\t|\r|\n", "");
					s = s.substring(0, s.length() - 1);
					temp.append(s);

				}
				if (temp != null && !temp.toString().trim().equals("")) {
					System.out.println("--------------" + temp);
					if (index == 2) {
						finiMember(j, temp.toString());
					}
					if (index == 3) {
						finiPp(j, temp.toString());
					}
					if (index == 4) {
						finiAb(j, temp.toString());
					}
					System.out.println("-=-=-=-在extractTable方法中=-===" + j
							+ "-=-=-=-value值为：" + temp.toString());
				}
			}

			if (index == 2) {
				// 对于文档中有空的表格的处理
				if (member.getXm() != null && !member.getXm().trim().equals("")) {
					members.add(member);
				}
			}
			if (index == 3) {
				if (pp.getXmmc() != null && !pp.getXmmc().trim().equals("")) {
					principalPorjects.add(pp);
				}
			}
			if (index == 4) {
				if (ab.getCgmc() != null && !ab.getCgmc().trim().equals("")) {
					achievementBefores.add(ab);
				}
			}
			System.out.println();
		}
		if (index == 2) {
			return members;
		}
		if (index == 3) {
			return principalPorjects;
		}
		if (index == 4) {
			return achievementBefores;
		}
		return null;
	}

	/**
	 * 获取剩余三个表格docx文档
	 * 
	 * @param tb
	 */
	private List<?> extractTableX(XWPFTable tb, int index) {
		List<Member> members = new ArrayList<Member>();
		List<PrincipalProject> principalPorjects = new ArrayList<PrincipalProject>();
		List<AchievementBefore> achievementBefores = new ArrayList<AchievementBefore>();
		List<XWPFTableRow> rows = tb.getRows();
		for (int i = 1; i < rows.size(); i++) {
			System.out.println("行循环了" + i + "次？？？？？？？？？？？？？？？？？？？？？？？？？？");
			XWPFTableRow row = rows.get(i);
			List<XWPFTableCell> cells = row.getTableCells();
			if (index == 2) {
				member = new Member();
			}
			if (index == 3) {
				pp = new PrincipalProject();
			}
			if (index == 4) {
				ab = new AchievementBefore();
			}

			for (int j = 0; j < cells.size(); j++) {
				XWPFTableCell cell = cells.get(j);
				String temp = "";
				String s = cell.getText();
				s.replaceAll("\\s*|\t|\r|\n", "");
				System.out.print(s);
				temp = s;
				if (temp != null && !temp.trim().equals("")) {
					if (index == 2) {
						finiMember(j, temp);
					}
					if (index == 3) {
						finiPp(j, temp);
					}
					if (index == 4) {
						finiAb(j, temp);
					}
					System.out.println("-=-=-=-在extractTable方法中=-===" + 1
							+ "-=-=-=-value值为：" + temp);
				}

			}
			if (index == 2) {
				// 对于文档中有空的表格的处理
				if (member.getXm() != null && !member.getXm().trim().equals("")) {
					members.add(member);
				}
			}
			if (index == 3) {
				if (pp.getXmmc() != null && !pp.getXmmc().trim().equals("")) {
					principalPorjects.add(pp);
				}
			}
			if (index == 4) {
				if (ab.getCgmc() != null && !ab.getCgmc().trim().equals("")) {
					achievementBefores.add(ab);
				}
				System.out.println();
			}
		}
		if (index == 2) {
			return members;
		}
		if (index == 3) {
			return principalPorjects;
		}
		if (index == 4) {
			return achievementBefores;
		}
		return null;
	}

	public void finiProject(String name, String value) {
		if (name.equals("项目编号")) {
			// 设置项目编号 但是数据库中设置时自增长的
		}
		if (name.equals("课题名称")) {
			project.setXmmc(value);
		} else if (name.equals("成果形式")) {
			project.setCgxs(value);
		} else if (name.equals("计划完成时间")) {
			Date date = dateFromString(value);
			project.setJhwcsj(date);
		} else if (name.equals("申报项目类别")) {
			project.setXmlb(value);
		} else if (name.equals("填表时间")) {
			Date date = dateFromString(value);
			project.setTbsj(date);
		}
	}

	public void finiPrincipal(String name, String value) {
		if (name.equals("负责人姓名")) {
			principal.setFzrxm(value);
			System.out.println("在设置了后。。。。" + principal.getFzrxm());
		}
		if (name.equals("性别")) {
			principal.setXb(value);
		}
		if (name.equals("民族")) {
			principal.setMz(value);
		}
		if (name.equals("出生年月")) {
			Date date = dateFromString(value);
			principal.setCsny(date);
		}
		if (name.equals("行政职务")) {
			principal.setXzzw(value);
		}
		if (name.equals("业务职务")) {
			principal.setYwzw(value);
		}
		if (name.equals("研究专长")) {
			principal.setYjzc(value);
		}
		if (name.endsWith("最后学历")) {
			principal.setZhxl(value);
		}
		if (name.equals("最后学位")) {
			principal.setZhxw(value);
		}
		if (name.equals("担任导师")) {
			principal.setDrds(value);
		}
		if (name.equals("工作单位")) {
			principal.setGzdw(value);
		}
		if (name.equals("联系电话")) {
			principal.setLxdh(value);
		}
		if (name.equals("通讯地址")) {
			principal.setTxdz(value);
		}
		if (name.equals("邮编")) {
			principal.setYb(value);
		}
		if (name.equals("是否同时承担其他科研项目的研究")) {
			principal.setSfdrqtxm(value);
		}
	}

	public void finiMember(int i, String value) {
		switch (i) {
		case 0:
			member.setXm(value);
			break;
		case 1:
			member.setXb(value);
			break;
		case 2:
			Date date = dateFromString(value);
			member.setCsny(date);
			break;
		case 3:
			member.setZyzw(value);
			break;
		case 4:
			member.setYjzc(value);
			break;
		case 5:
			member.setXlxw(value);
			break;
		case 6:
			member.setDw(value);
		default:
			break;

		}
		/*
		 * if(name.equals("姓  名")){ member.setXm(value); }
		 * if(name.equals("性别")){ member.setXb(value); }
		 * if(name.equals("出生年月")){ member.setCsny(value); }
		 * if(name.equals("专业职务")){ member.setZyzw(value); }
		 * if(name.equals("研究专长")){ member.setYjzc(value); }
		 * if(name.equals("学历学位")){ member.setXlxw(value); }
		 * if(name.equals("单  位")){ member.setDw(value); }
		 */
	}

	public void finiAb(int i, String value) {
		switch (i) {
		case 0:
			ab.setCgmc(value);
			break;
		case 1:
			ab.setCgzz(value);
			break;
		case 2:
			ab.setCgxs(value);
			break;
		case 3:
			ab.setFbkw(value);
			break;
		case 4:
			Date date = dateFromString(value);
			ab.setFbsj(date);
			break;
		default:
			break;
		}
		/*
		 * if(name.equals("成 果 名 称")){ ab.setCgmc(value); }
		 * if(name.equals("成果 作者")){ ab.setCgzz(value); }
		 * if(name.equals("成果形式")){ ab.setCgxs(value); }
		 * if(name.equals("发表刊物或出版单位")){ ab.setFbkw(value); }
		 * if(name.equals("发表或出版时间")){ ab.setFbsj(value); }
		 */
	}

	public void finiPp(int i, String value) {
		switch (i) {
		case 0:
			pp.setXmmc(value);
			break;
		case 1:
			pp.setXmlb(value);
			break;
		case 2:
			// 先前是只有一个字段，就是起止时间。但是现在变成了两个字段了。一个是开始时间，一个是结束时间
			// 原先的value值中间有一个“-”分隔
			String[] dates = null;
			if (value != null) {
				dates = value.split("-");
			}
			int index = 0;
			for (String temp : dates) {
				if (temp != null) {
					if (index == 0) {
						// 设置开始时间
						pp.setKssj(dateFromString(temp.trim()));
					}
					if (index == 1) {
						// 设置结束时间
						pp.setJssj(dateFromString(temp.trim()));
					}
				}
				index++;
			}
			break;
		case 3:
			pp.setPzdw(value);
			break;
		case 4:
			pp.setZzje(value);
		default:
			break;
		}
		/*
		 * if(name.equals("项目名称")){ pp.setXmmc(value); }
		 * if(name.equals("项目类别")){ pp.setXmlb(value); }
		 * if(name.equals("起止时间")){ pp.setQzsj(value); }
		 * if(name.equals("批准单位")){ pp.setPzdw(value); }
		 * if(name.equals("资助金额	（万）")){ pp.setZzje(value); }
		 */
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public AchievementBefore getAb() {
		return ab;
	}

	public void setAb(AchievementBefore ab) {
		this.ab = ab;
	}

	public PrincipalProject getPp() {
		return pp;
	}

	public void setPp(PrincipalProject pp) {
		this.pp = pp;
	}

	public Date dateFromString(String value) {
		int year = 0;
		// 如果没有月份，设置默认为1月
		int month = 1;
		int day = 1;
		//传入的value值中如果有换行，会使得doc与docx的转换方法有区别
		value = value.replaceAll("\\s*|\t|\r|\n", "");
		String[] vs = value.split("[年月日.]");
		if (vs.length == 4) {
			year = Integer.parseInt(vs[0]);
			//calendar对象默认一月为0
			month = Integer.parseInt(vs[1]) - 1;
			day = Integer.parseInt(vs[2]);
		} else if (vs.length == 3) {
			year = Integer.parseInt(vs[0]);
			month = Integer.parseInt(vs[1]) - 1;
			day = Integer.parseInt(vs[2]);
		} else if (vs.length == 2) {
			year = Integer.parseInt(vs[0]);
			month = Integer.parseInt(vs[1]) - 1;
		} else if (vs.length == 1) {
			year = Integer.parseInt(vs[0]);
			month = month - 1;
		}
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		//在使用set方法之前，必须先clear一下，否则很多信息会继承自系统当前时间
		cal.clear();
		cal.set(year, month, day);
		date = cal.getTime();
		return date;
	}
}