package cn.edu.cust.codelib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import cn.edu.cust.util.action.CommonAction2;

/**
 * #用于处理代码管理的，查询、添加、修改、删除
 * 
 * @author wbj
 * @2013-11-23
 */
public class CodeLibAction extends CommonAction2 {

	private CodeLib obj;
	private int updateIndex;

	public String add() {
		successmsg = "添加成功";
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		log.info("{}--------{}", obj.getName(), obj.getFilename());
		ServletContext sc = ServletActionContext.getServletContext();
		log.info("---------{}", sc.getRealPath("/"));
		try {
			String codelibsDir = sc.getRealPath(CodeLib.CODELIBS_DIR);
			File newF = new File(codelibsDir, obj.getFilename());
			if (!newF.exists()) {
				newF.createNewFile();
				Writer os = new OutputStreamWriter(new FileOutputStream(newF),
						"UTF-8");
				// OutputStreamWriter osw=new OutputStreamWriter(f,"UTF-8");
				new JSONArray().write(os);
				os.flush();
				os.close();
			}
			File f = new File(sc.getRealPath(CodeLib.CODELIBS_FILE));
			if (!f.exists()) {
				log.info("start");
				f.createNewFile();
				Writer os = new OutputStreamWriter(new FileOutputStream(f),
						"UTF-8");
				new JSONArray("[]").write(os);
				os.flush();
				os.close();
			}
			Reader in = new InputStreamReader(new FileInputStream(f), "UTF-8");
			JSONTokener jt = new JSONTokener(in);
			JSONArray jsonArray = new JSONArray(jt);
			jsonArray.put(obj.toJSONObject());
			Writer osw = new OutputStreamWriter(new FileOutputStream(f),
					"UTF-8");
			jsonArray.write(osw);
			osw.flush();
			in.close();
			osw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage(), e);
			errormsg = "";
			return error;
		}
		return success;
	}

	public String update() {
		successmsg = "修改成功";
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		log.info(obj.getName() + "--update --" + updateIndex + "----"
				+ obj.getFilename());
		try {
			ServletContext sc = ServletActionContext.getServletContext();

			// String path="code/admin/codelibs.json";
			File f = new File(sc.getRealPath(CodeLib.CODELIBS_FILE));
			Reader in = new InputStreamReader(new FileInputStream(f), "UTF-8");
			JSONTokener jt = new JSONTokener(in);
			JSONArray jsonArray = new JSONArray(jt);
			log.info("{}", jsonArray.get(updateIndex));
			JSONObject jbt = jsonArray.getJSONObject(updateIndex);
			log.info(jbt.getString("filename"));

			String codelibsDir = sc.getRealPath(CodeLib.CODELIBS_DIR);
			File oldF = new File(codelibsDir, jbt.getString("filename"));
			if (oldF.exists()) {
				oldF.renameTo(new File(codelibsDir, obj.getFilename()));
			}
			jsonArray.put(updateIndex, obj.toJSONObject());
			Writer osw = new OutputStreamWriter(new FileOutputStream(f),
					"UTF-8");
			jsonArray.write(osw);
			osw.flush();
			in.close();
			osw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage(), e);
			return error;
		}
		return success;
	}

	public String delete() {
		successmsg = "已删除";
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		log.info("----delete----");
		try {
			ServletContext sc = ServletActionContext.getServletContext();
			File f = new File(sc.getRealPath(CodeLib.CODELIBS_FILE));
			Reader in = new InputStreamReader(new FileInputStream(f), "UTF-8");
			JSONTokener jt = new JSONTokener(in);
			JSONArray jsonArray = new JSONArray(jt);
			JSONObject jbt = jsonArray.getJSONObject(updateIndex);
			log.info(jbt.getString("filename"));

			String codelibsDir = sc.getRealPath(CodeLib.CODELIBS_DIR);
			File oldF = new File(codelibsDir, jbt.getString("filename"));
			if (oldF.exists()) {
				oldF.delete();
			}
			jsonArray.remove(updateIndex);
			Writer osw = new OutputStreamWriter(new FileOutputStream(f),
					"UTF-8");
			jsonArray.write(osw);
			osw.flush();
			in.close();
			osw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage(), e);
			return error;
		}
		return success;
	}

	public CodeLib getObj() {
		return obj;
	}

	public void setObj(CodeLib obj) {
		this.obj = obj;
	}

	public int getUpdateIndex() {
		return updateIndex;
	}

	public void setUpdateIndex(int updateIndex) {
		this.updateIndex = updateIndex;
	}

}
