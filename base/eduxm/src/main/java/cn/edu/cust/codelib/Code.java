package cn.edu.cust.codelib;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

import org.json.JSONObject;

public class Code {

	private String id;// 编号代码例：i

	private String text;// 内容 例：个人用户

	private String pinyin;// 名称例：role

	private static HanyuPinyinOutputFormat format;

	static {
		format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPinyin() {
		if (pinyin != null && !pinyin.equals("")) {
			return pinyin;
		}
		StringBuffer sb = new StringBuffer();
		int len = text.length();
		for (int i = 0; i < len; i++) {
			char ch = text.charAt(i);
			try {
				String[] py = PinyinHelper.toHanyuPinyinStringArray(ch, format);
				if (py == null) {
					sb.append(ch);
					continue;
				}
				sb.append(py[0].charAt(0));
			} catch (Exception ex) {
				sb.append(ch);
			}
		}
		pinyin = sb.toString();
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public JSONObject toJSONObject() {
		return new JSONObject(this);
	}

}
