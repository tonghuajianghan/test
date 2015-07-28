package cn.edu.cust.codelib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CodeLibRegenerate {
	
	public static final String CODELIBS_FILE = "src/main/webapp/code/admin/codelibs.json";
	public static final String CODELIBS_DIR = "src/main/webapp/code/";
	
	public static void loadCodeLibs() throws IOException {
		File f = new File(CODELIBS_FILE);
		Reader in = new InputStreamReader(new FileInputStream(f), "UTF-8");
		JSONTokener jt = new JSONTokener(in);
		JSONArray jsonArray = new JSONArray(jt);
		in.close();

		int len = jsonArray.length();
		for (int i = 0; i < len; i++) {
			JSONObject jo = jsonArray.getJSONObject(i);
			String filename = jo.getString("filename");
			
			loadCodes(new File(CODELIBS_DIR, filename));
		}
	}

	private static void loadCodes(File f) throws IOException {
		Reader in = new InputStreamReader(new FileInputStream(f), "UTF-8");
		JSONTokener jt = new JSONTokener(in);
		JSONArray jsonArray = new JSONArray(jt);
		in.close();

		loadCodes(jsonArray);
		
		Writer out = new OutputStreamWriter(new FileOutputStream(f),
				"UTF-8");
		jsonArray.write(out);
		out.close();
	}

	private static JSONArray loadCodes(JSONArray jsonArray) {
		int len = jsonArray.length();
		for (int i = 0; i < len; i++) {
			JSONObject jo = jsonArray.getJSONObject(i);
			Code code = new Code();
			code.setId(jo.getString("id"));
			code.setText(jo.getString("text"));
			
			JSONObject newjo = code.toJSONObject();
			jsonArray.put(i, newjo);
			if (jo.has("children")) {
				newjo.put("children", loadCodes(jo.getJSONArray("children")));
			}
		}
		return jsonArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			loadCodeLibs();
			//loadCodes(new File(CODELIBS_DIR, "szd.json"));
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}
