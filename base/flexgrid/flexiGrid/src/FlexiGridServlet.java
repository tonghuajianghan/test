import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FlexiGridServlet extends HttpServlet {
	private DBConnection db;

	public void init() throws ServletException {
		System.out.println("--------------��ʼ����---------------------");
		db = new DBConnection();// ������
		try {
			db.getCurrentConnection();
		} catch (SQLException e1) {
		}
		System.out.println("--------------�����ӳɹ�---------------------");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response��ش���
		response.setContentType("html/txt");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");

		String action = request.getParameter("action");
		System.out.println("action=" + action);
		String tableName = "job_info1";
		 if ("add".equals(action)) {
			System.out.println("--------------------add--------------------");
			return;
		} else if ("delete".equals(action)) {
			System.out.println("--------------------delete------------------");
			String ids=request.getParameter("id");
			System.out.println("ids="+ids);
//			String[] id=ids.split(",");
			String sql = "delete from "+tableName+" where id in ("+ids+")";
			
			System.out.println("sql="+sql);
			try {
				db.executeUpdate(sql, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("delete success!!!");
			response.getWriter().write("success");
			response.getWriter().flush();
			response.getWriter().close();
			return;
		} else if ("modify".equals(action)) {
			System.out.println("--------------------modify-------------------");
			return;
		} else {

		}
		 System.out.println("--------------------������-------------------");
		
		// ��õ�ǰҳ��
		String pageIndex = request.getParameter("page");
		System.out.println("pageIndex=" + pageIndex);
		// ���ÿҳ���������
		String pageSize = request.getParameter("rp");
		System.out.println("pageSize=" + pageSize);
		// ���ģ����ѯ�ı�������ֵ
		String query = new String(request.getParameter("query").getBytes("ISO8859-1"), "UTF-8");
				
		System.out.println("query=" + query);
		// ���ģ����ѯ����
		String qtype = request.getParameter("qtype");
		System.out.println("qtype=" + qtype);
		// ������ֶ�
		String sortname = request.getParameter("sortname");
		System.out.println("sortname=" + sortname);
		// desc or asc
		String sortorder = request.getParameter("sortorder");
		System.out.println("sortorder=" + sortorder);

		int count = 0;
		String sql = "";
		List list = null;
		
		try {
			sql = "select count(*) from " + tableName;
			if (!query.equals("")) {
				sql += " where " + qtype + "='" + query + "'";
			}
			System.out.println("sql=" + sql);
			count = db.executeQuery(sql);
			System.out.println("count=" + count);

			sql = "select * from " + tableName;
			if (!query.equals("")) {
				sql += " where " + qtype + "='" + query + "'";
			}
			sql += " order by " + sortname + " " + sortorder;
			sql += " limit "
					+ ((Integer.parseInt(pageIndex) - 1) * Integer
							.parseInt(pageSize)) + "," + pageSize;
			System.out.println("sql=" + sql);
			list = db.executeQueryList(sql);
			System.out.println("list.size=" + list.size());
			if (list == null) {
				System.out.println("======������======");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map map = new HashMap();
		map.put("page", pageIndex);
		map.put("total", count + "");
		// ����JSON��ʽ��
		String json = toJSON(list, map);

		response.getWriter().write(json);
		response.getWriter().flush();
		response.getWriter().close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
		System.out.println("--------------�ر�����---------------------");
		db.closeCurrentConnection();
	}

	/**
	 * ����JSON��ʽ��
	 * 
	 * @param list
	 * @param pageInfo
	 * @return
	 */
	private String toJSON(List list, Map map) {
		List mapList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map cellMap = new HashMap();
			cellMap.put("id", ((Map) list.get(i)).get("id").toString());
			cellMap.put("cell", new Object[] { 
					//"<input type='checkbox'/>",
					((Map) list.get(i)).get("id"),
					((Map) list.get(i)).get("job_name"),
					((Map) list.get(i)).get("work_address"),
					((Map) list.get(i)).get("salary"),
					((Map) list.get(i)).get("date"),
					((Map) list.get(i)).get("language") });
			mapList.add(cellMap);
		}
		map.put("rows", mapList);
		JSONObject object = new JSONObject(map);
		return object.toString();
	}

}
