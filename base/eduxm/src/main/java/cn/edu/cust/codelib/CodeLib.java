package cn.edu.cust.codelib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CodeLib {

	public static final String CODELIBS_FILE = "code/admin/codelibs.json";
	public static final String CODELIBS_DIR = "code/";

	private String name;

	private String filename;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public JSONObject toJSONObject() {
		return new JSONObject(this);
	}
	
	public static HashMap<String, HashMap<String, String>> loadCodeLibs(
			File codelibsFile, File codelibsDir, String keyField,
			String valueField) throws IOException {
		Reader in = new InputStreamReader(new FileInputStream(codelibsFile),
				"UTF-8");
		JSONTokener jt = new JSONTokener(in);
		JSONArray jsonArray = new JSONArray(jt);
		in.close();

		// String codelibsDir = sc.getRealPath(CODELIBS_DIR);
		HashMap<String, HashMap<String, String>> codelibs = new HashMap<String, HashMap<String, String>>();
		int len = jsonArray.length();
		for (int i = 0; i < len; i++) {
			JSONObject jo = jsonArray.getJSONObject(i);
			String name = jo.getString("name");
			String filename = jo.getString("filename");
			codelibs.put(
					name,
					loadCodes(new File(codelibsDir, filename), keyField,
							valueField));
		}
		return codelibs;
	}

	/**
	 * 读取所有代码字典
	 * 
	 * @param keyField
	 *            key字段名
	 * @param valueField
	 *            value字段名
	 * @return
	 * @throws IOException
	 */
	public static HashMap<String, HashMap<String, String>> loadCodeLibs(
			String keyField, String valueField) throws IOException {
		ServletContext sc = ServletActionContext.getServletContext();
		File codelibsFile = new File(sc.getRealPath(CODELIBS_FILE));
		File codelibsDir = new File(sc.getRealPath(CODELIBS_DIR));
		return loadCodeLibs(codelibsFile, codelibsDir, keyField, valueField);
	}

	private static HashMap<String, String> loadCodes(File f, String keyField,
			String valueField) throws IOException {
		Reader in = new InputStreamReader(new FileInputStream(f), "UTF-8");
		JSONTokener jt = new JSONTokener(in);
		JSONArray jsonArray = new JSONArray(jt);
		in.close();

		HashMap<String, String> codes = new HashMap<String, String>();
		loadCodes(codes, jsonArray, keyField, valueField);
		return codes;
	}

	private static void loadCodes(HashMap<String, String> codes,
			JSONArray jsonArray, String keyField, String valueField) {
		int len = jsonArray.length();
		for (int i = 0; i < len; i++) {
			JSONObject jo = jsonArray.getJSONObject(i);
			String key = jo.getString(keyField);
			String value = jo.getString(valueField);
			codes.put(key, value);
			if (jo.has("children")) {
				loadCodes(codes, jo.getJSONArray("children"), keyField,
						valueField);
			}
		}
	}
}
