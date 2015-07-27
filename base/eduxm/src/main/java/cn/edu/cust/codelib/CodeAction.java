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
 * @2013-11-26
 */
public class CodeAction extends CommonAction2 {
	private Code obj;
	// private String path="code/admin/codelibs.json";
	private String filename;
	private String parentId;
	private String oldId;

	interface Handler {
		public void handle(JSONObject jsonObject, JSONArray jsonArray, int index);
	}

	private void recurseTree(JSONArray jsonArray, String id, Handler handler) {
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jb = jsonArray.getJSONObject(i);
			if (!jb.isNull("id") && id.equals(jb.get("id"))) {
				handler.handle(jb, jsonArray, i);
				return;
			}
			if (jb.has("children")) {
				recurseTree(jb.getJSONArray("children"), id, handler);
			}
		}
	}

	private void addNode(JSONArray jsonArray) {
		recurseTree(jsonArray, parentId, new Handler() {

			public void handle(JSONObject jsonObject, JSONArray jsonArray,
					int index) {
				// TODO Auto-generated method stub
				if (jsonObject.has("children")) {
					JSONArray ja = jsonObject.getJSONArray("children");
					log.info("wo 在 add children");
					ja.put(obj.toJSONObject());
				} else {
					JSONArray ja = new JSONArray();
					log.info("wo 在 no children");
					ja.put(obj.toJSONObject());
					jsonObject.put("children", ja);
				}
			}

		});
	}

	private void updateNode(JSONArray jsonArray) {
		recurseTree(jsonArray, oldId, new Handler() {

			public void handle(JSONObject jsonObject, JSONArray jsonArray,
					int index) {
				// TODO Auto-generated method stub
				log.info("updateTree");
				// jsonArray.put(i,obj.toJSONObject());
				jsonObject.put("id", obj.getId());
				jsonObject.put("pinyin", obj.getPinyin());
				jsonObject.put("text", obj.getText());
				// return jsonArray;
			}

		});
	}

	private void deleteNode(JSONArray jsonArray) {
		recurseTree(jsonArray, obj.getId(), new Handler() {

			public void handle(JSONObject jsonObject, JSONArray jsonArray,
					int index) {
				// TODO Auto-generated method stub
				log.info("deleteTree");
				// jsonArray.put(i,obj.toJSONObject());
				jsonArray.remove(index);
				// return jsonArray;
			}

		});
	}

	public String add() {
		successmsg = "添加成功";
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		log.info(filename + "filename" + parentId + "---" + obj.getId() + "---"
				+ obj.getText() + "---" + obj.getPinyin());

		ServletContext sc = ServletActionContext.getServletContext();

		try {
			String strPath = sc.getRealPath("/");
			File f = new File(strPath, "code/" + filename);
			log.info(f.length() + "---------" + sc.getRealPath("/"));
			if (!f.exists() || f.length() <= 0) {
				log.info("start");
				f.createNewFile();
				Writer os = new OutputStreamWriter(new FileOutputStream(f),
						"UTF-8");
				new JSONArray().write(os);
				os.flush();
				os.close();
			}
			Reader in = new InputStreamReader(new FileInputStream(f), "UTF-8");
			JSONTokener jt = new JSONTokener(in);
			JSONArray jsonArray = new JSONArray(jt);
			boolean checkParent = "".equals(parentId);
			if (checkParent || parentId == null) {
				log.info("no parent ");
				jsonArray.put(obj.toJSONObject());

			} else {
				log.info("have parent ");
				addNode(jsonArray);
			}
			Writer osw = new OutputStreamWriter(new FileOutputStream(f),
					"UTF-8");
			jsonArray.write(osw);
			osw.flush();
			in.close();
			osw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage(), e);
			errormsg = e.getMessage();
			return error;
		}
		return success;
	}

	public String update() {
		successmsg = "修改成功";
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		log.info(oldId + "update---" + obj.getId() + "---" + obj.getText()
				+ "---" + obj.getPinyin());
		ServletContext sc = ServletActionContext.getServletContext();
		log.info("---------" + sc.getRealPath("/"));
		try {
			String strPath = sc.getRealPath("/");
			File f = new File(strPath, "code/" + filename);
			Reader in = new InputStreamReader(new FileInputStream(f), "UTF-8");
			JSONTokener jt = new JSONTokener(in);
			JSONArray jsonArray = new JSONArray(jt);
			// jsonArray=updateTree(jsonArray);
			updateNode(jsonArray);
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

	public String delete() {
		successmsg = "删除成功";
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		log.info("delete---" + obj.getId() + "---" + obj.getText() + "---"
				+ obj.getPinyin());
		ServletContext sc = ServletActionContext.getServletContext();
		log.info("---------" + sc.getRealPath("/"));
		try {
			String strPath = sc.getRealPath("/");
			File f = new File(strPath, "code/" + filename);
			Reader in = new InputStreamReader(new FileInputStream(f), "UTF-8");
			JSONTokener jt = new JSONTokener(in);
			JSONArray jsonArray = new JSONArray(jt);
			deleteNode(jsonArray);
			Writer osw = new OutputStreamWriter(new FileOutputStream(f),
					"UTF-8");
			jsonArray.write(osw);
			osw.flush();
			in.close();
			osw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage(), e);
			errormsg = e.getMessage();
			return error;
		}

		return success;
	}

	public Code getObj() {
		return obj;
	}

	public void setObj(Code obj) {
		this.obj = obj;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getOldId() {
		return oldId;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
